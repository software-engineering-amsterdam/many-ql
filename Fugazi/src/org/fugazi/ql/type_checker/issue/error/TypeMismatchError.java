package org.fugazi.ql.type_checker.issue.error;

public class TypeMismatchError extends ASTErrorIssue {

    @Override
    public boolean equals(Object object) {
        if (object != null && object instanceof TypeMismatchError) {
            return true;
        }
        return false;
    }
}
