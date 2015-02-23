package lang.ql.ast.type;

/**
 * Created by bore on 17/02/15.
 */
public abstract class Type
{
    private String title;

    public Type(String s)
    {
        this.title = s;
    }

    public String getTitle()
    {
        return this.title;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o instanceof Type)
        {
            return this.title.equals(((Type)o).title);
        }

        return false;
    }

    @Override
    public int hashCode()
    {
        return this.title.hashCode();
    }

    public abstract void accept(TypeVisitor visitor);
}
