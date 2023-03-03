package com.tutorial.aop.Runner;

import com.tutorial.aop.BusinessService.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InvoiceRunner implements CommandLineRunner {
    @Autowired
    private BusinessService service;

    @Override
    public void run(String... args) throws Exception {

        service.helloInvoice();
        service.testMethodforAroundAdvice();
        service.saveInvoice();

    }
}
