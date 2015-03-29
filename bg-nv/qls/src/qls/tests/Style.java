package qls.tests;

import org.junit.Test;
import qls.ast.rule.Rule;
import qls.ast.rule.Rules;
import qls.ast.rule.Width;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bore on 29/03/15.
 */
public class Style
{
    @Test
    public void TesT()
    {
        Width t = new Width(100, 0);
        Width y = new Width(50, 0);

        assert t.isOverwrittenBy(y);

        Width wr = new Width(15, 0);
        List<Rule> ruleList = new ArrayList<>();
        ruleList.add(wr);

        Rules rules = new Rules(ruleList);

        //rules.addRules()
    }
}
