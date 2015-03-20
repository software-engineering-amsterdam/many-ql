package test.klq.ast;

import com.klq.ast.impl.Type;
import com.klq.ast.impl.expr.IdentifierNode;
import com.klq.gui.AST2GUIConverter;
import com.klq.ast.impl.stmt.QuestionNode;
import com.klq.ast.impl.stmt.QuestionnaireNode;
import com.klq.gui.control.ARenderedQuestion;
import com.klq.controller.Controller;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by juriaan on 24-2-15.
 */
public class AST2LogicTest extends Application {
    private Controller controller;
    private QuestionnaireNode ast;

    @Test
    public void testAST2Controller(){
        AST2LogicTest.main(new String[0]);
    }

    public static void main(String[] args) {
        launch();
    }

    public boolean testBasicQuestion() throws Exception {
        QuestionNode q1 = new QuestionNode(new IdentifierNode("question1"), Type.STRING, "This is a test question");
        QuestionNode q2 = new QuestionNode(new IdentifierNode("question2"), Type.NUMERAL, "This is a test question with a numeral answer");
        ast.getChildren().add(q1);
        ast.getChildren().add(q2);

        fillStore();

        assertEquals(2, controller.getOrderedQuestions().size());

        ArrayList<String> storeTextList = new ArrayList<>();
        for(ARenderedQuestion question : controller.getOrderedQuestions()){
            storeTextList.add(question.getText());
        }

        ArrayList<String> textList = new ArrayList<>();
        textList.add("This is a test question");
        textList.add("This is a test question with a numeral answer");
        assertThat(storeTextList, is(textList));
        return true;
    }

    @Override
    public void init() throws Exception {
        controller = new Controller();
        ast = new QuestionnaireNode();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        assert(testBasicQuestion());
        System.out.println("AST 2 GUI test successful");
        Platform.exit();
    }

    public void fillStore(){
        AST2GUIConverter a2gConverter = new AST2GUIConverter();
        controller = (Controller) a2gConverter.visit(ast);
    }
}
