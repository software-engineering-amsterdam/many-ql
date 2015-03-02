# AST for operators
from QL.Grammar.basic_types import *
from QL.AST.Elements.element import *


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

    def as_list(self):
        return [self.operator]


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