import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lang.ql.ast.form.Form;
import lang.ql.ast.types.IntType;
import lang.ql.ast.types.StrType;
import lang.ql.semantics.*;
import lang.ql.semantics.values.StringValue;
import lang.ql.semantics.values.Value;
import lang.ql.syntax.QLVisitorImpl;
import org.antlr.v4.misc.Graph;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.IOException;
import java.util.Map;

import lang.ql.gen.*;

public class Main extends Application
{
    private static Form ast;
    private static Map<String, Value> values;

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

            QLVisitorImpl visitor = new QLVisitorImpl();
            ast = (Form) visitor.visit(tree);

            Interpreter v = new Interpreter();
            v.visit(ast);
            values = v.getVariableValues();

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
        render(primaryStage);
    }

    private void render(final Stage primaryStage)
    {
        GraphicsVisitor gv = new GraphicsVisitor(values);
        gv.visit(ast);
        GridPane grid = gv.getGrid();

        Button btn = new Button("Make magic happen");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, grid.getChildren().size() + 1);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, grid.getChildren().size() + 1);


        btn.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent e)
            {
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Unicorns!");
                updateValues();
                render(primaryStage);
            }
        });

        Scene scene = new Scene(grid, 700, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle(ast.getId());
        primaryStage.show();
    }

    private void updateValues()
    {
        //TODO
    }
}
