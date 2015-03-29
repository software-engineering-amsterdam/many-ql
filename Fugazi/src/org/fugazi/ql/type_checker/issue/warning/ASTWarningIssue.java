package org.fugazi.ql.type_checker.issue.warning;

import org.fugazi.ql.type_checker.issue.ASTNodeIssueType;

public abstract class ASTWarningIssue implements ASTNodeIssueType {

    @Override
    public boolean equals(Object object) {
        if (object != null && object instanceof ASTWarningIssue) {
            return true;
        }
        return false;
    }
}
