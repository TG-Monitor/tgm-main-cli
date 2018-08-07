package ai.quantumsense.tgmonitor.main.cli.split;

import ai.quantumsense.tgmonitor.cli.Cli;
import ai.quantumsense.tgmonitor.ipc.UiEndpoint;
import ai.quantumsense.tgmonitor.ipc.messenger.RabbitMqUiMessenger;
import ai.quantumsense.tgmonitor.ipc.messenger.serializer.JsonSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainCli {
    private static Logger logger = LoggerFactory.getLogger(MainCli.class);

    private static final String VERSION = "0.0.5";

    public static void main(String[] args) {
        logger.debug("Creating UI Endpoint");
        UiEndpoint uiEndpoint = new UiEndpoint(new RabbitMqUiMessenger(new JsonSerializer()));
        logger.debug("Creating and launching CLI");
        Cli cli = new Cli(uiEndpoint, VERSION);
        cli.launch();
    }
}
