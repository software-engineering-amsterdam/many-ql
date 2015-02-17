from AST import AST
import ASTNodes
from collections import OrderedDict
from CustomTypes import *
import OperatorTypes

class QuestionTable(OrderedDict):
	def __init__(self, ast):
		super().__init__(self)

		for formStatement in ast.root.statements:
			form = Form(formStatement)

			for statement in formStatement.getChildren():
				self.__addStatement(statement, ExpressionsTuple(), form)

	def __addStatement(self, statement, expressionsTuple, form):
		assert isinstance(statement, ASTNodes.IfStatement) or isinstance(statement, ASTNodes.QuestionStatement)

		if isinstance(statement, ASTNodes.IfStatement):
			childExpressionsTuple = expressionsTuple + (ExpressionFactory.create((statement.expr)),)
			
			for childStatement in statement.getChildren():
				self.__addStatement(childStatement, childExpressionsTuple, form)
		else:
			question = Question(statement, expressionsTuple, form)
			questionList = self.get(question.identifier, QuestionList())
			questionList.append(question)
			self[question.identifier] = questionList

class ExpressionsTuple(tuple):
	def __add__(self, value):
		return ExpressionsTuple(tuple.__add__(self, value))

	def evaluate(self, typeTable):
		return all(expr.evaluate(typeTable) for expr in self)

class QuestionList(list):
	def getVisibleQuestion(self, typeTable):
		for question in self:
			if question.isVisible(typeTable):
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

class BinaryExpression(object):
	def __init__(self, binaryExpressionNode):
		self.left = ExpressionFactory.create(binaryExpressionNode.left)
		self.op = binaryExpressionNode.op
		self.right = ExpressionFactory.create(binaryExpressionNode.right)

	def evaluate(self, typeTable):
		leftValue = self.left.evaluate(typeTable)
		rightValue = self.right.evaluate(typeTable)
		pythonOp = typeTable.getBinaryOperator(self.op, leftValue, rightValue)

		return pythonOp(leftValue, rightValue)

class UnaryExpression(object):
	def __init__(self, unaryExpressionNode):
		self.op = unaryExpressionNode.op
		self.right = ExpressionFactory.create(unaryExpressionNode.right)

	def evaluate(self, typeTable):
		rightValue = self.right.evaluate(typeTable)
		pythonOp = typeTable.getUnaryPythonOperator(self.op)
		return pythonOp(right)

class AtomicExpression(object):
	def __init__(self, atomicExpressionNode):
		self.left = atomicExpressionNode.left

	def evaluate(self, typeTable):
		return self.left

class Question(object):
	def __init__(self, questionStatementNode, conditionalExpressionsTuple, form):
		assert isinstance(questionStatementNode, ASTNodes.QuestionStatement)
	
		self.identifier = questionStatementNode.identifier	
		self.valueExpression = questionStatementNode.expr
		self.text = questionStatementNode.text
		self.type = questionStatementNode.type

		self.conditionalExpressions = conditionalExpressionsTuple
		self.form = form

	def isVisible(self, typeTable):
		return self.conditionalExpressions.evaluate(typeTable)

class Page(object):
	def __init__(self, questionTable, questionIdentifiers):
		self.questionLists = []
		for identifier in questionIdentifiers:
			self.questionLists.append(questionTable[identifier])

	def getVisibleQuestions(self, typeTable):
		visibleQuestions = []
		
		for questionList in self.questionLists:
			visibleQuestion = questionList.getVisibleQuestion(typeTable)
			if visibleQuestion:
				visibleQuestions.append(visibleQuestion)

		return visibleQuestions

class Evaluator(object):
	def __init__(self, ast):
		self.questionTable = QuestionTable(ast)
		self.typeTable = OperatorTypes.Table()
		self.pages = []

	def createDefaultPages(self):
		self.pages = []
		self.pages.append(Page(self.questionTable, self.questionTable.keys()))

	def getVisibleQuestions(self, pageNumber):
		return self.pages[pageNumber].getVisibleQuestions(self.typeTable)


ast = AST("test_visitor.QL")
evaluator = Evaluator(ast)
evaluator.createDefaultPages()

for q in evaluator.getVisibleQuestions(0):
	print(q.text)

#for identifier, question in ec.items():
#	print(identifier, question)
	