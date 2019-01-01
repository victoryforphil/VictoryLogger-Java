package com.victoryforphil.logger;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class VictoryLogger{
    private static ArrayList<PluginInterface> plugins = new ArrayList<>();

    public enum LogLevel {
        DEBUG, INFO, SUCCESS, WARNING, ERROR
    };

    private static LogLevel logLevel = LogLevel.INFO;
    
    public static void setLogLevel(LogLevel newLogLevel){
        logLevel = newLogLevel;
    }

    public static LogLevel getLogLevel(){
        return logLevel;
    }
    
    public static String debug(String className, String method, String data){
        
        String printString = String.format("[%s] %s [%s (%s)] %s", " DEBUG ", getDate(),className, method,data);
        callPlugin(0,printString);
        return printString;
    }
    public static String info(String className, String method, String data){
       
        String printString = String.format("[%s] %s [%s (%s)] %s", " INFO ",  getDate(),className, method,data);
        callPlugin(1,printString);
        return printString;

    }
    public static String success(String className, String method, String data){
      
        String printString = String.format("[%s] %s [%s (%s)] %s", "SUCCESS",  getDate(),className, method,data);
        callPlugin(2,printString);
        return printString;

    }
    public static String warning(String className, String method, String data){
   
        String printString = String.format("[%s] %s [%s (%s)] %s", "WARNING",  getDate(),className, method,data);
        callPlugin(3,printString);
        return printString;

    }
    public static String error(String className, String method, String data){
       
        String printString = String.format("[%s] %s [%s (%s)] %s", " ERROR ",  getDate(),className, method,data);
        callPlugin(4,printString);
        return printString;

    }

    public static String getDate(){
        DateFormat dateFormat = new SimpleDateFormat("MM/DD/YYYY HH:mm:ss.ms"); 
        Date date = new Date();
        return dateFormat.format(date);
    }

    private static void callPlugin(int level,String toSend){
        int currentLevel = getLogLevelInt();
        if(level >= currentLevel){
            System.out.println(toSend);
        }
    }

    public static int getLogLevelInt(){
        switch(logLevel){
            case DEBUG:
            return 0;

            case INFO:
            return 1;

            case SUCCESS:
            return 2;
   
            case WARNING:
            return 3;

            case ERROR:
            return 4;
  
        }
        return 0;
    }
}