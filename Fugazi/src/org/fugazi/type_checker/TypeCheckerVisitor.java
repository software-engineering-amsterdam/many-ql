package org.fugazi.type_checker;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TypeCheckerVisitor implements IASTVisitor {

    private final ASTErrorHandler astErrorHandler;

    // TODO optimize these structures

    // used to detect duplicate  labels
    private final List<String> questionLabels;

    // used to detect duplicate question types
    private final Map<String, Type> questions;

    // used to detect circular dependencies
    private final DependencyList questionDependencies;
    private ID assignableIdLiteral;

    public TypeCheckerVisitor(){
        this.astErrorHandler = new ASTErrorHandler();
        this.questionLabels = new ArrayList<String>();
        this.questions = new HashMap<String, Type>();
        this.questionDependencies = new DependencyList();
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

        ID identifier = assignQuest.getIdentifier();
        Expression computed = assignQuest.getComputedExpression();

        // TODO check if assigned types correct

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
//        boolean questionDefined = this.checkIfDefined(idLiteral);
//        if (!questionDefined) {
//            this.astErrorHandler.registerNewError( idLiteral,
//                    "Question not defined."
//            );
//        }

        // if we are inside a computed expression
        // a dependency needs to be added and marked
        if (this.assignableIdLiteral != null) {
            // assignableIdLiteral is dependent on
            // the current idListeral
            this.addAndCheckDependency(this.assignableIdLiteral, idLiteral);
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
        return expression.getSupportedTypes().contains(IntType.class);
    }

    private boolean checkIfBool(Expression expression) {
        return expression.getSupportedTypes().contains(BoolType.class);
    }

    private boolean checkIfString(Expression expression) {
        return expression.getSupportedTypes().contains(StringType.class);
    }

    private boolean checkIfSameType(Type type1, Type type2) {
        return (type1.getClass() == type2.getClass());
    }

    private boolean checkIfDefined(ID idLiteral) {
        return (idLiteral.getType() != null);
    }

    private boolean checkIfLabelAlreadyExists(String label){
        return this.questionLabels.contains(label);
    }

    private boolean checkIfQuestionAlreadyDefinedWithDifferentType(
            ID questionId, Type questionType){
        Type earlierQuestionType = this.questions.get(questionId.getName());
        if (earlierQuestionType != null) {
            return !this.checkIfSameType(earlierQuestionType, questionType);
        }
        return false;
    }

    private boolean checkIfLiteralsDependent(ID depender, ID dependee) {
        List<ID> dependenciesForDepender = this.questionDependencies.getIdDependencies(depender);

        System.out.println("Curent deps for depender " + depender.toString() + ": ");
        System.out.println(dependenciesForDepender);

        // current depender has no dependencies
        // or the dependee is not one of them
        if ((dependenciesForDepender == null) ||
                !dependenciesForDepender.contains(dependee)) {
            System.out.println("Returning false");
            return false;
        }
        System.out.println("Returning true");
        return true;
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
        this.questions.put(questionId.getName(), questionType);
        return;
    }

    private void updateDependency(ID depender, ID dependee) {
        // this method has to find all the nodes that depend on depender
        // and add dependee as a dependency for them too, not only for depender

        // you have to add dependee and all dependee's further dependees
        // to detect cycles like this:
        // 1. a = b
        // 2. b = c
        // 3. c = d
        // 3. d = a
        // after 2. c needs to be added to a list of ids that depend on, and therefore a

        /*

        1. A new dependeeX detected for dependantY.
        2. Add to list of dependants of dependantY.
        3. Look who depends on depenantY -> add to tempList newDependants.
        4. while newDependants not empty:
           4a. newDependant = newDependants.pop(0)
           4b. newDependantDependants // Look who depends on newDependandt
           for x in newDependantDependants
            4b1. if any newDependantDependants in alreadyVisited
               REGISTER CIRCULAR DEPENDENCY (x, newDependant)
                else
                add newDependantDependants to tempList newDependants.
           4c. (ListOfIdsToAdd dependeeX to).append(newDependant)
           4d.
            4d1. alreadyVisited.append(newDependant)

        5. For id in (ListOfIdsToAdd dependeeX to):
           5a. addDependendcy(id, dependeeX);
         */

        // all the ids that are dependent on dependee directly or indirectly
        // ids depending on them need to be updated too with the new dependee
        List<ID> idsToAddNewDependencyTo = new ArrayList<ID>();
        // temporary list used for traversing the graph.
        // pop first element, update all it's dependencies and add them
        List<ID> idsWithNewDependencies = new ArrayList<ID>();

        idsToAddNewDependencyTo.add(depender);

        // so that we avoid endless looping when circular dependencies exist
        List<ID> alreadyAnalyzed = new ArrayList<ID>();

        while (idsWithNewDependencies.size() > 0) {
            ID newDependee = idsWithNewDependencies.get(0);

            // check all elements that potentially depend on newDependee
            // dependee passed as parameter added to this function needs to be added to them too
            for (ID key : this.questionDependencies.getIds()) {
                List<ID> dependenciesForKey = this.questionDependencies.getIdDependencies(key);
                if (dependenciesForKey != null &&
                        dependenciesForKey.contains(newDependee)) {
                    if (alreadyAnalyzed.contains((key))) {
                        System.out.println();
                        System.out.println("CIRCULAR DEPENDENCY");
                        System.out.println(key + " " + newDependee);
                        System.out.println();
                    }
                    idsWithNewDependencies.add(key);
                }
            }


            // analyzed, need to be updated
            idsToAddNewDependencyTo.add(depender);
            // fully analyzed, add to already analyzed list (so that it's not analyzed anymore)
            alreadyAnalyzed.add(newDependee);
        }

        for (ID newDependant : idsToAddNewDependencyTo) {
            this.questionDependencies.addIdDependenant(newDependant, dependee);
        }

        System.out.println(this.questionDependencies);


//        System.out.println("Updated dependency " + depender.toString() + " " + dependenciesForDepender);
//        this.questionDependencies.put(depender.getName(), dependenciesForDepender);
//        System.out.println("Saved dependency " + depender.toString() + " " + this.questionDependencies.get(depender.getName()).toString());
        return;
    }

    // TODO better words for dependent dependee
    private void addAndCheckDependency(ID depender, ID dependee) {
        System.out.println("Adding and checking deps for " + depender.toString() + " " + dependee.toString());
        // check if there is a reverse dependency
        if (this.checkIfLiteralsDependent(dependee, depender)) {
            this.astErrorHandler.registerNewError( dependee,
                    "Circular dependency between this node and " +
                            this.assignableIdLiteral.toString() + "."
            );
        }

        // add dependency
        this.updateDependency(depender, dependee);
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
