package utils;

import modelsSpoonable.formatter.HTMLFormatter;
import modelsSpoonable.models.User;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class MyLogger extends Logger {
    private static Logger LOGGER = null;

    protected MyLogger(String name,HTMLFormatter HTML_Formatter) {
        super(name, null);
        try {
            FileHandler handler = new FileHandler(".logs/" + java.util.UUID.randomUUID() + ".log");
            handler.setFormatter(HTML_Formatter);
            this.addHandler(handler);
            this.han
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void addWritingProcess(User user,String methodName){
        this.finest("");
    }

    public static Logger getLogger(String name,HTMLFormatter HTML_Formatter) {
        if (LOGGER == null) {
            LOGGER = new MyLogger(name,HTML_Formatter);
        }
        return LOGGER;
    }
}
