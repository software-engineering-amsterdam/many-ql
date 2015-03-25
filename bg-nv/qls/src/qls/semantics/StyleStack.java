package qls.semantics;

import ql.ast.type.Type;
import qls.ast.rule.Rules;

import java.util.Stack;

/**
 * Created by bore on 09/03/15.
 */
public class StyleStack
{
    private final Stack<Style> styles;

    public StyleStack()
    {
        this.styles = new Stack<>();
    }

    public void push(Style rs)
    {
        assert rs != null;

        if (this.styles.empty())
        {
            this.styles.push(rs);
        }
        else
        {
            Style p = this.styles.peek();
            rs.addStyle(p);
            this.styles.push(rs);
        }
    }

    public void pop()
    {
        this.styles.pop();
    }

    public Rules getRulesForType(Type t)
    {
        assert !this.styles.empty();

        Style s = this.styles.peek();
        return s.getRulesForType(t);
    }
}
