import QL.Grammar.constants as constants
import QL.AST.Expressions.Operations.binary_expression as b


class Equal(b.BinaryExpression):

    def set_operator(self):
        return " == "

    # get the return _type of the _expression
    def return_type_string(self, type_dict):
        return constants.BOOL

    # override as equal is allowed to have types on both sides which are not booleans
    def is_valid_expression_message(self, type_map):
        message = []

        # check for both operands if they are valid
        message.extend(self._operand1.is_valid_expression_message(type_map))
        message.extend(self._operand2.is_valid_expression_message(type_map))

        # if the types of both operands are not similar the expression is not correct
        if self._operand1.return_type_string(type_map) != self._operand2.return_type_string(type_map):
            message.append(self._operand1.pretty_print() +
                           " is not the same type as " + self._operand2.pretty_print())

        return message

    def eval(self, x, y):
        return x == y