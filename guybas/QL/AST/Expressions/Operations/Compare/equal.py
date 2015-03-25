import QL.AST.Expressions.Operations.binary_expression as b
import QL.AST.Expressions.Types.bool_type as bool_type


class Equal(b.BinaryExpression):

    def set_string_operator(self):
        return "=="

    # get the return _type of the _expression
    def return_type(self, type_map):
        return bool_type.Bool()

    # override as equal is allowed to have types on both sides which are not booleans
    def is_valid_messages(self, type_map):
        messages = []

        # check for both operands if they are valid
        messages.extend(self._left_operand.is_valid_messages(type_map))
        messages.extend(self._right_operand.is_valid_messages(type_map))

        # if the types of both operands are not similar the expression is not correct (except for compare expressions)
        left_operand_type = self._left_operand.return_type(type_map)
        right_operand_type = self._right_operand.return_type(type_map)
        if left_operand_type != right_operand_type:
            messages.append("%s is not the same type as %s" % (str(self._left_operand), str(self._right_operand)))

        return messages

    def concrete_eval(self, x, y):
        return x == y