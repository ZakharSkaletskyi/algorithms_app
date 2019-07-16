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
     * Method: findNumberByPosition(int position) has to a number 1
     */
    @Test
    public void findNumberByPositionTest() {
        long invoke = Deencapsulation.invoke(fibonacci, "findNumberByPosition", 100);
        assertEquals(invoke, 1);
    }

    /**
     * Method: findNumberByPosition(int position) has to return 0
     */
    @Test
    public void findNumberByPositionTestWithBadInput() {
        long invoke = Deencapsulation.invoke(modificationFibonacci, "findNumberByPosition", -100);
        assertEqquals(invoke, 0);
    }
}