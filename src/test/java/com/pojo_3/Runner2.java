package com.pojo_3;

import com.util.TestUtil;

public class Runner2 {
	public static void main(String[] args) {
		BookingdatesPOJO bookingdates = new BookingdatesPOJO("18-09-2024", "21-09-2024");

		CreateBookingPOJO createBooking = new CreateBookingPOJO("Saurabh", "Kumar", 10000, true, bookingdates,"Breakfast");

		System.out.println(createBooking);
		String createBookingJSON = TestUtil.convertPOJOtoJSON(createBooking);
		System.out.println(createBookingJSON); 
 
	}

}
