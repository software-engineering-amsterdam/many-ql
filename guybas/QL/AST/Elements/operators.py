# AST for operators
import QL.AST.Elements.element as e
import QL.AST.Elements.constants as constants


class Operator(e.Element):
    def __init__(self, operator):
        self.operator = operator

    def pretty_print(self):
        return " " + str(self.operator) + " "

    def get_dependencies(self):
        return []

    def as_list(self):
        return [self.operator]


class CompareOperator(Operator):
    def return_type(self, type_dict):
        return " " + constants.ElementsConstants.COMP_OP + " "


class CalcOperator(Operator):
    def return_type(self, type_dict):
        return " " + constants.ElementsConstants.CALC_OP + " "


class ExtraOperator(Operator):
    def return_type(self, type_dict):
        return " " + constants.ElementsConstants.EXTRA_OP + " "
