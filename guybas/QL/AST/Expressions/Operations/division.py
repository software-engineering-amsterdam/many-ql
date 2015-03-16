import QL.AST.Expressions.Elements.element as e
import QL.Grammar.constants as constants


class Division(e.Element):
    def __init__(self, operand1, operand2):
        self._operand1 = operand1
        self._operand2 = operand2

    def pretty_print(self, level=0):
        return self._operand1 + " / " + self._operand2

    # get the return _type of the _expression
    def return_type_string(self, type_dict):
        return constants.NUMBER

    # get all variables in the _expression
    def get_dependencies(self):
        return [self._operand1.get_dependencies(), self._operand2.get_dependencies()]