from .Table import *
from .EvaluatorTypes import *

from AST import AST
import ASTNodes
from CustomTypes import *
from TypeRules import OperatorTable


class Evaluator(object):
	def __init__(self, ast):
		self._questionTable = QuestionTable(ast)
		self._questionValueTable = QuestionValueTable(self._questionTable)
		self._operatorTable = OperatorTable()

	def evaluateBinaryExpression(self, operator, leftValue, rightValue):
		pythonOp = self._operatorTable.getBinaryOperator(operator, leftValue, rightValue)
		if pythonOp:
			return pythonOp(leftValue, rightValue)
		return None

	def evaluateUnaryExpression(self, operator, rightValue):
		pythonOp = self._operatorTable.getUnaryOperator(operator, rightValue)
		if pythonOp:
			return pythonOp(rightValue)
		return None

	def addValue(self, identifier, value):
		questions = self._questionTable.getQuestionList(identifier)

		for question in questions:
			self._questionValueTable.add(question, value)

	def getValue(self, identifier):
		question = self._questionTable.get(identifier, self)
		return self._questionValueTable.get(question, self)

	def getQuestion(self, identifier):
		return self._questionTable.get(identifier, self)	

	def getAllIdentifiers(self):
		return self._questionTable.keys()

# TODO rename to something else?
class PageStructure(object):
	def __init__(self, evaluator):
		self.evaluator = evaluator	
		self.pages = []

	def createDefaultPages(self):
		self.pages = [Page(self.evaluator.getAllIdentifiers())]

	def getVisibleQuestions(self, pageNumber):
		return self.pages[pageNumber].getQuestions(self.evaluator)

class Page(object):
	def __init__(self, questionIdentifiers):
		self.questionIdentifiers = questionIdentifiers

	def getQuestions(self, evaluator):
		questions = [evaluator.getQuestion(identifier) for identifier in self.questionIdentifiers]
		return [question for question in questions if question != None]	