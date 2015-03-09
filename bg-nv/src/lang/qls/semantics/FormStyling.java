package lang.qls.semantics;

import lang.qls.ast.Rule.Rules;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bore on 09/03/15.
 */
public class FormStyling
{
    private Map<String, Rules> questionStyles;

    public FormStyling()
    {
        this.questionStyles = new HashMap<>();
    }
}
