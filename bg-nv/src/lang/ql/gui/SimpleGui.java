package lang.ql.gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
//import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
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
import lang.ql.semantics.errors.Message;
import lang.ql.semantics.errors.Warning;
import lang.ql.semantics.values.*;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Nik on 23-2-15.
 */
public class SimpleGui implements ModelVisitor<Node>
{
    private ValueTable valueTable;

    private Canvas canvas;
    private Stage primaryStage;

    private Set<Refreshable> refreshables;
    private Set<Observable> observables;

    public static void run(Form ast, Stage primaryStage)
    {
        Modeler modeler = new Modeler();
        Canvas canvas = modeler.visit(ast);

        SimpleGui gui = new SimpleGui(ast);
        gui.canvas = canvas;
        gui.primaryStage = primaryStage;
        gui.start();
    }

    private SimpleGui(Form ast)
    {
        this.valueTable = Evaluator.evaluate(ast);
        this.refreshables = new HashSet<Refreshable>();
        this.observables = new HashSet<Observable>();
    }

    private void start()
    {
        GridPane grid = (GridPane) this.canvas.accept(this);

        GuiObserver obs = new GuiObserver(this.refreshables);
        for (Observable observable : this.observables)
        {
            observable.addObserver(obs);
        }

        this.primaryStage.setTitle("Questionnaire");

        Scene scene = new Scene(grid, 600, 700);
        this.primaryStage.setScene(scene);

        Button btn = new Button("Make magic happen");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 0, grid.getChildren().size() + 1);

        final Text actionTarget = new Text();
        grid.add(actionTarget, 0, grid.getChildren().size() + 1);

        btn.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent e)
            {
                actionTarget.setFill(Color.FIREBRICK);
                actionTarget.setText("Unicorns!");
            }
        });

        this.primaryStage.show();
    }

    @Override
    public Node visit(Canvas c)
    {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setStyle("-fx-background-color: #FFFFFF;");
        grid.setPadding(new Insets(25, 25, 25, 25));

        for (Section section : c.getSections())
        {
            Node node = section.accept(this);
            grid.add(node, 0, grid.getChildren().size() + 1);
        }

        return grid;
    }

    @Override
    public Node visit(final ConditionalSection section)
    {
        this.refreshables.add(section);

        Pane container = section.getContainer();
        Expr ex = section.getCondition();

        Value v = ExprEvaluator.evaluate(ex, valueTable);
        Boolean visible = false;
        if (!v.isUndefined())
        {
            visible = ((BooleanValue)v).getValue();
        }

        container.setVisible(visible);
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
        this.observables.add(input);
        CheckBox checkBox = input.getControl();

        checkBox.selectedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue)
            {
                valueTable.storeValue(input.getId(), new BooleanValue(newValue));;
                input.update(valueTable);
            }
        });

        return checkBox;
    }

    @Override
    public Node visit(DateInput input)
    {
        this.observables.add(input);
        return input.getControl();
    }

    @Override
    public Node visit(final DecInput input)
    {
        this.observables.add(input);
        final TextInputControl textField = input.getControl();

        textField.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue)
            {
                newValue = newValue.trim();
                try
                {
                    BigDecimal value = new BigDecimal(newValue);
                    valueTable.storeValue(input.getId(), new DecimalValue(value));
                    input.update(valueTable);
                }
                catch (NumberFormatException e)
                {
                    // TODO: create the warnings/errors
                    Warning warningMsg = new Warning("The entered value \"" + newValue + "\" is not a decimal.");
                }
            }
        });

        return textField;
    }

    @Override
    public Node visit(final IntInput input)
    {
        this.observables.add(input);
        final TextInputControl textField = input.getControl();

        textField.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue)
            {
                newValue = newValue.trim();
                try
                {
                    Integer value = Integer.parseInt(newValue);
                    valueTable.storeValue(input.getId(), new IntegerValue(value));
                    input.update(valueTable);
                }
                catch (NumberFormatException e)
                {
                    // TODO: create the warnings/errors
                    Warning warningMsg = new Warning("The entered value \"" + newValue + "\" is not an integer.");
                }
            }
        });

        return textField;
    }

    @Override
    public Node visit(final StrInput input)
    {
        this.observables.add(input);
        final TextInputControl textField = input.getControl();

        textField.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue)
            {
                valueTable.storeValue(input.getId(), new StringValue(newValue));
                input.update(valueTable);
            }
        });

        return textField;
    }

    @Override
    public Node visit(BoolExprInput input)
    {
        this.refreshables.add(input);

        CheckBox checkBox = input.getControl();
        Value val = valueTable.getValue(input.getId());

        Boolean selected = false;
        if (!val.isUndefined())
        {
            selected = ((BooleanValue)val).getValue();
        }
        checkBox.setSelected(selected);

        return checkBox;
    }

    @Override
    public Node visit(DateExprInput input)
    {
        this.refreshables.add(input);

        return input.getControl();
    }

    @Override
    public Node visit(DecExprInput input)
    {
        this.refreshables.add(input);

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
        this.refreshables.add(input);

        TextInputControl textField = input.getControl();
        Value val = valueTable.getValue(input.getId());

        String textValue = "";
        if (!val.isUndefined())
        {
            Integer intVal = ((IntegerValue)val).getValue();
            textValue = intVal.toString();
        }
        textField.setText(textValue);

        return textField;
    }

    @Override
    public Node visit(final StrExprInput input)
    {
        this.refreshables.add(input);

        TextInputControl textField = input.getControl();
        Value val = valueTable.getValue(input.getId());

        String textValue = "";
        if (!val.isUndefined())
        {
            textValue = ((StringValue)val).getValue();
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

    private HBox makeErrorBox(Message msg)
    {
        Text msgText = new Text(msg.getMessage());
        msgText.setFill(Color.FIREBRICK);

        HBox msgBox = new HBox();
        msgBox.setAlignment(Pos.BOTTOM_RIGHT);
        msgBox.getChildren().add(msgText);

        return msgBox;
    }
}
