package io.jochimsen.collo.handler.inbound;

import io.jochimsen.collo.stream.ProtocolInputStream;
import lombok.Value;
import lombok.experimental.NonFinal;

@Value
@NonFinal
public class RawProtocolMessageInput {
    private final int messageId;
    private final ProtocolInputStream protocolInputStream;
}
