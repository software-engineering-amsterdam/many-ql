package qls.semantics;

import ql.ast.type.Type;
import qls.ast.rule.Rules;
import qls.semantics.Style;

import java.util.Stack;

/**
 * Created by bore on 09/03/15.
 */
public class StyleStack
{
    Stack<Style> stack;

    public StyleStack()
    {
        this.stack = new Stack<>();
    }

    public void push(Style rs)
    {
        assert rs != null;

        if (this.stack.empty())
        {
            this.stack.push(rs);
        }
        else
        {
            Style p = this.stack.peek();
            Style merged = p.addStyle(rs);
            this.stack.push(merged);
        }
    }

    public void pop()
    {
        this.stack.pop();
    }

    public Rules getRulesForType(Type t)
    {
        assert !this.stack.empty();

        Style s = this.stack.peek();
        return s.getRulesForType(t);
    }
}
