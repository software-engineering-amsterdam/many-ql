package lang.qls.semantics;

import lang.ql.gui.segment.RowStyle;
import lang.qls.ast.rule.Rules;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bore on 09/03/15.
 */

public class FormStyle
{
    private Map<String, Rules> questionIdToRules;

    public FormStyle()
    {
        this.questionIdToRules = new HashMap<>();
    }

    public Rules getStyleForQuestion(String id)
    {
        return this.questionIdToRules.get(id);
    }

    public void registerStyle(String id, Rules rs)
    {
        this.questionIdToRules.put(id, rs);
    }

    public void test()
    {
        for (Rules r : this.questionIdToRules.values())
        {
            RowStyle style = RulesToGui.convert(r);

        }
    }
}