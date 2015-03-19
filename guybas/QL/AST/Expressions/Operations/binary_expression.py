import QL.AST.Expressions.Primitives.primitive as e


# The binary expression abstract class contains almost all functionality of the sub classes
class BinaryExpression(e.Primitive):

    def __init__(self, operand1, operand2):
        self._operand1 = operand1
        self._operand2 = operand2
        self.symbol = self.set_operator()

    # place parentheses around the expression to show the priorities in the expression
    def string_presentation(self, level=0):
        return "(" + self._operand1.string_presentation() + " " + self.symbol + " " + self._operand2.string_presentation() + ")"

    # returns the error message of the expression checking, empty if valid
    def is_valid_expression_message(self, type_map):
        error_messages = []

        # check for both operands if they are valid
        error_messages.extend(self._operand1.is_valid_expression_message(type_map))
        error_messages.extend(self._operand2.is_valid_expression_message(type_map))

        # if the types of both operands are not similar the expression is not correct (except for compare expressions)
        if self._operand1.return_type_string(type_map) != self._operand2.return_type_string(type_map):
            error_messages.append(self._operand1.string_presentation() +
                                  " is not the same type as " + self._operand2.string_presentation())

        # if the types of the operands do not match with the operation it's own type it is incorrect
        # (except for compare expressions)
        elif self._operand1.return_type_string(type_map) != self.return_type_string(type_map):
            error_messages.append("the operands " + self._operand1.string_presentation() +
                                  " and " + self._operand2.string_presentation() + " are not of the correct type")

        return error_messages

    # get the variables in both operands
    def get_variables(self):
        l = []
        l += (self._operand1.get_variables())
        l += (self._operand2.get_variables())
        return l

    # evaluate both operands and evaluate the result afterwards
    def eval_expression(self, type_map):
        x = self._operand1.eval_expression(type_map)
        y = self._operand2.eval_expression(type_map)
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
    def set_operator(self):
        raise NotImplementedError("Not implemented by sub class")

    # get the return _type of the _expression, only one needed to be overwritten
    def return_type_string(self, type_map):
        raise NotImplementedError("Not implemented by sub class")

    def eval(self, x, y):
        raise NotImplementedError("Not implemented by sub class")

