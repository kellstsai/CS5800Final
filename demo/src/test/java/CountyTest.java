import org.junit.Test;

import com.example.County;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class CountyTest {

    @Test
    public void testCountyEnum() {
        County laCounty = County.LA_COUNTY;
        County orangeCounty = County.ORANGE_COUNTY;
        County sanBernardinoCounty = County.SAN_BERNARDINO_COUNTY;

        assertEquals("LA_COUNTY", laCounty.name());
        assertEquals("ORANGE_COUNTY", orangeCounty.name());
        assertEquals("SAN_BERNARDINO_COUNTY", sanBernardinoCounty.name());

        assertSame(County.LA_COUNTY, laCounty);
        assertSame(County.ORANGE_COUNTY, orangeCounty);
        assertSame(County.SAN_BERNARDINO_COUNTY, sanBernardinoCounty);
    }
}
