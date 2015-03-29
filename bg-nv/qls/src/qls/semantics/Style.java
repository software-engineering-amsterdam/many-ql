package qls.semantics;

import ql.ast.type.Type;
import qls.ast.rule.Rule;
import qls.ast.rule.Rules;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bore on 09/03/15.
 */
public class Style
{
    private final Map<Type, Rules> typeToRules;

    public Style()
    {
        this.typeToRules = new HashMap<>();
    }

    public void addRules(Type t, Rules rs)
    {
        this.typeToRules.put(t, rs);
    }

    public Rules getRulesForType(Type t)
    {
        return this.typeToRules.get(t);
    }

    public void addStyle(Style lowPr)
    {
        for (Type t : lowPr.typeToRules.keySet())
        {
            Rules rs = this.getRulesForStyle(t, lowPr);
            this.addRules(t, rs);
        }
    }

    private Rules getRulesForStyle(Type t, Style s)
    {
        Rules lowPr = s.typeToRules.get(t);

        if (this.typeToRules.containsKey(t))
        {
            Rules highPr = this.typeToRules.get(t);
            return Rules.mergeRules(highPr, lowPr);
        }

        return lowPr;
    }
}
