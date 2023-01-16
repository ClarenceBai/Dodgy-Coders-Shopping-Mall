package ie.ucd.dodgycoders.userservice.api.repository;

import ie.ucd.dodgycoders.userservice.api.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface UserRepository extends MongoRepository<User,String> {
//public interface UserRepository{
    User findByUsernameAndPasswordNotNull (String username, String password);
}
