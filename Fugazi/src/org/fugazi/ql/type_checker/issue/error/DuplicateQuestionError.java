package org.fugazi.ql.type_checker.issue.error;

public class DuplicateQuestionError extends ASTErrorIssue {

    @Override
    public boolean equals(Object object) {
        if (object != null && object instanceof DuplicateQuestionError) {
            return true;
        }
        return false;
    }
}
