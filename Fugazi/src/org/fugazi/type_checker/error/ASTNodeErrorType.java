package org.fugazi.type_checker.error;


public interface ASTNodeErrorType {
    enum WARNING implements ASTNodeErrorType {
        WARNING
    }
    enum ERROR implements  ASTNodeErrorType {
        CYCLIC, UNDEFINED, DUPLICATE, TYPE_MISMATCH, NON_BOOL_CONDITION
    }
}
