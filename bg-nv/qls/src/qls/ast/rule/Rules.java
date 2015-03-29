package qls.ast.rule;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by bore on 08/03/15.
 */
public class Rules implements Iterable<Rule>
{
    private final List<Rule> rules;

    public Rules(List<Rule> rules)
    {
        this.rules = rules;
    }

    public Iterator<Rule> iterator()
    {
        return this.rules.iterator();
    }

    // TODO: why make new object
    public Rules addRules(Rules lowPr)
    {
        List<Rule> res = new ArrayList<>();
        res.addAll(this.rules);

        for (Rule l : lowPr)
        {
            if (!(l.isRuleOverwritten(this)))
            {
                res.add(l);
            }
        }

        return new Rules(res);
    }
}
