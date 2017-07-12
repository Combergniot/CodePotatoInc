package com.webmodels.test;

import com.webmodels.dao.PanaModelLinkDao;
import com.webmodels.data.PanaDataCollector;
import com.webmodels.data.PanaModelLinksCollectorForDb;
import com.webmodels.data.PanaStructureCollector;
import com.webmodels.model.Link;
import com.webmodels.util.JsonResponse;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CountryCodesTest {

   

    public static void main(String[] args) {

        PanaStructureCollector psc = new PanaStructureCollector();
        PanaModelLinksCollectorForDb plcfd = new PanaModelLinksCollectorForDb();
        PanaModelLinkDao dao = new PanaModelLinkDao();
        PanaDataCollector pd = new PanaDataCollector();

        //  for(String s : psc.getCountrycodes()){
        //      System.out.println(psc.createRootUrl(s));
        //      psc.getCategoriesUrls(psc.createRootUrl(s));
        //  for(String s1: psc.getCategoriesUrls(psc.createRootUrl(s))){
        //      System.out.println(psc.getCategoryUrlsFromPagination(s1));
        //  }
        //   }
        //  System.out.println(psc.getCategoryUrlsFromPagination("http://www.panasonic.com/pl/consumer/oswietlenie-led/lighting.html"));
        // psc.getProductUrls("http://www.panasonic.com/pl/consumer/oswietlenie-led/lighting.html");
        // List<Link> links = new ArrayList<Link>();
        //psc.getProductUrls("http://www.panasonic.com/pl/consumer/kino-domowe/telewizory-led.html", links);
        //System.out.print(links);
        //  System.out.println(psc.getCategoryUrlsFromPagination("http://www.panasonic.com/pl/consumer/kino-domowe/telewizory-led.html?browsing=params&sort=Featured&page=3"));
       
       //dao.truncateLinks();
      //  System.out.println(plcfd.collectAllLinks());
      
     // pd.collectIcons(pd.getHtml("http://www.panasonic.com/pl/consumer/kino-domowe/telewizory-led/tx-65ez1000e.html"));
     // pd.collectIcons(pd.getHtml("http://www.panasonic.com/pl/consumer/aparaty-i-kamery/aparaty-systemowe/dc-gh5.html"));
     // pd.collectIcons(pd.getHtml("http://www.panasonic.com/pl/consumer/domowa-rozrywka/sluchawki/douszne/rp-hjx6m.html"));
      //pd.collectSpecUrl(pd.getHtml("http://www.panasonic.com/pl/consumer/kino-domowe/telewizory-led/tx-65ez1000e.html"));
    
     // pd.collectImages360(pd.getHtml("http://www.panasonic.com/pl/consumer/kino-domowe/telewizory-led/tx-65ez1000e.html"));
//pd.collectVideoUrl(pd.getHtml("http://www.panasonic.com/pl/consumer/kino-domowe/telewizory-led/tx-65ez1000e.html"));
//pd.collectVideoUrl(pd.getHtml("http://www.panasonic.com/pl/consumer/aparaty-i-kamery/aparaty-systemowe/dc-gh5.html"));


//pd.collectDimensionImage(pd.getHtml("http://www.panasonic.com/pl/consumer/kino-domowe/telewizory-led/tx-65ez1000e.html"));
//pd.collectDimensionImage(pd.getHtml("http://www.panasonic.com/pl/consumer/domowa-rozrywka/sluchawki/douszne/rp-hjx6m.html"));
//pd.collectDimensionImage(pd.getHtml("http://www.panasonic.com/pl/consumer/aparaty-i-kamery/aparaty-systemowe/dc-gh5.html"));

  //  pd.collectImages360(pd.getHtml("http://www.panasonic.com/pl/consumer/kino-domowe/telewizory-led/tx-65ez1000e.html"));



    }

}
