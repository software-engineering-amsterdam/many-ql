import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import lang.ql.ast.form.Form;
import lang.ql.gui.GuiVisitor;
import lang.ql.gui.Modeler;
import lang.ql.gui.SimpleGui;
import lang.ql.gui.canvas.Canvas;
import lang.ql.semantics.*;
import lang.ql.ast.QLVisitor;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.IOException;

import lang.ql.gen.*;

public class Main extends Application
{
    private static Form ast;
    private static ValueTable values;

    public static void main(String[] args)
    {
        new JFXPanel(); //TODO: figure out why all hell breaks loose without this statement

        try
        {
            CharStream stream = new ANTLRFileStream("src/lang/tests/formInput");
            QLLexer lexer = new QLLexer(stream);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            QLParser parser = new QLParser(tokens);
            ParserRuleContext tree = parser.form();

            QLVisitor visitor = new QLVisitor();
            ast = (Form) visitor.visit(tree);

            TypeChecker.check(ast);

            Interpreter.interpret(ast);
            //values = v.getVariableValues();

            System.out.println(values);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Modeler modeler = new Modeler(values);

        // TODO: To cast, or not to cast...
        SimpleGui.run((Canvas) modeler.visit(this.ast), primaryStage);
    }
}
