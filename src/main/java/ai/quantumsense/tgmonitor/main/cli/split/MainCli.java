package ai.quantumsense.tgmonitor.main.cli.split;

import ai.quantumsense.tgmonitor.cli.Cli;
import ai.quantumsense.tgmonitor.ipc.ui.Endpoint;

public class MainCli {
    private static final String VERSION = "0.0.5";
    private static final String AMQP_URI = System.getenv("AMQP_URI");

    public static void main(String[] args) {
        checkEnv();
        Endpoint endpoint = new Endpoint(AMQP_URI);
        new Cli(endpoint, endpoint, VERSION);
    }

    private static void checkEnv() {
        if (AMQP_URI == null)
            throw new RuntimeException("Must set AMQP_URI environment variable");
    }
}
