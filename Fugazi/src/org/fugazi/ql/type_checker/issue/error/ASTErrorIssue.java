package org.fugazi.ql.type_checker.issue.error;

import org.fugazi.ql.type_checker.issue.ASTNodeIssueType;

public abstract class ASTErrorIssue implements ASTNodeIssueType {

    @Override
    public boolean equals(Object object) {
        if (object != null && object instanceof ASTErrorIssue) {
            return true;
        }
        return false;
    }
}
