package org.fugazi.type_checker.error;


public interface ASTNodeErrorType {
    enum WARNING implements ASTNodeErrorType {
        DUPLICATE_LABEL
    }
    enum ERROR implements  ASTNodeErrorType {
        CYCLIC, UNDEFINED, DUPLICATE, TYPE_MISMATCH, NON_BOOL_CONDITION
    }
}
