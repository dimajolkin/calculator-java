import model.CalculatorException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class CalculatorBuildNumberTest extends Assert {

    private Object[] chars;
    private float aFloat;

    public CalculatorBuildNumberTest(final Object[] chars, final float aFloat) {
        this.chars = chars;
        this.aFloat = aFloat;
    }

    @Parameterized.Parameters
    public static List<Object[]> isEmptyData() {
        return Arrays.asList(new Object[][] {
                { new Object[] {}, 0.f},
                { new Object[] { "1", "2" }, 12.f},
                { new Object[] { "1", "2", "3" }, 123.f},
                { new Object[] { "1", "2", "3", "4"}, 1234.f},
                { new Object[] { "0", "0", "3", "4"}, 34.f},
                { new Object[] { "1", ".", "4"}, 1.4f},
                { new Object[] { "1", ".", "4", "c"}, 0.f},
                { new Object[] { "1", ".", "4", "c", "1", "0", ".", "1"}, 10.1f},
        });
    }

    @Test
    public void testCreateFloatNumber() throws CalculatorException {

        model.Calculator calculator = new model.Calculator();
        for (Object c: chars) {
            calculator.add(c.toString());
        }

        assertEquals(calculator.getNumber(), Float.valueOf(aFloat));
    }
}
