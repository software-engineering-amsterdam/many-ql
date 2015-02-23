package lang.ql.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lang.ql.ast.expression.*;
import lang.ql.ast.form.Form;
import lang.ql.ast.statement.*;
import lang.ql.ast.type.*;
import lang.ql.gui.canvas.Canvas;
import lang.ql.gui.input.Input;
import lang.ql.gui.label.Label;
import lang.ql.gui.line.Line;
import lang.ql.semantics.ValueTable;
import lang.ql.semantics.Visitor;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Nik on 17-2-15.
 */
public class Modeler implements Visitor, TypeVisitor
{
    private ValueTable values;

    private Canvas canvas;
    private List<Line> lines;

    public Modeler(ValueTable values)
    {
        this.values = values;
    }

    @Override
    public void visit(Form form)
    {
        this.lines = new ArrayList<Line>();
        for (Statement s : form.getBody())
        {
            s.accept(this);
        }
        this.canvas = new Canvas(this.lines);
        this.lines = null;
    }

    @Override
    public void visit(Question q)
    {
        Label label = new Label(q.getLabel());
        q.getType().accept(this);
//        Input input = InputFactory.createInput(q.getType(), values.getValue(q.getId()));
//        this.lines.add(new Line(label, input));
    }

    @Override
    public void visit(CalculatedQuestion cq)
    {

        Label label = new Label(cq.getLabel());
        cq.getType().accept(this);
//        Input input = InputFactory.createInput(cq.getType(), values.getValue(cq.getId()));
//        this.lines.add(new Line(label, input));
    }

    @Override
    public void visit(BoolType t)
    {

    }

    @Override
    public void visit(DateType type)
    {

    }

    @Override
    public void visit(DecType type)
    {

    }

    @Override
    public void visit(IntType t)
    {

    }

    @Override
    public void visit(StrType type)
    {

    }

    @Override
    public void visit(IfCondition ifCond)
    {
        for (Statement s : ifCond.getBody())
        {
            s.accept(this);
        }
    }

    @Override
    public void visit(BoolExpr e)
    {

    }

    @Override
    public void visit(IntExpr e)
    {

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

    public static void render(final Stage primaryStage, final Form form, final ValueTable values)
    {
        Modeler visualizer = new Modeler(values);

        GridPane grid = new GridPane();
        grid.setAlignment(javafx.geometry.Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        visualizer.visit(form);

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
//                updateValues();
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
