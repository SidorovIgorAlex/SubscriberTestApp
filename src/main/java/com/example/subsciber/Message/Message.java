package com.example.subsciber.Message;

import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Setter
public class Message {
    int id;
    String msisdn;
    String action;
    Timestamp timestamp;
}
