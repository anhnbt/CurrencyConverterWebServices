/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package vn.aptech;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author anhnb
 */
@WebService(serviceName = "CurrencyConverter")
public class CurrencyConverter {

    /**
     * Web service operation
     *
     * @param from
     * @param to
     * @param amount
     * @return
     */
    @WebMethod(operationName = "converter")
    public double converter(@WebParam(name = "from") String from,
            @WebParam(name = "to") String to,
            @WebParam(name = "amount") double amount) {
        float rate = 0;
        ExchangeRate exchangeRate = new ExchangeRate(from, to);
        List<ExchangeRate> exchangeRates = ExchangeRate.getExchangeRates();
        System.out.println("size: " + exchangeRates.size());
        for (ExchangeRate item : exchangeRates) {
            System.out.println("------------------------------");
            System.out.println(item.toString());
            System.out.println("------------------------------");
            System.out.println("equal----" + item.equals(exchangeRate));
            if (item.equals(exchangeRate)) {
                rate = item.getRate();
                break;
            }
        }
        return amount * rate;
    }
}
