import static org.junit.Assert.*;
import org.junit.Test;

import com.example.County;
import com.example.Restaurant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class RestaurantTest {

    @Test
    public void testIsOpen_OpenDuringWeekday() {
        Restaurant restaurant = new Restaurant("Some Restaurant", "123 Main St", County.LA_COUNTY, "08:00-16:00");
        LocalDateTime mondayMorning = LocalDateTime.of(2024, 5, 20, 10, 0);
        assertTrue(restaurant.isOpen(mondayMorning));
    }

    @Test
    public void testIsOpen_ClosedDuringWeekday() {
        Restaurant restaurant = new Restaurant("Another Restaurant", "456 Elm St", County.LA_COUNTY, "10:00-18:00");
        LocalDateTime mondayAfternoon = LocalDateTime.of(2024, 5, 20, 15, 0);
        assertTrue(restaurant.isOpen(mondayAfternoon));
    }

    @Test
    public void testIsOpen_OpenOnWeekend() {
        Restaurant restaurant = new Restaurant("Weekend Restaurant", "789 Oak St", County.LA_COUNTY, "10:00-18:00");
        LocalDateTime saturdayMorning = LocalDateTime.of(2024, 5, 18, 11, 0);
        assertTrue(restaurant.isOpen(saturdayMorning));
    }

    @Test
    public void testIsOpen_ClosedOnSunday() {
        Restaurant restaurant = new Restaurant("Sunday Closed Restaurant", "101 Pine St", County.LA_COUNTY, "10:00-18:00");
        LocalDateTime sundayAfternoon = LocalDateTime.of(2024, 5, 19, 15, 0);
        assertFalse(restaurant.isOpen(sundayAfternoon));
    }
}
