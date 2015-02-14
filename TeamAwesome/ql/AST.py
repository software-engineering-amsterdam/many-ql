from decimal import *

class FormStatementNode(object):
	def __init__(self, name, statements):
		self.name = name
		self.statements = statements

class QuestionStatementNode(object):
	def __init__(self, name, text, questionType, expr = None):
		self.name = name
		self.text = text
		self.type = questionType
		self.expr = expr

class ExpressionNode(object):
	pass

class AtomicExpressionNode(ExpressionNode):
	def __init__(self, left):
		self.left = left

class UnaryExpressionNode(ExpressionNode):
	def __init__(self, op, right):
		self.op = op
		self.right = right

class BinaryExpressionNode(ExpressionNode):
	def __init__(self, left, op, right):
		self.left = left
		self.op = op
		self.right = right

class IfStatementNode(object):
	def __init__(self, expr, statements):
		self.expr = expr
		self.statements = statements

class QuestionIdentifierNode(object):
	def __init__(self, name):
		self.name = name

class Money(Decimal):
	pass

class Identifier(str):
	pass