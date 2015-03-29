package qls.semantics;

import ql.ast.type.Type;
import qls.ast.rule.Rules;

import java.util.Stack;

/**
 * Created by bore on 09/03/15.
 */
public class StyleStack
{
    private final Stack<Style> styleStack;

    public StyleStack()
    {
        this.styleStack = new Stack<>();
    }

    public void push(Style rs)
    {
        assert rs != null;

        if (this.styleStack.empty())
        {
            this.styleStack.push(rs);
        }
        else
        {
            Style prevStyle = this.styleStack.peek();
            Style newStyle = new Style();
            newStyle.addStyle(rs);
            newStyle.addStyle(prevStyle);

            this.styleStack.push(newStyle);
        }
    }

    public void pop()
    {
        this.styleStack.pop();
    }

    public Rules peekRulesForType(Type t)
    {
        assert !this.styleStack.empty();

        Style s = this.styleStack.peek();
        return s.getRulesForType(t);
    }
}
