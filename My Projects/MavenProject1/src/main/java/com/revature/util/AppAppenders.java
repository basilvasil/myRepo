package com.revature.util;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class AppAppenders {

    private static PatternLayout forExecution = new PatternLayout("%p : %d{yyyy-MM-dd HH:mm:ss} : %m%n");

    public static void fileAppender() {
        org.apache.log4j.FileAppender fileAppender = new org.apache.log4j.FileAppender();
        fileAppender.setThreshold(Level.ALL);
        fileAppender.setLayout(forExecution);
        fileAppender.setFile("logs/log.txt");
        fileAppender.activateOptions();
        Logger.getRootLogger().addAppender(fileAppender);
    }
}

