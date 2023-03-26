package ar.com.job.java_tuples;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class TP2Test {

    @org.junit.jupiter.api.Test
    void create() {

        final TP2<Integer, Integer> tp2Integer = TP2.create(45, -2);

        assertNotNull(tp2Integer);
        assertEquals(45, tp2Integer.f1);
        assertEquals(-2, tp2Integer.f2);

        final TP2<String, String> tp2String = TP2.create("TEST", "not");

        assertEquals("TEST", tp2String.f1);
        assertEquals("not", tp2String.f2);
        assertTrue("test".equalsIgnoreCase(tp2String.f1));

        final TP2<Object, Object> tp2Null = TP2.create(null, null);

        assertNull(tp2Null.f1);
        assertNull(tp2Null.f2);
    }

    @org.junit.jupiter.api.Test
    void getF1F2() {

        final TP2<Integer, String> tp2IntegerString = TP2.create(45, "Hello");

        assertNotNull(tp2IntegerString);
        assertEquals(45, tp2IntegerString.getF1());
        assertEquals("Hello", tp2IntegerString.getF2());

        final TP2<String, Character> tp2StringCharacter = TP2.create("TEST", 'C');

        assertEquals("TEST", tp2StringCharacter.getF1());
        assertEquals('C', tp2StringCharacter.getF2());

        final TP2<String, Integer> tp2Null = TP2.create(null, null);

        assertNull(tp2Null.getF1());
        assertNull(tp2Null.getF2());
    }

    @org.junit.jupiter.api.Test
    void testEquals() {

        final TP2<Integer, String> tp2Integer1 = TP2.create(999999990, "");
        final TP2<Integer, String> tp2Integer2 = TP2.create(new Integer(tp2Integer1.f1), "");

        assertEquals(tp2Integer1, tp2Integer2);

        final TP2<Integer, String> tp2Integer3 = TP2.create(3, "");

        assertNotEquals(tp2Integer1, tp2Integer3);
        assertNotEquals(tp2Integer3, tp2Integer1);

        final TP2<Integer, String> tp2Integer4 = TP2.create(999999990, "");
        final TP2<Integer, String> tp2Integer5 = TP2.create(new Integer(tp2Integer4.f1), "a");

        assertNotEquals(tp2Integer4, tp2Integer5);

        final TP2<String, String> tp2String1 = TP2.create("", "TEST");
        final TP2<String, String> tp2String2 = TP2.create("", "test");
        final TP2<String, String> tp2String3 = TP2.create("", "TES" + 'T');
        final TP2<String, String> tp2String4 = TP2.create("test", "TES" + 'T');
        final TP2<String, String> tp2String5 = TP2.create("test", "TES" + 'T');

        assertEquals(tp2String1, tp2String1);
        assertNotEquals(tp2String1, tp2String2);
        assertNotEquals(tp2String2, tp2String1);
        assertEquals(tp2String3, tp2String1);
        assertEquals(tp2String4, tp2String5);
        assertNotEquals(tp2String3, tp2String4);

        final TP2<Object, Object> tp2Null1 = TP2.create(null, null);
        final TP2<Object, Object> tp2Null2 = TP2.create(null, null);

        assertNotEquals(tp2String1, tp2Null1);
        assertNotEquals(tp2Null1, tp2String1);
        assertEquals(tp2Null1, tp2Null2);
        assertNotEquals(tp2Integer1, tp2Null1);
        assertNotEquals(tp2Null1, tp2Integer1);
    }

    @org.junit.jupiter.api.Test
    void testHashCode() {

        final TP2<Integer, String> tp2Integer1 = TP2.create(999999990, "");
        final TP2<Integer, String> tp2Integer2 = TP2.create(new Integer(tp2Integer1.f1), "");

        assertEquals(tp2Integer1.hashCode(), tp2Integer2.hashCode());

        final TP2<Integer, String> tp2Integer3 = TP2.create(3, "");

        assertNotEquals(tp2Integer1.hashCode(), tp2Integer3.hashCode());
        assertNotEquals(tp2Integer3.hashCode(), tp2Integer1.hashCode());

        final TP2<Integer, String> tp2Integer4 = TP2.create(999999990, "");
        final TP2<Integer, String> tp2Integer5 = TP2.create(new Integer(tp2Integer4.f1), "a");

        assertNotEquals(tp2Integer4.hashCode(), tp2Integer5.hashCode());

        final TP2<String, String> tp2String1 = TP2.create("", "TEST");
        final TP2<String, String> tp2String2 = TP2.create("", "test");
        final TP2<String, String> tp2String3 = TP2.create("", "TES" + 'T');
        final TP2<String, String> tp2String4 = TP2.create("test", "TES" + 'T');
        final TP2<String, String> tp2String5 = TP2.create("test", "TES" + 'T');

        assertEquals(tp2String1.hashCode(), tp2String1.hashCode());
        assertNotEquals(tp2String1.hashCode(), tp2String2.hashCode());
        assertNotEquals(tp2String2.hashCode(), tp2String1.hashCode());
        assertEquals(tp2String3.hashCode(), tp2String1.hashCode());
        assertEquals(tp2String4.hashCode(), tp2String5.hashCode());
        assertNotEquals(tp2String3.hashCode(), tp2String4.hashCode());

        final TP2<Object, Object> tp2Null1 = TP2.create(null, null);
        final TP2<Object, Object> tp2Null2 = TP2.create(null, null);

        assertNotEquals(tp2String1.hashCode(), tp2Null1.hashCode());
        assertNotEquals(tp2Null1.hashCode(), tp2String1.hashCode());
        assertEquals(tp2Null1.hashCode(), tp2Null2.hashCode());
        assertNotEquals(tp2Integer1.hashCode(), tp2Null1.hashCode());
        assertNotEquals(tp2Null1.hashCode(), tp2Integer1.hashCode());
    }

    @org.junit.jupiter.api.Test
    void testClone() throws CloneNotSupportedException {

        final TP2<Integer, Float> tp2IntegerFloat = TP2.create(999999990, 0.1f);

        assertEquals(tp2IntegerFloat, tp2IntegerFloat.clone());

        final TP2<Double, Integer> tp2DoubleInteger = TP2.create(0.2, 3);

        assertEquals(tp2DoubleInteger.clone(), tp2DoubleInteger);
        assertNotEquals(tp2IntegerFloat, tp2DoubleInteger.clone());
    }

    @org.junit.jupiter.api.Test
    void testToString() {

        final TP2<Integer, Character> tp2IntegerChar = TP2.create(999999990,'A');

        assertEquals("TP2[f1=999999990, f2=A]", tp2IntegerChar.toString());

        final TP2<Integer, Integer> TP2Null = TP2.create(null, null);

        assertEquals("TP2[f1=null, f2=null]", TP2Null.toString());
    }

    @org.junit.jupiter.api.Test
    void length() {

        assertEquals(2, TP2.LENGTH);

        final TP2<Integer, Object> tp2 = TP2.create(999999990, null);

        assertEquals(2, tp2.length());
    }

    @org.junit.jupiter.api.Test
    void iterator() {

        final Iterator<Integer> iterator = TP2.create(99999, "123").iterator();

        assertEquals(99999, iterator.next());
        assertEquals("123", iterator.next());
        assertFalse(iterator.hasNext());

        final Iterator<Integer> iterator2 = TP2.create(null, null).iterator();

        assertNull(iterator2.next());
        assertNull(iterator2.next());
        assertFalse(iterator2.hasNext());
    }
}