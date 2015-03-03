package lang.ql.gui.input;

import lang.ql.ast.type.*;
import lang.ql.gui.input.regular.*;

/**
 * Created by Nik on 28-02-2015
 */
public class InputBuilder implements TypeVisitor<Input>
{
    private String id;

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
        return new BoolInput(this.id);
    }

    @Override
    public Input visit(DateType type)
    {
        return new DateInput(this.id);
    }

    @Override
    public Input visit(DecType type)
    {
        return new DecInput(this.id);
    }

    @Override
    public Input visit(IntType type)
    {
        return new IntInput(this.id);
    }

    @Override
    public Input visit(StrType type)
    {
        return new StrInput(this.id);
    }

    @Override
    public Input visit(UndefinedType type)
    {
        return null;
    }
}
