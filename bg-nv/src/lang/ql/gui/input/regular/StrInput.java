package lang.ql.gui.input.regular;

import javafx.beans.value.ChangeListener;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import lang.ql.gui.ModelVisitor;
import lang.ql.semantics.ValueTable;
import lang.ql.semantics.values.StringValue;
import lang.ql.semantics.values.Value;

/**
 * Created by Nik on 22-02-2015
 */
public class StrInput extends RegularInput<String, TextInputControl>
{
    public StrInput(String id)
    {
        this(id, true, false);
    }

    public StrInput(String id, Boolean visible, Boolean disabled)
    {
        super(id, new TextField(), visible, disabled);
    }

    @Override
    public <V> V accept(ModelVisitor<V> visitor)
    {
        return visitor.visit(this);
    }

    @Override
    public Value convertUserInputToValue(String userInput)
    {
        this.resetValidation();
        userInput = userInput.trim();
        return new StringValue(userInput);
    }

    @Override
    public void attachListener(ValueTable valueTable)
    {
        ChangeListener<String> cl = this.constructChangeListener(valueTable);
        this.control.textProperty().addListener(cl);
    }
}
