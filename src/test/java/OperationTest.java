import model.CalculatorException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class OperationTest extends Assert {

    private Object[] chars;
    private float aFloat;

    public OperationTest(final Object[] chars, final float aFloat) {
        this.chars = chars;
        this.aFloat = aFloat;
    }

    @Parameterized.Parameters
    public static List<Object[]> isEmptyData() {
        return Arrays.asList(new Object[][] {
                { new Object[] { "1", "+", "1", "=" }, 2.f},
                { new Object[] { "1", "+", "1", "+" }, 0.f},
                { new Object[] { "1", "+", "1", "*" }, 0.f},
                { new Object[] { "1", "+" }, 0.f},
                { new Object[] { "1", "1", "+", "1", "2", "=" }, 23.f},
                { new Object[] { "1", "+", "1" , "+", "1", "=" }, 3.f},
        });
    }

    @Test
    public void testExecuteOperation() {

        model.Calculator calculator = new model.Calculator();
        for (Object c: chars) {
            try {
                calculator.add(c.toString());
            } catch (CalculatorException e) {
                e.printStackTrace();
                fail(e.getMessage());
                return;
            }
        }

        assertEquals(calculator.getNumber(), Float.valueOf(aFloat));
    }

}
