package com.example.subsciber.AOP_Log;

import com.example.subsciber.Message.Message;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
    @SneakyThrows
    @Around("execution(* getMessage(*))")
    public void afterGetMessageToDB(ProceedingJoinPoint proceedingJoinPoint) {
        Object object = proceedingJoinPoint.getArgs()[0];
        Class messageClass = Message.class;
        proceedingJoinPoint.proceed();
        Field[] fields = messageClass.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
        }

        Integer id = fields[0].getInt(object);
        String msisdn = (String) fields[1].get(object);
        String action = (String) fields[2].get(object);
        String timeStamp = new SimpleDateFormat("dd-mm-yyyy HH:mm:ss").format((Timestamp) fields[3].get(object));

        String templateLog = String.format("Id : %d, msisdn : %s, action: %s, timeStamp : %s\n",
                id, msisdn, action, timeStamp);

        log.info(templateLog);
    }
}
