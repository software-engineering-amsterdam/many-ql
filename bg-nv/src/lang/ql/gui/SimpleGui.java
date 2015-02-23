package lang.ql.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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
import lang.ql.gui.canvas.Canvas;
import lang.ql.gui.input.*;
import lang.ql.gui.label.Label;
import lang.ql.gui.line.Line;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nik on 23-2-15.
 */
public class SimpleGui implements GuiVisitor
{
    private GridPane grid;
    private List<HBox> rows;
    private List<Node> rowColumns;

    public static void run(Canvas canvas, Stage primaryStage)
    {
        SimpleGui gui = new SimpleGui(canvas);
        gui.start(primaryStage);
    }

    private SimpleGui(Canvas canvas)
    {
        this.grid = null;
        this.rows = null;
        this.rowColumns = null;

        visit(canvas);
    }

    private void start(Stage primaryStage)
    {
        primaryStage.setTitle("Questionnaire");

        Scene scene = new Scene(this.grid, 700, 500);
        primaryStage.setScene(scene);

        Button btn = new Button("Make magic happen");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        this.grid.add(hbBtn, 1, this.grid.getChildren().size()+1);

        final Text actiontarget = new Text();
        this.grid.add(actiontarget, 1, 6);

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
    public void visit(Canvas c)
    {
        this.grid = new GridPane();
        this.grid.setAlignment(Pos.CENTER);
        this.grid.setHgap(10);
        this.grid.setVgap(10);
        this.grid.setPadding(new Insets(25, 25, 25, 25));

        this.rows = new ArrayList<HBox>();
        for (Line l : c.getLines())
        {
            l.accept(this);
        }

        for (HBox box : this.rows)
        {
            this.grid.add(box, 0, this.grid.getChildren().size()+1);
        }
        this.rows = null;
    }

    @Override
    public void visit(Line line)
    {
        this.rowColumns = new ArrayList<Node>();

        line.getLabel().accept(this);
        line.getInput().accept(this);

        HBox box = new HBox();
        for (Node n : this.rowColumns)
        {
            box.getChildren().add(n);
        }
        this.rows.add(box);

        this.rowColumns = null;
    }

    @Override
    public void visit(Input input)
    {
        input.accept(this);
    }

    @Override
    public void visit(BoolInput input)
    {
        this.rowColumns.add(new CheckBox());
    }
//
//    @Override
//    public void visit(DateInput input)
//    {
//        this.rowColumns.add(new DatePicker());
//    }

    @Override
    public void visit(DecInput input)
    {
        this.rowColumns.add(new TextField());
    }

    @Override
    public void visit(IntInput input)
    {
        this.rowColumns.add(new TextField());
    }

    @Override
    public void visit(StrInput input)
    {
        this.rowColumns.add(new TextField());
    }

    @Override
    public void visit(Label label)
    {
        this.rowColumns.add(new Text(label.getText()));
    }
}
