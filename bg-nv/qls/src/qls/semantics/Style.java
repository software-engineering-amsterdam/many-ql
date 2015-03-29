package qls.semantics;

import ql.ast.type.Type;
import qls.ast.rule.Rule;
import qls.ast.rule.Rules;

import java.util.*;

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
        if (this.typeToRules.containsKey(t))
        {
            return this.typeToRules.get(t);
        }
        return Rules.empty;
    }

    public static Style mergeStyles(Style highPr, Style lowPr)
    {
        Style result = new Style();
        result.typeToRules.putAll(highPr.typeToRules);

        for (Type t : lowPr.typeToRules.keySet())
        {
            Rules rs = result.getRulesForStyle(t, lowPr);
            result.addRules(t, rs);
        }

        return result;
    }

    private Rules getRulesForStyle(Type t, Style s)
    {
        Rules lowPr = s.typeToRules.get(t);

        if (this.typeToRules.containsKey(t))
        {
            Rules highPr = this.typeToRules.get(t);
            return Rules.mergeRules(highPr, lowPr);
        }

        return Rules.mergeRules(lowPr, Rules.empty);
    }
}
