import com.klq.AST2GUIConverter;
import com.klq.ast.ANode;
import com.klq.ast.ASTPrinter;
import com.klq.ast.ParseTreeConverter;
import com.klq.logic.controller.Store;
import com.klq.logic.question.Question;
import javafx.application.Application;
import javafx.stage.Stage;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.*;
import parser.*;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * Created by Timon on 09.02.2015.
 */
public class Main extends Application {
    private List<Question> questionList;

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

        ParseTreeConverter eval = new ParseTreeConverter();
        ANode ast = eval.visit(tree);

        AST2GUIConverter AST2GUIConverter = new AST2GUIConverter();
        Store store = (Store) ast.accept(AST2GUIConverter);

        //questionList = visitor.getQuestList();

        //print AST for test purposes
        ASTPrinter printer = new ASTPrinter();
        ast.accept(printer);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        VBox root = new VBox();
//        Scene scene = new Scene(root, 500, 200);
//        primaryStage.setScene(scene);
//        QuestionPage page = new QuestionPage(questionList);
//        root.getChildren().add(page);
//        primaryStage.show();
        System.exit(1);
    }
}
