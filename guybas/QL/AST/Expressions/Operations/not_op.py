import QL.AST.Expressions.Elements.element as e
import QL.Grammar.constants as constants


class Not(e.Element):
    def __init__(self, operand):
        self._operand = operand

    def pretty_print(self,level=0):
        return "not " + self._operand.pretty_print()

    # get the return _type of the _expression
    def return_type_string(self, type_dict):
        return constants.BOOL

    # get all variables in the _expression
    def get_dependencies(self):
        raise NotImplementedError("Not implemented by sub class")