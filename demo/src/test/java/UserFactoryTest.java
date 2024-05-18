import static org.junit.Assert.*;
import org.junit.Test;

import com.example.County;
import com.example.Customer;
import com.example.Driver;
import com.example.Restaurant;
import com.example.Shift;
import com.example.User;
import com.example.UserFactory;

public class UserFactoryTest {

    @Test
    public void testCreateUser_Customer() {
        User customer = UserFactory.createUser("customer", "Alice", "123 Main St", County.LA_COUNTY, null, null);
        assertTrue(customer instanceof Customer);
        assertEquals("Alice", customer.getName());
        assertEquals("123 Main St", customer.getAddress());
    }

    @Test
    public void testCreateUser_Restaurant() {
        User restaurant = UserFactory.createUser("restaurant", "Some Restaurant", "456 Elm St", County.LA_COUNTY, "08:00-16:00", null);
        assertTrue(restaurant instanceof Restaurant);
        assertEquals("Some Restaurant", restaurant.getName());
        assertEquals("456 Elm St", restaurant.getAddress());
    }

    @Test
    public void testCreateUser_Driver() {
        User driver = UserFactory.createUser("driver", "Bob", "789 Oak St", County.LA_COUNTY, null, Shift.FIRST_SHIFT);
        assertTrue(driver instanceof Driver);
        assertEquals("Bob", driver.getName());
        assertEquals("789 Oak St", driver.getAddress());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateUser_InvalidType() {

        UserFactory.createUser("invalid", "Invalid User", "Invalid Address", County.LA_COUNTY, null, null);
    }
}
