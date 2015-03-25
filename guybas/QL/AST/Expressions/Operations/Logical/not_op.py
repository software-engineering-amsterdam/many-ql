import QL.AST.Expressions.Primitives.primitive as p
import QL.AST.Expressions.Types.bool_type as t


class Not(p.Primitive):
    def __init__(self, operand):
        self.__operand = operand

    def __str__(self,level=0):
        return "not " + str(self.__operand)

    def return_type(self, type_map):
        return t.Bool()

    # get all variables in the expression
    def get_variables(self):
        return self.__operand.get_variables()

    # return the error message of type checking, empty if valid expression
    def is_valid_messages(self, td):
        return self.__operand.is_valid_messages() and self.__operand.return_type == t.Bool()

    def eval_expression(self, answer_map):
        x = self.__operand.eval_expression(answer_map)
        if x is None:
            return None
        return not x