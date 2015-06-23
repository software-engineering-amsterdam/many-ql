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

        Style newStyle = rs;
        if (!(this.styleStack.empty()))
        {
            Style prevStyle = this.styleStack.peek();
            newStyle = Style.mergeStyles(rs, prevStyle);
        }
        this.styleStack.push(newStyle);
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
