package com.tutorial.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class InvoiceAspect {

    @Pointcut("execution(public void com.dev.spring.aop.service.InvoiceBusinessService.saveInvoice())")
    public void p1() {

    }

    @Pointcut("execution(public String com.dev.spring.aop.service.InvoiceBusinessService.helloInvoice())")
    public void p2() {

    }


    @Pointcut("execution(* com.dev.spring.aop.service.InvoiceBusinessService.testMethodforAroundAdvice())")
    public void p4() {

    }

    @Before("p1()")
    public void beginTransaction() {
        System.out.println("Transaction begins !");
    }

    @After("p1()")
    public void completeTransaction() {
        System.out.println("Transaction completes !");
    }

    @AfterReturning("p1()")
    public void commitTransaction() {
        System.out.println("Transaction committed !");
    }

    @AfterThrowing("p1()")
    public void rollbackTransaction() {
        System.out.println("Transaction rolled back !");
    }

    @AfterReturning(value="p2()", returning = "obj")
    public void getAdviceReturnValue(Object obj) {
        System.out.println("Returning Value is : "+obj);
    }

    @AfterThrowing(value="p1()", throwing = "th")
    public void rollbackTransactionGetMessage(Throwable th) {
        System.out.println("Transaction rolled back ! Message from method : "+th);
    }


    @Around("p4()")
    public void testAroundAdvice(ProceedingJoinPoint pj) throws Throwable {

        System.out.println("Executing Before part of business method");

        pj.proceed();  // this code will call business method

        System.out.println("Executing After part of business method");
    }
}
