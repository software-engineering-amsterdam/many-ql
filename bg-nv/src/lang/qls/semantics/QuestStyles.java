package lang.qls.semantics;

import lang.qls.ast.Rule.Rules;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bore on 09/03/15.
 */

public class QuestStyles
{
    private Map<String, Rules> questionIdToRules;

    public QuestStyles()
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
}