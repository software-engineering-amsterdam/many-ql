package test.klq.typechecker;

import com.klq.ast.impl.expr.IdentifierNode;
import com.klq.ast.impl.stmt.QuestionNode;
import com.klq.typechecker.QuestionTable;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by juriaan on 17-3-15.
 */
public class QuestionTableTest {
    @Test
    public void testHasMethod() throws Exception {
        QuestionTable qt = new QuestionTable();
        IdentifierNode id1 = new IdentifierNode("question1");
        IdentifierNode id2 = new IdentifierNode("question1");

        qt.add(id1, new QuestionNode(id1, "string", "test"));
        assertEquals(true, qt.has(id2));
    }
}
