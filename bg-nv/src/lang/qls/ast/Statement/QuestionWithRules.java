package lang.qls.ast.Statement;

import lang.qls.ast.Rule.StylesheetRule;

import java.util.List;

/**
 * Created by bore on 02/03/15.
 */
public class QuestionWithRules extends Question
{
    private List<StylesheetRule> body;

    public QuestionWithRules(String id, List<StylesheetRule> body)
    {
        super(id);
        this.body = body;
    }

    public List<StylesheetRule> getBody()
    {
        return this.body;
    }
}
