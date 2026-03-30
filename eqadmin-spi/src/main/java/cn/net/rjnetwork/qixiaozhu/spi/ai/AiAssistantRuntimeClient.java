package cn.net.rjnetwork.qixiaozhu.spi.ai;

import java.util.List;

/**
 * Public bridge for host-provided AI assistant runtimes used by plugins.
 */
public interface AiAssistantRuntimeClient {

    @FunctionalInterface
    interface MessageListener {
        void onMessage(Object message, String clientId);
    }

    record SendResult(
            boolean success,
            String message,
            String error,
            List<Object> messages
    ) {
    }

    boolean runtimeAvailable();

    boolean connected();

    boolean ensureConnected();

    String statusMessage();

    String lastError();

    Object registerMessageListener(MessageListener listener);

    void unregisterMessageListener(Object handle);

    SendResult sendAndReceive(String content, int maxMessages, int timeoutSeconds, String clientId);
}
