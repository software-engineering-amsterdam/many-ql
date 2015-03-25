import QL.AST.Expressions.Operations.binary_expression as b
import QL.AST.Expressions.Types.number_type as number_type


class NumberExpression(b.BinaryExpression):
    # get the return _type of the _expression
    def return_type(self, type_map):
        return number_type.Number()

    def set_string_operator(self):
        raise NotImplementedError("Not implemented by sub class")

    def eval(self, x, y):
        raise NotImplementedError("Not implemented by sub class")