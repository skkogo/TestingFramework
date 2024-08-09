package com.pojo_3;

public class Runner2 {
	public static void main(String[] args) {
		Bookingdates bookingdates = new Bookingdates("18-09-2024", "21-09-2024");
		CreateBooking createBooking = new CreateBooking("Saurabh", "Kumar", 10000, true, "Breakfast", bookingdates);
		System.out.println(createBooking);
		
	}

}
