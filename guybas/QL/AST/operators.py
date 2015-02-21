# AST for operators
from Grammar.expressions import *


class Element:
    def __init__(self):
        pass

    def return_type(self):
        pass

    def __str__(self):
        pass


class Variable(Element):
    def __init__(self, name):
        self.name = name

    @staticmethod
    def return_type():
        return QuestionTypes.text_name

    def __str__(self):
        return str(self.name)


class Number(Element):
    def __init__(self, number):
        self.number = number

    @staticmethod
    def return_type():
        return QuestionTypes.number_name

    def __str__(self):
        return self.number


class Bool(Element):
    def __init__(self, bool):
        self.bool = bool

    @staticmethod
    def return_type():
        return QuestionTypes.bool_name

    def __str__(self):
        return self.bool


class Operator:
    def __init__(self, operator):
        self.operator = operator

    @staticmethod
    def return_type():
        return Expressions.operator_name

    def __str__(self):
        return str(self.operator)

    @staticmethod
    def compatible():
        pass


class CompareOperator(Operator):
    def compatible(self):
        return [QuestionTypes.bool_name, QuestionTypes.number_name, QuestionTypes.text_name]


class CalcOperator(Operator):
    def compatible(self):
        return QuestionTypes.number_name