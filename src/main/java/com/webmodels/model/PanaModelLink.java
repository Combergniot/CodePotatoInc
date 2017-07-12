
package com.webmodels.model;

import java.util.HashMap;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PanaModelLink {
    
    @Id
    @GeneratedValue
    Long id;
    
    private String modelSymbol;
    private String countryId;
    private String productUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelSymbol() {
        return modelSymbol;
    }

    public void setModelSymbol(String modelSymbol) {
        this.modelSymbol = modelSymbol;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }
    
    
    
    
    
    
    
}
