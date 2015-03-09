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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lang.ql.ast.expression.Expr;
import lang.ql.ast.form.Form;
import lang.ql.gui.canvas.Canvas;
import lang.ql.gui.input.*;
import lang.ql.gui.input.expression.*;
import lang.ql.gui.input.regular.*;
import lang.ql.gui.label.Label;
import lang.ql.gui.section.ConditionalSection;
import lang.ql.gui.section.LineSection;
import lang.ql.gui.section.Section;
import lang.ql.semantics.*;
import lang.ql.semantics.values.*;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Nik on 23-2-15.
 */
public class SimpleGui implements ModelVisitor<Node>
{
    private ValueTable valueTable;
    private final Refresher refresher;
    private final DataStore dataStore;

    public static void run(Form ast, Stage stage)
    {
        Modeler modeler = new Modeler();
        Canvas canvas = modeler.visit(ast);

        SimpleGui gui = new SimpleGui(ast);
        gui.start(canvas, stage);
    }

    private SimpleGui(Form ast)
    {
        this.dataStore = new DataStore(ast);
        this.valueTable = Evaluator.evaluate(ast);
        this.refresher = new Refresher();
    }

    private void start(Canvas canvas, Stage stage)
    {
        GridPane grid = (GridPane) canvas.accept(this);

        Button btn = new Button("Save answers");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 0, grid.getChildren().size() + 1);

        Text actionTarget = new Text();
        grid.add(actionTarget, 0, grid.getChildren().size() + 1);

//        ProgressBar pb = new ProgressBar(0);
//        pb.setPrefWidth(500);
//        grid.add(pb, 0, grid.getChildren().size() + 1);

        btn.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent e)
            {
                dataStore.store(valueTable);
                actionTarget.setFill(Color.FIREBRICK);
                actionTarget.setText("Your data has been saved.");
            }
        });

        ScrollPane pane = new ScrollPane();
        pane.setFitToWidth(true);
        pane.setFitToHeight(true);
        pane.setContent(grid);
        pane.setStyle("-fx-border-color: lightgray;");

        Scene scene = new Scene(pane, 600, 700);

        stage.setTitle(canvas.getName());
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public Node visit(Canvas c)
    {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setStyle("-fx-background-color: white;");
        grid.setPadding(new Insets(75, 50, 25, 50));

        for (Section section : c.getSections())
        {
            Node node = section.accept(this);
            grid.add(node, 0, grid.getChildren().size());
        }
        grid.layout();

        return grid;
    }

    @Override
    public Node visit(final ConditionalSection section)
    {
        this.refresher.addItem(section);

        Pane container = section.getContainer();
        Expr ex = section.getCondition();

        Value v = ExprEvaluator.evaluate(ex, valueTable);
        Boolean visible = false;
        if (!v.isUndefined())
        {
            visible = ((BooleanValue) v).getValue();
        }
        section.setVisible(visible);

        for (Section subsection : section.getSubsections())
        {
            Node n = subsection.accept(this);
            container.getChildren().add(n);
        }

        return container;
    }

    @Override
    public Node visit(LineSection lineSection)
    {
        VBox container = lineSection.getContainer();
        Label label = lineSection.getLabel();
        Input input = lineSection.getInput();

        container.setFillWidth(true);
        container.setPrefWidth(400);
        container.setPadding(new Insets(0, 0, 10, 0));
        List<Node> containerChildren = container.getChildren();

        //label
        HBox labelBox = new HBox();
        Node labelNode = label.accept(this);
        labelBox.getChildren().add(labelNode);
        containerChildren.add(labelBox);

        //input
        HBox inputBox = new HBox();
        inputBox.setAlignment(Pos.TOP_RIGHT);
        Node inputNode = input.accept(this);
        inputBox.getChildren().add(inputNode);
        containerChildren.add(inputBox);

        return container;
    }

    @Override
    public Node visit(final BoolInput input)
    {
        input.addObserver(this.refresher);
        CheckBox checkBox = input.getControl();

        checkBox.selectedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue)
            {
                input.processUserInput(newValue, valueTable);
            }
        });
        return createInputBox(input);
    }

    @Override
    public Node visit(DateInput input)
    {
        input.addObserver(this.refresher);
        return input.getControl();
    }

    @Override
    public Node visit(final DecInput input)
    {
        input.addObserver(this.refresher);
        final TextInputControl textField = input.getControl();

        textField.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue)
            {
                input.processUserInput(newValue, valueTable);
            }
        });

        return createInputBox(input);
    }

    @Override
    public Node visit(final IntInput input)
    {
        input.addObserver(this.refresher);
        final TextInputControl textField = input.getControl();

        textField.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue)
            {
                input.processUserInput(newValue, valueTable);
            }
        });

        return createInputBox(input);
    }

    @Override
    public Node visit(final StrInput input)
    {
        input.addObserver(this.refresher);
        final TextInputControl textField = input.getControl();

        textField.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue)
            {
                input.processUserInput(newValue, valueTable);
            }
        });

        return createInputBox(input);
    }

    @Override
    public Node visit(BoolExprInput input)
    {
        this.refresher.addItem(input);

        CheckBox checkBox = input.getControl();
        Value val = valueTable.getValue(input.getId());

        Boolean selected = false;
        if (!val.isUndefined())
        {
            selected = ((BooleanValue) val).getValue();
        }
        checkBox.setSelected(selected);

        return checkBox;
    }

    @Override
    public Node visit(DateExprInput input)
    {
        this.refresher.addItem(input);

        return input.getControl();
    }

    @Override
    public Node visit(DecExprInput input)
    {
        this.refresher.addItem(input);

        TextInputControl textField = input.getControl();
        Value val = valueTable.getValue(input.getId());

        String textValue = "";
        if (!val.isUndefined())
        {
            BigDecimal decVal = ((DecimalValue) val).getValue();
            textValue = decVal.toString();
        }
        textField.setText(textValue);

        return textField;
    }

    @Override
    public Node visit(IntExprInput input)
    {
        this.refresher.addItem(input);

        TextInputControl textField = input.getControl();
        Value val = valueTable.getValue(input.getId());

        String textValue = "";
        if (!val.isUndefined())
        {
            Integer intVal = ((IntegerValue) val).getValue();
            textValue = intVal.toString();
        }
        textField.setText(textValue);

        return textField;
    }

    @Override
    public Node visit(final StrExprInput input)
    {
        this.refresher.addItem(input);

        TextInputControl textField = input.getControl();
        Value val = valueTable.getValue(input.getId());

        String textValue = "";
        if (!val.isUndefined())
        {
            textValue = ((StringValue) val).getValue();
        }
        textField.setText(textValue);

        return input.getControl();
    }

    @Override
    public Node visit(Label label)
    {
        Text text = new Text(label.getText());
        return text;
    }

    private Node createInputBox(RegularInput input)
    {
        Pane box = new VBox();
        box.getChildren().add(input.getControl());
        box.getChildren().add(input.getErrorField());
        return box;
    }
}
