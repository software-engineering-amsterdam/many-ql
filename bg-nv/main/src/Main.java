import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import ql.ast.form.Form;
import ql.gen.QLLexer;
import ql.gen.QLParser;
import ql.ast.AstBuilder;
import ql.gui.SimpleGui;
import ql.semantics.Flat;
import ql.semantics.Flattener;
import ql.semantics.TypeChecker;
import ql.semantics.errors.Messages;
import qls.ast.Stylesheet;
import qls.gen.QLSLexer;
import qls.gen.QLSParser;
import qls.gui.StyledModeler;
import qls.semantics.*;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.IOException;

public class Main extends Application
{
    private static Form ast;
    private static Stylesheet stylesheet;
    private static FormStyle formStyle;
    private static Flat flat;

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

            Messages ms = TypeChecker.check(ast);
            if (ms.containsError())
            {
                System.err.print(ms.toString());
                System.exit(1);
            }

            CharStream s = new ANTLRFileStream(args[1]);
            QLSLexer l = new QLSLexer(s);
            QLSParser p = new QLSParser(new CommonTokenStream(l));
            ParserRuleContext style = p.stylesheet();

            qls.ast.AstBuilder builder = new qls.ast.AstBuilder();
            stylesheet = (Stylesheet)builder.visit(style);

            qls.semantics.TypeChecker.check(stylesheet, ast);
            formStyle = StyleMerger.getStyles(stylesheet, ast);
            flat = Flattener.flatten(ast);

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
        SimpleGui.run(ast, new StyledModeler(flat, stylesheet, formStyle), primaryStage);
    }
}
