import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import ql.ast.form.Form;
import ql.gen.QLLexer;
import ql.gen.QLParser;
import ql.ast.AstBuilder;
import ql.gui.SimpleGui;
import ql.gui.SimpleModeler;
import ql.semantics.TypeChecker;
import qls.ast.Stylesheet;
import qls.gen.QLSLexer;
import qls.gen.QLSParser;
import qls.semantics.*;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.IOException;

public class Main extends Application
{
    private static Form ast;

    public static void main(String[] args)
    {
        new JFXPanel(); //TODO: figure out why all hell breaks loose without this statement

        try
        {
            CharStream stream = new ANTLRFileStream(args[0]);
            QLLexer lexer = new QLLexer(stream);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            QLParser parser = new QLParser(tokens);
            ParserRuleContext tree = parser.form();

            AstBuilder visitor = new AstBuilder();
            ast = (Form) visitor.visit(tree);

            TypeChecker.check(ast);

            CharStream s = new ANTLRFileStream(args[1]);
            QLSLexer l = new QLSLexer(s);
            QLSParser p = new QLSParser(new CommonTokenStream(l));
            ParserRuleContext style = p.stylesheet();

            qls.ast.AstBuilder builder = new qls.ast.AstBuilder();
            Stylesheet styleAst = (Stylesheet)builder.visit(style);

            qls.semantics.TypeChecker.check(styleAst, ast);
            StyleMerger.getStyles(styleAst, ast);

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
        SimpleGui.run(ast, new SimpleModeler(), primaryStage);
    }
}
