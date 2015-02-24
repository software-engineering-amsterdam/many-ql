package org.fugazi.type_checker.visitor;

import org.fugazi.ast.IASTVisitor;
import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.expression.comparison.*;
import org.fugazi.ast.expression.literal.BOOL;
import org.fugazi.ast.expression.literal.ID;
import org.fugazi.ast.expression.literal.INT;
import org.fugazi.ast.expression.literal.STRING;
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
import org.fugazi.type_checker.dependency.DependencyList;
import org.fugazi.type_checker.error.ASTErrorHandler;
import org.fugazi.type_checker.error.ASTNodeError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TypeCheckerVisitor implements IASTVisitor<Void> {

    private final ASTErrorHandler astErrorHandler;

    // used to detect duplicate  labels
    private final List<String> questionLabels;
    // used to detect duplicate question types
    private final Map<String, Type> questionTypes;
    // used to detect circular dependencies
    private final DependencyList questionDependencies;
    private ID assignableIdLiteral;

    public TypeCheckerVisitor(){
        this.astErrorHandler = new ASTErrorHandler();
        this.questionLabels = new ArrayList<String>();
        this.questionTypes = new HashMap<String, Type>();
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
        String label = question.getLabel();

        // save and check if duplicate question with different type
        boolean isQuestionDuplicate =
            this.checkIfQuestionAlreadyDefinedWithDifferentType(
                    identifier, type
            );
        if (isQuestionDuplicate) {
            this.astErrorHandler.registerNewError(question,
                    "Question already defined with different type."
            );
        } else {
            this.saveQuestionType(identifier, type);
        }

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
        Type type = assignQuest.getType();
        Expression computed = assignQuest.getComputedExpression();

        // check if assigned types equal
        boolean typesEqual = this.checkIfTypesEqual(type, computed.getReturnedType());
        if (!typesEqual) {
            this.astErrorHandler.registerNewError(assignQuest,
                    "Attempted to assign type " + computed.getReturnedType()
                            + " to variable of type " + type.getClass() + "."
            );
        }


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
    private Void visitUnaryLogical(Unary unary) {
        Expression expr = unary.getExpr();

        boolean exprCorrect = this.checkIfExpressionIsBool(unary);

        if (!exprCorrect) {
            this.astErrorHandler.registerNewError( unary,
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
       This checks if both sides of the binary logical comparison are of required type bool.
    */
    private Void visitBinaryComparison(Comparison comparison) {
        Expression left = comparison.getLeft();
        Expression right = comparison.getRight();

        boolean leftCorrect = this.checkIfExpressionIsInt(left);
        boolean rightCorrect = this.checkIfExpressionIsInt(right);

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
    public Void visitEQ(EQ eq) {
        return this.visitBinaryComparison(eq);
    }

    @Override
    public Void visitGE(GE ge) {
        return this.visitBinaryComparison(ge);
    }

    @Override
    public Void visitGreater(Greater greater) {
        return this.visitBinaryComparison(greater);
    }

    @Override
    public Void visitLE(LE le) {
        return this.visitBinaryComparison(le);
    }

    @Override
    public Void visitLesser(Less less) {
        return this.visitBinaryComparison(less);
    }

    @Override
    public Void visitNotEq(NotEq notEq) {
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
    private Void visitBinaryNumerical(Numerical numerical) {
        Expression left = numerical.getLeft();
        Expression right = numerical.getRight();

        boolean leftCorrect = this.checkIfExpressionIsInt(left);
        boolean rightCorrect = this.checkIfExpressionIsInt(right);

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
    private Void visitUnaryNumerical(Unary unary) {
        // Both sides of the expressions need to be of type boolean.
        Expression expr = unary.getExpr();

        boolean exprCorrect = this.checkIfExpressionIsInt(unary);

        if (!exprCorrect) {
            this.astErrorHandler.registerNewError( unary,
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
            this.astErrorHandler.registerNewError( idLiteral,
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
            this.astErrorHandler.registerNewError( intLiteral,
                    "Int Literal not of type int."
            );
        }
        return null;
    }

    @Override
    public Void visitSTRING(STRING stringLiteral) {
        boolean exprCorrect = this.checkIfExpressionIsString(stringLiteral);

        if (!exprCorrect) {
            this.astErrorHandler.registerNewError( stringLiteral,
                    "String Literal not of type string."
            );
        }
        return null;
    }

    @Override
    public Void visitBOOL(BOOL boolLiteral) {
        boolean exprCorrect = this.checkIfExpressionIsBool(boolLiteral);

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

    /**
     * =======================
     * Checker functions
     * =======================
     */

    private boolean checkIfExpressionIsInt(Expression expression) {
        return expression.getReturnedType().equals(new IntType());
    }

    private boolean checkIfExpressionIsBool(Expression expression) {
        return expression.getReturnedType().equals(new BoolType());
    }

    private boolean checkIfExpressionIsString(Expression expression) {
        return expression.getReturnedType().equals(new StringType());
    }

    private boolean checkIfTypesEqual(Type type1, Type type2) {
        return type1.equals(type2);
    }

    private boolean checkIfDefined(ID idLiteral) {
        return (idLiteral.getType() != null);
    }

    private boolean checkIfLabelAlreadyExists(String label){
        return this.questionLabels.contains(label);
    }

    private boolean checkIfQuestionAlreadyDefinedWithDifferentType(
            ID questionId, Type questionType){
        Type earlierQuestionType = this.questionTypes.get(questionId.getName());
        if (earlierQuestionType != null) {
            return !this.checkIfTypesEqual(earlierQuestionType, questionType);
        }
        return false;
    }

    // a = b
    // a - depender
    // b - dependee
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

    private void saveQuestionLabel(String label) {
        this.questionLabels.add(label);
        return;
    }

    private void saveQuestionType(ID questionId, Type questionType) {
        this.questionTypes.put(questionId.getName(), questionType);
        return;
    }

    /* This method has to find all the nodes that depend on depender
    *   You have to add dependee and all depender's further dependers
        to detect cycles like this:
        1. a = b
        2. b = c
        3. c = d
        3. d = a
        after 2. c needs to be added to a list of ids that depend on, and therefore a.

        In other words, the update needs to propapagte through the whole graph
         (see transitive closure).
    */
    private void addDependency(ID depender, ID dependee) {
        // all the ids that are dependent on depender directly or indirectly
        // ids depending on them need to be updated too with the new dependee
        List<ID> idsToAddNewDependencyTo = new ArrayList<ID>();
        // temporary list used for traversing the graph.
        // pop first element, update all it's dependencies and add them
        // used to traverse the graph until all elements indirectly affected
        // by new dependence relation found
        List<ID> idsWithNewDependencies = new ArrayList<ID>();
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

        for (ID newDependant : idsToAddNewDependencyTo) {
            this.questionDependencies.addIdDependenant(newDependant, dependee);
        }
        return;
    }

    // a = b
    // a - depender
    // b - dependee
    private void addAndCheckDependency(ID depender, ID dependee) {
        boolean revertedDependencyExists = this.checkDependency(dependee, depender);
        if (revertedDependencyExists) {
            this.astErrorHandler.registerNewError( depender,
                    "Circular dependency between this node and " +
                            dependee.toString() + "."
            );
        }
        this.addDependency(depender, dependee);
        return;
    }

    private void clearErrorHandler() {
        this.astErrorHandler.clearErrorsAndWarnings();
    }

    /**
     * =======================
     * Exposed general form functions
     * =======================
     */

    public boolean isFormCorrect() {
        return !this.astErrorHandler.hasErrors();
    }

    public List<ASTNodeError> getErrors() {
        return this.astErrorHandler.getErrors();
    }

    public List<ASTNodeError> getWarnings() {
        return this.astErrorHandler.getWarnings();
    }
}