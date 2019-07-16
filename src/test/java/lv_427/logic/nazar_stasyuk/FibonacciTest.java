package lv_427.logic.nazar_stasyuk;

import mockit.Deencapsulation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Fibonacci Test.
 *
 * @author Oleksandr Agarkov
 * @version 1.0
 */
public class FibonacciTest {

    private Fibonacci fibonacci;

    /**
     * Init method.
     */
    @Before
    public void init() {
        fibonacci = new Fibonacci();
    }

    /**
     * Method: findNumberByPosition(int position) has to a number 3
     */
    @Test
    public void findNumberByPositionTest() {
        long invoke = Deencapsulation.invoke(fibonacci, "findNumberByPosition", 3);
        assertEquals(invoke, 2);
    }

    /**
     * Method: findNumberByPosition(int position) has to return 1
     */
    @Test
    public void findNumberByPositionTestWithBadInput() {
        long invoke = Deencapsulation.invoke(modificationFibonacci, "findNumberByPosition", 1);
        assertEquals(invoke, 1);
    }
}