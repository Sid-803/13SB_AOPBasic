package com.tutorial.aop.BusinessService;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class BusinessService {

    public void saveInvoice() {
        System.out.println("From saveInvoice()");
        if(new Random().nextInt(15)<=10) {
            throw new RuntimeException("Exception occured");
        }
    }

    public String helloInvoice() {
        return "FROM helloInvoice()";
    }

    public void testMethodforAroundAdvice() {
        System.out.println("Business Method is getting Executed !");
    }

}
