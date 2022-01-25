/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author anhnbt
 */
public class ExchangeRate {

    private String from;
    private String to;
    private float rate;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public static List<ExchangeRate> getExchangeRates() {
        List<ExchangeRate> exchangeRates = new ArrayList<>();
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            File file = new File(classLoader.getResource("ExchangeRate.xml").getFile());
            if (file.exists()) {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse(file);
                System.out.println("File ton tai");
                System.out.println("---------------------------------------------------");
                NodeList nodeList = doc.getElementsByTagName("cap");
                Element elm = null;
                for (int i = 0; i < nodeList.getLength(); i++) {
                    elm = (Element) nodeList.item(i);
                    ExchangeRate exchangeRate = new ExchangeRate();
                    exchangeRate.setFrom(elm.getElementsByTagName("from").item(0).getFirstChild().getNodeValue().toUpperCase());
                    exchangeRate.setTo(elm.getElementsByTagName("to").item(0).getFirstChild().getNodeValue().toUpperCase());
                    exchangeRate.setRate(Float.parseFloat(elm.getElementsByTagName("rate").item(0).getFirstChild().getNodeValue()));
                    exchangeRates.add(exchangeRate);
                }
            } else {
                System.out.println("File khong ton tai");
            }
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(ExchangeRate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exchangeRates;
    }

    public ExchangeRate() {
    }

    public ExchangeRate(String from, String to) {
        this.from = from.toUpperCase();
        this.to = to.toUpperCase();
    }

    @Override
    public String toString() {
        return "TyGia{" + "from=" + from + ", to=" + to + ", rate=" + rate + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ExchangeRate other = (ExchangeRate) obj;
        if (!Objects.equals(this.from, other.from)) {
            return false;
        }
        if (!Objects.equals(this.to, other.to)) {
            return false;
        }
        return true;
    }

}
