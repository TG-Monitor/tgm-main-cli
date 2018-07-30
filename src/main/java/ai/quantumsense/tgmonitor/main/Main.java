package ai.quantumsense.tgmonitor.main;

import ai.quantumsense.tgmonitor.cli.Cli;
import ai.quantumsense.tgmonitor.ipcadapter.rpc.RabbitMqRpcClient;
import ai.quantumsense.tgmonitor.ipcadapter.rpc.RabbitMqRpcMonitorFacade;
import ai.quantumsense.tgmonitor.ipcadapter.rpc.RpcClient;
import ai.quantumsense.tgmonitor.monitorfacade.MonitorFacade;

public class Main {
    private static final String VERSION = "0.0.5";
    private static final String RABBITMQ_QUEUE_NAME = "tg-monitor";

    public static void main(String[] args) {
        RpcClient rpcClient = new RabbitMqRpcClient(RABBITMQ_QUEUE_NAME);
        MonitorFacade rpcMonitorFacade = new RabbitMqRpcMonitorFacade(rpcClient);
        Cli cli = new Cli(rpcMonitorFacade, VERSION);
        cli.launch();
    }
}
