package com.example.agilekata;

import com.example.agilekata.service.BerlinClickService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AgileKataApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgileKataApplication.class, args);
        System.out.println(BerlinClickService.digitalTimeToBerlinTime("13:14:13"));
        System.err.println(BerlinClickService.getDigitalTimeFromBerlinTime("ORROORRROYYOOOOOOOOOYYYY"));
    }

}
