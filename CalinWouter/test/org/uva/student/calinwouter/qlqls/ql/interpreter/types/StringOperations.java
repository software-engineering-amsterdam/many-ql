package org.uva.student.calinwouter.qlqls.ql.interpreter.types;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringOperations {

    @Test
    public void testAdd() {
        assertEquals("ab", new TString("a").add(new TString("b")).getValue());
    }

}
