import QL.AST.Expressions.Operations.binary_expression as binary_expression
import QL.AST.Expressions.Types.bool_type as bool_type
import QL.AST.Expressions.Types.number_type as number_type


class CompareExpression(binary_expression.BinaryExpression):

    # get the return _type of the _expression
    def return_type(self, type_map):
        return bool_type.Bool()

    # Override this one as it returns a bool but expects two numbers
    def operands_correct_type(self, type_map):
        # Only one check is needed, as is already checked if they are they same
        return self._left_operand.return_type(type_map) == number_type.Number()