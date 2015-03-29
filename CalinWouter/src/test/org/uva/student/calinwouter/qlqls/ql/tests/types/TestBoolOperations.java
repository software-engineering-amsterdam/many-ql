package org.uva.student.calinwouter.qlqls.ql.tests.types;

import org.junit.Test;
import org.uva.student.calinwouter.qlqls.ql.types.BooleanValue;

import static org.junit.Assert.*;

public class TestBoolOperations {

    @Test
    public void testOr() {
        assertEquals(true, new BooleanValue(true).or(new BooleanValue(true)).toJavaObject());
        assertEquals(true, new BooleanValue(true).or(new BooleanValue(false)).toJavaObject());
        assertEquals(true, new BooleanValue(false).or(new BooleanValue(true)).toJavaObject());
        assertEquals(false, new BooleanValue(false).or(new BooleanValue(false)).toJavaObject());
    }

    @Test
    public void testAnd() {
        assertEquals(true, new BooleanValue(true).and(new BooleanValue(true)).toJavaObject());
        assertEquals(false, new BooleanValue(true).and(new BooleanValue(false)).toJavaObject());
        assertEquals(false, new BooleanValue(false).and(new BooleanValue(false)).toJavaObject());
        assertEquals(false, new BooleanValue(false).and(new BooleanValue(false)).toJavaObject());
    }

    @Test
    public void testNot() {
        assertEquals(false, new BooleanValue(true).not().toJavaObject());
        assertEquals(true, new BooleanValue(false).not().toJavaObject());
    }

}
