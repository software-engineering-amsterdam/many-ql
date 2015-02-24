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
//import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lang.ql.gui.canvas.Canvas;
import lang.ql.gui.input.*;
import lang.ql.gui.label.Label;
import lang.ql.gui.line.Line;
import lang.ql.semantics.values.IntegerValue;

import java.util.List;

/**
 * Created by Nik on 23-2-15.
 */
public class SimpleGui implements GuiVisitor<Node>
{

    public static void run(Canvas canvas, Stage primaryStage)
    {
        SimpleGui gui = new SimpleGui();
        gui.start(canvas, primaryStage);
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
        grid.add(actiontarget, 1, 6);

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
        HBox box = new HBox();
        List<Node> boxChildren = box.getChildren();
        boxChildren.add(line.getLabel().accept(this));
        boxChildren.add(line.getInput().accept(this));

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
        return new CheckBox();
    }

    @Override
    public Node visit(DateInput input)
    {
        return null;//new DatePicker();
    }

    @Override
    public Node visit(DecInput input)
    {
        return new TextField();
    }

    @Override
    public Node visit(final IntInput input)
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
                    input.setValue(new IntegerValue(Integer.parseInt(newValue)));
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
    public Node visit(Label label)
    {
        return new Text(label.getText());
    }
}
