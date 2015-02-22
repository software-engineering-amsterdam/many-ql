package lang.ql.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lang.ql.ast.expression.*;
import lang.ql.ast.form.Form;
import lang.ql.ast.statement.*;
import lang.ql.semantics.ValueTable;
import lang.ql.semantics.values.*;

import java.util.LinkedList;
import java.util.Queue;


/**
 * Created by Nik on 17-2-15.
 */
public class FxVisualizer extends Visualizer
{
    private Queue<Node> elements;

    private ValueTable values;

    public FxVisualizer(ValueTable values)
    {
        this.values = values;
        this.elements = new LinkedList<Node>();
    }

    @Override
    public void visit(Form form)
    {

        for (Statement s : form.getStatements())
        {
            s.accept(this);
        }
    }

    @Override
    public void visit(Question q)
    {
        this.elements.add(new Text(q.getText()));
        this.values.getValue(q.getId()).accept(this);

//        Text statement = new Text(q.getText());
//        HBox qBox = new HBox(10);
//
//        Text statement = new Text(q.getText());
//        qBox.getChildren().add(statement);
//
//        grid.add(qBox, 0, this.row++);
    }

    @Override
    public void visit(CalculatedQuestion cq)
    {
        this.elements.add(new Text(cq.getText()));
        cq.getExpr().accept(this);
//        HBox qBox = new HBox(10);
//
//        Text statement = new Text(cq.getText());
//        qBox.getChildren().add(statement);
//
//        grid.add(qBox, 0, this.row++);
    }

    @Override
    public void visit(IfCondition ifCond)
    {
        for (Statement s : ifCond.getStatements())
        {
            s.accept(this);
        }
    }

    @Override
    public void visit(BoolExpr e)
    {
        this.elements.add(new CheckBox());
//        HBox qBox = new HBox(10);
//        qBox.getChildren().add(new CheckBox());
//        grid.add(qBox, row++, 0);
    }

    @Override
    public void visit(IntExpr e)
    {
        this.elements.add(new TextField());
    }

    @Override
    public void visit(DecExpr e)
    {

    }

    @Override
    public void visit(StrExpr e)
    {

    }

    @Override
    public void visit(Indent e)
    {

    }

    @Override
    public void visit(Neg e)
    {

    }

    @Override
    public void visit(lang.ql.ast.expression.Pos e)
    {

    }

    @Override
    public void visit(Not e)
    {

    }

    @Override
    public void visit(Add e)
    {

    }

    @Override
    public void visit(Sub e)
    {

    }

    @Override
    public void visit(Mul e)
    {

    }

    @Override
    public void visit(Div e)
    {

    }

    @Override
    public void visit(Gt e)
    {

    }

    @Override
    public void visit(Lt e)
    {

    }

    @Override
    public void visit(GtEqu e)
    {

    }

    @Override
    public void visit(LtEqu e)
    {

    }

    @Override
    public void visit(Equ e)
    {

    }

    @Override
    public void visit(NotEqu e)
    {

    }

    @Override
    public void visit(And e)
    {

    }

    @Override
    public void visit(Or e)
    {

    }

    @Override
    public void visit(BooleanValue val)
    {

    }

    @Override
    public void visit(DateValue val)
    {

    }

    @Override
    public void visit(DecimalValue val)
    {

    }

    @Override
    public void visit(IntegerValue val)
    {

    }

    @Override
    public void visit(StringValue val)
    {

    }

    public void render(final Stage primaryStage, final Form form)
    {
        FxVisualizer visualizer = new FxVisualizer(values);

        GridPane grid = new GridPane();
        grid.setAlignment(javafx.geometry.Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        visualizer.visit(form);

        int row = 0;
        for (Node n : this.elements)
        {
            grid.add(n, row++, 0);
        }


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
                actiontarget.setText("Unicorns");
                updateValues();
//                render(primaryStage, form);
            }
        });

        Scene scene = new Scene(grid, 700, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle(form.getId());
        primaryStage.show();
    }

    private void updateValues()
    {
        //TODO
    }
}
