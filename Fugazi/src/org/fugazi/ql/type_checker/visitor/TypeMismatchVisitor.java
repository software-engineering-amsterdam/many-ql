package org.fugazi.ql.type_checker.visitor;


import org.fugazi.ql.ast.expression.Expression;
import org.fugazi.ql.ast.expression.comparison.*;
import org.fugazi.ql.ast.expression.literal.BOOL;
import org.fugazi.ql.ast.expression.literal.INT;
import org.fugazi.ql.ast.expression.literal.STRING;
import org.fugazi.ql.ast.expression.logical.And;
import org.fugazi.ql.ast.expression.logical.Logical;
import org.fugazi.ql.ast.expression.logical.Or;
import org.fugazi.ql.ast.expression.numerical.*;
import org.fugazi.ql.ast.expression.unary.Negative;
import org.fugazi.ql.ast.expression.unary.Not;
import org.fugazi.ql.ast.expression.unary.Positive;
import org.fugazi.ql.ast.expression.unary.Unary;
import org.fugazi.ql.ast.form.form_data.QLFormDataStorage;
import org.fugazi.ql.ast.form.form_data.visitor.FullQLFormVisitor;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.ql.type_checker.issue.error.TypeMismatchError;

import java.util.List;

public class TypeMismatchVisitor extends FullQLFormVisitor {
    public TypeMismatchVisitor(QLFormDataStorage _formData) {
        super(_formData);
    }

    /**
     * =======================
     * Binary visitors
     * =======================
     */

    /*
       This checks if both sides of the binary logical expression are of required type bool.
    */
    private Void visitBinaryLogical(Logical logical) {
        Expression left = logical.getLeft();
        Expression right = logical.getRight();

        boolean leftCorrect = left.isExpressionOfTypeBool(this.formData);
        boolean rightCorrect = right.isExpressionOfTypeBool(this.formData);

        if (!leftCorrect) {
            this.astIssueHandler.registerNewError(
                    new TypeMismatchError(), logical,
                    "Left side of the binary logical expression not of type bool."
            );
        }
        if (!rightCorrect) {
            this.astIssueHandler.registerNewError(
                    new TypeMismatchError(), logical,
                    "Right side of the binary logical expression not of type bool."
            );
        }

        left.accept(this);
        right.accept(this);
        return null;
    }

    /*
       This checks if unary expression is of required type bool.
    */
    private Void visitUnaryLogical(Unary unary) {
        Expression expr = unary.getExpr();

        boolean exprCorrect = unary.isExpressionOfTypeBool(this.formData);

        if (!exprCorrect) {
            this.astIssueHandler.registerNewError(
                    new TypeMismatchError(), unary,
                    "Unary logical expression not of type bool."
            );
        }
        expr.accept(this);
        return null;
    }

    /*
       This checks if both sides of the logical comparison are of required type.
    */
    private Void visitBinaryComparison(Comparison comparison, List<Type> expectedTypes) {
        Expression left = comparison.getLeft();
        Expression right = comparison.getRight();

        // both sides need to be of same supported type
        // in order for the expression to be correct
        boolean differentTypes = false;
        boolean unsupportedTypes = false;

        if (!expectedTypes.contains(left.getReturnedType(this.formData))
                || !expectedTypes.contains(right.getReturnedType(this.formData))) {
            unsupportedTypes = true;
        }
        if (!left.getReturnedType(this.formData).equals(right.getReturnedType(this.formData))) {
            differentTypes = true;
        }

        if (unsupportedTypes) {
            this.astIssueHandler.registerNewError(
                    new TypeMismatchError(), comparison,
                    "Side(s) of the binary comparison not of supported type(s): "
                            + expectedTypes.toString() + ". " + "Instead received types: "
                            + left.getReturnedType(this.formData) + " and "
                            + right.getReturnedType(this.formData) + "."
            );
        } else if (differentTypes) {
            this.astIssueHandler.registerNewError(
                    new TypeMismatchError(), comparison,
                    "Two sides of the binary comparison expression of different types: "
                            + left.getReturnedType(this.formData) + " and "
                            + right.getReturnedType(this.formData) + "."
            );
        }

        left.accept(this);
        right.accept(this);
        return null;
    }

    @Override
    public Void visitAnd(And and) {
        return this.visitBinaryLogical(and);
    }

