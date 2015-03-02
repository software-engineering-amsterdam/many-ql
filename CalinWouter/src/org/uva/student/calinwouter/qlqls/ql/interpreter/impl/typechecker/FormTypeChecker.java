package org.uva.student.calinwouter.qlqls.ql.interpreter.impl.typechecker;

import org.uva.student.calinwouter.qlqls.generated.node.AForm;
import org.uva.student.calinwouter.qlqls.ql.interpreter.FormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interpreter.StmtInterpreter;
import org.uva.student.calinwouter.qlqls.ql.exceptions.InterpretationException;
import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeDescriptor;

import java.util.HashMap;
import java.util.List;

/**
 * This FormTypeChecker detects:
 *
 * - Reference to undefined questions
 * - Duplicate question declarations (NOT with different types)
 * - Conditions that are not of the type boolean
 * - Operands of invalid type to operators
 * - Duplicate labels (warning)
 *
 * Does not detect cyclic dependencies between questions, because it is not possible to create cyclic dependencies.
 */
public class FormTypeChecker extends FormInterpreter {
    private InterpretationException fatalException;
    private HashMap<String, TypeDescriptor<?>> typeDescriptorMap;

    @Override
    protected StmtInterpreter createStmtInterpreter() {
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
            super.caseAForm(node);
        } catch(InterpretationException e) {
            fatalException = e;
        }
    }
}
