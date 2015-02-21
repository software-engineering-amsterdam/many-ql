package org.fugazi.type_checker;

import org.fugazi.ast.IASTVisitor;
import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.expression.comparison.*;
import org.fugazi.ast.expression.literal.*;
import org.fugazi.ast.expression.logical.And;
import org.fugazi.ast.expression.logical.Logical;
import org.fugazi.ast.expression.logical.Or;
import org.fugazi.ast.expression.numerical.*;
import org.fugazi.ast.expression.unary.Negative;
import org.fugazi.ast.expression.unary.Not;
import org.fugazi.ast.expression.unary.Positive;
import org.fugazi.ast.expression.unary.Unary;
import org.fugazi.ast.form.Form;
import org.fugazi.ast.statement.ComputedQuestion;
import org.fugazi.ast.statement.IfStatement;
import org.fugazi.ast.statement.Question;
import org.fugazi.ast.statement.Statement;
import org.fugazi.ast.type.*;

import java.util.*;

public class TypeCheckerVisitor implements IASTVisitor {

    private final ASTErrorHandler astErrorHandler;

    // used to detect duplicate  labels
    private final List<String> questionLabels;

    // used to detect circular dependencies
    private final Map<ID, List<ID>> questionDependencies;

    public TypeCheckerVisitor(){
        this.astErrorHandler = new ASTErrorHandler();
        this.questionLabels = new ArrayList<String>();
        this.questionDependencies = new HashMap<ID, List<ID>>();
    }

    /**
     * =======================
     * General visitors
     * =======================
     */

    @Override
    public Object visitForm(Form form) {
        List<Statement> statementList = form.getBody();

        for (Statement statement : statementList) {
            statement.accept(this);
        }
        return null;
    }


    @Override
    public Object visitQuestion(Question question) {

        Type type = question.getType();
        ID identifier = question.getIdentifier();
        String label = question.getLabel();

        // save and check for duplicate labels
        boolean isLabelDuplicate = this.checkIfLabelAlreadyExists(label);

        if (isLabelDuplicate) {
            this.astErrorHandler.registerNewWarning(question,
                    "Label defined multiple times! Possible confusion."
            );
        } else {
            this.saveQuestionLabel(label);
        }

        type.accept(this);
        identifier.accept(this);
        return null;
    }

    @Override
    public Object visitIfStatement(IfStatement ifStatement) {
        Expression expression = ifStatement.getCondition();
        List<Statement> statementList = ifStatement.getBody();

        expression.accept(this);
        for (Statement statement : statementList) {
            statement.accept(this);
        }
        return null;
    }

    @Override
    public Object visitComputedQuestion(ComputedQuestion assignQuest) {

        Type type = assignQuest.getType();
        ID identifier = assignQuest.getIdentifier();
        Expression computed = assignQuest.getComputedExpression();

        // check if no circular reference
        System.out.println();System.out.println();
        System.out.println(computed);System.out.println();System.out.println();

        type.accept(this);
        identifier.accept(this);
        computed.accept(this);
        return null;
    }

    /**
     * =======================
     * Binary visitors
     * =======================
     */

    /*
       This checks if both sides of the binary logical expression are of required type bool.
    */
    private Object visitBinaryLogical(Logical logical) {
        Expression left = logical.getLeft();
        Expression right = logical.getRight();

        boolean leftCorrect = this.checkIfBool(left);
        boolean rightCorrect = this.checkIfBool(right);

        if (!leftCorrect) {
            this.astErrorHandler.registerNewError( logical,
                    "Left side of the binary logical expression not of type bool."
            );
        }
        if (!rightCorrect) {
            this.astErrorHandler.registerNewError( logical,
                    "Right side of the binary logical expression not of type bool."
            );
        }

        left.accept(this);
        right.accept(this);
        return null;

    }

    /*
       This checks if the unary logical expression is of required type bool.
    */
    private Object visitUnaryLogical(Unary unary) {
        Expression expr = unary.getExpr();

        boolean exprCorrect = this.checkIfBool(unary);

        if (!exprCorrect) {
            this.astErrorHandler.registerNewError( unary,
                    "Unary logical expression not of type bool."
            );
        }
        expr.accept(this);
        return null;
    }

    @Override
    public Object visitAnd(And and) {
        return this.visitBinaryLogical(and);
    }

    @Override
    public Object visitOr(Or or) {
        return this.visitBinaryLogical(or);
    }

    @Override
    public Object visitNot(Not not) {
        return this.visitUnaryLogical(not);
    }

    /*
       This checks if both sides of the binary logical comparison are of required type bool.
    */
    private Object visitBinaryComparison(Comparison comparison) {
        Expression left = comparison.getLeft();
        Expression right = comparison.getRight();

        boolean leftCorrect = this.checkIfInt(left);
        boolean rightCorrect = this.checkIfInt(right);

        if (!leftCorrect) {
            this.astErrorHandler.registerNewError( comparison,
                    "Left side of the binary comparison expression not of type int."
            );
        }
        if (!rightCorrect) {
            this.astErrorHandler.registerNewError( comparison,
                    "Right side of the binary comparison expression not of type int."
            );
        }

        left.accept(this);
        right.accept(this);
        return null;
    }

