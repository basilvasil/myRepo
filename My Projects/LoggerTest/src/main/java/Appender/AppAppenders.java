package Appender;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class AppAppenders {

    public static void fileAppender(){
        org.apache.log4j.FileAppender fileAppender = new org.apache.log4j.FileAppender();
        fileAppender.setThreshold(Level.WARN);
        fileAppender.setLayout(new PatternLayout("%p : %d{yyyy-MM-dd HH:mm:ss} : %m%n"));
        fileAppender.setFile("logs/logs.txt");
        fileAppender.activateOptions();
        Logger.getRootLogger().addAppender(fileAppender);

    }

}
