package org.maxwell.se.base.api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateDemo {

    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.getMinute());
        System.out.println(now);

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss:mm");
        System.out.println(df.format(now));


    }

}