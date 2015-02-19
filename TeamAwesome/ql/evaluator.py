from AST import AST
import ASTNodes
from collections import OrderedDict
from CustomTypes import *
import OperatorTypes

# TODO make pretty
class QuestionValueTable(object):
	def __init__(self):
		self._table = OrderedDict()

	def add(self, key, val):
		self._table[key] = val

	def get(self, key, evaluator):
		val = self._table[key]

		if isinstance(val, Expression):
			return val.evaluate(evaluator)
		return val


class QuestionTable(OrderedDict):
	def __init__(self, ast):
		super().__init__(self)

		for formStatement in ast.root.statements:
			form = Form(formStatement)

			for statement in formStatement.getChildren():
				self._addStatement(statement, ExpressionsTuple(), form)

	def _addStatement(self, statement, expressionsTuple, form):
		assert isinstance(statement, ASTNodes.IfStatement) or isinstance(statement, ASTNodes.QuestionStatement)

		if isinstance(statement, ASTNodes.IfStatement):
			childExpressionsTuple = expressionsTuple + (ExpressionFactory.create((statement.expr)),)
			
			for childStatement in statement.getChildren():
				self._addStatement(childStatement, childExpressionsTuple, form)
		else:
			question = Question(statement, expressionsTuple, form)
			questionList = self.get(question.identifier, QuestionList())
			questionList.append(question)
			self[question.identifier] = questionList

class ExpressionsTuple(tuple):
	def __add__(self, value):
		return ExpressionsTuple(tuple.__add__(self, value))

	def evaluate(self, evaluator):
		return all(expr.evaluate(evaluator) for expr in self)

class QuestionList(list):
	def getVisibleQuestion(self, evaluator):
		for question in self:
			if question.isVisible(evaluator):
				return question
		return None

class Form(object):
	def __init__(self, formStatementNode):
		assert isinstance(formStatementNode, ASTNodes.FormStatement)

		self.identifier = formStatementNode.identifier

class ExpressionFactory(object):
	@staticmethod
	def create(expressionNode):
		assert isinstance(expressionNode, ASTNodes.Expression)
		
		method = ExpressionFactory._getCreateMethod(expressionNode)
		return method(expressionNode)
		
	@staticmethod
	def _getCreateMethod(expressionNode):
		methodName = '_create' + expressionNode.__class__.__name__
		return getattr(ExpressionFactory, methodName)

	@staticmethod
	def _createBinaryExpression(binaryExpressionNode):
		return BinaryExpression(binaryExpressionNode)

	@staticmethod
	def _createUnaryExpression(unaryExpressionNode):
		return UnaryExpression(unaryExpressionNode)

	@staticmethod
	def _createAtomicExpression(atomicExpressionNode):
		return AtomicExpression(atomicExpressionNode)

class Expression(object):
	pass

class BinaryExpression(Expression):
	def __init__(self, binaryExpressionNode):
		self.left = ExpressionFactory.create(binaryExpressionNode.left)
		self.op = binaryExpressionNode.op
		self.right = ExpressionFactory.create(binaryExpressionNode.right)

	def evaluate(self, evaluator):
		leftValue = self.left.evaluate(evaluator)
		rightValue = self.right.evaluate(evaluator)
		pythonOp = evaluator.typeTable.getBinaryOperator(self.op, leftValue, rightValue)

		return pythonOp(leftValue, rightValue)

class UnaryExpression(Expression):
	def __init__(self, unaryExpressionNode):
		self.op = unaryExpressionNode.op
		self.right = ExpressionFactory.create(unaryExpressionNode.right)

	def evaluate(self, evaluator):
		rightValue = self.right.evaluate(evaluator)
		pythonOp = evaluator.typeTable.getUnaryPythonOperator(self.op)
		return pythonOp(right)

class AtomicExpression(Expression):
	def __init__(self, atomicExpressionNode):
		self.left = atomicExpressionNode.left

	def evaluate(self, evaluator):
		if isinstance(self.left, Identifier):
			return evaluator.questionValueTable.get(self.left, evaluator)
		return self.left

class Question(object):
	def __init__(self, questionStatementNode, conditionalExpressionsTuple, form):
		assert isinstance(questionStatementNode, ASTNodes.QuestionStatement)
	
		self.identifier = questionStatementNode.identifier	
		self.valueExpression = ExpressionFactory.create(questionStatementNode.expr)
		self.text = questionStatementNode.text
		self.type = questionStatementNode.type

		self.conditionalExpressions = conditionalExpressionsTuple
		self.form = form

	def isVisible(self, evaluator):
		return self.conditionalExpressions.evaluate(evaluator)

class Page(object):
	def __init__(self, questionTable, questionIdentifiers):
		self.questionLists = []
		for identifier in questionIdentifiers:
			self.questionLists.append(questionTable[identifier])

	def getVisibleQuestions(self, evaluator):
		visibleQuestions = []
		
		for questionList in self.questionLists:
			visibleQuestion = questionList.getVisibleQuestion(evaluator)
			if visibleQuestion:
				visibleQuestions.append(visibleQuestion)

		return visibleQuestions

class Evaluator(object):
	def __init__(self, ast):
		self.questionTable = QuestionTable(ast)
		self.questionValueTable = QuestionValueTable()
		
		for identifier, questionList in self.questionTable.items():
			question = questionList[0]

			if question.valueExpression:
				self.questionValueTable.add(identifier, question.valueExpression)
			else:
				self.questionValueTable(identifier, None)

		self.typeTable = OperatorTypes.Table()
		self.pages = []

	def createDefaultPages(self):
		self.pages = []
		self.pages.append(Page(self.questionTable, self.questionTable.keys()))

	def getVisibleQuestions(self, pageNumber):
		return self.pages[pageNumber].getVisibleQuestions(self)


ast = AST("test_visitor.QL")
evaluator = Evaluator(ast)
evaluator.createDefaultPages()

for q in evaluator.getVisibleQuestions(0):
	print(q.text)

#for identifier, question in ec.items():
#	print(identifier, question)
	