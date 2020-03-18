package Booking.entity;

import Booking.dao.Identifiable;

import java.io.Serializable;

public class User implements Identifiable, Serializable {
  private long id;
  private String user_name;
  private String passwd;

  static long counter;

  private static final long serialVersionUID = 1L;

  public User(String user_name, String passwd) {
    this(++counter, user_name, passwd);
//    this.login = login;
//    this.passwd = passwd;
//    this.id = ++counter;
  }

  public User(long id, String user_name, String passwd) {
    System.out.println("user constructor");
    this.user_name = user_name;
    this.passwd = passwd;
    this.id = id;
  }

  public static void setCounter(long counter) {
    User.counter = counter;
  }

  @Override
  public long getId() {
    return id;
  }

  public String getUser_name() {
    return user_name;
  }

  public String getPasswd() {
    return passwd;
  }

  public String represent() {
    return String.format("User{id=%d, login='%s', passwd='%s'}", id, user_name, passwd);
  }
}
