package ql.gui.input;

import ql.ast.type.*;
import ql.gui.control.*;

import java.math.BigDecimal;

/**
 * Created by Nik on 28-02-2015
 */
public class InputBuilder implements TypeVisitor<Input>
{
    private final String id;
    private final Boolean VISIBLE = true;
    private final Boolean DISABLED = false;

    public static Input build(String id, Type type)
    {
        InputBuilder b = new InputBuilder(id);
        return type.accept(b);
    }


    private InputBuilder(String id)
    {
        this.id = id;
    }

    @Override
    public Input visit(BoolType type)
    {
        return new BoolInput(this.id, new Radio(VISIBLE, DISABLED, "yes", "no"));
    }

    @Override
    public Input visit(DateType type)
    {
        return null; //new DateInput(this.id, new TextField(VISIBLE, DISABLED));
    }

    @Override
    public Input visit(DecType type)
    {
        return new DecInput(this.id, new TextField(VISIBLE, DISABLED));
    }

    @Override
    public Input visit(IntType type)
    {
        return new IntInput(this.id, new Slider(VISIBLE, DISABLED));
    }

    @Override
    public Input visit(StrType type)
    {
        return new StrInput(this.id, new TextField(VISIBLE, DISABLED));
    }

    @Override
    public Input visit(UndefType type)
    {
        throw new IllegalArgumentException("Cannot build input for undefined type.");
    }
}
