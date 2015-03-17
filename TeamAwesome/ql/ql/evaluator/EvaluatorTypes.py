from ..core.QLTypes import *

class BinaryExpression(object):
	def __init__(self, leftExpression, op, rightExpression, evaluator):
		self._left = leftExpression
		self._op = op
		self._right = rightExpression
		self._evaluator = evaluator

	@property
	def value(self):
		leftValue = self._left.value
		rightValue = self._right.value
		print(leftValue, type(leftValue), rightValue, type(rightValue))
		return self._evaluator.evaluateBinaryExpression(self._op, leftValue, rightValue)

class UnaryExpression(object):
	def __init__(self, op, expression, evaluator):
		self._op = op
		self._expression = expression
		self._evaluator = evaluator

	@property
	def value(self):
		exprValue = self._expression.value
		return self._evaluator.evaluateUnaryExpression(self._op, exprValue)

class AtomicExpression(object):
	def __init__(self, value):
		self._value = value

	@property
	def value(self):
		return self._value.value

class Form(object):
	def __init__(self, identifier):
		self.identifier = identifier
		
class Question(object):
	def __init__(self, identifier, text, questionType, conditionalExpressionsTuple, form, valueExpression = None):
		self.identifier = identifier
		self.valueExpression = valueExpression
		self.text = text
		self.type = questionType
		self.form = form

		self.conditionalExpressions = conditionalExpressionsTuple
		self.constant = self.valueExpression != None

	def __str__(self):
		return "id:%s, text:%s, type:%s" %(self.identifier, self.text, self.type)

	def isVisible(self):
		print(self.text, self.conditionalExpressions.value)
		return self.conditionalExpressions.value


class EvalIdentifier(object):
	def __init__(self, value, evaluator):
		self._value = value
		self._evaluator = evaluator

	@property
	def value(self):
		print(self._evaluator.getValue(self), self._value, "HERRREE")
		return self._evaluator.getValue(self) 

	def __hash__(self):
		return hash(self._value)

	def __eq__(self, other):
		if isinstance(other, EvalIdentifier):
			return other._value == self._value
		return False