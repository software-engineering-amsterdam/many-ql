from decimal import *

class FormStatementNode(object):
	def __init__(self, statements):
		self.statements = statements

class QuestionStatementNode(object):
	def __init__(self, name, text, question_type, expr = None):
		self.name = name
		self.text = text
		self.type = question_type
		self.expr = expr

class ExpressionNode(object):
	pass

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

class MoneyNode(object):
	def __init__(self, number1, number2):
		number1 = Decimal(number1)
		number2 = Decimal(number2)
		while number2 > 0:
			number2 /= 10
		self.val = number1 + number2

	def value(self):
		return self.val
