import static org.junit.Assert.*;
import org.junit.Test;

import com.example.County;
import com.example.Driver;
import com.example.FoodOrder;
import com.example.Shift;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DriverTest {

    @Test
    public void testGetName() {
        Driver driver = new Driver("John Smith", "456 Oak St", County.LA_COUNTY, Shift.FIRST_SHIFT);
        assertEquals("John Smith", driver.getName());
    }

    @Test
    public void testGetAddress() {
        Driver driver = new Driver("John Smith", "456 Oak St", County.LA_COUNTY, Shift.FIRST_SHIFT);
        assertEquals("456 Oak St", driver.getAddress());
    }

    @Test
    public void testGetCounty() {
        County county = County.LA_COUNTY;
        Driver driver = new Driver("John Smith", "456 Oak St", county, Shift.FIRST_SHIFT);
        assertEquals(county, driver.getCounty());
    }

    @Test
    public void testGetShift() {
        Shift shift = Shift.FIRST_SHIFT;
        Driver driver = new Driver("John Smith", "456 Oak St", County.LA_COUNTY, shift);
        assertEquals(shift, driver.getShift());
    }
}


