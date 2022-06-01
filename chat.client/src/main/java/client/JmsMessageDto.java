package client;

import lombok.Builder;
import lombok.Value;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Builder
@Value
public class JmsMessageDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 4301336120077008522L;
    String text;
    Set<String> receivers;
    MessageType messageType;
}
