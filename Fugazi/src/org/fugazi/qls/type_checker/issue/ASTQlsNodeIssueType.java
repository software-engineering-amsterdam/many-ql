package org.fugazi.qls.type_checker.issue;

import org.fugazi.ql.type_checker.issue.ASTNodeIssueType;

public interface ASTQlsNodeIssueType extends ASTNodeIssueType {
    enum QLS_ERROR implements ASTNodeIssueType {
        UNDEFINED, MISSING_STYLE, DUPLICATE, WRONG_WIDGET_TYPE
    }
}
