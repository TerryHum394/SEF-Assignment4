
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestClass_FlightSerach {
    
	@Test
	void testrunFlightSearch_testCase1() {
		//Test Case 1: Check function with valid inputs
			//Test Case 1_Test Data 1
			FlightSearch flightSerachTestCase1Data1 = new flightSearch();
			assertTrue(flightSerachTestCase1Data1.runFlightSearch("20/10/2025", "syd", true, "25/10/2025", 
																	"mel", "economy", 1, 0, 0));
			assertEquals("20/10/2025", flightSerachTestCase1Data1.departureDate);
			//Test Case 1_Test Data 2
			FlightSearch flightSerachTestCase1Data2 = new flightSearch();
			assertTrue(flightSerachTestCase1Data2.runFlightSearch("21/10/2025", "del", false, "30/10/2025",
																	"pvg", "first", 1, 0, 1));
			
			//Test Case 1_Test Data 3
			FlightSearch flightSerachTestCase1Data3 = new flightSearch();
			assertTrue(flightSerachTestCase1Data3.runFlightSearch("25/10/2025", "syd", false, "01/11/2025", 
																	"lax", "premium economy", 7, 2, 0));
			
			//Test Case 1_Test Data 4
			FlightSearch flightSerachTestCase1Data4 = new flightSearch();
			assertTrue(flightSerachTestCase1Data4.runFlightSearch("22/10/2025", "lax", false, "28/10/2025", 
																	"cdg", "economy", 4, 1, 4));
	}
	
}
