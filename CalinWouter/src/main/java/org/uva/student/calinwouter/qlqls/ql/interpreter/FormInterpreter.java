package org.uva.student.calinwouter.qlqls.ql.interpreter;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.AForm;
import org.uva.student.calinwouter.qlqls.generated.node.PStmt;
import org.uva.student.calinwouter.qlqls.ql.exceptions.FieldInUseException;
import org.uva.student.calinwouter.qlqls.ql.exceptions.InterpretationException;
import org.uva.student.calinwouter.qlqls.ql.exceptions.LabelInUseException;
import org.uva.student.calinwouter.qlqls.ql.types.Value;

import java.util.*;

public abstract class FormInterpreter extends AnalysisAdapter {

    private Map<String, Value<?>> variableMap;
    private Set<String> usedFields;
    private Set<String> usedLabels;
    protected List<InterpretationException> interpretationExceptions;
    private List<InterpretationException> warnings;

    public List<InterpretationException> getWarnings() {
        return warnings;
    }

    @Override
    public void caseAForm(AForm node) {
        LinkedList<PStmt> stmts = node.getStmt();
        usedFields = new HashSet<String>();
        usedLabels = new HashSet<String>();
        warnings = new LinkedList<InterpretationException>();
        interpretationExceptions = new LinkedList<InterpretationException>();
        for (PStmt stmt : stmts) {
            stmt.apply(createStmtInterpreter());
        }
    }

    public Value<?> getField(String key) {
        return variableMap.get(key);
    }

    public void registerFieldUse(String key) {
        if (!usedFields.add(key)) {
            throw new FieldInUseException(key);
        }
    }

    public void registerLabelUse(String label) {
        if (!usedLabels.add(label)) {
            warnings.add(new LabelInUseException(label));
        }
    }

    public void notifyTypeChecker(InterpretationException exception) {
        interpretationExceptions.add(exception);
    }

    protected abstract StmtInterpreter createStmtInterpreter();

    public void setField(String key, Value<?> value) {
        variableMap.put(key, value);
    }

    public FormInterpreter() {
        variableMap = new HashMap<String, Value<?>>();
    }
}