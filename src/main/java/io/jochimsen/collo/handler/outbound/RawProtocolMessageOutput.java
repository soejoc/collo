package io.jochimsen.collo.handler.outbound;

import io.jochimsen.collo.stream.ProtocolOutputStream;

public class RawProtocolMessageOutput {
    private final int messageId;
    private final ProtocolOutputStream protocolOutputStream;

    public RawProtocolMessageOutput(final int messageId, final ProtocolOutputStream protocolOutputStream) {
        this.messageId = messageId;
        this.protocolOutputStream = protocolOutputStream;
    }

    public int getMessageId() {
        return messageId;
    }

    public ProtocolOutputStream getProtocolOutputStream() {
        return protocolOutputStream;
    }
}
