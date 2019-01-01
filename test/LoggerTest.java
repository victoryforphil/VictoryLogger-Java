import static org.junit.jupiter.api.Assertions.fail;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import org.junit.jupiter.api.Test;
import com.victoryforphil.logger.*;
import com.victoryforphil.logger.VictoryLogger.LogLevel;

public class LoggerTest {
    @Test
    public void testDebug(){
        String className = "LoggerTest";
        String method = "testDebug";
        String data = "This is a test!";

        String date = VictoryLogger.getDate();
        String txt = VictoryLogger.debug(className,method, data);

        String expectString = String.format("[%s] %s [%s (%s)] %s", " DEBUG ",date,className, method,data);

        if(txt.equals(expectString) == false){
            fail("Console Mismatch:\n\tExpected: " + expectString + "\n\tGot: " + txt);
        }
    }

    @Test
    public void testInfo(){
        String className = "LoggerTest";
        String method = "testInfo";
        String data = "This is a test!";

        String date = VictoryLogger.getDate();
        String txt = VictoryLogger.info(className,method, data);

        String expectString = String.format("[%s] %s [%s (%s)] %s",  " INFO ",date,className, method,data);

        if(txt.equals(expectString) == false){
            fail("Console Mismatch:\n\tExpected: " + expectString + "\n\tGot: " + txt);
        }
    }

    @Test
    public void testSuccess(){
        String className = "LoggerTest";
        String method = "testSuccess";
        String data = "This is a test!";

        String date = VictoryLogger.getDate();
        String txt = VictoryLogger.success(className,method, data);

        String expectString = String.format("[%s] %s [%s (%s)] %s",  "SUCCESS",date,className, method,data);

        if(txt.equals(expectString) == false){
            fail("Console Mismatch:\n\tExpected: " + expectString + "\n\tGot: " + txt);
        }
    }

    @Test
    public void testWarning(){
        String className = "LoggerTest";
        String method = "testWarning";
        String data = "This is a test!";

        String date = VictoryLogger.getDate();
        String txt = VictoryLogger.warning(className,method, data);

        String expectString = String.format("[%s] %s [%s (%s)] %s",  "WARNING",date,className, method,data);

        if(txt.equals(expectString) == false){
            fail("Console Mismatch:\n\tExpected: " + expectString + "\n\tGot: " + txt);
        }
    }

    @Test
    public void testError(){
        String className = "LoggerTest";
        String method = "testError";
        String data = "This is a test!";

        String date = VictoryLogger.getDate();
        String txt = VictoryLogger.error(className,method, data);

        String expectString = String.format("[%s] %s [%s (%s)] %s",  " ERROR ",date,className, method,data);

        if(txt.equals(expectString) == false){
            fail("Console Mismatch:\n\tExpected: " + expectString + "\n\tGot: " + txt);
        }
    }

    @Test
    public void logLevelTest(){
        VictoryLogger.setLogLevel(LogLevel.INFO);
        if(VictoryLogger.getLogLevel() != LogLevel.INFO){
            fail("Log level not set correct!");
        }

        

        String className = "LoggerTest";
        String method = "logLevelTest";
        String data = "This shouldnt be seen!";
        VictoryLogger.debug(className, method, data);
        VictoryLogger.setLogLevel(LogLevel.DEBUG);
        data = "This SHOULD be seen!";
        VictoryLogger.debug(className, method, data);
       
    }

  
}
