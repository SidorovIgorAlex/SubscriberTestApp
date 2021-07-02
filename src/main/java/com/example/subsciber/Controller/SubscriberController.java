package com.example.subsciber.Controller;

import com.example.subsciber.Message.Message;
import com.example.subsciber.Service.ServiceMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubscriberController {
    @Autowired
    private ServiceMessage serviceMessage;

    @PostMapping(value = "/subscriber")
    public void getMessage(@RequestBody Message message) {
        serviceMessage.getMessage(message);
    }
}
