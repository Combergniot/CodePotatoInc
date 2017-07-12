package com.webmodels.controller;

import com.webmodels.dao.PanaModelLinkDao;
import com.webmodels.data.DataCollector;
import com.webmodels.data.PanaDataCollector;
import com.webmodels.data.PanaStructureCollector;
import com.webmodels.data.StructureCollector;
import com.webmodels.model.Link;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CountryFormController {
    
    @Autowired
    PanaModelLinkDao dao;

    @RequestMapping(value = "selectCountry", method = RequestMethod.GET)
    public String getCountrySelectorForm(Model model) {
        ArrayList<String> allModelSymbols = (ArrayList<String>) dao.getAllModelSymbols();
        
        model.addAttribute("productSymbols", allModelSymbols);
        

        return "countryform";
    }

    // TODO refactor variable name to countryUrl instead of countryCode
    @RequestMapping(value = "showCountry", method = RequestMethod.POST)
    public String showCountry(@RequestParam(value = "countryCode", required = false, defaultValue = "pl") String countryCode, Model model) {
        PanaStructureCollector psc = new PanaStructureCollector();
        //   List<String> categories = psc.getCategoriesUrls(countryCode);
        model.addAttribute("categories", psc.getCategoriesUrls(countryCode));
        System.out.println(countryCode);
        return "country";
    }

    @GetMapping(value = "category")
    public String showCategory(@RequestParam(value = "url", required = false, defaultValue = "kategoria led z pl") String categoryUrl, Model model) {
        PanaStructureCollector psc = new PanaStructureCollector();
        List<Link> links = new ArrayList<>();
        System.out.println(psc.getProductUrls(categoryUrl, links).getClass());
        model.addAttribute("links", psc.getProductUrls(categoryUrl, links));
        System.out.println(categoryUrl);

        return "category";
    }
    
     @RequestMapping(value = "selectCountry1", method = RequestMethod.GET)
    public String getCountrySelectorForm1(Model model) {
        ArrayList<String> allModelSymbols = (ArrayList<String>) dao.getAllModelSymbols();
        
        model.addAttribute("productSymbols", allModelSymbols);
        

        return "countryform_1";
    }

}
