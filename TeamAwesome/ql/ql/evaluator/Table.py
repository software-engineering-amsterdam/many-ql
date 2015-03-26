from collections import OrderedDict
from .EvaluatorTypes import Form, Question
from ..ast import Nodes

class QuestionValueTable(object):
    def __init__(self):
        self._valueTable = OrderedDict()
        self._expressionTable = OrderedDict()

    def __iter__(self):
        tempTable = {}
        tempTable.update(self._valueTable)
        tempTable.update(self._expressionTable)
        return tempTable.__iter__()

    def questions(self):
        return self._valueTable.keys() + self._expressionTable.keys()

    def add(self, question):
        if question.valueExpression:
            self._expressionTable[question] = question.valueExpression
        else:
            self._valueTable[question] = None

    def update(self, question, value):
        if question in self._valueTable:
            self._valueTable[question] = value

    def get(self, question):
        if question in self._expressionTable:
            return self._expressionTable[question].value
        return self._valueTable.get(question, None)

class QuestionTable(object):
    def __init__(self):
        self._table = OrderedDict()

    def __iter__(self):
        return self._table.__iter__()

    def questions(self):
        return [q for qList in self._table.values() for q in qList]

    def identifiers(self):
        return self._table.keys()

    def add(self, question):
        questionList = self._table.get(question.identifier, QuestionList())
        questionList.append(question)
        self._table[question.identifier] = questionList

    def get(self, identifier):
        questions = self._table.get(identifier, None)
        if questions:
            return questions.getVisibleQuestion()

    def getType(self, identifier):
        questions = self._table.get(identifier, None)
        if questions:
            return questions[0].type

    def getQuestionList(self, identifier):
        return self._table.get(identifier, None)

class ExpressionsTuple(tuple):
    def __add__(self, value):
        return ExpressionsTuple(tuple.__add__(self, value))

    @property
    def value(self):
        return all(expr.value.value for expr in self)

class ExpressionsList(list):
    def __add__(self, value):
        return ExpressionsList(tuple.__add__(self, value))

    @property
    def value(self):
        return all(expr.value.value for expr in self)

    def copy(self):
        return ExpressionsList(self)


class QuestionList(list):
    def getVisibleQuestion(self):
        for question in self:
            if question.isVisible():
                return question
        return None
