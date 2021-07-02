package com.example.subsciber.Service;

import com.example.subsciber.DAO.MessageRepositoryPURCHASE;
import com.example.subsciber.DAO.MessageRepositorySUBSCRIPTION;
import com.example.subsciber.Message.Message;
import com.example.subsciber.Message.MessagePURCHASE;
import com.example.subsciber.Message.MessageSUBSCRIPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceMessageImpl implements ServiceMessage{
    @Autowired
    private MessageRepositorySUBSCRIPTION messageRepositorySUBSCRIPTION;

    @Autowired
    private MessageRepositoryPURCHASE messageRepositoryPURCHASE;

    @Override
    public void getMessage(Message message) {
        if(message.getAction().equals("PURCHASE")) {
            messageRepositoryPURCHASE.save(new MessagePURCHASE(message.getId(),
                    message.getMsisdn(), message.getAction(), message.getTimestamp()));
        }
        else messageRepositorySUBSCRIPTION.save(new MessageSUBSCRIPTION(message.getId(),
                message.getMsisdn(), message.getAction(), message.getTimestamp()));
    }
}
