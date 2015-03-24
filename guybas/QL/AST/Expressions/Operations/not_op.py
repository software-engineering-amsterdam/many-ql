import QL.AST.Expressions.Primitives.primitive as p


class Not(p.Primitive):
    def __init__(self, operand):
        self.__operand = operand

    def __str__(self,level=0):
        return "not " + self.__operand.__str__()

    def return_type(self, type_dict):
        return bool

    # get all variables in the expression
    def get_variables(self):
        return self.__operand.get_variables()

    # return the error message of type checking, empty if valid expression
    def is_valid_expression_message(self, td):
        return self.__operand.is_valid_expression_message() and self.__operand.return_type == bool

    def eval_expression(self, type_map):
        x = self.__operand.eval_expression(type_map)
        if x is None:
            return None
        return not x