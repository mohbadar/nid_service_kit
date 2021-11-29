package af.gov.anar.service_kit.notification.service.channel;


import af.gov.anar.service_kit.notification.model.ChannelType;
import af.gov.anar.service_kit.notification.model.Message;

public interface Channel {
    default void notify(Message msg) {
        throw new RuntimeException("Notify method is not implemented yet.");
    }

    default boolean supports(ChannelType type) {
        throw new RuntimeException("Notify method is not implemented yet.");
    }
}
