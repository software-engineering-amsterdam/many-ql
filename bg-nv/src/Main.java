import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import lang.ql.ast.form.Form;
import lang.ql.ast.type.DecType;
import lang.ql.ast.type.IntType;
import lang.ql.ast.type.Type;
import lang.ql.gui.Modeler;
import lang.ql.gui.SimpleGui;
import lang.ql.gui.canvas.Canvas;
import lang.ql.semantics.*;
import lang.ql.ast.AstBuilder;
import lang.ql.semantics.TypeChecker;
import lang.qls.ast.Stylesheet;
import lang.qls.semantics.*;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.IOException;

import lang.ql.gen.*;

public class Main extends Application
{
    private static Form ast;
//    private static ValueTable values;

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

            AstBuilder visitor = new AstBuilder();
            ast = (Form) visitor.visit(tree);

            TypeChecker.check(ast);

            CharStream s = new ANTLRFileStream("gen/styleInput");
            QLSLexer l = new QLSLexer(s);
            QLSParser p = new QLSParser(new CommonTokenStream(l));
            ParserRuleContext style = p.stylesheet();

            QlsBuilder builder = new QlsBuilder();
            Stylesheet styleAst = (Stylesheet)builder.visit(style);

            lang.qls.semantics.TypeChecker.check(styleAst, ast);
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
        SimpleGui.run(ast, primaryStage);
    }
}
