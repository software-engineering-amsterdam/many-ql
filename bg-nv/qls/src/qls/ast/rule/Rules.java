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

    public static Rules mergeRules(Rules highPr, Rules lowPr)
    {
        List<Rule> rules = new ArrayList<>();
        rules.addAll(highPr.rules);

        for (Rule l : lowPr)
        {
            if (!(l.isRuleOverwrittenBy(highPr)))
            {
                rules.add(l);
            }
        }

        return new Rules(rules);
    }
}
