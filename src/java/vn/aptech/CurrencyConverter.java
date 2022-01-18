/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package vn.aptech;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author anhnb
 */
@WebService(serviceName = "CurrencyConverter")
public class CurrencyConverter {

    /**
     * This is a sample web service operation
     * @param txt
     * @return 
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     * @param from
     * @param to
     * @param amount
     * @return 
     */
    @WebMethod(operationName = "converter")
    public double converter(@WebParam(name = "from") String from, 
            @WebParam(name = "to") String to, 
            @WebParam(name = "amount") double amount) {
        float rate;
        if (from.equalsIgnoreCase("usd") && to.equalsIgnoreCase("thb")) {
            rate = 33;
        } else if (from.equalsIgnoreCase("usd") && to.equalsIgnoreCase("eur")) {
            rate = 0.8f;
        } else if (from.equalsIgnoreCase("thb") && to.equalsIgnoreCase("usd")) {
            rate = 0.05f;
        } else if (from.equalsIgnoreCase("thb") && to.equalsIgnoreCase("eur")) {
            rate = 0.03f;
        } else if (from.equalsIgnoreCase("eur") && to.equalsIgnoreCase("usd")) {
            rate = 1.45f;
        } else if (from.equalsIgnoreCase("eur") && to.equalsIgnoreCase("thb")) {
            rate = 51;
        } else {
            rate = 0;
        }
        return amount * rate;
    }
}
