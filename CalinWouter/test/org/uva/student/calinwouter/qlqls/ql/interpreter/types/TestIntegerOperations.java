package org.uva.student.calinwouter.qlqls.ql.interpreter.types;

import org.junit.Test;
import org.uva.student.calinwouter.qlqls.ql.types.TInteger;

import static org.junit.Assert.*;

public class TestIntegerOperations {

    @Test
    public void testAdd() {
        assertEquals(new TInteger(10).add(new TInteger(5)).getValue(), 15);
    }

    @Test
    public void testSub() {
        assertEquals(new TInteger(10).sub(new TInteger(5)).getValue(), 5);
    }

    @Test
    public void testMul() {
        assertEquals(new TInteger(10).mul(new TInteger(5)).getValue(), 50);
    }

    @Test
    public void testDiv() {
        assertEquals(new TInteger(10).div(new TInteger(5)).getValue(), 2);
    }

    @Test
    public void testMod() {
        assertEquals(new TInteger(10).mod(new TInteger(5)).getValue(), 0);
    }

    @Test
    public void testLt() {
        assertEquals(true, new TInteger(-1).lt(new TInteger(0)).getValue());
        assertEquals(false, new TInteger(0).lt(new TInteger(0)).getValue());
        assertEquals(false, new TInteger(1).lt(new TInteger(0)).getValue());
    }

    @Test
    public void testGt() {
        assertEquals(false, new TInteger(-1).gt(new TInteger(0)).getValue());
        assertEquals(false, new TInteger(0).gt(new TInteger(0)).getValue());
        assertEquals(true, new TInteger(1).gt(new TInteger(0)).getValue());
    }

    @Test
    public void testLte() {
        assertEquals(true, new TInteger(-1).lte(new TInteger(0)).getValue());
        assertEquals(true, new TInteger(0).lte(new TInteger(0)).getValue());
        assertEquals(false, new TInteger(1).lte(new TInteger(0)).getValue());
    }

    @Test
    public void testGte() {
        assertEquals(false, new TInteger(-1).gte(new TInteger(0)).getValue());
        assertEquals(true, new TInteger(0).gte(new TInteger(0)).getValue());
        assertEquals(true, new TInteger(1).gte(new TInteger(0)).getValue());
    }

}
