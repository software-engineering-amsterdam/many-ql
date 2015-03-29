package org.fugazi.ql.type_checker.issue.error;

public class UndefinedQuestionError extends ASTErrorIssue {

    @Override
    public boolean equals(Object object) {
        if (object != null && object instanceof UndefinedQuestionError) {
            return true;
        }
        return false;
    }
}
