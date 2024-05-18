import static org.junit.Assert.*;
import org.junit.Test;

import com.example.Shift;

import java.time.LocalTime;

public class ShiftTest {

    @Test
    public void testGetStart() {
        assertEquals(LocalTime.of(8, 0), Shift.FIRST_SHIFT.getStart());
        assertEquals(LocalTime.of(16, 0), Shift.SECOND_SHIFT.getStart());
        assertEquals(LocalTime.of(0, 0), Shift.THIRD_SHIFT.getStart());
    }

    @Test
    public void testGetEnd() {
        assertEquals(LocalTime.of(16, 0), Shift.FIRST_SHIFT.getEnd());
        assertEquals(LocalTime.of(0, 0), Shift.SECOND_SHIFT.getEnd());
        assertEquals(LocalTime.of(8, 0), Shift.THIRD_SHIFT.getEnd());
    }
}

