package lang.ql.gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lang.ql.ast.form.Form;
import lang.ql.gui.canvas.Canvas;
import lang.ql.gui.input.*;
import lang.ql.gui.input.expression.*;
import lang.ql.gui.input.regular.*;
import lang.ql.gui.label.Label;
import lang.ql.gui.line.Line;
import lang.ql.semantics.Evaluator;
import lang.ql.semantics.ValueTable;
import lang.ql.semantics.values.Value;

import java.util.List;

/**
 * Created by Nik on 23-2-15.
 */
public class SimpleGui implements GuiVisitor<Node>
{
    private ValueTable valueTable;

    public static void run(Form ast, Stage primaryStage)
    {
        Modeler modeler = new Modeler();
        Canvas canvas = modeler.visit(ast);

        SimpleGui gui = new SimpleGui(ast);
        gui.start(canvas, primaryStage);
    }

    private SimpleGui(Form ast)
    {
        this.valueTable = Evaluator.evaluate(ast);
    }

    private void start(Canvas canvas, Stage primaryStage)
    {
        GridPane grid = (GridPane) visit(canvas);

        primaryStage.setTitle("Questionnaire");

        Scene scene = new Scene(grid, 700, 500);
        primaryStage.setScene(scene);

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
            }
        });

        primaryStage.show();
    }

    @Override
    public Node visit(Canvas c)
    {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        for (Line l : c.getLines())
        {
            Node node = l.accept(this);
            grid.add(node, 0, grid.getChildren().size() + 1);
        }

        return grid;
    }

    @Override
    public Node visit(Line line)
    {
        VBox box = new VBox();
        List<Node> boxChildren = box.getChildren();

        HBox labelBox = new HBox();
        labelBox.getChildren().add(line.getLabel().accept(this));
        boxChildren.add(labelBox);

        HBox inputBox = new HBox();
        inputBox.setAlignment(Pos.TOP_RIGHT);
        inputBox.getChildren().add(line.getInput().accept(this));
        boxChildren.add(inputBox);

        return box;
    }

    @Override
    public Node visit(Input input)
    {
        return input.accept(this);
    }

    @Override
    public Node visit(BoolInput input)
    {
        CheckBox checkBox = new CheckBox();

        //TODO: fix this mess below
        Value val = valueTable.getValue(input.getId());
        Boolean selected = val.isUndefined() ? false : (Boolean)val.getValue();

        checkBox.setSelected(selected);
        return checkBox;
    }

    @Override
    public Node visit(DateInput input)
    {
        return new DatePicker();
    }

    @Override
    public Node visit(DecInput input)
    {
        return new TextField();
    }

    @Override
    public Node visit(IntInput input)
    {
        final TextField textField = new TextField();
        textField.textProperty().addListener(new ChangeListener<String>()
        {

            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue)
            {
                newValue = newValue.trim();
                try
                {
//                    input.setValue(new IntegerValue(Integer.parseInt(newValue)));
                }
                catch (NumberFormatException e)
                {
                    // TODO: display some validation error
                }
            }
        });

        return textField;
    }

    @Override
    public Node visit(StrInput input)
    {
        return new TextField();
    }

    @Override
    public Node visit(ExprInput input)
    {
        return input.accept(this);
    }

    @Override
    public Node visit(BoolExprInput input)
    {
        CheckBox checkBox = new CheckBox();

        //TODO: fix this mess below
        Value val = valueTable.getValue(input.getId());
        Boolean selected = val.isUndefined() ? false : (Boolean)val.getValue();

        checkBox.setSelected(selected);
        return checkBox;
    }

    @Override
    public Node visit(DateExprInput input)
    {
        return new DatePicker();
    }

    @Override
    public Node visit(DecExprInput input)
    {
        return new TextField();
    }

    @Override
    public Node visit(IntExprInput input)
    {
        return new TextField();
    }

    @Override
    public Node visit(StrExprInput input)
    {
        TextField textField = new TextField();

        //TODO: fix this mess below
        Value val = valueTable.getValue(input.getId());
        String text = val.isUndefined() ? "" : (String)val.getValue();

        textField.setText(text);

        return textField;
    }

    @Override
    public Node visit(Label label)
    {
        return new Text(label.getText());
    }
}
