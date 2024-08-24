package com.pojo_3;

public class PartialBookingPOJO {
	private String firstname;
	private String lastname;
	@Override
	public String toString() {
		return "PartialBookingPOJO [firstname=" + firstname + ", lastname=" + lastname + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public PartialBookingPOJO(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}
}
