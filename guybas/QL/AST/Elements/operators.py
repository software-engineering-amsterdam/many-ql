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

class CalcOperator(Operator):
    def return_type(self, type_dict):
        return " calc_operator "


class ExtraOperator(Operator):
    def return_type(self, type_dict):
        return " extra_operator "
