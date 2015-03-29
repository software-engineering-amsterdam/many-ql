package org.fugazi.ql.type_checker.issue.warning;

public class DuplicateLabelWarning extends ASTWarningIssue {
    
    @Override
    public boolean equals(Object object) {
        if (object != null && object instanceof DuplicateLabelWarning) {
            return true;
        }
        return false;
    }
}