    @Override
    public Void visitOr(Or or) {
        return this.visitBinaryLogical(or);
    }

    @Override
    public Void visitNot(Not not) {
        return this.visitUnaryLogical(not);
    }

    @Override
    public Void visitEQ(EQ eq) {
        return this.visitBinaryComparison(eq, eq.getSupportedTypes());
    }

    @Override
    public Void visitGE(GE ge) {
        return this.visitBinaryComparison(ge, ge.getSupportedTypes());
    }

    @Override
    public Void visitGreater(Greater greater) {
        return this.visitBinaryComparison(greater, greater.getSupportedTypes());
    }

    @Override
    public Void visitLE(LE le) {
        return this.visitBinaryComparison(le, le.getSupportedTypes());
    }

    @Override
    public Void visitLesser(Less less) {
        return this.visitBinaryComparison(less, less.getSupportedTypes());
    }

    @Override
    public Void visitNotEq(NotEq notEq) {
        return this.visitBinaryComparison(notEq, notEq.getSupportedTypes());
    }

    /**
     * =======================
     * Numerical visitors
     * =======================
     */

    /*
       This checks if both sides of the binary numerical comparison are of required type int.
    */
    private Void visitBinaryNumerical(Numerical numerical) {
        Expression left = numerical.getLeft();
        Expression right = numerical.getRight();

        boolean leftCorrect = left.isExpressionOfTypeInt(this.formData);
        boolean rightCorrect = right.isExpressionOfTypeInt(this.formData);

        if (!leftCorrect) {
            this.astIssueHandler.registerNewError(
                    new TypeMismatchError(), numerical,
                    "Left side of the binary expression not of type int."
            );
        }
        if (!rightCorrect) {
            this.astIssueHandler.registerNewError(
                    new TypeMismatchError(), numerical,
                    "Right side of the binary expression not of type int."
            );
        }

        left.accept(this);
        right.accept(this);
        return null;

    }

    /*
       This checks if the unary numerical expression is of required type int.
    */
    private Void visitUnaryNumerical(Unary unary) {
        // Both sides of the expressions need to be of type boolean.
        Expression expr = unary.getExpr();

        boolean exprCorrect = unary.isExpressionOfTypeInt(this.formData);

        if (!exprCorrect) {
            this.astIssueHandler.registerNewError(
                    new TypeMismatchError(), unary,
                    "Unary numerical expression not of type int."
            );
        }
        expr.accept(this);
        return null;
    }

    @Override
    public Void visitNegative(Negative negative) {
        return this.visitUnaryNumerical(negative);
    }

    @Override
    public Void visitPositive(Positive positive) {
        return this.visitUnaryNumerical(positive);
    }

    @Override
    public Void visitAdd(Add add) {
        return this.visitBinaryNumerical(add);
    }

    @Override
    public Void visitSub(Sub sub) {
        return this.visitBinaryNumerical(sub);
    }

    @Override
    public Void visitMul(Mul mul) {
        return this.visitBinaryNumerical(mul);
    }

    @Override
    public Void visitDiv(Div div) {
        return this.visitBinaryNumerical(div);
    }



    /**
     * =======================
     * Literal visitors
     * =======================
     */

    @Override
    public Void visitINT(INT intLiteral) {

        boolean exprCorrect = intLiteral.isExpressionOfTypeInt(this.formData);

        if (!exprCorrect) {
            this.astIssueHandler.registerNewError(
                    new TypeMismatchError(), intLiteral,
                    "Int Literal not of type int."
            );
        }
        return null;
    }

    @Override
    public Void visitSTRING(STRING stringLiteral) {
        boolean exprCorrect = stringLiteral.isExpressionOfTypeString(this.formData);

        if (!exprCorrect) {
            this.astIssueHandler.registerNewError(
                    new TypeMismatchError(), stringLiteral,
                    "String Literal not of type string."
            );
        }
        return null;
    }

    @Override
    public Void visitBOOL(BOOL boolLiteral) {
        boolean exprCorrect = boolLiteral.isExpressionOfTypeBool(this.formData);

        if (!exprCorrect) {
            this.astIssueHandler.registerNewError(
                    new TypeMismatchError(), boolLiteral,
                    "Bool Literal not of type bool."
            );
        }
        return null;
    }

}