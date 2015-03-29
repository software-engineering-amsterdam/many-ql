package nl.uva.bromance;

public class ParsingTest {

    protected static final String CORRECT_FORM = "    Form: \"default\" {\n" +
            "       Label: \"something\"{\n" +
            "           Text: \"something\"\n" +
            "      }}\n";

    protected static final String CORRECT_QUESTIONNAIRE = "Name: \"Tax\" {\n" +
            CORRECT_FORM +
            "}\n";
    protected static final String CORRECT_QUESTION = "\n     Question: \"identifier\"{" +
            "           Text: \"text\"" +
            "           Answer: integer" +
            "       }";

    protected static final String CORRECT_ELSE = "  Else:{ Text: \"something\"}\n";
    protected static final String CORRECT_IF = "   If: something{  Text: \"something\" }\n";
    protected static final String CORRECT_ELSE_IF = "Else If: something{ Text: \"something\" }\n";

    protected static final String CORRECT_CALCULATION = "Calculation: \"calculation\"{\n Input: 50+5 }\n";

    protected static final String CORRECT_FORM_SETUP = "Name: \"Tax\" {\n" +
            CORRECT_FORM +
            "}";

    protected static final String CORRECT_INPUT = "Input: expression";

    protected static final String CORRECT_LABEL = "Label: \"identifier\"{ Text: \"something\"}";

    protected static final String CORRECT_EXPRESSION = "expression";

}
