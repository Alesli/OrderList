package com.example.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

// интерфейс работает как веб-сервис
@WebService
/* это веб-сервис будет использоваться для вызова методов
Style.RPC, т.е. для вызова метода.*/
@SOAPBinding(style = SOAPBinding.Style.RPC)

public interface CurrentTime {

    // этот метод можно вызывать удаленно
    @WebMethod
    String getCurrentTime();
}
