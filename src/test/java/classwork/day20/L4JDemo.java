package classwork.day20;

import org.apache.log4j.Logger;

public class L4JDemo {

    private static final Logger LOGGER =
            Logger.getLogger(L4JDemo.class.getName());

    public static void main(String[] args) {
        LOGGER.fatal("Сообщение с уровнем FATAL");
        LOGGER.error("Сообщение с уровнем ERROR");
        LOGGER.warn("Сообщение с уровнем WARNING");
        LOGGER.info("Сообщение с уровнем INFO");
        LOGGER.debug("Сообщение с уровнем DEBUG");
        LOGGER.trace("Сообщение с уровнем TRACE");
    }
}
