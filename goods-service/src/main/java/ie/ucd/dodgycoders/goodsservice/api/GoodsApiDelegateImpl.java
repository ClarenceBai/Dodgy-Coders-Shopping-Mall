package ie.ucd.dodgycoders.goodsservice.api;

import ie.ucd.dodgycoders.goodsservice.api.model.Goods;
import ie.ucd.dodgycoders.goodsservice.api.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsApiDelegateImpl implements GoodsApiDelegate {

    @Autowired
    private GoodsRepository goodsRepo;

    @Override
    public ResponseEntity<List> goodsGet(){
        System.out.println("GOODS LOG: Received request from client, getting all goods...");
        List<Goods> response;

        try{
            response = goodsRepo.findAll();
        }catch(Exception e) {
            System.out.println("GOODS LOG: Error when getting all goods...");
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        System.out.println("GOODS LOG: Found all goods, returning...");
        return  new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Goods> goodsItemIdGet(Long itemId){
        System.out.println("GOODS LOG: Received request from client, finding item with id:" + itemId + "...");
        Goods response;

        try{
            response = goodsRepo.findGoodsByItemId(itemId);
        }catch(Exception e) {
            System.out.println("GOODS LOG: Error when getting item with id:" + itemId + "...");
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        System.out.println("GOODS LOG: Found item with id:" + itemId + ", returning...");
        return  new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
