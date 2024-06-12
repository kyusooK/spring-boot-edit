package edittemplate.domain;

import edittemplate.domain.*;
import edittemplate.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class StockIncreased extends AbstractEvent {

    private Long id;
    private Integer stock;

    public StockIncreased(Product aggregate) {
        super(aggregate);
    }

    public StockIncreased() {
        super();
    }
}
//>>> DDD / Domain Event
