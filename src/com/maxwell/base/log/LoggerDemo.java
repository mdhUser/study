package com.maxwell.base.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerDemo {
    public static final Logger LOGGER = LoggerFactory.getLogger(LoggerDemo.class);

    public static void main(String[] args) {

        LOGGER.error("这里是error");
        LOGGER.debug("这里是debug");
        LOGGER.info("这里是info");

    }

}
