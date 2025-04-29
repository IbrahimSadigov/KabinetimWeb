package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author : Ibrahim Sadigov
 * @mailto : isadigov4638@ada.edu.az
 * @created : 11 April, 2025
 **/
public class LoggerUtil {
    private static final Logger logger = LoggerFactory.getLogger(LoggerUtil.class);

    public static void info(String msg) {
        logger.info(msg);
    }
    public static void error(String msg, Throwable t) {
        logger.error(msg, t);
    }
}