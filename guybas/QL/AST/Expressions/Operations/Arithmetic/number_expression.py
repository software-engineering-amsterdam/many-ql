import QL.AST.Expressions.Operations.binary_expression as binary_expression
import QL.AST.Expressions.Types.number_type as number_type


class NumberExpression(binary_expression.BinaryExpression):

    # get the return _type of the _expression
    def return_type(self, type_map):
        return number_type.Number()