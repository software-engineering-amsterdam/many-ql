from ..core.QLTypes import *
from abc import ABCMeta, abstractmethod



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
		return self.conditionalExpressions.evaluate()



class Evaluable(object):
	@property
	@abstractmethod
	def value(self):
		"""Returns a QLType value"""
		raise NotImplementedError()


	def __str__(self):
		return "%s:%s" %(self.__class__.__name__, self.value)



class BinaryExpression(Evaluable):
	def __init__(self, leftEvaluable, op, rightEvaluable, evaluator):
		self._left = leftEvaluable
		self._op = op
		self._right = rightEvaluable
		self._evaluator = evaluator


	@property
	def value(self):
		leftValue = self._left.value
		rightValue = self._right.value
		return self._evaluator.evaluateBinaryExpression(self._op, leftValue, rightValue)



class UnaryExpression(Evaluable):
	def __init__(self, op, evaluable, evaluator):
		self._op = op
		self._evaluable = evaluable
		self._evaluator = evaluator


	@property
	def value(self):
		value = self._evaluable.value
		return self._evaluator.evaluateUnaryExpression(self._op, value)



class AtomicType(Evaluable):
	def __init__(self, value):
		self._value = value


	@property
	def value(self):
		return self._value 


	def __hash__(self):
		return hash(self.value)


	def __eq__(self, other):
		if isinstance(other, type(self)):
			return other.value == self.value
		return False



class EvalNone(Evaluable):
	def __init__(self, *args):
		pass


	@property
	def value(self):
		pass


	def __hash__(self):
		return 0


	def __eq__(self, other):
		return isinstance(other, type(self))



class EvalIdentifier(Evaluable):
	def __init__(self, name, evaluator):
		self._name = name
		self._evaluator = evaluator


	@property
	def value(self):
		return self._evaluator.getValue(self) 


	def __hash__(self):
		return hash(self._name)


	def __eq__(self, other):
		if isinstance(other, type(self)):
			return other._name == self._name
		return False


	def __str__(self):
		return "%s:%s,%s" %(self.__class__.__name__, self._name, self.value)