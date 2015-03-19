package test.klq.controller;

import com.klq.ast.impl.Type;
import com.klq.ast.impl.expr.IdentifierNode;
import com.klq.ast.impl.stmt.QuestionNode;
import com.klq.ast.impl.value.StringValue;
import com.klq.controller.VariableTable;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Timon on 24.02.2015.
 */
public class VariableTableTest {
    VariableTable table;
    private QuestionNode q1;

    @Before
    public void init(){
        table = new VariableTable();
        q1 = new QuestionNode(new IdentifierNode("question1"), Type.STRING, "Test1");
    }

    @Test
    public void testVariableTableUpdate(){
        try {
            table.update(q1.getID(), new StringValue("Test"));
        } catch (AssertionError ae){
            assertTrue(true);
        }
    }

    @Test
    public void testAdd(){
        assertFalse(table.contains(q1.getID()));
        table.add(q1.getID());
        assertTrue(table.contains(q1.getID()));
        StringValue answer = new StringValue("Correct");
        table.update(q1.getID(), answer);
        assertEquals(table.get(q1.getID()), answer);
    }
}
