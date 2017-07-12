package com.webmodels.data;

import com.webmodels.model.Feature;
import com.webmodels.model.PanaFeature;
import com.webmodels.model.PanaProduct;
import com.webmodels.model.Product;
import com.webmodels.util.JsonResponse;
import com.webmodels.util.UrlValidator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class PanaDataCollector implements DataCollector {

    private static final String API_URL_PARAMS = "?req=set,json,UTF-8";
    private static final String REFERER = "http://www.google.com";
    private static final String USER_AGENT = "Mozilla";
    private static final String PRODUCT_IMAGE_PARAMS = "?wid=845&hei=633&fmt=png-alpha";
    private static final String IMAGE_SERVER_URL = "http://image.panasonic.com/is/image/";

    @Override
    public Document getHtml(String productUrl) {
        if (productUrl == null) {
            throw new IllegalArgumentException("Url should not be empty!");
        }

        Document doc = null;
        try {
            doc = Jsoup.connect(productUrl)
                    .userAgent(USER_AGENT)
                    .referrer(REFERER)
                    .ignoreContentType(true)
                    .get();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return doc;
    }

    @Override
    public PanaProduct collectProductData(String url) throws MalformedURLException {
        if (!UrlValidator.validateUrl(url)) {
            throw new MalformedURLException("URL - wygląda na błędny!");
        }

        PanaProduct p = new PanaProduct(url);
        Document doc = getHtml(url);

        p.setSymbol(collectSymbol(doc));
        p.setHeading(collectHeading(doc));
        p.setSubHeading(collectSubHeading(doc));
        p.setFeatures(collectFeatures(doc));
        p.setHeroImage(collectHeroImage(doc));
        p.setIcons(collectIcons(doc));
        p.setSpecUrl(collectSpecUrl(doc));
        p.setVideos(collectVideoUrl(doc));
        p.setImages360(collectImages360(doc));

        return p;
    }

    private String collectSymbol(Document doc) {
        String symbol = doc.getElementsByClass("typenum subheader2").first().text();
        return symbol;
    }

    private String collectHeading(Document doc) {
//        String heading = doc.getElementsByClass("header1 style-dark").first().text();
        String heading = doc.select("[class^=header1 style]").first().text();

        return heading;
    }

    private String collectSubHeading(Document doc) {
        String subheading = doc.getElementsByClass("bodycopy1 keycopy-body").get(0).text();
        return subheading;
    }

    private String collectHeroImage(Document doc) {
        Elements e = doc.select("#hero");
        String subheading = e.attr("abs:data-bgimg-src");
        return subheading;
    }

    private List<String> collectImages360(Document doc) {

        List<String> productImagesUrls = new ArrayList<>();
        //   List<String> rtnProductImagesUrls = new ArrayList<>();
        try {
            String serverUrl = doc.select("div.s7container").first().absUrl("data-serverurl");
            String assetUrl = doc.select("div.s7-asset").first().attr("data-asset");
            // System.out.println(serverUrl);
            JsonResponse jsonResponse = new JsonResponse();
            productImagesUrls = jsonResponse.getResponse(serverUrl + assetUrl + API_URL_PARAMS);

            for (int i = 0; i < productImagesUrls.size(); i++) {
                productImagesUrls.set(i, IMAGE_SERVER_URL + productImagesUrls.get(i) + PRODUCT_IMAGE_PARAMS);
            }

        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }

        return productImagesUrls;
    }

    // TODO URL-e
    private List<Feature> collectFeatures(Document doc) {
        List<Feature> prodFeatures = new ArrayList<Feature>();
        Elements features = doc.select(".slide-cont");

        for (Element feature : features) {
            PanaFeature pf = new PanaFeature();
            String description;

            pf.setName(feature.child(0).attr("title"));
            if (feature.select(".bodycopy1").text().equals("") || feature.select(".bodycopy1").text() == null) {
                description = feature.select("p[style]").text();
            } else {
                description = feature.select(".bodycopy1").text();
            }
            pf.setCopy(description);
            pf.setImage(feature.select("img").attr("abs:data-src"));
            prodFeatures.add(pf);
        }
        return prodFeatures;
    }

    private List<String> collectIcons(Document doc) {
        List<String> badges = new ArrayList<>();
        Elements icons = doc.select(".badge li > a img");
        if (icons.size() == 0) {
            icons = doc.select(".badge li > img");
        }
        for (Element icon : icons) {
            badges.add(icon.absUrl("data-src"));
        }
        return badges;
    }

    public String collectDimensionImage(Document doc) {
        Element element = doc.select(".specs-images img").first();
        System.out.println(element);
        String dimensionImage = element.absUrl("data-src");
        System.out.println(dimensionImage);
        return dimensionImage;
    }

    private List<String> collectVideoUrl(Document doc) {
        List<String> vids = new ArrayList<>();
        for (Element element : doc.select(".youtube-placeholder")) {
            vids.add(element.absUrl("src"));
        }
        return vids;
    }

    private String collectSpecUrl(Document doc) {
        Element element = doc.select(".techspecsblock .seeall a[href]").first();
        String url = element.absUrl("href");
        return url;
    }

}
