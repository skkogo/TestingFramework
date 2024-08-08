package com.pojo_3;

public class CreateBooking {
	private String username ; 
  private String  password ;
public CreateBooking(String username, String password) {
	super();
	this.username = username;
	this.password = password;
}
@Override
public String toString() {
	return "CreateBooking [username=" + username + ", password=" + password + ", getClass()=" + getClass()
			+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
} 

}
