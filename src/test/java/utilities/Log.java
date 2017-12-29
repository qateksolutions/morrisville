package utilities;

import org.apache.log4j.Logger;

public class Log {
    private static final Logger LOGGER = Logger.getLogger(Log.class);

    public static void startTestCase(String testCaseName) {
        LOGGER.info("*************************************************");
        LOGGER.info("-------" + testCaseName + "--------");
        LOGGER.info("*************************************************");
    }

    public static void endTestCase(String testCaseName) {
        LOGGER.info("---End---" + testCaseName);
    }

    public static void info(String message) {
        LOGGER.info(message);
    }

    public static void error(String message) {
        LOGGER.error(message);
    }

    public static void warning(String message) {
        LOGGER.warn(message);
    }
}
