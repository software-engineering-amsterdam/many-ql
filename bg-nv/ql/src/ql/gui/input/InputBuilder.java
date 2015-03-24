package ql.gui.input;

import ql.ast.type.*;
import ql.gui.control.*;

/**
 * Created by Nik on 28-02-2015
 */
public class InputBuilder implements TypeVisitor<Input>
{
    private final String id;

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
        return new BoolInput(this.id, new Radio("yes", "no"));
    }

    @Override
    public Input visit(DecType type)
    {
        return new DecInput(this.id, new TextField());
    }

    @Override
    public Input visit(IntType type)
    {
        return new IntInput(this.id, new Slider(0, 100, 1));
    }

    @Override
    public Input visit(StrType type)
    {
        return new StrInput(this.id, new TextField());
    }

    @Override
    public Input visit(UndefType type)
    {
        throw new IllegalArgumentException("Cannot build input for undefined type.");
    }
}
