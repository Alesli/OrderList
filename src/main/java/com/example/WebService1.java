package com.example;

import com.example.service.impl.CurrentTimeImpl;

import javax.xml.ws.Endpoint;

public class WebService1 {
    public static void main(String... args) {

//        WSDL описанием http://localhost:8090/wss/time?wsdl
        Endpoint.publish("http://localhost:8090/wss/time",
                new CurrentTimeImpl());
    }
}
