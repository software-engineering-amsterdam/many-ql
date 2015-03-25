import QL.AST.Expressions.Operations.binary_expression as b
import QL.AST.Expressions.Types.bool_type as bool_type


class Equal(b.BinaryExpression):

    def set_string_operator(self):
        return "=="

    # get the return _type of the _expression
    def return_type(self, type_map):
        return bool_type.Bool()

    # override as equal is allowed to have types on both sides which are not booleans
    def is_valid_expression_message(self, type_map):
        messages = []

        # check for both operands if they are valid
        messages.extend(self._left_operand.is_valid_expression_message(type_map))
        messages.extend(self._right_operand.is_valid_expression_message(type_map))

        # if the types of both operands are not similar the expression is not correct
        if self._left_operand.return_type(type_map) != self._right_operand.return_type(type_map):
            messages.append(self._left_operand.__str__() +
                           " is not the same type as " + self._right_operand.__str__())

        return messages

    def eval(self, x, y):
        return x == y