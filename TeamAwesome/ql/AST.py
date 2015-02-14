from decimal import *

class FormStatementNode(object):
	def __init__(self, identifier, statements, lineNumber):
		self.identifier = identifier
		self.statements = statements
		self.lineNumber = lineNumber

class QuestionStatementNode(object):
	def __init__(self, identifier, text, questionType, lineNumber, expr = None):
		self.identifier = identifier
		self.text = text
		self.type = questionType
		self.lineNumber = lineNumber
		self.expr = expr

class ExpressionNode(object):
	pass

class AtomicExpressionNode(ExpressionNode):
	def __init__(self, left, lineNumber):
		self.left = left
		self.lineNumber = lineNumber

class UnaryExpressionNode(ExpressionNode):
	def __init__(self, op, right, lineNumber):
		self.op = op
		self.right = right
		self.lineNumber = lineNumber

class BinaryExpressionNode(ExpressionNode):
	def __init__(self, left, op, right, lineNumber):
		self.left = left
		self.op = op
		self.right = right
		self.lineNumber = lineNumber

class IfStatementNode(object):
	def __init__(self, expr, statements, lineNumber):
		self.expr = expr
		self.statements = statements
		self.lineNumber = lineNumber

class Money(Decimal):
	pass

class Identifier(str):
	def __new__(cls, string, lineNumber):
		obj = str.__new__(cls, string)
		obj.lineNumber = lineNumber
		return obj