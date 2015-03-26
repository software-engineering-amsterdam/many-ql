import QL.AST.Expressions.Operations.Compare.compare_expression as compare_expression
import QL.AST.Expressions.Types.bool_type as bool_type


class Equal(compare_expression.CompareExpression):

    def set_string_operator(self):
        return "=="

    # get the return _type of the _expression
    def return_type(self, type_map):
        return bool_type.Bool()

    # override as equal is allowed to have all types on both sides as long as they are the same
    def type_error_messages(self, type_map):
        error_messages = []

        # check for both operands if they are valid
        error_messages.extend(self._left_operand.type_error_messages(type_map))
        error_messages.extend(self._right_operand.type_error_messages(type_map))

        if not self.operands_same_type(type_map):
            error_messages.append("%s is not the same type as %s" % (str(self._left_operand), str(self._right_operand)))

        return error_messages

    def concrete_eval(self, x, y):
        return x == y