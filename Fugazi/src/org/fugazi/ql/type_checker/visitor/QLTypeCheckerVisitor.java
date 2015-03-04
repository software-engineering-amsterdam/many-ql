package org.fugazi.ql.type_checker.visitor;

import org.fugazi.ql.ast.IASTVisitor;
import org.fugazi.ql.ast.expression.Expression;
import org.fugazi.ql.ast.expression.comparison.*;
import org.fugazi.ql.ast.expression.literal.BOOL;
import org.fugazi.ql.ast.expression.literal.ID;
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
import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.ast.statement.ComputedQuestion;
import org.fugazi.ql.ast.statement.IfStatement;
import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.ast.statement.Statement;
import org.fugazi.ql.ast.type.BoolType;
import org.fugazi.ql.ast.type.IntType;
import org.fugazi.ql.ast.type.StringType;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.ql.type_checker.dependency.DependencyList;
import org.fugazi.ql.type_checker.issue.ASTIssueHandler;
import org.fugazi.ql.type_checker.issue.ASTNodeIssue;
import org.fugazi.ql.type_checker.issue.ASTNodeIssueType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QLTypeCheckerVisitor implements IASTVisitor<Void> {

    private final ASTIssueHandler astIssueHandler;

    // used to detect circular dependencies
    private final DependencyList questionDependencies;
    private ID assignableIdLiteral;

    public QLTypeCheckerVisitor(){
        this.astIssueHandler = new ASTIssueHandler();
        this.questionDependencies = new DependencyList();
    }

    /**
     * =======================
     * General visitors
     * =======================
     */

    @Override
    public Void visitForm(Form form) {
        // clean errors (if any from previous visit)
        this.clearErrorHandler();

        List<Statement> statementList = form.getBody();

        for (Statement statement : statementList) {
            statement.accept(this);
        }
        return null;
    }

    @Override
    public Void visitQuestion(Question question) {

        Type type = question.getType();
        ID identifier = question.getIdentifier();

        type.accept(this);
        identifier.accept(this);
        return null;
    }

    @Override
    public Void visitIfStatement(IfStatement ifStatement) {
        Expression expression = ifStatement.getCondition();
        List<Statement> statementList = ifStatement.getBody();

        expression.accept(this);
        for (Statement statement : statementList) {
            statement.accept(this);
        }
        return null;
    }

    @Override
    public Void visitComputedQuestion(ComputedQuestion assignQuest) {

        ID identifier = assignQuest.getIdentifier();
        Expression computed = assignQuest.getComputedExpression();

        // check if no circular reference
        // is performed while visiting idLiterals
        // from the computed expression

        // first - mark which identifier is dependent on
        // each of the identifiers that will appear while
        // visiting the computed expression
        this.assignableIdLiteral = identifier;

        // this is the only part of visitedQuestion
        // that needs further visiting
        computed.accept(this);

        // analyzing dependencies finished for
        // identifier from this computed question
        this.assignableIdLiteral = null;
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
    private Void visitBinaryLogical(Logical logical) {
        Expression left = logical.getLeft();
        Expression right = logical.getRight();

        boolean leftCorrect = this.checkIfExpressionIsBool(left);
        boolean rightCorrect = this.checkIfExpressionIsBool(right);

        if (!leftCorrect) {
            this.astIssueHandler.registerNewError(
                    ASTNodeIssueType.ERROR.TYPE_MISMATCH, logical,
                    "Left side of the binary logical expression not of type bool."
            );
        }
        if (!rightCorrect) {
            this.astIssueHandler.registerNewError(
                    ASTNodeIssueType.ERROR.TYPE_MISMATCH, logical,
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
    private Void visitUnaryLogical(Unary unary) {
        Expression expr = unary.getExpr();

        boolean exprCorrect = this.checkIfExpressionIsBool(unary);

        if (!exprCorrect) {
            this.astIssueHandler.registerNewError(
                    ASTNodeIssueType.ERROR.TYPE_MISMATCH, unary,
                    "Unary logical expression not of type bool."
            );
        }
        expr.accept(this);
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

        if (!expectedTypes.contains(left.getReturnedType())
                || !expectedTypes.contains(right.getReturnedType())) {
            unsupportedTypes = true;
        }
        if (!left.getReturnedType().equals(right.getReturnedType())) {
            differentTypes = true;
        }

        if (unsupportedTypes) {
            this.astIssueHandler.registerNewError(
                    ASTNodeIssueType.ERROR.TYPE_MISMATCH, comparison,
                    "Side(s) of the binary comparison not of supported type(s): "
                            + expectedTypes.toString() + ". " + "Instead received types: "
                            + left.getReturnedType() + " and " + right.getReturnedType() + "."
            );
        } else if (differentTypes) {
            this.astIssueHandler.registerNewError(
                    ASTNodeIssueType.ERROR.TYPE_MISMATCH, comparison,
                    "Two sides of the binary comparison expression of different types: "
                            + left.getReturnedType() + " and " + right.getReturnedType() + "."
            );
        }

        left.accept(this);
        right.accept(this);
        return null;
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

        boolean leftCorrect = this.checkIfExpressionIsInt(left);
        boolean rightCorrect = this.checkIfExpressionIsInt(right);

        if (!leftCorrect) {
            this.astIssueHandler.registerNewError(
                    ASTNodeIssueType.ERROR.TYPE_MISMATCH, numerical,
                    "Left side of the binary expression not of type int."
            );
        }
        if (!rightCorrect) {
            this.astIssueHandler.registerNewError(
                    ASTNodeIssueType.ERROR.TYPE_MISMATCH, numerical,
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

        boolean exprCorrect = this.checkIfExpressionIsInt(unary);

        if (!exprCorrect) {
            this.astIssueHandler.registerNewError(
                    ASTNodeIssueType.ERROR.TYPE_MISMATCH, unary,
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
    public Void visitID(ID idLiteral) {
        // check if variable defined
        // if it's type equals null => it is undefined
        boolean questionDefined = this.checkIfDefined(idLiteral);
        if (!questionDefined) {
            this.astIssueHandler.registerNewError(
                    ASTNodeIssueType.ERROR.UNDEFINED, idLiteral,
                    "Question not defined."
            );
        }

        // if we are inside a computed expression
        // a dependency needs to be added and marked
        if (this.assignableIdLiteral != null) {
            // assignableIdLiteral is dependent on
            // the current idLiteral
            this.addAndCheckDependency(this.assignableIdLiteral, idLiteral);
        }

        return null;
    }

    @Override
    public Void visitINT(INT intLiteral) {

        boolean exprCorrect = this.checkIfExpressionIsInt(intLiteral);

        if (!exprCorrect) {
            this.astIssueHandler.registerNewError(
                    ASTNodeIssueType.ERROR.TYPE_MISMATCH, intLiteral,
                    "Int Literal not of type int."
            );
        }
        return null;
    }

    @Override
    public Void visitSTRING(STRING stringLiteral) {
        boolean exprCorrect = this.checkIfExpressionIsString(stringLiteral);

        if (!exprCorrect) {
            this.astIssueHandler.registerNewError(
                    ASTNodeIssueType.ERROR.TYPE_MISMATCH, stringLiteral,
                    "String Literal not of type string."
            );
        }
        return null;
    }

    @Override
    public Void visitBOOL(BOOL boolLiteral) {
        boolean exprCorrect = this.checkIfExpressionIsBool(boolLiteral);

        if (!exprCorrect) {
            this.astIssueHandler.registerNewError(
                    ASTNodeIssueType.ERROR.TYPE_MISMATCH, boolLiteral,
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

    /**
     * =======================
     * Checker functions
     * =======================
     */

    private boolean checkIfExpressionIsOfType(Expression expression, Type type) {
        return this.checkIfTypesEqual(expression.getReturnedType(), type);
    }

    private boolean checkIfExpressionIsInt(Expression expression) {
        return this.checkIfExpressionIsOfType(expression, new IntType());
    }

    private boolean checkIfExpressionIsBool(Expression expression) {
        return this.checkIfExpressionIsOfType(expression, new BoolType());
    }

    private boolean checkIfExpressionIsString(Expression expression) {
        return this.checkIfExpressionIsOfType(expression, new StringType());
    }

    private boolean checkIfTypesEqual(Type type1, Type type2) {
        return type1.equals(type2);
    }

    private boolean checkIfDefined(ID idLiteral) {
        return (idLiteral.getType() != null);
    }

    // a = b, a - depender, b - dependee
    private boolean checkDependency(ID depender, ID dependee) {
        List<String> dependenciesForDepender =
                this.questionDependencies.getIdDependencyNames(depender);

        if ((dependenciesForDepender != null)
                && dependenciesForDepender.contains(dependee.getName())) {
            return true;
        }
        return false;
    }

    /**
     * =======================
     * Private data handling functions
     * =======================
     */

    private void updateDependencyGraph(ID depender, ID dependee) {

        // get all indirectly affected nodes (that depend on the depender)
        List<ID> idsToAddNewDependencyTo = this.getAllIdsWithNewIndirectDependency(depender);

        // for a new depender add also all dependencies of dependee (propagate backwards)
        for (ID newDependant : idsToAddNewDependencyTo) {
            this.addSingleDependencyForId(newDependant, dependee);
        }

        // for a new depender add also all dependencies of dependee (propagate forward)
        this.addDependenciesForId(depender, this.questionDependencies.getIdDependencies(dependee));
    }

    // TODO get this be simplified?
    private List<ID> getAllIdsWithNewIndirectDependency(ID depender) {
        // all the ids that are dependent on depender directly or indirectly
        // ids depending on them need to be updated too with the new dependee
        List<ID> idsToAddNewDependencyTo = new ArrayList<>();
        // temporary list used for traversing the graph.
        // pop first element, update all it's dependencies and add them
        // used to traverse the graph until all elements indirectly affected
        // by new dependence relation found
        List<ID> idsWithNewDependencies = new ArrayList<>();
        idsWithNewDependencies.add(depender);

        while (idsWithNewDependencies.size() > 0) {
            ID indirectDependee = idsWithNewDependencies.remove(0);

            // check all elements that depend on newDependee and therefore indirectly on passed dependee
            for (ID key : this.questionDependencies.getIds()) {
                List<String> dependenciesForKey = this.questionDependencies.getIdDependencyNames(key);

                if ((dependenciesForKey != null)
                        && dependenciesForKey.contains(indirectDependee.getName())) {
                    idsToAddNewDependencyTo.add(key);
                }
            }
            idsToAddNewDependencyTo.add(depender);
        }

        return idsToAddNewDependencyTo;
    }

    private void addDependenciesForId(ID depender, List<ID> newDepenees) {
        if (newDepenees != null) {
            for (ID newDependee : newDepenees) {
                this.addSingleDependencyForId(depender, newDependee);
            }
        }
        return;
    }

    private void addSingleDependencyForId(ID depender, ID dependee) {
        this.questionDependencies.addIdDependenant(depender, dependee);
        return;
    }

    // a = b, a - depender, b - dependee
    private void addAndCheckDependency(ID depender, ID dependee) {
        boolean revertedDependencyExists = this.checkDependency(dependee, depender);
        if (revertedDependencyExists) {
            this.astIssueHandler.registerNewError(
                    ASTNodeIssueType.ERROR.CYCLIC, depender,
                    "Circular dependency between this node and " +
                            dependee.toString() + "."
            );
        }
        this.updateDependencyGraph(depender, dependee);
    }

    private void clearErrorHandler() {
        this.astIssueHandler.clearErrorsAndWarnings();
    }

    /**
     * =======================
     * Exposed general form functions
     * =======================
     */

    public boolean isFormCorrect() {
        return !this.astIssueHandler.hasErrors();
    }

    public List<ASTNodeIssue> getErrors() {
        return this.astIssueHandler.getErrors();
    }

    public List<ASTNodeIssue> getWarnings() {
        return this.astIssueHandler.getWarnings();
    }
}
