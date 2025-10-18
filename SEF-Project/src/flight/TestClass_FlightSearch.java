package flight;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestClass_FlightSearch {
	
	void attributesNotInit(FlightSearch fs) {
		// Tests the function has not initialized attributes
		assertEquals("null",        fs.getDepartureAirportCode());
		assertEquals(false, fs.isEmergencyRowSeating());
		assertEquals("null", fs.getReturnDate());
		assertEquals("null",        fs.getDestinationAirportCode());
		assertEquals("null",    fs.getSeatingClass());
		assertEquals(-1, fs.getAdultPassengerCount());
		assertEquals(-1, fs.getChildPassengerCount());
		assertEquals(-1, fs.getInfantPassengerCount());
	}
	
	@Test
	void testrunFlightSearch_testCase1() {
		//Test Case 1: Check function with valid inputs
			//Test Case 1_Test Data 1
			FlightSearch flightSerachTestCase1Data1 = new FlightSearch();
			assertTrue(flightSerachTestCase1Data1.runFlightSearch("20/10/2025", "syd", true, "25/10/2025", 
																	"mel", "economy", 1, 0, 0));
			 assertEquals("20/10/2025", flightSerachTestCase1Data1.getDepartureDate());
		     assertEquals("syd",        flightSerachTestCase1Data1.getDepartureAirportCode());
		     assertTrue(flightSerachTestCase1Data1.isEmergencyRowSeating());
		     assertEquals("25/10/2025", flightSerachTestCase1Data1.getReturnDate());
		     assertEquals("mel",        flightSerachTestCase1Data1.getDestinationAirportCode());
		     assertEquals("economy",    flightSerachTestCase1Data1.getSeatingClass());
		     assertEquals(1, flightSerachTestCase1Data1.getAdultPassengerCount());
		     assertEquals(0, flightSerachTestCase1Data1.getChildPassengerCount());
		     assertEquals(0, flightSerachTestCase1Data1.getInfantPassengerCount());
			
			
			//Test Case 1_Test Data 2
			FlightSearch flightSerachTestCase1Data2 = new FlightSearch();
			assertTrue(flightSerachTestCase1Data2.runFlightSearch("21/10/2025", "del", false, "30/10/2025",
																"pvg", "first", 1, 0, 1));
			assertEquals("21/10/2025", flightSerachTestCase1Data2.getDepartureDate());
			assertEquals("del",        flightSerachTestCase1Data2.getDepartureAirportCode());
			assertFalse(flightSerachTestCase1Data2.isEmergencyRowSeating());
			assertEquals("30/10/2025", flightSerachTestCase1Data2.getReturnDate());
			assertEquals("pvg",        flightSerachTestCase1Data2.getDestinationAirportCode());
			assertEquals("first",      flightSerachTestCase1Data2.getSeatingClass());
			assertEquals(1, flightSerachTestCase1Data2.getAdultPassengerCount());
			assertEquals(0, flightSerachTestCase1Data2.getChildPassengerCount());
			assertEquals(1, flightSerachTestCase1Data2.getInfantPassengerCount());
			
			//Test Case 1_Test Data 3
			FlightSearch flightSerachTestCase1Data3 = new FlightSearch();
			assertTrue(flightSerachTestCase1Data3.runFlightSearch("25/10/2025", "syd", false, "01/11/2025", 
																	"lax", "premium economy", 7, 2, 0));
			assertEquals("25/10/2025", flightSerachTestCase1Data3.getDepartureDate());
			assertEquals("syd",        flightSerachTestCase1Data3.getDepartureAirportCode());
			assertFalse(flightSerachTestCase1Data3.isEmergencyRowSeating());
			assertEquals("01/11/2025", flightSerachTestCase1Data3.getReturnDate());
			assertEquals("lax",        flightSerachTestCase1Data3.getDestinationAirportCode());
			assertEquals("premium economy", flightSerachTestCase1Data3.getSeatingClass());
			assertEquals(7, flightSerachTestCase1Data3.getAdultPassengerCount());
			assertEquals(2, flightSerachTestCase1Data3.getChildPassengerCount());
			assertEquals(0, flightSerachTestCase1Data3.getInfantPassengerCount());
			
			//Test Case 1_Test Data 4
			FlightSearch flightSerachTestCase1Data4 = new FlightSearch();
			assertTrue(flightSerachTestCase1Data4.runFlightSearch("22/10/2025", "lax", false, "28/10/2025", 
																	"cdg", "economy", 4, 1, 4));
			assertEquals("22/10/2025", flightSerachTestCase1Data4.getDepartureDate());
			assertEquals("lax",        flightSerachTestCase1Data4.getDepartureAirportCode());
			assertFalse(flightSerachTestCase1Data4.isEmergencyRowSeating());
			assertEquals("28/10/2025", flightSerachTestCase1Data4.getReturnDate());
			assertEquals("cdg",        flightSerachTestCase1Data4.getDestinationAirportCode());
			assertEquals("economy",    flightSerachTestCase1Data4.getSeatingClass());
			assertEquals(4, flightSerachTestCase1Data4.getAdultPassengerCount());
			assertEquals(1, flightSerachTestCase1Data4.getChildPassengerCount());
			assertEquals(4, flightSerachTestCase1Data4.getInfantPassengerCount());
	}
	
	@Test
	void testrunFlightSearch_testCase2() {
		//Test Case 2: Check function with invalid total number of passengers
			//Test Case 2_Test Data 1
			FlightSearch flightSerachTestCase2Data1 = new FlightSearch();
			assertFalse(flightSerachTestCase2Data1.runFlightSearch("20/10/2025", "syd", false, "25/10/2025", 
																	"mel", "economy", 0, 0, 0));
			attributesNotInit(flightSerachTestCase2Data1);
			
			//Test Case 2_Test Data 2
			FlightSearch flightSerachTestCase2Data2 = new FlightSearch();
			assertFalse(flightSerachTestCase2Data2.runFlightSearch("22/10/2025", "syd", false, "28/10/2025", 
																	"cdh", "economy", 5, 1, 4));
			attributesNotInit(flightSerachTestCase2Data2);
	}
	
	@Test
	void testrunFlightSearch_testCase3() {
		//Test Case 3: Check function with children seated in emergency row seating or first class.
			//Test Case 3_Test Data 1
			FlightSearch flightSerachTestCase3Data1 = new FlightSearch();
			assertFalse(flightSerachTestCase3Data1.runFlightSearch("20/10/2025", "syd", false, "25/10/2025", 
																	"mel", "first", 1, 2, 0));
			attributesNotInit(flightSerachTestCase3Data1);
			
			//Test Case 3_Test Data 2
			FlightSearch flightSerachTestCase3Data2 = new FlightSearch();
			assertFalse(flightSerachTestCase3Data2.runFlightSearch("25/10/2025", "syd", true, "01/11/2025", 
																	"lax", "economy", 3, 6, 0));
			attributesNotInit(flightSerachTestCase3Data2);
	}
	
	@Test
	void testrunFlightSearch_testCase4() {
		//Test Case 4: Check function with infants seated in emergency row seating or business class.
			//Test Case 4_Test Data 1
			FlightSearch flightSerachTestCase4Data1 = new FlightSearch();
			assertFalse(flightSerachTestCase4Data1.runFlightSearch("21/10/2025", "del", false, "30/10/2025",
																	"pvg", "business", 1, 0, 1));
			attributesNotInit(flightSerachTestCase4Data1);
			
			//Test Case 4_Test Data 2
			FlightSearch flightSerachTestCase4Data2 = new FlightSearch();
			assertFalse(flightSerachTestCase4Data2.runFlightSearch("22/10/2025", "lax", true, "28/10/2025", 
																	"cdg", "economy", 4, 0, 4));
			attributesNotInit(flightSerachTestCase4Data2);
	}
	
	@Test
	void testrunFlightSearch_testCase5() {
		//Test Case 5: Check function with invalid number of child passengers per adult.
			//Test Case 5_Test Data 1
			FlightSearch flightSerachTestCase5Data1 = new FlightSearch();
			assertFalse(flightSerachTestCase5Data1.runFlightSearch("20/10/2025", "syd", false, "25/10/2025",
																	"mel", "economy", 0, 1, 0));
			attributesNotInit(flightSerachTestCase5Data1);
			
			//Test Case 5_Test Data 2
			FlightSearch flightSerachTestCase5Data2 = new FlightSearch();
			assertFalse(flightSerachTestCase5Data2.runFlightSearch("25/10/2025", "syd", false, "01/11/2025", 
																	"lax", "premium economy", 2, 6, 0));
			attributesNotInit(flightSerachTestCase5Data2);
	}
	
	@Test
	void testrunFlightSearch_testCase6() {
		//Test Case 6: Check function with invalid number of infants per adult.
			//Test Case 6_Test Data 1
			FlightSearch flightSerachTestCase6Data1 = new FlightSearch();
			assertFalse(flightSerachTestCase6Data1.runFlightSearch("20/10/2025", "syd", false, "25/10/2025",
																	"mel", "economy", 0, 0, 1));
			attributesNotInit(flightSerachTestCase6Data1);
			
			//Test Case 6_Test Data 2
			FlightSearch flightSerachTestCase6Data2 = new FlightSearch();
			assertFalse(flightSerachTestCase6Data2.runFlightSearch("20/10/2025", "syd", false, "25/10/2025", 
																	"mel", "economy", 4, 0, 5));
			attributesNotInit(flightSerachTestCase6Data2);
	}
	
	@Test
	void testrunFlightSearch_testCase7() {
		//Test Case 7: Check function with departure date in the past.
			//Test Case 7_Test Data 1
			FlightSearch flightSerachTestCase7Data1 = new FlightSearch();
			assertFalse(flightSerachTestCase7Data1.runFlightSearch("10/10/2025", "syd", false, "25/10/2025",
																	"mel", "economy", 1, 0, 0));
			attributesNotInit(flightSerachTestCase7Data1);
			
			//Test Case 7_Test Data 2
			FlightSearch flightSerachTestCase7Data2 = new FlightSearch();
			assertFalse(flightSerachTestCase7Data2.runFlightSearch("05/10/2025", "syd", false, "06/10/2025",
																	"mel", "economy", 1, 0, 0));
			attributesNotInit(flightSerachTestCase7Data2);
	}
	
	@Test
	void testrunFlightSearch_testCase8() {
	    //Test Case 8: Check function with invalid date format.

	    //Test Case 8_Test Data 1
	    FlightSearch flightSerachTestCase8Data1 = new FlightSearch();
	    assertFalse(flightSerachTestCase8Data1.runFlightSearch("12/31/2025", "syd", false, "31/12/2026",
	                                                           "mel", "economy", 1, 0, 0));
	    attributesNotInit(flightSerachTestCase8Data1);

	    //Test Case 8_Test Data 2
	    FlightSearch flightSerachTestCase8Data2 = new FlightSearch();
	    assertFalse(flightSerachTestCase8Data2.runFlightSearch("31/12/2025", "syd", false, "12/31/2026",
	                                                           "mel", "economy", 1, 0, 0));
	    attributesNotInit(flightSerachTestCase8Data2);

	    //Test Case 8_Test Data 3
	    FlightSearch flightSerachTestCase8Data3 = new FlightSearch();
	    assertFalse(flightSerachTestCase8Data3.runFlightSearch("2025/13/31", "syd", false, "31/12/2026",
	                                                           "mel", "economy", 1, 0, 0));
	    attributesNotInit(flightSerachTestCase8Data3);

	    //Test Case 8_Test Data 4
	    FlightSearch flightSerachTestCase8Data4 = new FlightSearch();
	    assertFalse(flightSerachTestCase8Data4.runFlightSearch("31/12/2025", "syd", false, "2026/13/31",
	                                                           "mel", "economy", 1, 0, 0));
	    attributesNotInit(flightSerachTestCase8Data4);

	    //Test Case 8_Test Data 5
	    FlightSearch flightSerachTestCase8Data5 = new FlightSearch();
	    assertFalse(flightSerachTestCase8Data5.runFlightSearch("29/02/2026", "syd", false, "01/03/2026",
	                                                           "mel", "economy", 1, 0, 0));
	    attributesNotInit(flightSerachTestCase8Data5);

	    //Test Case 8_Test Data 6
	    FlightSearch flightSerachTestCase8Data6 = new FlightSearch();
	    assertFalse(flightSerachTestCase8Data6.runFlightSearch("28/02/2026", "syd", false, "29/02/2026",
	                                                           "mel", "economy", 1, 0, 0));
	    attributesNotInit(flightSerachTestCase8Data6);

	    //Test Case 8_Test Data 7
	    FlightSearch flightSerachTestCase8Data7 = new FlightSearch();
	    assertFalse(flightSerachTestCase8Data7.runFlightSearch("1/01/2026", "syd", false, "31/12/2026",
	                                                           "mel", "economy", 1, 0, 0));
	    attributesNotInit(flightSerachTestCase8Data7);

	    //Test Case 8_Test Data 8
	    FlightSearch flightSerachTestCase8Data8 = new FlightSearch();
	    assertFalse(flightSerachTestCase8Data8.runFlightSearch("01/1/2026", "syd", false, "31/12/2026",
	                                                           "mel", "economy", 1, 0, 0));
	    attributesNotInit(flightSerachTestCase8Data8);

	    //Test Case 8_Test Data 9
	    FlightSearch flightSerachTestCase8Data9 = new FlightSearch();
	    assertFalse(flightSerachTestCase8Data9.runFlightSearch("01/01/2026", "syd", false, "1/01/2027",
	                                                           "mel", "economy", 1, 0, 0));
	    attributesNotInit(flightSerachTestCase8Data9);

	    //Test Case 8_Test Data 10
	    FlightSearch flightSerachTestCase8Data10 = new FlightSearch();
	    assertFalse(flightSerachTestCase8Data10.runFlightSearch("01/01/2026", "syd", false, "01/1/2027",
	                                                            "mel", "economy", 1, 0, 0));
	    attributesNotInit(flightSerachTestCase8Data10);
	}

	@Test
	void testrunFlightSearch_testCase9() {
	    //Test Case 9: Check function with invalid return dates.

	        //Test Case 9_Test Data 1
	        FlightSearch flightSerachTestCase9Data1 = new FlightSearch();
	        assertFalse(flightSerachTestCase9Data1.runFlightSearch("20/10/2025", "syd", false, "19/10/2025",
	                                                                "mel", "economy", 1, 0, 0));
	        attributesNotInit(flightSerachTestCase9Data1);

	        //Test Case 9_Test Data 2
	        FlightSearch flightSerachTestCase9Data2 = new FlightSearch();
	        assertFalse(flightSerachTestCase9Data2.runFlightSearch("20/10/2025", "syd", false, "", "",
	                                                                "economy", 1, 0, 0));
	        attributesNotInit(flightSerachTestCase9Data2);
	}	
	
	@Test
	void testrunFlightSearch_testCase10() {
	    //Test Case 10: Check function with invalid seating classes.

	        //Test Case 10_Test Data 1
	        FlightSearch flightSerachTestCase10Data1 = new FlightSearch();
	        assertFalse(flightSerachTestCase10Data1.runFlightSearch("20/10/2025", "syd", true, "25/10/2025",
	                                                                "mel", "", 1, 0, 0));
	        attributesNotInit(flightSerachTestCase10Data1);

	        //Test Case 10_Test Data 2
	        FlightSearch flightSerachTestCase10Data2 = new FlightSearch();
	        assertFalse(flightSerachTestCase10Data2.runFlightSearch("20/10/2025", "syd", true, "25/10/2025",
	                                                                "mel", "scum", 1, 0, 0));
	        attributesNotInit(flightSerachTestCase10Data2);
	}
	
	@Test
	void testrunFlightSearch_testCase11() {
	    //Test Case 11: Check function with invalid emergency row seating.

	        //Test Case 11_Test Data 1
	        FlightSearch flightSerachTestCase11Data1 = new FlightSearch();
	        assertFalse(flightSerachTestCase11Data1.runFlightSearch("20/10/2025", "syd", true, "25/10/2025",
	                                                                "mel", "premium economy", 1, 0, 0));
	        attributesNotInit(flightSerachTestCase11Data1);

	        //Test Case 11_Test Data 2
	        FlightSearch flightSerachTestCase11Data2 = new FlightSearch();
	        assertFalse(flightSerachTestCase11Data2.runFlightSearch("20/10/2025", "syd", true, "25/10/2025",
	                                                                "mel", "business", 1, 0, 0));
	        attributesNotInit(flightSerachTestCase11Data2);

	        //Test Case 11_Test Data 3
	        FlightSearch flightSerachTestCase11Data3 = new FlightSearch();
	        assertFalse(flightSerachTestCase11Data3.runFlightSearch("20/10/2025", "syd", true, "25/10/2025",
	                                                                "mel", "first", 1, 0, 0));
	        attributesNotInit(flightSerachTestCase11Data3);
	}
	
	@Test
	void testrunFlightSearch_testCase12() {
	    //Test Case 12: Check function with invalid departure and destination airports.

	        //Test Case 12_Test Data 1
	        FlightSearch flightSerachTestCase12Data1 = new FlightSearch();
	        assertFalse(flightSerachTestCase12Data1.runFlightSearch("20/10/2025", "byd", true, "25/10/2025",
	                                                                "mel", "economy", 1, 0, 0));
	        attributesNotInit(flightSerachTestCase12Data1);

	        //Test Case 12_Test Data 2
	        FlightSearch flightSerachTestCase12Data2 = new FlightSearch();
	        assertFalse(flightSerachTestCase12Data2.runFlightSearch("20/10/2025", "mel", true, "25/10/2025",
	                                                                "lpd", "economy", 1, 0, 0));
	        attributesNotInit(flightSerachTestCase12Data2);
	}

	
}
