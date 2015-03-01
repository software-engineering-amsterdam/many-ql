package test.klq.typechecker;

import com.klq.ast.impl.QuestionNode;
import com.klq.ast.impl.QuestionnaireNode;
import com.klq.logic.controller.Store;
import com.klq.typecheker.TypeChecker;
import com.klq.typecheker.error.NotUniqueID;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Created by Juriaan on 28-2-2015.
 */
public class TypeCheckerTest {
    private QuestionnaireNode ast;
    @Before
    public void setUp() throws Exception {
        ast = new QuestionnaireNode("1");
    }

    @Test
    public void testDuplicateQuestionId(){
        ast.getChildren().add(new QuestionNode("question1", "string", "This is a test question", "1: 14"));
        ast.getChildren().add(new QuestionNode("question2", "numeral", "This is another test question", "2: 14"));
        TypeChecker tc = new TypeChecker(ast);
        tc.firstPass();
        assertEquals(tc.getErrors().size(), 0);

        ast.getChildren().add(new QuestionNode("question1", "numeral", "This is another test question, but with a duplicate ID", "3:14"));
        tc = new TypeChecker(ast);
        tc.firstPass();
        assertEquals(tc.getErrors().size(), 1);
        assertThat(tc.getErrors().get(0), instanceOf(NotUniqueID.class));
        System.out.println(tc.getErrors().get(0).toString());
    }
}
