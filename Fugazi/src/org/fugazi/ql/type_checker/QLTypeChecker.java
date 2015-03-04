package org.fugazi.ql.type_checker;

import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.form_data.QLFormDataStorage;
import org.fugazi.ql.type_checker.issue.ASTNodeIssue;
import org.fugazi.ql.type_checker.visitor.QLTypeCheckerVisitor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class QLTypeChecker {
    private final QLTypeCheckerVisitor visitor;

    public QLTypeChecker() {
        this.visitor = new QLTypeCheckerVisitor();
    }

    /**
     * =====================
     * Private check methods
     * =====================
     */

    private Set<String> findDuplicatesInList(List<String> listContainingDuplicates) {

        final Set<String> setToReturn = new HashSet<>();
        final Set<String> fullSet = new HashSet<>();

        for (String yourInt : listContainingDuplicates) {
            if (!fullSet.add(yourInt)) {
                setToReturn.add(yourInt);
            }
        }
        return setToReturn;
    }

//    private void checkForDuplicateLabels(QLFormDataStorage formData) {
//        List<String> questionLabels = formData.getQuestionLabels();
//    }

    /**
     * =====================
     * Exposed global methods
     * =====================
     */

    public boolean checkForm(Form form, QLFormDataStorage formData) {
        // perform all checks that require storage

        // perform all the checks that can be done on the fly
        form.accept(this.visitor);
        return this.visitor.isFormCorrect();
    }

    public boolean isFormCorrect() {
        return this.visitor.isFormCorrect();
    }

    public List<ASTNodeIssue> getErrors() {
        return this.visitor.getErrors();
    }

    public List<ASTNodeIssue> getWarnings() {
        return this.visitor.getWarnings();
    }
}
