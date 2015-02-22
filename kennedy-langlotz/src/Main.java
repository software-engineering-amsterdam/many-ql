import com.klq.Visitor;
import com.klq.ast.ParseTreeConverter;
import com.klq.ast.ASTPrinter;
import com.klq.gui.QuestionPage;
import com.klq.logic.Question;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.*;
import parser.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Timon on 09.02.2015.
 */
public class Main extends Application {
    static List<Question> questionList;

    public static void main(String[] args) throws Exception {
        String inputFile = null;
        if ( args.length>0 )
            inputFile = args[0];
        InputStream is = System.in;
        if ( inputFile!=null )
            is = new FileInputStream(inputFile);
        ANTLRInputStream input = new ANTLRInputStream(is);

        KLQLexer lexer = new KLQLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        KLQParser parser = new KLQParser(tokens);
        ParseTree tree = parser.questionnaire();

        ParseTreeConverter eval = new ParseTreeConverter();
        eval.visit(tree);

        Visitor visitor = new Visitor();
        eval.getAst().accept(visitor);

        //print AST for test purposes
        ASTPrinter printer = new ASTPrinter();
        eval.getAst().accept(printer);

        questionList = visitor.getQuestList();
        launch();

//        for (ANode child : eval.getAst().getChildren()){
//            child.printSelf();
//        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();
        Scene scene = new Scene(root, 500, 200);
        primaryStage.setScene(scene);
        QuestionPage page = new QuestionPage(questionList);
        root.getChildren().add(page);
        primaryStage.show();
    }
}
