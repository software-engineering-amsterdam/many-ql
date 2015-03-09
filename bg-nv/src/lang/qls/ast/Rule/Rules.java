package lang.qls.ast.Rule;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * Created by bore on 08/03/15.
 */
public class Rules implements Iterable<Rule>
{
    private List<Rule> rules;

    public Rules(List<Rule> rules)
    {
        this.rules = rules;
    }

    public Optional<Rule> getRule(String label)
    {
        return this.rules
                .stream()
                .filter(r -> r.getLabel().equals(label))
                .findFirst();
    }

    public Iterator<Rule> iterator()
    {
        return this.rules.iterator();
    }
}
