package com.webmodels.data;

import com.webmodels.model.Product;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;

/**
 * Created by Marcin on 2017-06-06.
 */
public interface DataCollector {

    Product collectProductData(String url) throws MalformedURLException;

    Document getHtml(String url) throws IOException, ParseException;
}
