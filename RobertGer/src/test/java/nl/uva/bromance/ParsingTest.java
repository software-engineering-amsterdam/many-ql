package nl.uva.bromance;

/**
 * Created by Robert on 3/2/2015.
 */
public class ParsingTest {

    protected static final String CORRECT_FORM = "    Form: \"default\" {\n" +
            "       Label: \"something\"{" +
            "           Text: \"something\"" +
            "      }}";

    protected static final String CORRECT_QUESTIONNAIRE = "Name: \"Tax\" {\n" +
            CORRECT_FORM +
            "}";
    protected static final String CORRECT_QUESTION = "\n     Question: \"question\"{" +
            "           Text: \"text?\"" +
            "           Answer: integer" +
            "       }";

    protected static final String CORRECT_ELSE = "\n     Else:{ Text: \"something\"}";
    protected static final String CORRECT_IF = "\n     If: something{  Text: \"something\" }";
    protected static final String CORRECT_ELSE_IF = "Else If: something{ Text: \"something\"}";

    protected static final String CORRECT_CALCULATION = "\n     Calculation: \"calculation\"{" +
            CORRECT_IF +
            "    }";

    public static final String CORRECT_FORM_SETUP = "Name: \"Tax\" {\n" +
            CORRECT_FORM +
            "}";
}
