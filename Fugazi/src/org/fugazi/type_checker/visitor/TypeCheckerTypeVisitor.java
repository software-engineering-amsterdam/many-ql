package org.fugazi.type_checker.visitor;

import org.fugazi.ast.type.*;

public class TypeCheckerTypeVisitor implements ITypeVisitor<Void> {

    /**
     * ==============
     * Types
     * ==============
     */
    public Void visitBoolType(BoolType boolType){return null;}
    public Void visitIntType(IntType intType){return null;}
    public Void visitStringType(StringType moneyType){return null;}
    public Void visitUndefinedType(UndefinedType undefinedType){return null;}
}
