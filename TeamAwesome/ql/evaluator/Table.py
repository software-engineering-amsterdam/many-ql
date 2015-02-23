from collections import OrderedDict
from .EvaluatorTypes import Form, Question, ExpressionFactory, Expression
from ..CustomTypes import *
from ..ast import Nodes

class QuestionValueTable(object):
	def __init__(self, questionTable):
		self._table = OrderedDict()

		for questions in questionTable.values():
			for question in questions:
				if question.valueExpression:
					self.add(question, question.valueExpression)
				else:
					self.add(question, None)

	def __iter__(self):
		return self._table.__iter__()

	def items(self):
		return self._table.items()

	def values(self):
		return self._table.values()

	def keys(self):
		return self._table.keys()

	def add(self, question, value):
		oldValue = self._table.get(question, None)
		if not (oldValue and isinstance(oldValue, Expression)):
			self._table[question] = value

	def get(self, question, evaluator):
		val = self._table[question]
		
		if isinstance(val, Expression):
			return val.evaluate(evaluator)
		return val

class QuestionTable(object):
	def __init__(self, ast):
		self._table = OrderedDict()

		for formStatement in ast.root.statements:
			form = Form(formStatement)

			for statement in formStatement.getChildren():
				self._add(statement, ExpressionsTuple(), form)

	def __iter__(self):
		return self._table.__iter__()

	def items(self):
		return self._table.items()

	def values(self):
		return self._table.values()

	def keys(self):
		return self._table.keys()

	def _add(self, statement, expressionsTuple, form):
		if isinstance(statement, Nodes.IfStatement):
			childExpressionsTuple = expressionsTuple + (ExpressionFactory.create((statement.expr)),)
			
			for childStatement in statement.getChildren():
				self._add(childStatement, childExpressionsTuple, form)
		else:
			question = Question(statement, expressionsTuple, form)
			questionList = self._table.get(question.identifier, QuestionList())
			questionList.append(question)
			self._table[question.identifier] = questionList

	def get(self, identifier, evaluator):
		questions = self._table.get(identifier, None)
		
		if questions:
			return questions.getVisibleQuestion(evaluator)
		return questions

	def getQuestionList(self, identifier):
		return self._table.get(identifier, None)

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
