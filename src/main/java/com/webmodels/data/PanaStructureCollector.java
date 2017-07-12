package com.webmodels.data;

import com.webmodels.model.Link;
import com.webmodels.model.PanaLink;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PanaStructureCollector implements StructureCollector {

    // TODO: nie potrzebne w tym momencie, do usuniecia. URLe do krajow sa zakodowane w jsp
    public String[] getCountrycodes() {
        return new String[]{"pl", "hu", "cz", "bg", "hr", "ee", "lt", "lv"};
    }
    // TODO: nie potrzebne w tym momencie, do usuniecia. URLe do krajow sa zakodowane w jsp
    public String createRootUrl(String countryCode) {
        String url = "http://www.panasonic.com/" + countryCode + "/consumer/all-products.html ";
        return url;
    }

    @Override
    public void getLinks() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // gets urls of main category pages listed in All products page
    public List<HashMap<String, String>> getCategoriesUrls(String rootUrl) {
        Document doc = getHtml(rootUrl);
        List<HashMap<String, String>> urls = new ArrayList<HashMap<String, String>>();
        Elements e = doc.select(".item li>a");
        for (Element s : e) {
            String categoryTitle = "";
            try {
                categoryTitle = s.parent().firstElementSibling().text() + " / ";
            } catch (NullPointerException npe) {
                
            }
            HashMap<String, String> map = new HashMap<String, String>();
            map.put(s.attr("abs:href"), categoryTitle  + s.text());
            urls.add(map);
            System.out.println(map);
            //   System.out.println(s.attr("abs:href"));
        }
        return urls;
    }

    // gets links to further category pages from pagination links at the bottom of category page
    public String getCategoryUrlsFromPagination(String categoryUrl) {
        Document doc = getHtml(categoryUrl);
        Elements e = doc.select("p.next > a");
        for (Element s : e) {
            //  System.out.println(s);
            //  System.out.println(s.text());
            System.out.println("DEEP LINK: " + s.attr("abs:href"));
        }

        return "dupa";
    }

    public Document getHtml(String url) {
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

    public List<Link> getProductUrls(String categoryUrl, List<Link> links) {
        Document doc = getHtml(categoryUrl);
        Elements productBoxes = doc.select(".product-box");

        for (Element pb : productBoxes) {
            // System.out.println(pb.select("a").first().attr("abs:href"));
            System.out.println(pb.select(".productname").text());
            //System.out.println("Product link: " + pb.attr("abs:href$=.html"));
            HashMap hm = new HashMap<String, String>();
            hm.put(pb.select(".productname").first().text(), pb.select("a").first().attr("abs:href"));
            PanaLink l = new PanaLink();
            l.setLink(hm);
            links.add(l);
        }
        if (doc.select("p.next > a").attr("abs:href") != null && !doc.select("p.next > a").attr("abs:href").equals("")) {
            System.out.println("paginacja...");
            System.out.println(doc.select("p.next > a").attr("abs:href"));
            getProductUrls(doc.select("p.next > a").attr("abs:href"), links);
        }
        return links;
    }

}
