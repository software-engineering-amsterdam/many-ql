package org.uva.student.calinwouter.qlqls.ql.types;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoolOperations {

    @Test
    public void testOr() {
        assertEquals(true, new TBool(true).or(new TBool(true)).getValue());
        assertEquals(true, new TBool(true).or(new TBool(false)).getValue());
        assertEquals(true, new TBool(false).or(new TBool(true)).getValue());
        assertEquals(false, new TBool(false).or(new TBool(false)).getValue());
    }

    @Test
    public void testAnd() {
        assertEquals(true, new TBool(true).and(new TBool(true)).getValue());
        assertEquals(false, new TBool(true).and(new TBool(false)).getValue());
        assertEquals(false, new TBool(false).and(new TBool(false)).getValue());
        assertEquals(false, new TBool(false).and(new TBool(false)).getValue());
    }

    @Test
    public void testNot() {
        assertEquals(false, new TBool(true).not().getValue());
        assertEquals(true, new TBool(false).not().getValue());
    }

}
