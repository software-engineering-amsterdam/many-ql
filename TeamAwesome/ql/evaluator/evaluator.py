import types

from .Table import *
from .EvaluatorTypes import *

from ..ast import AST, Nodes
from ..ast.Visitor import Visitor as ASTVisitor
from ..TypeRules import OperatorTable

def createEvaluator(ast):
	return Visitor().visit(ast.root)

class Evaluator(object):
	def __init__(self):
		self._questionTable = QuestionTable()
		self._questionValueTable = QuestionValueTable()
		self._operatorTable = OperatorTable()

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
		questions = self._questionTable.getQuestionList(identifier)

		for question in questions:
			self._questionValueTable.update(question, value)

	def getValue(self, identifier):
		question = self._questionTable.get(identifier)
		return self._questionValueTable.get(question)

	def addQuestion(self, question):
		self._questionTable.add(question)
		self._questionValueTable.add(question)

	def getQuestion(self, identifier):
		return self._questionTable.get(identifier)

	def identifiers(self):
		return self._questionTable.identifiers()


class Visitor(ASTVisitor):
    def __init__(self):
        self._evaluator = Evaluator()
        self._currentForm = None
        self._conditionalStatements = ExpressionsList()

    def _visitRoot(self, node):
        super()._visitRoot(node)
        return self._evaluator

    def _visitFormStatement(self, node):
        self._currentForm = Form(node)
        for n in node.getChildren():
            child = self.visit(n)

    def _visitQuestionStatement(self, node):
    	expr = self.visit(node.expr) if node.expr else None
    	question = Question(node, self._conditionalStatements.copy(), self._currentForm, valueExpression = expr)
    	self._evaluator.addQuestion(question)

    def _visitIfStatement(self, node):
        expr = self.visit(node.expr)
        self._conditionalStatements.append(expr)
        for n in node.getChildren():
            self.visit(n)
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

    def _visitIdentifier(self, node):
       	return Identifier(node, self._evaluator)

    def _visitStr(self, node):
        return String(node)

    def _visitMoney(self, node):
        return Money(node)

    def _visitInt(self, node):
        return Integer(node)

    def _visitBool(self, node):
        return Boolean(node)

# TODO rename to something else?
class PageStructure(object):
	def __init__(self, evaluator):
		self.evaluator = evaluator	
		self.pages = []

	def createDefaultPages(self):
		self.pages = [Page(self.evaluator.identifiers())]

	def getVisibleQuestions(self, pageNumber):
		return self.pages[pageNumber].getQuestions(self.evaluator)

class Page(object):
	def __init__(self, questionIdentifiers):
		self.questionIdentifiers = questionIdentifiers

	def getQuestions(self, evaluator):
		questions = [evaluator.getQuestion(identifier) for identifier in self.questionIdentifiers]
		return [question for question in questions if question != None]	