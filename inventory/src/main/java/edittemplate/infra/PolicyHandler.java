package edittemplate.infra;

import edittemplate.domain.*;
import java.util.function.Consumer;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Bean
    public Consumer<Message<?>> discardFunction() {
        return message -> {
            // Ingore unnecessary message
            System.out.println("Discarded message: " + message);
        };
    }

    @Bean
    public Consumer<Message<OrderPlaced>> wheneverOrderPlaced_DecreaseStock() {
        return event -> {
            OrderPlaced orderPlaced = event.getPayload();
            Product.decreaseStock(orderPlaced);
        };
    }

    @Bean
    public Consumer<Message<OrderCanceled>> wheneverOrderCanceled_IncreaseStock() {
        return event -> {
            OrderCanceled orderCanceled = event.getPayload();
            Product.increaseStock(orderCanceled);
        };
    }
}
//>>> Clean Arch / Inbound Adaptor
