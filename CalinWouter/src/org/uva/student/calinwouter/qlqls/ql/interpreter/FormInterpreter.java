package org.uva.student.calinwouter.qlqls.ql.interpreter;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.AForm;
import org.uva.student.calinwouter.qlqls.generated.node.PStmt;
import org.uva.student.calinwouter.qlqls.ql.types.TypeModel;
import org.uva.student.calinwouter.qlqls.ql.exceptions.FieldInUseException;
import org.uva.student.calinwouter.qlqls.ql.exceptions.InterpretationException;
import org.uva.student.calinwouter.qlqls.ql.exceptions.LabelInUseException;

import java.util.*;
import java.util.List;

public abstract class FormInterpreter extends AnalysisAdapter {

    private Map<String, TypeModel<?>> variableMap;
    private LinkedList<PStmt> stmts;
    private Set<String> usedFields;
    private Set<String> usedLabels;
    protected List<InterpretationException> interpretationExceptions;
    private List<InterpretationException> warnings;

    public List<InterpretationException> getWarnings() {
        return warnings;
    }

    @Override
    public void caseAForm(AForm node) {
        stmts = node.getStmt();
    }

    public TypeModel<?> getField(String key) {
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

    protected void reInterpret() {
        usedFields = new HashSet<String>();
        usedLabels = new HashSet<String>();
        warnings = new LinkedList<InterpretationException>();
        interpretationExceptions = new LinkedList<InterpretationException>();
        for (PStmt stmt : stmts) {
            stmt.apply(createStmtInterpreter());
        }
    }

    public void setFieldWithoutReinterprete(String key, TypeModel<?> value) {
        variableMap.put(key, value);
    }

    public void setField(String key, TypeModel<?> value) {
        setFieldWithoutReinterprete(key, value);
        reInterpret();
    }

    public FormInterpreter() {
        variableMap = new HashMap<String, TypeModel<?>>();
    }
}
