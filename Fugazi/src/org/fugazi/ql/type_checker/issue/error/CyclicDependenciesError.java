package org.fugazi.ql.type_checker.issue.error;

public class CyclicDependenciesError extends ASTErrorIssue {

    @Override
    public boolean equals(Object object) {
        if (object != null && object instanceof CyclicDependenciesError) {
            return true;
        }
        return false;
    }
}
