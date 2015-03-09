package lang.qls.semantics;

import lang.ql.ast.type.Type;
import lang.qls.ast.Rule.Rules;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bore on 09/03/15.
 */
public class Style
{
    private Map<Type, Rules> styles;

    public Style()
    {
        this.styles = new HashMap<>();
    }

    public void addRules(Type t, Rules rs)
    {
        this.styles.put(t, rs);
    }

    public Rules getRulesForType(Type t)
    {
        return this.styles.get(t);
    }

    public Style addStyle(Style lowPr)
    {
        Style result = new Style();
        result.styles.putAll(this.styles);

        for (Type t : lowPr.styles.keySet())
        {
            Rules rs = lowPr.styles.get(t);

            if (this.styles.containsKey(t))
            {
                Rules h = this.styles.get(t);
                Rules l = lowPr.styles.get(t);
                rs = h.addRules(l);
            }

            result.addRules(t, rs);
        }

        return result;
    }
}
