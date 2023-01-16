package ie.ucd.dodgycoders.orderservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<OrderDoc, String> {

}
