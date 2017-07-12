package com.webmodels.data;

import com.webmodels.model.PanaModelLink;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PanaModelLinksCollectorForDb {

    // todo create one static  method in utils to get html for all classes
    private Document getHtml(String url) {
        if (url == null) {
            throw new IllegalArgumentException("Url should not be empty!");
        }
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return doc;
    }

    public HashMap<String, String> getCategoriesUrls(String rootUrl, String countryCode) {
        Document doc = getHtml(rootUrl);
        HashMap<String, String> urls = new HashMap<String, String>();
        Elements e = doc.select(".item li>a");
        for (Element s : e) {
            String categoryTitle = "";
            try {
                categoryTitle = s.parent().firstElementSibling().text() + " / ";
            } catch (NullPointerException npe) {
            }
            urls.put(s.attr("abs:href"), countryCode);
        }
        return urls;
    }

    private List<PanaModelLink> getLinksForCategory(String categoryUrl, String countryCode, List<PanaModelLink> links) {
        Document doc = getHtml(categoryUrl);
        Elements productBoxes = doc.select(".product-box");

        for (Element pb : productBoxes) {
            // System.out.println(pb.select("a").first().attr("abs:href"));
            System.out.println(pb.select(".productname").text());
            //System.out.println("Product link: " + pb.attr("abs:href$=.html"));
            PanaModelLink productLink = new PanaModelLink();
            productLink.setCountryId(countryCode);
            productLink.setModelSymbol(pb.select(".productname").first().text());
            productLink.setProductUrl(pb.select("a").first().attr("abs:href"));

            System.out.println("Produkt: " + productLink);
            System.out.println("Links size" + links.size());
            links.add(productLink);
        }
        if (doc.select("p.next > a").attr("abs:href") != null && !doc.select("p.next > a").attr("abs:href").equals("")) {
            System.out.println("paginacja...");
            System.out.println(doc.select("p.next > a").attr("abs:href"));
            getLinksForCategory(doc.select("p.next > a").attr("abs:href"), countryCode, links);
        }
        return links;
    }

    public List<PanaModelLink> collectAllLinks() {
        HashMap<String, String> categoriesUrls = new HashMap<>();
        List<PanaModelLink> links = new ArrayList<>();
        List<PanaModelLink> tempLinks = new ArrayList<>();
        // create HashMap of category pages for each country
        // thread sleeps to have less agressive strategy on data server
        // coutry code is a key, link is a value 
        for (Map.Entry<String, String> entry : getCountryRootUrls().entrySet()) {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            categoriesUrls.putAll(getCategoriesUrls(entry.getValue(), entry.getKey()));
        }
        System.out.println(categoriesUrls.size());
        System.out.println(categoriesUrls);

        // for each category get list of products
        // thread sleeps to have less agressive strategy on data server
        // tempLinks is a list used by getLinksForCategory in each loop cycle
        // each time it starts as empty list, is filled with links and added to final link list. 
        for (Map.Entry<String, String> entry : categoriesUrls.entrySet()) {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            links.addAll(getLinksForCategory(entry.getKey(), entry.getValue(), tempLinks));
        }
        return links;
    }

    private HashMap<String, String> getCountryRootUrls() {
        HashMap<String, String> countries = new HashMap<>();
        countries.put("pl", "http://www.panasonic.com/pl/consumer/all-products.html");
        countries.put("cz", "http://www.panasonic.com/cz/consumer/all-products.html");
        countries.put("sk", "http://www.panasonic.com/sk/consumer/vsetky-panasonic-produkty.html");
        countries.put("hu", "http://www.panasonic.com/hu/consumer/all-products.html");
        countries.put("bg", "http://www.panasonic.com/bg/consumer/all-products.html");
        countries.put("hr", "http://www.panasonic.com/hr/consumer/all-products.html");
        countries.put("ro", "http://www.panasonic.com/ro/consumer/toate-produsele-panasonic.html");
        countries.put("ee", "http://www.panasonic.com/ee/consumer/all-products.html");
        countries.put("lv", "http://www.panasonic.com/lv/consumer/all-products.html");
        countries.put("lt", "http://www.panasonic.com/lt/consumer/all-products.html");

        return countries;
    }

}
