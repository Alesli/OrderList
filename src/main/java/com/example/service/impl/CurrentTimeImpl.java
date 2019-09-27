package com.example.service.impl;

import com.example.service.CurrentTime;

import javax.faces.bean.ManagedBean;
import javax.jws.WebService;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebService(endpointInterface = "com.example.service.CurrentTime")
@ManagedBean(name = "сurrentTime")
public class CurrentTimeImpl implements CurrentTime {

    private Date currentDate = new Date();
    private SimpleDateFormat dateFormat = new SimpleDateFormat();

    /**
     * Метод возвращает тукущее время и дату
     * @return String currentDate, в формате `dd.MM.yyyy HH:mm`
     */
    @Override
    public String getCurrentTime() {
        return dateFormat.format(currentDate);
    }
}
