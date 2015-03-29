package org.fugazi.ql.type_checker.issue.error;

public class NonBoolConditionError extends ASTErrorIssue {

    @Override
    public boolean equals(Object object) {
        if (object != null && object instanceof NonBoolConditionError) {
            return true;
        }
        return false;
    }
}
