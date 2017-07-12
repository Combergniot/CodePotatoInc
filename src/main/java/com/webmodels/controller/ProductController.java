package com.webmodels.controller;

import com.webmodels.dao.PanaModelLinkDao;
import com.webmodels.data.DataCollector;
import com.webmodels.data.PanaDataCollector;
import com.webmodels.data.PanaStructureCollector;
import com.webmodels.model.PanaModelLink;
import com.webmodels.model.PanaProduct;
import java.net.MalformedURLException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @Autowired
    PanaModelLinkDao dao;

    // TODO refactor to String instead of ModelAndView
    @RequestMapping(value = "product", method = RequestMethod.GET, params = {"url"})
    public ModelAndView product(
            @RequestParam(value = "url", required = true, defaultValue = "Combergniot") String productUrl,
            @RequestParam(value = "export2pdf", required = false, defaultValue="false") boolean isExport) throws MalformedURLException {
        
        ModelAndView mav = new ModelAndView("product");
        DataCollector dc = new PanaDataCollector();
        PanaProduct product = (PanaProduct) dc.collectProductData(productUrl);

        mav.addObject("product", product);
        mav.addObject("productUrl", productUrl);
        mav.addObject("isExport", isExport);

        PanaProduct p = (PanaProduct) dc.collectProductData(productUrl);
        //System.out.println(p);
        return mav;
    }

    @RequestMapping(value = "showModel", method = RequestMethod.POST)
    public String showModel(@RequestParam(value = "modelSymbol", required = false, defaultValue = "") String modelSymbol, Model model) {
        model.addAttribute("links", dao.getLinksFromModelSymbol(modelSymbol));
        return "product-countries";
    }

}
