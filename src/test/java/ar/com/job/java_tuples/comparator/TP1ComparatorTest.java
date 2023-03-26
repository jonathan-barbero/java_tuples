package ar.com.job.java_tuples.comparator;

import ar.com.job.java_tuples.TP1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TP1ComparatorTest {

    @Test
    void compareTP1() {

        TP1<Integer> tp1Integer1 = TP1.create(123);
        TP1<Integer> tp1Integer2 = TP1.create(new Integer(123));
        TP1<Integer> tp1Integer3 = TP1.create(null);
        TP1<Integer> tp1Integer4 = TP1.create(-1);

        TP1<String> tp1String1 = TP1.create("hola");
        TP1<String> tp1String2 = TP1.create("HOLA");
        TP1<String> tp1String3 = TP1.create(null);

        final int result0 = TP1Comparator.compareTP1(tp1Integer1, tp1Integer1);
        assertEquals(0, result0);

        final int result1 = TP1Comparator.compareTP1(tp1Integer1, tp1Integer2);
        assertEquals(0, result1);

        //final int result2 = TP1Comparator.compareTP1(tp1Integer1, tp1Integer3);
        //assertEquals(0,result2);

        final int result3 = TP1Comparator.compareTP1(tp1Integer1, tp1Integer4);
        assertEquals(1, result3);

        final int result4 = TP1Comparator.compareTP1(tp1Integer4, tp1Integer2);
        assertEquals(-1, result4);

        final int result5 = TP1Comparator.compareTP1(tp1String1, tp1String2);
        assertTrue(result5 > 0);
    }

    @Test
    void compare() {

        TP1Comparator<Integer> comparatorInt = new TP1Comparator<Integer>();

        assertEquals(0, comparatorInt.compare(TP1.create(0), TP1.create(0)));
        assertEquals(-1, comparatorInt.compare(TP1.create(0), TP1.create(2)));
        assertEquals(1, comparatorInt.compare(TP1.create(10), TP1.create(2)));
    }
}