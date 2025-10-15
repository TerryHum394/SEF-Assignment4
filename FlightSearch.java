package flight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class FlightSearch {
   private String  departureDate;
   private String  departureAirportCode;
   private boolean emergencyRowSeating;
   private String  returnDate;
   private String  destinationAirportCode; 
   private String  seatingClass;
   private int     adultPassengerCount;
   private int     childPassengerCount;
   private int     infantPassengerCount;

   public FlightSearch() {
      this.departureDate = null;
      this.departureAirportCode = null;
      this.emergencyRowSeating = false;
      this.returnDate = null;
      this.destinationAirportCode = null;
      this.seatingClass = null;
      this.adultPassengerCount = -1;
      this.childPassengerCount = -1;
      this.infantPassengerCount = -1;
   }

   public boolean runFlightSearch(String departureDate,    String departureAirportCode,   boolean emergencyRowSeating, 
                                  String returnDate,       String destinationAirportCode, String seatingClass, 
                                  int adultPassengerCount, int childPassengerCount,       int infantPassengerCount) {
      boolean valid = true;

      // Condition 1
      int totalPassengerCount = adultPassengerCount + childPassengerCount + infantPassengerCount;
      if ((totalPassengerCount < 1) || (totalPassengerCount > 9))
         valid = false;
      
      // Condition 2
      if ((childPassengerCount > 0) && (emergencyRowSeating || seatingClass.equals("first")))
         valid = false;
      
      // Condition 3
      if ((infantPassengerCount > 0) && (emergencyRowSeating || seatingClass.equals("business")))
         valid = false;
      
      // Condition 4
      if (childPassengerCount > adultPassengerCount * 2)
         valid = false;
      
      // Condition 5
      if (infantPassengerCount > adultPassengerCount)
         valid = false;

      // Condition 6, 7, 8
      DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
      try {
         LocalDate depDate = LocalDate.parse(departureDate, fmt);
         LocalDate currentDate = LocalDate.now();

         // Validate departure date format strictly and ensure it is not in the past, else invalid
         if (depDate.isBefore(currentDate))
            valid = false;
         
         // If a return date is provided, validate its format strictly and ensure it is not before departure, else invalid
         if (returnDate != null && !returnDate.isEmpty()) {
            LocalDate retDate = LocalDate.parse(returnDate, fmt);
            if (retDate.isBefore(depDate))
               valid = false;
         } else 
            valid = false;
      } catch (DateTimeParseException e) {
         valid = false; // Invalid date format or invalid date (strict)
      }

      // Condition 9
      if (!(seatingClass.equals("economy") || !seatingClass.equals("premium economy") || !seatingClass.equals("business") || !seatingClass.equals("first")))
         valid = false;

      // Condition 10
      if (!seatingClass.equals("economy") && emergencyRowSeating)
         valid = false;
      
      // Condition 11
      String[] airportCodes = {"syd", "mel", "lax", "cdg", "del", "pvg", "doh"};
      // Validate departure airport code
      valid = false;
      for (String code : airportCodes) {
         if (departureAirportCode.equals(code)) {
            valid = true;
            break;
         }
      }
      // Validate destination airport code
       valid = false;
      for (String code : airportCodes) {
         if (destinationAirportCode.equals(code)) {
            valid = true;
            break;
         }
      }

      // If all conditions are met, return true and initialize attributes
      if (valid) {
         this.departureDate = departureDate;
         this.departureAirportCode = departureAirportCode;
         this.emergencyRowSeating = emergencyRowSeating;
         this.returnDate = returnDate;
         this.destinationAirportCode = destinationAirportCode;
         this.seatingClass = seatingClass;
         this.adultPassengerCount = adultPassengerCount;
         this.childPassengerCount = childPassengerCount;
         this.infantPassengerCount = infantPassengerCount;
      }
      
      return valid;
   }
}