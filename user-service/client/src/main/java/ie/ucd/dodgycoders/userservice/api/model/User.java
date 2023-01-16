package ie.ucd.dodgycoders.userservice.api.model;

import java.math.BigInteger;
import org.springframework.data.annotation.Id;


/**
 * User
 */


public class User {
  @Id
  private BigInteger _id;
  private int id;
  private String username;
  private String password;
  private String email;

  public User() {}
  public User(BigInteger _id, int id, String username, String password, String email) {
    this._id = _id;
    this.id = id;
    this.username = username;
    this.password = password;
    this.email = email;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}


