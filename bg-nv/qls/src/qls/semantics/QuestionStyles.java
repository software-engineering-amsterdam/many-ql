package qls.semantics;

import qls.ast.rule.Rules;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bore on 09/03/15.
 */

public class QuestionStyles
{
    private final Map<String, Rules> questionIdToRules;

    public QuestionStyles()
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