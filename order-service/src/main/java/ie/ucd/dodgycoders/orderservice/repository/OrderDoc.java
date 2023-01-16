package ie.ucd.dodgycoders.orderservice.repository;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.mapping.Document;

import ie.ucd.dodgycoders.orderservice.api.model.Order;

/**
 * MongoDB Entity for Order document
 */
@Document("orders")
public class OrderDoc extends Order {
    public Date date;

    public static OrderDoc factory(Order order) {
        OrderDoc doc = new OrderDoc();
        // Ignore orderDate when copying properites, instead use a new field.
        // Persisting date time types with time zones was never supported by Spring Data
        // https://stackoverflow.com/a/53098325
        BeanUtils.copyProperties(order, doc, "orderDate");
        doc.date = new Date();
        // System.out.println("Converted Order to model: " + doc);
        return doc;
    }

    @Override
    public String toString() {
        return "OrderDoc [date=" + date + super.toString() + "]";
    }

    
}
