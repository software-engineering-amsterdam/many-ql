package org.fugazi.type_checker;

import org.fugazi.ast.type.ITypeVisitor;
import org.fugazi.ast.type.*;

public class TypeCheckerVisitor implements ITypeVisitor<Void> {

    /**
     * ==============
     * Types
     * ==============
     */
    public Void visitBoolType(BoolType boolType){return null;}
    public Void visitIntType(IntType intType){return null;}
    public Void visitMoneyType(MoneyType moneyType){return null;}
    public Void visitStringType(StringType moneyType){return null;}
    public Void visitUndefinedType(UndefinedType undefinedType){return null;}
}
