import Appender.AppAppenders;
import org.apache.log4j.Logger;

public class Driver {

    static final Logger logger = Logger.getLogger(Driver.class);
    public static void main(String[] args){

        AppAppenders.fileAppender();
        logger.warn("Warn Example");


    }
}
