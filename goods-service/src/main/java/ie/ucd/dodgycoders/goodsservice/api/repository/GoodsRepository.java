package ie.ucd.dodgycoders.goodsservice.api.repository;

import ie.ucd.dodgycoders.goodsservice.api.model.Goods;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GoodsRepository extends MongoRepository<Goods, Long> {

    List<Goods> findAll();
    Goods findGoodsByItemId(Long itemId);
}
