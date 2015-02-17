package lang.ql.semantics;

import javafx.geometry.*;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import lang.ql.ast.expression.*;
import lang.ql.ast.form.Form;
import lang.ql.ast.statement.*;
import lang.ql.semantics.values.Value;

import java.util.Map;

import static lang.ql.ast.statement.QuestionType.*;

/**
 * Created by Nik on 17-2-15.
 */
public class GraphicsVisitor extends VisitorAbstract
{

    public GridPane getGrid()
    {
        return grid;
    }

    private GridPane grid;
    private int row;
    private Map<String, Value> values;

    public GraphicsVisitor(Map<String, Value> values)
    {
        this.values = values;
    }

    @Override
    public void visit(Form form)
    {
        this.grid = new GridPane();
        this.grid.setAlignment(javafx.geometry.Pos.CENTER);
        this.grid.setHgap(10);
        this.grid.setVgap(10);
        this.grid.setPadding(new Insets(25, 25, 25, 25));

        this.row = 0;

        for (Statement s : form.getStatements())
        {
            s.accept(this);
        }
    }

    @Override
    public void visit(Question n)
    {
        HBox qBox = new HBox(10);

        Text statement = new Text(n.getText());
        qBox.getChildren().add(statement);

        //TODO: bad bad switch, ga weg
        Value val = this.values.get(n);
        switch (n.getQuestionType())
        {
            case BOOLEAN:
                qBox.getChildren().add(new CheckBox());
                break;
            case DATE:
            case DECIMAL:
            case INTEGER:
            case STRING:
                qBox.getChildren().add(new TextField());
                break;
        }

        this.grid.add(qBox, 0, this.row++);
    }

    @Override
    public void visit(CalculatedQuestion cq)
    {
        HBox qBox = new HBox(10);

        Text statement = new Text(cq.getText());
        qBox.getChildren().add(statement);

        //TODO: bad bad switch, ga weg
        switch (cq.getQuestionType())
        {
            case BOOLEAN:
                CheckBox cb = new CheckBox();
                cb.setDisable(true);
                qBox.getChildren().add(cb);
                break;
            case DATE:
            case DECIMAL:
            case INTEGER:
            case STRING:
                qBox.getChildren().add(new Text("<some calculated value>"));
                break;
        }

        this.grid.add(qBox, 0, this.row++);
    }

    @Override
    public void visit(IfCondition ifCond)
    {
        for (Statement s : ifCond.getStatements())
        {
            s.accept(this);
        }
    }
}
