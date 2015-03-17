package test.klq.typechecker;

import com.klq.ast.impl.expr.AExpression;
import com.klq.ast.impl.expr.literal.IdentifierNode;
import com.klq.ast.impl.expr.literal.NumberNode;
import com.klq.ast.impl.expr.bool.*;
import com.klq.ast.impl.expr.math.AddNode;
import com.klq.ast.impl.expr.math.DivideNode;
import com.klq.ast.impl.expr.math.MultiplyNode;
import com.klq.ast.impl.expr.math.SubtractNode;
import com.klq.ast.impl.stmt.AStatementNode;
import com.klq.ast.impl.stmt.ConditionalNode;
import com.klq.ast.impl.stmt.QuestionNode;
import com.klq.ast.impl.stmt.QuestionnaireNode;
import com.klq.typechecker.TypeChecker;
import com.klq.typechecker.error.InvalidCondition;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Created by Juriaan on 1-3-2015.
 */
public class InvalidConditionTest {
    private QuestionnaireNode ast;
    private ArrayList<AStatementNode> children;

    @Before
    public void setUp() throws Exception {
        ast = new QuestionnaireNode();
        children = new ArrayList<>();
        children.add(new QuestionNode(new IdentifierNode("question1"), "string", "This is a test question"));
    }

    @Test
    public void testGreaterThanExpression() throws Exception {
        GreaterThanNode node = new GreaterThanNode(new NumberNode(new BigDecimal("1")), new NumberNode(new BigDecimal("2")));
        runCorrectTest(node);
    }

    @Test
    public void testLessThanExpression() throws Exception {
        LessThanNode node = new LessThanNode(new NumberNode(new BigDecimal("1")), new NumberNode(new BigDecimal("2")));
        runCorrectTest(node);
    }

    @Test
    public void testGreaterEqualsExpression() throws Exception {
        GreaterEqualsNode node = new GreaterEqualsNode(new NumberNode(new BigDecimal("1")), new NumberNode(new BigDecimal("2")));
        runCorrectTest(node);
    }

    @Test
    public void testLessEqualsnExpression() throws Exception {
        LessEqualsNode node = new LessEqualsNode(new NumberNode(new BigDecimal("1")), new NumberNode(new BigDecimal("2")));
        runCorrectTest(node);
    }

    @Test
    public void testEqualsExpression() throws Exception {
        EqualsNode node = new EqualsNode(new NumberNode(new BigDecimal("1")), new NumberNode(new BigDecimal("2")));
        runCorrectTest(node);
    }

    @Test
    public void testNotEqualsExpression() throws Exception {
        NotEqualsNode node = new NotEqualsNode(new NumberNode(new BigDecimal("1")), new NumberNode(new BigDecimal("2")));
        runCorrectTest(node);
    }

    @Test
    public void testAddExpression() throws Exception {
        AddNode node = new AddNode(new NumberNode(new BigDecimal("1")), new NumberNode(new BigDecimal("2")));
        runWrongTest(node);
    }

    @Test
    public void testSubtractExpression() throws Exception {
        SubtractNode node = new SubtractNode(new NumberNode(new BigDecimal("1")), new NumberNode(new BigDecimal("2")));
        runWrongTest(node);
    }

    @Test
    public void testDivideExpression() throws Exception {
        DivideNode node = new DivideNode(new NumberNode(new BigDecimal("1")), new NumberNode(new BigDecimal("2")));
        runWrongTest(node);
    }

    @Test
    public void testMultiplyExpression() throws Exception {
        MultiplyNode node = new MultiplyNode(new NumberNode(new BigDecimal("1")), new NumberNode(new BigDecimal("2")));
        runWrongTest(node);
    }

    private void runCorrectTest(AExpression node){
        ast.getChildren().add(new ConditionalNode(node, children));
        TypeChecker tc = new TypeChecker(ast);
        tc.run();

        assertEquals(0, tc.getErrors().size());
    }

    private void runWrongTest(AExpression node){
        ast.getChildren().add(new ConditionalNode(node, children));
        TypeChecker tc = new TypeChecker(ast);
        tc.run();

        assertEquals(1, tc.getErrors().size());
        assertThat(tc.getErrors().get(0), instanceOf(InvalidCondition.class));
    }
}
