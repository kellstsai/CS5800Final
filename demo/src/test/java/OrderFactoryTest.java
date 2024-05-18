import static org.junit.Assert.*;
import org.junit.Test;

import com.example.County;
import com.example.Customer;
import com.example.FoodOrder;
import com.example.OrderFactory;
import com.example.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class OrderFactoryTest {

    @Test
    public void testGetOrder_NewOrder() {
        Customer customer = new Customer("Alice", "123 Main St", County.LA_COUNTY);
        Restaurant restaurant = new Restaurant("Some Restaurant", "456 Elm St", County.LA_COUNTY, "08:00-16:00");
        List<String> foodItems = new ArrayList<>();
        foodItems.add("Burger");
        foodItems.add("Fries");
        FoodOrder order = OrderFactory.getOrder(customer, restaurant, foodItems);
        assertNotNull(order);
        assertEquals(customer, order.getCustomer());
        assertEquals(restaurant, order.getRestaurant());
        assertEquals(1, order.getFoodItems().size());
        assertNotEquals(2, order.getFoodItems().get(0).size());
        assertFalse(order.getFoodItems().get(0).contains("Burger"));
        assertFalse(order.getFoodItems().get(0).contains("Fries"));
    }

    @Test
    public void testGetOrder_ExistingOrder() {
        Customer customer = new Customer("Bob", "789 Oak St", County.LA_COUNTY);
        Restaurant restaurant = new Restaurant("Another Restaurant", "101 Pine St", County.LA_COUNTY, "10:00-18:00");
        List<String> foodItems = new ArrayList<>();
        foodItems.add("Pizza");
        foodItems.add("Salad");
        FoodOrder order1 = OrderFactory.getOrder(customer, restaurant, foodItems);
        FoodOrder order2 = OrderFactory.getOrder(customer, restaurant, foodItems);
        assertNotNull(order1);
        assertNotNull(order2);
        assertEquals(order1, order2);
    }
}
