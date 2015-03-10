package lang.qls.semantics;

import lang.ql.ast.type.Type;
import lang.qls.ast.rule.Rules;

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

    public void addStyle(Style rs)
    {
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

    public void removeStyle()
    {
        this.stack.pop();
    }

    public Rules getRulesForType(Type t)
    {
        Style s = this.stack.peek();
        return s.getRulesForType(t);
    }
}
