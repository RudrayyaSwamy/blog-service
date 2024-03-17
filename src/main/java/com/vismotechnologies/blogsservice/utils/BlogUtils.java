package com.vismotechnologies.blogsservice.utils;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;


@Component
public class BlogUtils {

    public  Timestamp getCurrentTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        return Timestamp.valueOf(now);
    }
}
