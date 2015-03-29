package org.uva.student.calinwouter.qlqls.ql.model;

import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeDescriptor;

import java.util.LinkedList;
import java.util.List;

public class QLTypeCheckResults {
    private final List<String> errors, warnings;

    public List<String> getErrors() {
        return errors;
    }

    public List<String> getWarnings() {
        return warnings;
    }

    private void addError(String s) {
        this.errors.add(s);
    }

    public void addErrorTypeIsNotOfType(ITypeDescriptor typeDescriptor) {
        addError("Type is not of type: " + typeDescriptor + ".");
    }

    public void addUndefinedReferenceError(String undefinedReference) {
        addError("Undefined reference: " + undefinedReference + ".");
    }

    public void addCyclicDependencyError(String firstIdentifier, String secondIdentifier){
        addError("Cyclic dependency between: " + firstIdentifier + " and " + secondIdentifier + ".");
    }

    private void addWarning(final String s) {
        this.warnings.add(s);
    }

    public void addTwoQuestionsSameTypeError(final String variable) {
        addError("Two questions with the same identifier and a different type were found for variable: " + variable + ".");
    }

    public void addLabelFoundTwiceWarning(final String fieldLabel) {
        addWarning("Label " + fieldLabel + " found twice.");
    }

    private void appendAllErrorsStrings(StringBuilder results) {
        for (String error : errors) {
            results.append("\t\t");
            results.append(error);
            results.append("\n");
        }
    }

    private void appendAllWarningsStrings(StringBuilder results) {
        for (String warning : warnings) {
            results.append("\t\t");
            results.append(warning);
            results.append("\n");
        }
    }

    private void appendErrorsString(StringBuilder results) {
        if (errors.size() > 0) {
            results.append("\tErrors:\n");
            appendAllErrorsStrings(results);
        }
        results.append("\tNo errors.\n");
    }

    private void appendWarningsString(StringBuilder results) {
        if (warnings.size() > 0) {
            results.append("\n\tWarnings:\n");
            appendAllWarningsStrings(results);
            return;
        }
        results.append("\tNo warnings.\n");
    }

    public String toString() {
        final StringBuilder results = new StringBuilder("Type checker results:\n");
        appendErrorsString(results);
        appendWarningsString(results);
        return results.toString();
    }

    public boolean hasErrors() {
        return errors.size() != 0;
    }

    public QLTypeCheckResults() {
        this.errors = new LinkedList<String>();
        this.warnings = new LinkedList<String>();
    }

}
