import types

from .Table import *
from .EvaluatorTypes import *

from ..ast import Nodes
from ..ast.Visitor import ExpressionVisitor as ASTExpressionVisitor
from ..ast.Visitor import StatementVisitor as ASTStatementVisitor

from ..core.TypeRules import OperatorTable


def createEvaluator(questionnaire):
    return questionnaire.accept(Visitor())


class Evaluator(object):
    def __init__(self):
        self._questionTable = QuestionTable()
        self._questionValueTable = QuestionValueTable()
        self._operatorTable = OperatorTable()
    
    def evaluateBinaryExpression(self, operator, leftValue, rightValue):
        pythonOp = self._operatorTable.getBinaryOperator(operator, type(leftValue), type(rightValue))
        if pythonOp:
            return pythonOp(leftValue, rightValue)
        return EvalNone()

    def evaluateUnaryExpression(self, operator, value):
        pythonOp = self._operatorTable.getUnaryOperator(operator, type(value))
        if pythonOp:
            return pythonOp(value)
        return EvalNone()

    def addValue(self, identifier, value):
        question = self._questionTable.get(identifier)
        if question:
            self._questionValueTable.update(question, value)

    def getValue(self, identifier):
        question = self._questionTable.get(identifier)
        value = self._questionValueTable.get(question)
        if value != None:
            return value
        return EvalNone()
        
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
        self._currentForm = None
        self._conditionalStatements = ExpressionsList()

    def visitQuestionnaireEnd(self, node):
        return self._evaluator

    def visitFormStatementBegin(self, node):
        self._currentForm = Form(node.identifier)

    def visitQuestionStatement(self, node):
        expression = node.expression
        if expression:
            expressionVisitor = ExpressionVisitor(self._evaluator)
            expression = node.expression.accept(expressionVisitor)
        
        identifier = EvalIdentifier(node.identifier.value.value, self._evaluator)

        question = Question(identifier,
                            node.text,
                            node.type,
                            self._conditionalStatements.copy(),
                            self._currentForm,
                            expression)
        
        self._evaluator.addQuestion(question)
        
        return question

    def visitIfStatementBegin(self, node):
        expressionVisitor = ExpressionVisitor(self._evaluator)
        expression = node.expression.accept(expressionVisitor)
        
        self._conditionalStatements.append(expression)
        
    def visitIfStatementEnd(self, node):
        return self._conditionalStatements.pop()


class ExpressionVisitor(ASTExpressionVisitor):
    def __init__(self, evaluator):
        self._evaluator = evaluator
        self._evaluableStack = []

    def visitUnaryExpressionEnd(self, node):
        evaluable = self._evaluableStack.pop()
        
        unaryExpression = UnaryExpression(node.operator, evaluable, self._evaluator)
        self._evaluableStack.append(unaryExpression)
        return unaryExpression

    def visitBinaryExpressionEnd(self, node):
        right = self._evaluableStack.pop()
        left = self._evaluableStack.pop()
        
        binaryExpression = BinaryExpression(left, node.operator, right, self._evaluator)
        self._evaluableStack.append(binaryExpression)
        return binaryExpression

    def _createAtom(self, node):
        atom = AtomicType(node.value)
        self._evaluableStack.append(atom)
        return atom

    def visitBoolean(self, node):
        return self._createAtom(node)

    def visitInteger(self, node):
        return self._createAtom(node)

    def visitString(self, node):
        return self._createAtom(node)

    def visitMoney(self, node):
        return self._createAtom(node)

    def visitIdentifier(self, node):
        identifier = EvalIdentifier(node.value.value, self._evaluator)
        self._evaluableStack.append(identifier)
        return identifier
