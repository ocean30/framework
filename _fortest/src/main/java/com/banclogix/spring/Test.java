package com.banclogix.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.banclogix.spring.service.GreetingService;

public class Test {  
  
    public static void main(String[] args)throws Exception {  
        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));  
        GreetingService greetingService = (GreetingService)factory.getBean("greetingService");  
        greetingService.sayGreeting();  
    }  
  
}  