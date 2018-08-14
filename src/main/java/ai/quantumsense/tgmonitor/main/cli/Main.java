package ai.quantumsense.tgmonitor.main.cli;

import ai.quantumsense.tgmonitor.cli.Cli;
import ai.quantumsense.tgmonitor.ipc.ui.Endpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class Main {

    private static Logger logger;
    static {
        createLogDir();
        logger = LoggerFactory.getLogger(Main.class);
    }

    private static final String VERSION = "0.0.5";
    private static final String AMQP_URI = System.getenv("AMQP_URI");

    public static void main(String[] args) {
        checkEnv();
        createLogDir();
        Endpoint endpoint = new Endpoint(AMQP_URI);
        new Cli(endpoint, endpoint, VERSION);
    }

    private static void checkEnv() {
        if (AMQP_URI == null)
            throw new RuntimeException("Must set AMQP_URI environment variable");
    }

    private static void createLogDir() {
        new File("/var/log/tg-monitor").mkdirs();
    }
}
