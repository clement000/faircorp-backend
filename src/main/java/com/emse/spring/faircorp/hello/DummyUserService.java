package com.emse.spring.faircorp.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DummyUserService {

    private GreetingService greetingService;

    @Autowired
    public DummyUserService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public void greetAll() {
        List<String> names = Arrays.asList("Elodie", "Charles");
        for (String name : names) {
            greetingService.greet(name);
        }
    }

}
