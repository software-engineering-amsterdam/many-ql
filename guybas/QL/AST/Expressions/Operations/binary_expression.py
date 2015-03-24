import QL.AST.Expressions.Primitives.primitive as e


# The binary expression abstract class contains almost all functionality of the sub classes
class BinaryExpression(e.Primitive):

    def __init__(self, left_operand, right_operand):
        self._left_operand = left_operand
        self._right_operand = right_operand
        self.symbol = self.set_string_operator()

    # place parentheses around the expression to show the priorities in the expression
    def __str__(self):
        return "(" + self._left_operand.__str__() + " " + self.symbol + " " + self._right_operand.__str__() + ")"

    # returns the error message of the expression checking, empty if valid
    def is_valid_expression_message(self, type_map):
        error_messages = []

        # check for both operands if they are valid
        error_messages.extend(self._left_operand.is_valid_expression_message(type_map))
        error_messages.extend(self._right_operand.is_valid_expression_message(type_map))

        # if the types of both operands are not similar the expression is not correct (except for compare expressions)
        if self._left_operand.return_type_string(type_map) != self._right_operand.return_type_string(type_map):
            error_messages.append(self._left_operand.__str__() +
                                  " is not the same type as " + self._right_operand.__str__())

        # if the types of the operands do not match with the operation it's own type it is incorrect
        # (except for compare expressions)
        elif self._left_operand.return_type_string(type_map) != self.return_type_string(type_map):
            error_messages.append("the operands " + self._left_operand.__str__() +
                                  " and " + self._right_operand.__str__() + " are not of the correct type")

        return error_messages

    # get the variables in both operands
    def get_variables(self):
        l = []
        l += (self._left_operand.get_variables())
        l += (self._right_operand.get_variables())
        return l

    # evaluate both operands and evaluate the result afterwards
    def eval_expression(self, type_map):
        x = self._left_operand.eval_expression(type_map)
        y = self._right_operand.eval_expression(type_map)
        if x is None or y is None:
            z = None
        else:
            z = self.eval(x, y)
        return z

    #
    # Need to be overridden by sub classes
    #

    # Since the init is the same for all binary expressions this method is needed to make the distinction between
    # the operations
    def set_string_operator(self):
        raise NotImplementedError("Not implemented by sub class")

    # get the return _type of the _expression, only one needed to be overwritten
    def return_type_string(self, type_map):
        raise NotImplementedError("Not implemented by sub class")

    def eval(self, x, y):
        raise NotImplementedError("Not implemented by sub class")

