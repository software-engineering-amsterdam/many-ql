package lang.ql.gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
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
import lang.ql.semantics.*;
import lang.ql.semantics.errors.Message;
import lang.ql.semantics.errors.Warning;
import lang.ql.semantics.values.BooleanValue;
import lang.ql.semantics.values.IntegerValue;
import lang.ql.semantics.values.StringValue;
import lang.ql.semantics.values.Value;

import java.util.*;

/**
 * Created by Nik on 23-2-15.
 */
public class SimpleGui implements GuiModelVisitor<Node>
{
    private ValueTable valueTable;
    private DependencyTable dependencyTable;

    private Canvas canvas;
    private Stage primaryStage;

    // TODO: is there a nicer way?
    private Map<String, GuiObserver> observers = new HashMap<String, GuiObserver>();
    private Map<String, GuiObservable> observables = new HashMap<String, GuiObservable>();

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
        this.dependencyTable = DependencyResolver.resolve(ast);
    }

//    private void rerender()
//    {
//        this.start();
//    }

    private void start()
    {
        GridPane grid = (GridPane) this.canvas.accept(this);

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

        for (Line line : c.getLines())
        {
            Node node = line.accept(this);
            grid.add(node, 0, grid.getChildren().size() + 1);
        }

        return grid;
    }

    @Override
    public Node visit(Line line)
    {
        Label label = line.getLabel();
        Input input = line.getInput();

        VBox container = new VBox();
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

        //validation
        if (!input.isValid())
        {
            Message msg = input.getValidationError();
            containerChildren.add(makeErrorBox(msg));
        }

        return container;
    }

    @Override
    public Node visit(Input input)
    {
        return input.accept(this);
    }

    @Override
    public Node visit(final BoolInput input)
    {
        CheckBox checkBox = makeCheckbox(input);

        checkBox.selectedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue)
            {
                valueTable.storeValue(input.getId(), new BooleanValue(newValue));
//                rerender();
            }
        });

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
        return this.makeTextField(input);
    }

    @Override
    public Node visit(final IntInput input)
    {
        final TextField textField = this.makeTextField(input);

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
                    input.passValidation();

                }
                catch (NumberFormatException e)
                {
                    // TODO: create the warnings/errors
                    Warning warningMsg = new Warning("The entered value \"" + newValue + "\" is not an integer.");
                    input.failValidation(warningMsg);
                }
//                rerender();
            }
        });

        return textField;
    }

    @Override
    public Node visit(final StrInput input)
    {
        final TextField textField = this.makeTextField(input);

        final GuiObservable guiObservable = new GuiObservable();
        this.observables.put(input.getId(), guiObservable);

        textField.focusedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue)
            {
                if (!newValue)
                {
                    valueTable.storeValue(input.getId(), new StringValue(textField.getText()));
//                    rerender();
                    guiObservable.updateRevision();
                    guiObservable.notifyObservers();
                }
            }
        });
        textField.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue)
            {
                valueTable.storeValue(input.getId(), new StringValue(newValue));
//                rerender();
            }
        });

        return textField;
    }

    @Override
    public Node visit(ExprInput input)
    {
        return input.accept(this);
    }

    @Override
    public Node visit(BoolExprInput input)
    {
        reevaluate(input);
        return makeCheckbox(input);
    }

    @Override
    public Node visit(DateExprInput input)
    {
        reevaluate(input);
        return new DatePicker();
    }

    @Override
    public Node visit(DecExprInput input)
    {
        reevaluate(input);
        return this.makeTextField(input);
    }

    @Override
    public Node visit(IntExprInput input)
    {
        reevaluate(input);
        return this.makeTextField(input);
    }

    @Override
    public Node visit(final StrExprInput input)
    {
        reevaluate(input);

        final TextField textField = this.makeTextField(input);

        GuiObserver observer = new GuiTextObserver(input.getId(), textField, input);
        this.observers.put(input.getId(), observer);

        final GuiObservable guiObservable = new GuiObservable();
        this.observables.put(input.getId(), guiObservable);

        Set<String> dependants = this.dependencyTable.getDependants(input.getId());
        for (String dependant : dependants)
        {
            // TODO: figure out if I can solve this somehow for fields that haven't been visited yet
            if (this.observables.containsKey(dependant))
            {
                this.observables.get(dependant).addObserver(observer);
            }
        }

        textField.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue)
            {

                valueTable.storeValue(input.getId(), new StringValue(newValue));
//                rerender();
                guiObservable.updateRevision();
                guiObservable.notifyObservers();
            }
        });

        return textField;
    }

    @Override
    public Node visit(Label label)
    {
        Text text = new Text(label.getText());
        return text;
    }

    private void reevaluate(ExprInput input)
    {
        Value val = ExprEvaluator.evaluate(input.getExpression(), this.valueTable);
        this.valueTable.storeValue(input.getId(), val);
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

    private CheckBox makeCheckbox(Input input)
    {
        CheckBox checkBox = new CheckBox();

        Value val = valueTable.getValue(input.getId());
        Boolean selected = val.isUndefined() ? false : (Boolean) val.getValue();

        checkBox.setSelected(selected);
        checkBox.setDisable(input.getDisabled());

        return checkBox;
    }

    private TextField makeTextField(Input input)
    {
        TextField textField = new TextField();
        textField.setDisable(input.getDisabled());

        Value val = valueTable.getValue(input.getId());
        if (!val.isUndefined())
        {
            textField.setText(val.getValue().toString());
        }
        return textField;
    }

    private abstract class GuiObserver implements Observer
    {
    }


    private class GuiTextObserver extends GuiObserver
    {
        private ExprInput input;
        private TextInputControl control;
        private String id;

        public GuiTextObserver(String id, TextInputControl control, ExprInput input)
        {
            this.id = id;
            this.control = control;
            this.input = input;
        }

        @Override
        public void update(Observable o, Object arg)
        {
            Value newValue = ExprEvaluator.evaluate(this.input.getExpression(), valueTable);
            valueTable.storeValue(input.getId(), newValue);
            if (!newValue.isUndefined())
            {
                String newText = ((StringValue) newValue).getValue();
                control.setText(newText);
            }
        }
    }

    private class GuiObservable extends Observable
    {
        public GuiObservable()
        {
        }

        //dummy method to trigger change
        public void updateRevision()
        {
            setChanged();
        }
    }

}
