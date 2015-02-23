from ..CustomTypes import *

class ExpressionFactory(object):
	@staticmethod
	def create(expressionNode):
		if expressionNode:
			method = ExpressionFactory._getCreateMethod(expressionNode)
			return method(expressionNode)
		return None
		
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
		return evaluator.evaluateBinaryExpression(self.op, leftValue, rightValue)

class UnaryExpression(Expression):
	def __init__(self, unaryExpressionNode):
		self.op = unaryExpressionNode.op
		self.right = ExpressionFactory.create(unaryExpressionNode.right)

	def evaluate(self, evaluator):
		rightValue = self.right.evaluate(evaluator)
		return evaluator.evaluateUnaryExpression(self.op, rightValue)

class AtomicExpression(Expression):
	def __init__(self, atomicExpressionNode):
		self.left = atomicExpressionNode.left

	def evaluate(self, evaluator):
		if isinstance(self.left, Identifier):
			return evaluator.getValue(self.left)
		return self.left

class Form(object):
	def __init__(self, formStatementNode):
		self.identifier = formStatementNode.identifier

class Question(object):
	def __init__(self, questionStatementNode, conditionalExpressionsTuple, form):
		self.identifier = questionStatementNode.identifier	
		self.valueExpression = ExpressionFactory.create(questionStatementNode.expr)
		self.text = questionStatementNode.text
		self.type = questionStatementNode.type

		self.conditionalExpressions = conditionalExpressionsTuple
		self.form = form

	def __str__(self):
		return "id:%s, text:%s, type:%s" %(self.identifier, self.text, self.type)

	def isVisible(self, evaluator):
		return self.conditionalExpressions.evaluate(evaluator)
