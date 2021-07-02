package com.example.subsciber.Message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "PURCHASE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessagePURCHASE extends Message{
    @Id
    private int id;
    private String msisdn;
    private String action;
    private Timestamp timestamp;
}
