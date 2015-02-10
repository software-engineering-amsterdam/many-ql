package org.uva.student.calinwouter.ql.interpreter.model;

import org.uva.student.calinwouter.ql.generated.lexer.Lexer;
import org.uva.student.calinwouter.ql.generated.node.AExpBegin;
import org.uva.student.calinwouter.ql.generated.node.Start;
import org.uva.student.calinwouter.ql.generated.parser.Parser;
import org.uva.student.calinwouter.ql.interpreter.components.PExpInterpreter;

import javax.swing.event.TableModelEvent;
import java.io.PushbackReader;
import java.io.StringReader;

public class ComputedValueModel implements DisplayModelInterface {
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

    public ComputedValueModel(String variable, String text, String type, Object value, Environment e) {
        this.variable = variable;
        this.text = text;
        this.type = type;
        e.getEnvVars().put(variable, value);
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
        return false;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
