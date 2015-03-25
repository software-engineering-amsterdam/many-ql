import QL.AST.Expressions.Primitives.primitive as e


# The binary expression abstract class contains almost all functionality of the sub classes
class BinaryExpression(e.Primitive):

    def __init__(self, left_operand, right_operand):
        self._left_operand = left_operand
        self._right_operand = right_operand
        self._symbol = self.set_string_operator()

    # place parentheses around the expression to show the priorities in the expression
    def __str__(self):
        return "(%s %s %s)" % (str(self._left_operand), self._symbol, str(self._right_operand))

    # returns the error message of the expression checking, empty if valid
    def is_valid_messages(self, type_map):
        error_messages = []

        # check for both operands if they are valid
        error_messages.extend(self._left_operand.is_valid_messages(type_map))
        error_messages.extend(self._right_operand.is_valid_messages(type_map))

        if not self.operands_same_type(type_map):
            error_messages.append("%s is not the same type as %s" % (str(self._left_operand), str(self._right_operand)))

        # if the types of the operands do not match with the operation it's own type it is incorrect
        if not self.operands_correct_type(type_map):
            error_messages.append("the operands %s and %s are not of the correct type"
                                  % (str(self._left_operand), str(self._right_operand)))

        return error_messages

    def operands_same_type(self, type_map):
        left_operand_type = self._left_operand.return_type(type_map)
        right_operand_type = self._right_operand.return_type(type_map)
        if left_operand_type == right_operand_type:
            return True
        return False

    def operands_correct_type(self, type_map):
        # Only one check is needed, as is already checked if they are they same
        return self._left_operand.return_type(type_map) == self.return_type(type_map)

    # get the variables in both operands
    def get_variables(self):
        return self._left_operand.get_variables() +self._right_operand.get_variables()

    # evaluate both operands and evaluate the result afterwards
    def eval_expression(self, answer_map):
        x = self._left_operand.eval_expression(answer_map)
        y = self._right_operand.eval_expression(answer_map)
        if x is None or y is None:
            z = None
        else:
            z = self.concrete_eval(x, y)
        return z

    #
    # Need to be overridden by sub classes
    #

    # Since the init is the same for all binary expressions this method is needed to make the distinction between
    # the operations
    def set_string_operator(self):
        raise NotImplementedError("Not implemented by sub class")

    # get the return _type of the _expression, only one needed to be overwritten
    def return_type(self, type_map):
        raise NotImplementedError("Not implemented by sub class")

    def concrete_eval(self, x, y):
        raise NotImplementedError("Not implemented by sub class")

