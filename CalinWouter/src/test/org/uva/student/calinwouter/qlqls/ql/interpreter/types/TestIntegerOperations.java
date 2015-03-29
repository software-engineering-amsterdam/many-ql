package org.uva.student.calinwouter.qlqls.ql.interpreter.types;

import org.junit.Test;
import org.uva.student.calinwouter.qlqls.ql.types.IntegerValue;

import static org.junit.Assert.*;

public class TestIntegerOperations {

    @Test
    public void testAdd() {
        assertEquals(new IntegerValue(10).add(new IntegerValue(5)).toJavaObject(), 15);
    }

    @Test
    public void testSub() {
        assertEquals(new IntegerValue(10).sub(new IntegerValue(5)).toJavaObject(), 5);
    }

    @Test
    public void testMul() {
        assertEquals(new IntegerValue(10).mul(new IntegerValue(5)).toJavaObject(), 50);
    }

    @Test
    public void testDiv() {
        assertEquals(new IntegerValue(10).div(new IntegerValue(5)).toJavaObject(), 2);
    }

    @Test
    public void testMod() {
        assertEquals(new IntegerValue(10).mod(new IntegerValue(5)).toJavaObject(), 0);
    }

    @Test
    public void testLt() {
        assertEquals(true, new IntegerValue(-1).lt(new IntegerValue(0)).toJavaObject());
        assertEquals(false, new IntegerValue(0).lt(new IntegerValue(0)).toJavaObject());
        assertEquals(false, new IntegerValue(1).lt(new IntegerValue(0)).toJavaObject());
    }

    @Test
    public void testGt() {
        assertEquals(false, new IntegerValue(-1).gt(new IntegerValue(0)).toJavaObject());
        assertEquals(false, new IntegerValue(0).gt(new IntegerValue(0)).toJavaObject());
        assertEquals(true, new IntegerValue(1).gt(new IntegerValue(0)).toJavaObject());
    }

    @Test
    public void testLte() {
        assertEquals(true, new IntegerValue(-1).lte(new IntegerValue(0)).toJavaObject());
        assertEquals(true, new IntegerValue(0).lte(new IntegerValue(0)).toJavaObject());
        assertEquals(false, new IntegerValue(1).lte(new IntegerValue(0)).toJavaObject());
    }

    @Test
    public void testGte() {
        assertEquals(false, new IntegerValue(-1).gte(new IntegerValue(0)).toJavaObject());
        assertEquals(true, new IntegerValue(0).gte(new IntegerValue(0)).toJavaObject());
        assertEquals(true, new IntegerValue(1).gte(new IntegerValue(0)).toJavaObject());
    }

}
