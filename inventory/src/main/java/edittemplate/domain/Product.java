package edittemplate.domain;

import edittemplate.InventoryApplication;
import edittemplate.domain.StockDecreased;
import edittemplate.domain.StockIncreased;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Entity
@Table(name = "Product_table")
@Data
//<<< DDD / Aggregate Root
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer stock;

    @PostPersist
    public void onPostPersist() {
        StockDecreased stockDecreased = new StockDecreased(this);
        stockDecreased.publishAfterCommit();

        StockIncreased stockIncreased = new StockIncreased(this);
        stockIncreased.publishAfterCommit();
    }

    public static ProductRepository repository() {
        ProductRepository productRepository = InventoryApplication.applicationContext.getBean(
            ProductRepository.class
        );
        return productRepository;
    }

    //<<< Clean Arch / Port Method
    public static void decreaseStock(OrderPlaced orderPlaced) {
        //implement business logic here:

        /** Example 1:  new item 
        Product product = new Product();
        repository().save(product);

        StockDecreased stockDecreased = new StockDecreased(product);
        stockDecreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(product->{
            
            product // do something
            repository().save(product);

            StockDecreased stockDecreased = new StockDecreased(product);
            stockDecreased.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void increaseStock(OrderCanceled orderCanceled) {
        //implement business logic here:

        /** Example 1:  new item 
        Product product = new Product();
        repository().save(product);

        StockIncreased stockIncreased = new StockIncreased(product);
        stockIncreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(product->{
            
            product // do something
            repository().save(product);

            StockIncreased stockIncreased = new StockIncreased(product);
            stockIncreased.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
