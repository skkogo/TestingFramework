package com.pojo_3;

public class CreateBookingPOJO {
	private String firstname;
	private String lastname;
	private int totalprice;
	private boolean depositpaid;
	private BookingdatesPOJO bookingdates;
	private String additionalneeds;
	public CreateBookingPOJO(String firstname, String lastname, int totalprice, boolean depositpaid,
			BookingdatesPOJO bookingdates, String additionalneeds) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.totalprice = totalprice;
		this.depositpaid = depositpaid;
		this.bookingdates = bookingdates;
		this.additionalneeds = additionalneeds;
	}
	@Override
	public String toString() {
		return "CreateBooking [firstname=" + firstname + ", lastname=" + lastname + ", totalprice=" + totalprice
				+ ", depositpaid=" + depositpaid + ", bookingdates=" + bookingdates + ", additionalneeds="
				+ additionalneeds + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}


}
