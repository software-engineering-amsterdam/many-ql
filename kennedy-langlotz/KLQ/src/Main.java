import com.klq.gui.AST2GUIConverter;
import com.klq.ast.ParseTreeConverter;
import com.klq.ast.impl.stmt.QuestionnaireNode;
import com.klq.gui.QuestionPage;
import com.klq.gui.Questionnaire;
import com.klq.controller.Controller;
import com.klq.parser.KLQLexer;
import com.klq.parser.KLQParser;
import com.klq.typechecker.TypeChecker;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.*;
import java.util.Map;

/**
 * Created by Timon on 09.02.2015.
 */
public class Main extends Application {
    private Questionnaire questionnaire;

    public static void main(String[] args) throws Exception {
        if (args == null || args.length == 0) {
            System.out.println("No input file provided!");
            return;
        } else if (args.length > 1) {
            System.out.println("Too many arguments. Please provide one input file.");
            return;
        }
        Application.launch(args);
    }

    @Override
    public void init() throws Exception {
        Map<String, String> arguments = getParameters().getNamed();
        String path = arguments.get("file");
        File file = new File(path);
        InputStream is;
        try {
            is = new FileInputStream(file);
        } catch (FileNotFoundException fnf){
            System.out.println("File not found!");
            return;
        }
        ANTLRInputStream input;
        try {
            input = new ANTLRInputStream(is);
        } catch (IOException io){
            System.out.println("Error while creating the ANTLR input stream.");
            return;
        }

        KLQLexer lexer = new KLQLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        KLQParser parser = new KLQParser(tokens);
        ParseTree tree = parser.questionnaire();

        ParseTreeConverter eval = new ParseTreeConverter(file);
        QuestionnaireNode ast = (QuestionnaireNode) eval.visit(tree);

        TypeChecker tc = new TypeChecker(ast);
        tc.run();
        tc.printErrors();

        if(tc.stopApplication()){
            Platform.exit();
        }

        AST2GUIConverter AST2GUIConverter = new AST2GUIConverter();
        Controller controller = (Controller) ast.accept(AST2GUIConverter);

        QuestionPage page = new QuestionPage(controller);
        page.addQuestions(controller.getOrderedQuestions());

        questionnaire = new Questionnaire(controller);
        questionnaire.addQuestionPage(page);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(questionnaire);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
