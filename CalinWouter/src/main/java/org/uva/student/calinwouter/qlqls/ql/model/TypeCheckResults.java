package org.uva.student.calinwouter.qlqls.ql.model;

import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeDescriptor;

import java.util.LinkedList;
import java.util.List;

public class TypeCheckResults {
    private final List<String> errors, warnings;

    private void addError(String s) {
        this.errors.add(s);
    }

    public void addErrorTypeIsNotOfType(TypeDescriptor typeDescriptor) {
        addError("Type is not of type: " + typeDescriptor + ".");
    }

    public void addUndefinedReferenceError(String undefinedReference) {
        addError("Undefined reference: " + undefinedReference);
    }

    private void addWarning(final String s) {
        this.warnings.add(s);
    }

    public TypeCheckResults() {
        this.errors = new LinkedList<String>();
        this.warnings = new LinkedList<String>();
    }

    public void addNotDeclaredError(final String identifier) {
        addError(identifier + " is not declared.");
    }

    public void addTwoQuestionsSameTypeError(final String variable) {
        addError("Two questions with the same identifier and a different type was found for variable: " + variable);
    }

    public String toString() {
        String results = "Type checker results:\n";
        if (errors.size() > 0) {
            results += "\tErrors:\n";
            for (String error : errors)
                results += "\t\t" + error + "\n";
        } else {
            results += "\tNo errors.\n";
        }
        if (warnings.size() > 0) {
            results += "\n" +
                    "\tWarnings:\n";
            for (String warning : warnings)
                results += "\t\t" + warning + "\n";
        } else {
            results += "\tNo warnings.\n";
        }
        return results;
    }

    public boolean hasErrors() {
        return errors.size() != 0;
    }

    public void addLabelFoundTwiceWarning(final String fieldLabel) {
        addWarning("Label " + fieldLabel + " found twice.");
    }
}
