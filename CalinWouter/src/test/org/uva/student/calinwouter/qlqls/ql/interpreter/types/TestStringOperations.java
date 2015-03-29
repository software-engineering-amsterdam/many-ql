package org.uva.student.calinwouter.qlqls.ql.interpreter.types;

import org.junit.Test;
import org.uva.student.calinwouter.qlqls.ql.types.StringValue;

import static org.junit.Assert.assertEquals;

public class TestStringOperations {

    @Test
    public void testAdd() {
        assertEquals("ab", new StringValue("a").add(new StringValue("b")).toJavaObject());
    }

}
