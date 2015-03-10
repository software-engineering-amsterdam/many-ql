package org.uva.student.calinwouter.qlqls.ql.interpreter.impl.typechecker;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.AForm;
import org.uva.student.calinwouter.qlqls.generated.node.PStmt;
import org.uva.student.calinwouter.qlqls.ql.exceptions.FieldInUseException;
import org.uva.student.calinwouter.qlqls.ql.exceptions.InterpretationException;
import org.uva.student.calinwouter.qlqls.ql.exceptions.LabelInUseException;
import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeDescriptor;

import java.util.*;

/**
 * This FormTypeChecker detects:
 * <p/>
 * - Reference to undefined questions
 * - Duplicate question declarations (NOT with different types)
 * - Conditions that are not of the type boolean
 * - Operands of invalid type to operators
 * - Duplicate labels (warning)
 * <p/>
 * Does not detect cyclic dependencies between questions, because it is not possible to create cyclic dependencies.
 */
//public class FormTypeChecker extends FormInterpreter {
public class FormTypeChecker extends AnalysisAdapter {

    private InterpretationException fatalException;
    private HashMap<String, TypeDescriptor<?>> typeDescriptorMap;
    protected List<InterpretationException> interpretationExceptions;
    private List<InterpretationException> warnings;
    private Set<String> usedFields;
    private Set<String> usedLabels;

    public List<InterpretationException> getWarnings() {
        return warnings;
    }

    public Set<Map.Entry<String, TypeDescriptor<?>>> getFields() {
        return typeDescriptorMap.entrySet();
    }

    public SortedSet<String> getFieldNames() { // TODO Does not sort!!!!
        SortedSet<String> nameSet = new TreeSet<String>();
        for (Map.Entry<String, TypeDescriptor<?>> entry : typeDescriptorMap.entrySet()) {
            nameSet.add(entry.getKey());
        }
        return nameSet;
    }

    //@Override
    //protected StmtInterpreter createStmtInterpreter() {
    protected StmtTypeChecker createStmtInterpreter() {
        return new StmtTypeChecker(this);
    }

    public InterpretationException getFatalException() {
        return fatalException;
    }

    public void setTypeDescriptor(String field, TypeDescriptor<?> typeDescriptor) {
        typeDescriptorMap.put(field, typeDescriptor);
    }

    public TypeDescriptor<?> getTypeDescriptor(String field) {
        return typeDescriptorMap.get(field);
    }

    @Override
    public void caseAForm(AForm node) {
        try {
            typeDescriptorMap = new HashMap<String, TypeDescriptor<?>>();
            //super.caseAForm(node);
            LinkedList<PStmt> stmts = node.getStmt();
            for (PStmt stmt : stmts) {
                stmt.apply(createStmtInterpreter());
            }
        } catch (InterpretationException e) {
            fatalException = e;
        }
    }

    public void notifyTypeChecker(InterpretationException exception) {
        interpretationExceptions.add(exception);
    }

    public void registerLabelUse(String label) {
        if (!usedLabels.add(label)) {
            warnings.add(new LabelInUseException(label));
        }
    }

    public void registerFieldUse(String key) {
        if (!usedFields.add(key)) {
            throw new FieldInUseException(key);
        }
    }

    public FormTypeChecker() {
        warnings = new LinkedList<InterpretationException>();
        interpretationExceptions = new LinkedList<InterpretationException>();
        usedFields = new HashSet<String>();
        usedLabels = new HashSet<String>();
    }
}