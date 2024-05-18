import static org.junit.Assert.*;
import org.junit.Test;

import com.example.County;
import com.example.Customer;
import com.example.Driver;
import com.example.FoodOrder;
import com.example.Restaurant;
import com.example.Shift;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FoodOrderTest {

    @Test
    public void testCreateOrder() {
        Customer customer = new Customer("Alice", "123 Main St", County.LA_COUNTY);
        Restaurant restaurant = new Restaurant("Some Restaurant", "456 Elm St", County.LA_COUNTY, "08:00-16:00");
        List<List<String>> foodItems = new ArrayList<>();
        foodItems.add(new ArrayList<>(List.of("Burger", "Fries")));
        foodItems.add(new ArrayList<>(List.of("Pizza", "Salad")));
        FoodOrder order = new FoodOrder(customer, restaurant, foodItems);
        order.createOrder(); 
    }

    @Test
    public void testAssignDriver() {
        Customer customer = new Customer("Alice", "123 Main St", County.LA_COUNTY);
        Restaurant restaurant = new Restaurant("Some Restaurant", "456 Elm St", County.LA_COUNTY, "08:00-16:00");
        List<List<String>> foodItems = new ArrayList<>();
        foodItems.add(new ArrayList<>(List.of("Burger", "Fries")));
        foodItems.add(new ArrayList<>(List.of("Pizza", "Salad")));
        FoodOrder order = new FoodOrder(customer, restaurant, foodItems);
        Driver driver = new Driver("John", "789 Oak St", County.LA_COUNTY, Shift.FIRST_SHIFT);
        order.assignDriver(driver);
        assertEquals(driver, order.getDriver());
        assertNotNull(order.getOrderPickupTime());
    }

    @Test
    public void testCompleteOrder() {
        Customer customer = new Customer("Alice", "123 Main St", County.LA_COUNTY);
        Restaurant restaurant = new Restaurant("Some Restaurant", "456 Elm St", County.LA_COUNTY, "08:00-16:00");
        List<List<String>> foodItems = new ArrayList<>();
        foodItems.add(new ArrayList<>(List.of("Burger", "Fries")));
        foodItems.add(new ArrayList<>(List.of("Pizza", "Salad")));
        FoodOrder order = new FoodOrder(customer, restaurant, foodItems);
        Driver driver = new Driver("John", "789 Oak St", County.LA_COUNTY, Shift.FIRST_SHIFT);
        order.assignDriver(driver);
        order.completeOrder();
        assertNotNull(order.getOrderDeliveryTime());
    }
}
