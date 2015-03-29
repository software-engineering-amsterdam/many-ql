package qls.tests;

import ql.ast.type.Type;
import qls.ast.rule.Rules;
import qls.semantics.Style;

/**
 * Created by bore on 29/03/15.
 */
public class StyleBuilder
{
    private Style style;

    public StyleBuilder()
    {
        this.style = new Style();
    }

    public StyleBuilder WithRules(Type t, Rules rs)
    {
        this.style.addRules(t, rs);
        return this;
    }

    public Style build()
    {
        return this.style;
    }
}
