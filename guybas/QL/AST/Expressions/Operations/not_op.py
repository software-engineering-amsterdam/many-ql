import QL.AST.Expressions.Primitives.primitive as p
import QL.Grammar.constants as constants


class Not(p.Primitive):
    def __init__(self, operand):
        self.__operand = operand

    def pretty_print(self,level=0):
        return "not " + self.__operand.pretty_print()

    # get the return _type of the expression
    def return_type_string(self, type_dict):
        return constants.BOOL

    # get all variables in the expression
    def get_dependency_collection(self):
        return self.__operand.get_dependency_collection()

    # return the error message of type checking, empty if valid expression
    def is_valid_expression_message(self, td):
        return self.__operand.is_valid_expression_message() and self.__operand.return_type_string == constants.BOOL

    def eval_expression(self, type_map):
        x = self.__operand.eval_expression(type_map)
        if x is None:
            return None
        return not x