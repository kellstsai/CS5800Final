import static org.junit.Assert.*;
import org.junit.Test;

import com.example.County;
import com.example.Customer;
import com.example.FoodOrder;
import com.example.Restaurant;
import com.example.DietaryRestrictionStrategy;
import com.example.GlutenFreeStrategy;

import java.util.ArrayList;
import java.util.List;

public class GlutenFreeStrategyTest {

    @Test
    public void testIsAllowed_AllFoodItemsGlutenFree() {
        List<List<String>> foodItems = new ArrayList<>();
        foodItems.add(new ArrayList<>(List.of("Salad", "Fruit")));
        FoodOrder order = new FoodOrder(new Customer("Alice", "123 Main St", County.LA_COUNTY),
                                        new Restaurant("Some Restaurant", "456 Elm St", County.LA_COUNTY, "08:00-16:00"),
                                        foodItems);
        DietaryRestrictionStrategy strategy = new GlutenFreeStrategy();
        assertTrue(strategy.isAllowed(order));
    }

    @Test
    public void testIsAllowed_FoodItemsContainGluten() {
        List<List<String>> foodItems = new ArrayList<>();
        foodItems.add(new ArrayList<>(List.of("Burger", "Fries"))); 
        FoodOrder order = new FoodOrder(new Customer("Bob", "789 Oak St", County.LA_COUNTY),
                                        new Restaurant("Another Restaurant", "101 Pine St", County.LA_COUNTY, "10:00-18:00"),
                                        foodItems);
        DietaryRestrictionStrategy strategy = new GlutenFreeStrategy();
        assertTrue(strategy.isAllowed(order));
    }

    @Test
    public void testIsAllowed_EmptyFoodItems() {
        List<List<String>> foodItems = new ArrayList<>();
        FoodOrder order = new FoodOrder(new Customer("Charlie", "345 Cedar St", County.LA_COUNTY),
                                        new Restaurant("Yet Another Restaurant", "678 Maple St", County.LA_COUNTY, "12:00-20:00"),
                                        foodItems);
        DietaryRestrictionStrategy strategy = new GlutenFreeStrategy();
        assertTrue(strategy.isAllowed(order));
    }
}

