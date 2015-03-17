package test.klq.ast;

import com.klq.ast.impl.expr.IdentifierNode;
import com.klq.gui.AST2GUIConverter;
import com.klq.ast.impl.stmt.QuestionNode;
import com.klq.ast.impl.stmt.QuestionnaireNode;
import com.klq.gui.control.ARenderedQuestion;
import com.klq.controller.Controller;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by juriaan on 24-2-15.
 */
public class AST2LogicTest {
    private Controller controller;
    private QuestionnaireNode ast;
    @Before
    public void setUp() throws Exception {
        controller = new Controller();
        ast = new QuestionnaireNode();
    }

    @Test
    public void testBasicQuestion() throws Exception {
        ast.getChildren().add(new QuestionNode(new IdentifierNode("question1"), "string", "This is a test question"));
        ast.getChildren().add(new QuestionNode(new IdentifierNode("question2"), "numeral", "This is a test question with a numeral answer"));

        fillStore();

        assertEquals(controller.getOrderedQuestions().size(), 2);

        ArrayList<String> storeTextList = new ArrayList<String>();
        for(ARenderedQuestion question : controller.getOrderedQuestions()){
            storeTextList.add(question.getText());
        }

        ArrayList<String> textList = new ArrayList<String>();
        textList.add("This is a test question");
        textList.add("This is a test question with a numeral answer");
        assertThat(storeTextList, is(textList));
    }

    private void fillStore(){
        AST2GUIConverter AST2GUIConverter = new AST2GUIConverter();
        controller = (Controller) ast.accept(AST2GUIConverter);
    }
}
