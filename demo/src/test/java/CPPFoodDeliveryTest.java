import org.junit.Before;
import org.junit.Test;

import com.example.CPPFoodDelivery;
import com.example.Customer;
import com.example.Driver;
import com.example.Shift;
import com.example.FoodOrder;
import com.example.Restaurant;
import com.example.User;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class CPPFoodDeliveryTest {
    public CPPFoodDelivery cppFoodDelivery;

    @Before
    public void setUp() {
        cppFoodDelivery = CPPFoodDelivery.getInstance();
        cppFoodDelivery.getDrivers().clear();  // Clear drivers for isolated tests
    }

    @Test
    public void testSingletonInstance() {
        CPPFoodDelivery instance1 = CPPFoodDelivery.getInstance();
        CPPFoodDelivery instance2 = CPPFoodDelivery.getInstance();
        assertSame(instance1, instance2);
    }

}
