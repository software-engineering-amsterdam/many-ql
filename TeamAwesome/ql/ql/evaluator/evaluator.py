import types

from .Table import *
from .EvaluatorTypes import *

from ..ast import AST, Nodes
from ..ast.Visitor import ExpressionVisitor as ASTExpressionVisitor
from ..ast.Visitor import StatementVisitor as ASTStatementVisitor
from ..TypeRules import OperatorTable

def createEvaluator(ast):
    return Visitor().visit(ast.root)

class Evaluator(object):
    def __init__(self):
        self._questionTable = QuestionTable()
        self._questionValueTable = QuestionValueTable()
        self._operatorTable = OperatorTable()
        self._forms = []

    def evaluateBinaryExpression(self, operator, leftValue, rightValue):
        pythonOp = self._operatorTable.getBinaryOperator(operator, type(leftValue), type(rightValue))
        if pythonOp:
            return pythonOp(leftValue, rightValue)
        return None

    def evaluateUnaryExpression(self, operator, value):
        pythonOp = self._operatorTable.getUnaryOperator(operator, type(value))
        if pythonOp:
            return pythonOp(value)
        return None

    def addValue(self, identifier, value):
        question = self._questionTable.get(identifier)
        if question:
            self._questionValueTable.update(question, value)

    def getValue(self, identifier):
        question = self._questionTable.get(identifier)
        return self._questionValueTable.get(question)

    def addQuestion(self, question):
        self._questionTable.add(question)
        self._questionValueTable.add(question)

    def getQuestion(self, identifier):
        return self._questionTable.get(identifier)

    def getQuestionType(self, identifier):
        return self._questionTable.getType(identifier)

    def identifiers(self):
        return self._questionTable.identifiers()

    def questions(self):    
        questions = []
        for ident in self.identifiers():
            question = self.getQuestion(ident)
            if question:
                questions.append(question)
        return questions



class Visitor(ASTStatementVisitor):
    def __init__(self):
        self._evaluator = Evaluator()
        self._currentQuestions = []
        self._conditionalStatements = ExpressionsList()

    def visitQuestionnaire(self, node):
        return self._evaluator

    def visitFormStatement(self, node):
        form = Form(node.identifier, self._currentQuestions)
        self._currentQuestions = []
        return form

    def visitQuestionStatement(self, node):
        if node.expr:
            expressionVisitor = ExpressionVisitor(self._evaluator)
            expression = node.expr.accept(expressionVisitor)
        else:
            expression = None

        question = Question(node.identifier,
                            node.text,
                            node.type
                            self._conditionalStatements.copy(),
                            expression)

        self._evaluator.addQuestion(question)

        return question

    def _visitIfStatement(self, node):
        expressionVisitor = ExpressionVisitor(self._evaluator)
        expression = node.expr.accept(expressionVisitor)
        
        self._conditionalStatements.append(expression)
        self._conditionalStatements.pop()

    def _visitAtomicExpression(self, node):
        return AtomicExpression(self.visit(node.left))

    def _visitUnaryExpression(self, node):
        expr = self.visit(node.right)
        return UnaryExpression(node.op, expr, self._evaluator)

    def _visitBinaryExpression(self, node):
        leftExpr = self.visit(node.left)
        rightExpr = self.visit(node.right)
        return BinaryExpression(leftExpr, node.op, rightExpr, self._evaluator)

class ExpressionVisitor(ASTExpressionVisitor):
    def __init__(self, evaluator):
        self._evaluator = evaluator
        self._expressionStack = []

    def visitUnaryExpression(self, node):
        expr = self._expressionStack.pop()
        
        unaryExpression = UnaryExpression(node.op, expr, self._evaluator)
        self._expressionStack.append(unaryExpression)
        return unaryExpression

    def visitBinaryExpression(self, node):
        right = self._expressionStack.pop()
        left = self._expressionStack.pop()
        
        binaryExpression = BinaryExpression(left, op, right, self._evaluator)
        self._expressionStack.append(binaryExpression)
        return binaryExpression

    def visitBoolean(self, node):
        boolean = Boolean(node.value)
        self._expressionStack.append(boolean)
        return boolean

    def visitInteger(self, node):
        integer = Integer(node.value)
        self._expressionStack.append(integer)
        return integer

    def visitString(self, node):
        string = String(node.value)
        self._expressionStack.append(string)
        return string

    def visitMoney(self, node):
        money = Money(node.value)
        self._expressionStack.append(money)
        return money

    def visitIdentifier(self, node):
        identifier = Identifier(node.value, self._evaluator)
        self._expressionStack.append(identifier)
        return identifier