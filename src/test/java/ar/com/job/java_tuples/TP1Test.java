package ar.com.job.java_tuples;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class TP1Test {

    @org.junit.jupiter.api.Test
    void create() {

        final TP1<Integer> tp1Integer = TP1.create(45);

        assertNotNull(tp1Integer);
        assertEquals(45, tp1Integer.f1);

        final TP1<String> tp1String = TP1.create("TEST");

        assertEquals("TEST", tp1String.f1);
        assertTrue("test".equalsIgnoreCase(tp1String.f1));

        final TP1<Object> tp1Null = TP1.create(null);

        assertNull(tp1Null.f1);
    }

    @org.junit.jupiter.api.Test
    void getF1() {

        final TP1<Integer> tp1Integer = TP1.create(45);

        assertNotNull(tp1Integer);
        assertEquals(45, tp1Integer.getF1());

        final TP1<String> tp1String = TP1.create("TEST");

        assertEquals("TEST", tp1String.getF1());

        final TP1<Object> tp1Null = TP1.create(null);

        assertNull(tp1Null.getF1());
    }

    @org.junit.jupiter.api.Test
    void testEquals() {

        final TP1<Integer> tp1Integer1 = TP1.create(999999990);
        final TP1<Integer> tp1Integer2 = TP1.create(new Integer(tp1Integer1.f1));

        assertEquals(tp1Integer1, tp1Integer2);

        final TP1<Integer> tp1Integer3 = TP1.create(3);

        assertNotEquals(tp1Integer1, tp1Integer3);
        assertNotEquals(tp1Integer3, tp1Integer1);

        final TP1<String> tp1String1 = TP1.create("TEST");
        final TP1<String> tp1String2 = TP1.create("test");
        final TP1<String> tp1String3 = TP1.create(new StringBuilder("TES").append('T').toString());

        assertEquals(tp1String1, tp1String1);
        assertNotEquals(tp1String1, tp1String2);
        assertNotEquals(tp1String2, tp1String1);
        assertEquals(tp1String3, tp1String1);

        final TP1<Object> tp1Null1 = TP1.create(null);
        final TP1<Object> tp1Null2 = TP1.create(null);

        assertNotEquals(tp1String1, tp1Null1);
        assertNotEquals(tp1Null1, tp1String1);
        assertEquals(tp1Null1, tp1Null2);
        assertNotEquals(tp1Integer1, tp1Null1);
        assertNotEquals(tp1Null1, tp1Integer1);
    }

    @org.junit.jupiter.api.Test
    void testHashCode() {
        final TP1<Integer> tp1Integer1 = TP1.create(999999990);
        final TP1<Integer> tp1Integer2 = TP1.create(new Integer(tp1Integer1.f1));

        assertEquals(tp1Integer1.hashCode(), tp1Integer2.hashCode());

        final TP1<Integer> tp1Integer3 = TP1.create(3);

        assertNotEquals(tp1Integer1.hashCode(), tp1Integer3.hashCode());
        assertNotEquals(tp1Integer3.hashCode(), tp1Integer1.hashCode());

        final TP1<String> tp1String1 = TP1.create("TEST");
        final TP1<String> tp1String2 = TP1.create("test");
        final TP1<String> tp1String3 = TP1.create(new StringBuilder("TES").append('T').toString());

        assertEquals(tp1String1.hashCode(), tp1String1.hashCode());
        assertNotEquals(tp1String1.hashCode(), tp1String2.hashCode());
        assertNotEquals(tp1String2.hashCode(), tp1String1.hashCode());
        assertEquals(tp1String3.hashCode(), tp1String1.hashCode());

        final TP1<Object> tp1Null1 = TP1.create(null);
        final TP1<Object> tp1Null2 = TP1.create(null);

        assertNotEquals(tp1String1.hashCode(), tp1Null1.hashCode());
        assertNotEquals(tp1Null1.hashCode(), tp1String1.hashCode());
        assertEquals(tp1Null1.hashCode(), tp1Null2.hashCode());
        assertNotEquals(tp1Integer1.hashCode(), tp1Null1.hashCode());
        assertNotEquals(tp1Null1.hashCode(), tp1Integer1.hashCode());
    }

    @org.junit.jupiter.api.Test
    void testClone() throws CloneNotSupportedException {

        final TP1<Integer> tp1Integer1 = TP1.create(999999990);

        assertEquals(tp1Integer1, tp1Integer1.clone());

        final TP1<Integer> tp1Integer2 = TP1.create(3);

        assertEquals(tp1Integer2.clone(), tp1Integer2);
        assertNotEquals(tp1Integer1, tp1Integer2.clone());
    }

    @org.junit.jupiter.api.Test
    void testToString() {

        final TP1<Integer> tp1Integer1 = TP1.create(999999990);

        assertEquals("TP1[f1=999999990]", tp1Integer1.toString());

        final TP1<Integer> tp1Null = TP1.create(null);

        assertEquals("TP1[f1=null]", tp1Null.toString());
    }

    @org.junit.jupiter.api.Test
    void length() {

        assertEquals(1, TP1.LENGTH);

        final TP1<Integer> tp1Integer1 = TP1.create(999999990);

        assertEquals(1, tp1Integer1.length());
    }

    @org.junit.jupiter.api.Test
    void iterator() {

        final Iterator<Integer> iterator = TP1.create(99999).iterator();

        assertEquals(99999, iterator.next());
        assertFalse(iterator.hasNext());

        final Iterator<Object> iterator2 = TP1.create(null).iterator();

        assertNull(iterator2.next());
        assertFalse(iterator2.hasNext());
    }
}