package org.uva.student.calinwouter.ql.interpreter.model;

import org.uva.student.calinwouter.ql.generated.lexer.Lexer;
import org.uva.student.calinwouter.ql.generated.node.AExpBegin;
import org.uva.student.calinwouter.ql.generated.node.Start;
import org.uva.student.calinwouter.ql.generated.parser.Parser;
import org.uva.student.calinwouter.ql.interpreter.components.PExpInterpreter;

import javax.swing.event.TableModelEvent;
import java.io.PushbackReader;
import java.io.StringReader;

public class QuestionModel implements DisplayModelInterface {
    private final String variable;
    private final String text;
    private final String type;

    public String getVariable() {
        return variable;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public QuestionModel(String variable, String text, String type) {
        this.variable = variable;
        this.text = text;
        this.type = type;
    }

    private Object interpreteExpression(Environment environment, String expression) {
        Lexer lexer = new Lexer(new PushbackReader(new StringReader(expression)));
        Parser parser = new Parser(lexer);
        try {
            Start ast = parser.parse();
            return new PExpInterpreter().interprete(environment, ((AExpBegin) ast.getPBegin()).getExp());
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object[] renderTableRow(Environment environment) {
        return new Object[] {
                text,
                environment.getEnvVars().get(variable)
        };
    }

    @Override
    public boolean updateEnvironmentForRowChange(TableModelEvent e, String change, Environment environment) {
        environment.getEnvVars().put(variable, interpreteExpression(environment, change));
        return true;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return column == 1;
    }
}
