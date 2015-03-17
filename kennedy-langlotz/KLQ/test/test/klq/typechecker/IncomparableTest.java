package test.klq.typechecker;

import com.klq.ast.impl.expr.bool.GreaterThanNode;
import com.klq.ast.impl.expr.literal.IdentifierNode;
import com.klq.ast.impl.expr.literal.NumberNode;
import com.klq.ast.impl.stmt.AStatementNode;
import com.klq.ast.impl.stmt.ConditionalNode;
import com.klq.ast.impl.stmt.QuestionNode;
import com.klq.ast.impl.stmt.QuestionnaireNode;
import com.klq.typechecker.TypeChecker;
import com.klq.typechecker.error.Incomparable;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Created by juriaan on 17-3-15.
 */
public class IncomparableTest {
    private QuestionnaireNode ast;
    private ArrayList<AStatementNode> children;

    @Before
    public void setUp() throws Exception {
        ast = new QuestionnaireNode();
        children = new ArrayList<AStatementNode>();
        children.add(new QuestionNode(new IdentifierNode("question1"), "string", "This is a test question"));
    }

    @Test
    public void testNestedExpression() throws Exception {
        GreaterThanNode gt1 = new GreaterThanNode(new NumberNode(new BigDecimal("1")), new NumberNode(new BigDecimal("2")));
        GreaterThanNode gt2 = new GreaterThanNode(new NumberNode(new BigDecimal("1")), gt1);

        ast.getChildren().add(new ConditionalNode(gt2, children));
        TypeChecker tc = new TypeChecker(ast);
        tc.run();

        assertEquals(1, tc.getErrors().size());
        assertThat(tc.getErrors().get(0), instanceOf(Incomparable.class));
    }
}
