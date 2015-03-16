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
    def get_dependency_collection(self):
        return self._operand.get_dependency_collection()

    def is_valid_expression_message(self, td):
        return self._operand.is_valid_expression_message() and self._operand.return_type_string == constants.BOOL