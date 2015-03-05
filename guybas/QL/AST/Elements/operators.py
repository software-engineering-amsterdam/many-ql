# AST for operators
from QL.Grammar.basic_types import *
from QL.AST.Elements.element import *
import QL.AST.Elements.constants as econstants

class Operator(Element):
    def __init__(self, operator):
        self.operator = operator

    def return_type(self, type_dict):
        return " " + econstants.ElementsConstants.OPERATOR + " "

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
        return " " + econstants.ElementsConstants.COMP_OP + " "

class CalcOperator(Operator):
    def return_type(self, type_dict):
        return " " + econstants.ElementsConstants.CALC_OP + " "


class ExtraOperator(Operator):
    def return_type(self, type_dict):
        return " " + econstants.ElementsConstants.EXTRA_OP + " "
