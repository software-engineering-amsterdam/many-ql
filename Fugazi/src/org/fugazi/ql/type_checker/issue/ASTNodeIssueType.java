package org.fugazi.ql.type_checker.issue;


public interface ASTNodeIssueType {
    enum WARNING implements ASTNodeIssueType {
        DUPLICATE_LABEL
    }
    enum ERROR implements ASTNodeIssueType {
        CYCLIC, UNDEFINED, DUPLICATE, TYPE_MISMATCH, NON_BOOL_CONDITION
    }
}