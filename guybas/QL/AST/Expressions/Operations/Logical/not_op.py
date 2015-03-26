import QL.AST.Expressions.Primitives.primitive as primitive
import QL.AST.Expressions.Types.bool_type as bool_type


class Not(primitive.Primitive):
    def __init__(self, operand):
        self.__operand = operand

    def __str__(self,level=0):
        return "not " + str(self.__operand)

    def return_type(self, type_map):
        return bool_type.Bool()

    # get all variables in the expression
    def get_variables(self):
        return self.__operand.get_variables()

    # return the error message of type checking, empty if valid expression
    def type_error_messages(self, td):
        return self.__operand.type_error_messages() and self.__operand.return_type == bool_type.Bool()

    def eval_expression(self, answer_map):
        x = self.__operand.eval_expression(answer_map)
        if x is None:
            return None
        return not x