    @Override
    public Object visitEQ(EQ eq) {
        return this.visitBinaryComparison(eq);
    }

    @Override
    public Object visitGE(GE ge) {
        return this.visitBinaryComparison(ge);
    }

    @Override
    public Object visitGreater(Greater greater) {
        return this.visitBinaryComparison(greater);
    }

    @Override
    public Object visitLE(LE le) {
        return this.visitBinaryComparison(le);
    }

    @Override
    public Object visitLesser(Less less) {
        return this.visitBinaryComparison(less);
    }

    @Override
    public Object visitNotEq(NotEq notEq) {
        return this.visitBinaryComparison(notEq);
    }

    /**
     * =======================
     * Numerical visitors
     * =======================
     */
    /*
       This checks if both sides of the binary numerical comparison are of required type int.
    */
    private Object visitBinaryNumerical(Numerical numerical) {
        Expression left = numerical.getLeft();
        Expression right = numerical.getRight();

        boolean leftCorrect = this.checkIfInt(left);
        boolean rightCorrect = this.checkIfInt(right);

        if (!leftCorrect) {
            this.astErrorHandler.registerNewError( numerical,
                    "Left side of the binary expression not of type int."
            );
        }
        if (!rightCorrect) {
            this.astErrorHandler.registerNewError( numerical,
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
    private Object visitUnaryNumerical(Unary unary) {
        // Both sides of the expressions need to be of type boolean.
        Expression expr = unary.getExpr();

        boolean exprCorrect = this.checkIfInt(unary);

        if (!exprCorrect) {
            this.astErrorHandler.registerNewError( unary,
                    "Unary numerical expression not of type int."
            );
        }
        expr.accept(this);
        return null;
    }

    @Override
    public Object visitNegative(Negative negative) {
        return this.visitUnaryNumerical(negative);
    }

    @Override
    public Object visitPositive(Positive positive) {
        return this.visitUnaryNumerical(positive);
    }

    @Override
    public Object visitAdd(Add add) {
        return this.visitBinaryNumerical(add);
    }

    @Override
    public Object visitSub(Sub sub) {
        return this.visitBinaryNumerical(sub);
    }

    @Override
    public Object visitMul(Mul mul) {
        return this.visitBinaryNumerical(mul);
    }

    @Override
    public Object visitDiv(Div div) {
        return this.visitBinaryNumerical(div);
    }

    /**
     * =======================
     * Literal visitors
     * =======================
     */

    @Override
    public Object visitID(ID idLiteral) {
        // check if variable defined
        // if it's type equals null => it is undefined
        boolean questionDefined = this.checkIfDefined(idLiteral);
        if (!questionDefined) {
            this.astErrorHandler.registerNewError( idLiteral,
                    "Question not defined."
            );
        }

        return null;
    }

    @Override
    public Object visitINT(INT intLiteral) {

        boolean exprCorrect = this.checkIfInt(intLiteral);

        if (!exprCorrect) {
            this.astErrorHandler.registerNewError( intLiteral,
                    "Int Literal not of type int."
            );
        }
        return null;
    }

    @Override
    public Object visitSTRING(STRING stringLiteral) {
        boolean exprCorrect = this.checkIfString(stringLiteral);

        if (!exprCorrect) {
            this.astErrorHandler.registerNewError( stringLiteral,
                    "String Literal not of type string."
            );
        }
        return null;
    }

    @Override
    public Object visitBOOL(BOOL boolLiteral) {
        boolean exprCorrect = this.checkIfBool(boolLiteral);

        if (!exprCorrect) {
            this.astErrorHandler.registerNewError( boolLiteral,
                    "Bool Literal not of type bool."
            );
        }
        return null;
    }

    /**
     * =======================
     * Type visitors
     * =======================
     */


    @Override
    public Void visitBoolType(BoolType boolType){return null;}
    @Override
    public Void visitIntType(IntType intType){return null;}
    @Override
    public Void visitStringType(StringType moneyType){return null;}
    @Override
    public Void visitUndefinedType(UndefinedType undefinedType){return null;}

    /**
     * =======================
     * Checker functions
     * =======================
     */

    private boolean checkIfInt(Expression expression) {
        return expression.getSupportedTypes().contains(new IntType().getClass());
    }

    private boolean checkIfBool(Expression expression) {
        return expression.getSupportedTypes().contains(new BoolType().getClass());
    }

    private boolean checkIfString(Expression expression) {
        return expression.getSupportedTypes().contains(new StringType().getClass());
    }

    private boolean checkIfDefined(ID idLiteral) {
        return (idLiteral.getType() != null);
    }

    private boolean checkIfLabelAlreadyExists(String label){
        return this.questionLabels.contains(label);
    }

    /**
     * =======================
     * Private data handling functions
     * =======================
     */

    private void saveQuestionLabel(String label) {
        this.questionLabels.add(label);
        return;
    }

    /**
     * =======================
     * Exposed general form functions
     * =======================
     */


    public boolean isFormCorrect() {
        return !this.astErrorHandler.hasErrors();
    }


    public void displayFormWarningsAndErrors() {
        this.astErrorHandler.displayWarningsAndErrors();
        return;
    }
}
