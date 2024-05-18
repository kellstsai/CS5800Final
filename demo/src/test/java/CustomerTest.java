import static org.junit.Assert.*;
import org.junit.Test;

import com.example.County;
import com.example.Customer;
import com.example.Driver;
import com.example.Order;

public class CustomerTest {

    @Test
    public void testGetName() {
        Customer customer = new Customer("John Doe", "123 Main St", County.LA_COUNTY);
        assertEquals("John Doe", customer.getName());
    }

    @Test
    public void testGetAddress() {
        Customer customer = new Customer("John Doe", "123 Main St", County.LA_COUNTY);
        assertEquals("123 Main St", customer.getAddress());
    }

    @Test
    public void testGetCounty() {
        County county = County.LA_COUNTY;
        Customer customer = new Customer("John Doe", "123 Main St", county);
        assertEquals(county, customer.getCounty());
    }

    @Test
    public void testPlaceOrder() {
        Customer customer = new Customer("John Doe", "123 Main St", County.LA_COUNTY);
        Order order = new OrderMock();
        customer.placeOrder(order);
        assertTrue(((OrderMock)order).isCreateOrderCalled());
    }
    
    private static class OrderMock implements Order {
        private boolean createOrderCalled;

        @Override
        public void createOrder() {
            createOrderCalled = true;
        }

        public boolean isCreateOrderCalled() {
            return createOrderCalled;
        }

        @Override
        public void assignDriver(Driver driver) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'assignDriver'");
        }

        @Override
        public void completeOrder() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'completeOrder'");
        }
    }
}

