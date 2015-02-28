# AST for operators
from Grammar.basic_types import *


# TODO: Put this in multiple files?
class Element:
    def __init__(self):
        pass

    def return_type(self, type_dict):
        pass

    def pretty_print(self):
        pass

    def get_dependencies(self):
        pass


class Variable(Element):
    def __init__(self, name):
        self.name = name

    def __str__(self):
        return str(self.name)

    def return_type(self, type_dict):
        return type_dict[self.name]

    def pretty_print(self):
        return self.name

    def get_dependencies(self):
        return [self.name]


class Number(Element):
    def __init__(self, number):
        self.number = number

    def return_type(self, type_dict):
        return "number"

    def pretty_print(self):
        return str(self.number)

    def get_dependencies(self):
        return []


class Bool(Element):
    def __init__(self, pbool):
        self.bool = pbool

    def return_type(self, type_dict):
        return "bool"

    def pretty_print(self):
        return str(self.bool)

    def get_dependencies(self):
        return []


class Operator(Element):
    def __init__(self, operator):
        self.operator = operator

    def return_type(self, type_dict):
        return " operator "

    def pretty_print(self):
        return " " + str(self.operator) + " "

    @staticmethod
    def compatible():
        pass

    def get_dependencies(self):
        return []


class CompareOperator(Operator):
    def return_type(self, type_dict):
        return " comp_operator "

    def compatible(self):
        return [BasicTypes.bool_name, BasicTypes.number_name, BasicTypes.text_name]


class CalcOperator(Operator):
    def return_type(self, type_dict):
        return " calc_operator "

    def compatible(self):
        return [BasicTypes.number_name, BasicTypes.text_name]