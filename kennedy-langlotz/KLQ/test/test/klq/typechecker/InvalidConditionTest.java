package test.klq.typechecker;

import com.klq.ast.ANode;
import com.klq.ast.impl.*;
import com.klq.ast.impl.expr.literal.NumberNode;
import com.klq.ast.impl.expr.bool.*;
import com.klq.ast.impl.expr.math.AddNode;
import com.klq.ast.impl.expr.math.DivideNode;
import com.klq.ast.impl.expr.math.MultiplyNode;
import com.klq.ast.impl.expr.math.SubtractNode;
import com.klq.typecheker.TypeChecker;
import com.klq.typecheker.error.InvalidCondition;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Created by Juriaan on 1-3-2015.
 */
public class InvalidConditionTest {
    private QuestionnaireNode ast;
    private ArrayList<ANode> children;

    @Before
    public void setUp() throws Exception {
        ast = new QuestionnaireNode("1");
        children = new ArrayList<ANode>();
        children.add(new QuestionNode("question1", "string", "This is a test question", "1"));
    }

    @Test
    public void testGreaterThanExpression() throws Exception {
        GreaterThanNode node = new GreaterThanNode(new NumberNode(1, ""), new NumberNode(2, ""), "");
        runCorrectTest(node);
    }

    @Test
    public void testLessThanExpression() throws Exception {
        LessThanNode node = new LessThanNode(new NumberNode(1, ""), new NumberNode(2, ""), "");
        runCorrectTest(node);
    }

    @Test
    public void testGreaterEqualsExpression() throws Exception {
        GreaterEqualsNode node = new GreaterEqualsNode(new NumberNode(1, ""), new NumberNode(2, ""), "");
        runCorrectTest(node);
    }

    @Test
    public void testLessEqualsnExpression() throws Exception {
        LessEqualsNode node = new LessEqualsNode(new NumberNode(1, ""), new NumberNode(2, ""), "");
        runCorrectTest(node);
    }

    @Test
    public void testEqualsExpression() throws Exception {
        EqualsNode node = new EqualsNode(new NumberNode(1, ""), new NumberNode(2, ""), "");
        runCorrectTest(node);
    }

    @Test
    public void testNotEqualsExpression() throws Exception {
        NotEqualsNode node = new NotEqualsNode(new NumberNode(1, ""), new NumberNode(2, ""), "");
        runCorrectTest(node);
    }

    @Test
    public void testAddExpression() throws Exception {
        AddNode node = new AddNode(new NumberNode(1, ""), new NumberNode(2, ""), "");
        runWrongTest(node);
    }

    @Test
    public void testSubtractExpression() throws Exception {
        SubtractNode node = new SubtractNode(new NumberNode(1, ""), new NumberNode(2, ""), "");
        runWrongTest(node);
    }

    @Test
    public void testDivideExpression() throws Exception {
        DivideNode node = new DivideNode(new NumberNode(1, ""), new NumberNode(2, ""), "");
        runWrongTest(node);
    }

    @Test
    public void testMultiplyExpression() throws Exception {
        MultiplyNode node = new MultiplyNode(new NumberNode(1, ""), new NumberNode(2, ""), "");
        runWrongTest(node);
    }

    private void runCorrectTest(ANode node){
        ast.getChildren().add(new ConditionalNode(node, children, ""));
        TypeChecker tc = new TypeChecker(ast);
        tc.run();

        assertEquals(0, tc.getErrors().size());
    }

    private void runWrongTest(ANode node){
        ast.getChildren().add(new ConditionalNode(node, children, ""));
        TypeChecker tc = new TypeChecker(ast);
        tc.run();

        assertEquals(1, tc.getErrors().size());
        assertThat(tc.getErrors().get(0), instanceOf(InvalidCondition.class));
    }
}
