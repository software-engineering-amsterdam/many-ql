import QL.AST.Expressions.Primitives.primitive as e
import QL.AST.Exceptions.exception as er


# The binary expression abstract class contains almost all functionality of the sub classes
class BinaryExpression(e.Primitive):

    # It expects the symbol so all the sub classed don't need to overwrite the constructor and pretty print
    def __init__(self, operand1, operand2):
        self._operand1 = operand1
        self._operand2 = operand2
        self.symbol = self.set_operator()

    def set_operator(self):
        raise Exception("Not implemented by sub class")

    def pretty_print(self, level=0):
        return "(" + self._operand1.pretty_print() + " " + self.symbol + " " + self._operand2.pretty_print() + ")"

    # get the return _type of the _expression, only one needed to be overwritten
    def return_type_string(self, type_dict):
        raise NotImplementedError("Not implemented by sub class")

    # returns the error message of the expression checking, empty if valid
    def is_valid_expression_message(self, type_map):
        message = []

        # check for both operands if they are valid
        message.extend(self._operand1.is_valid_expression_message(type_map))
        message.extend(self._operand2.is_valid_expression_message(type_map))

        # if the types of both operands are not similar the expression is not correct
        if self._operand1.return_type_string(type_map) != self._operand2.return_type_string(type_map):
            message.append(self._operand1.pretty_print() + " is not the same type as " + self._operand2.pretty_print())

        # if the types of the operands do not match with the operation it's own type it is incorrect
        # (except for equals)
        elif self._operand1.return_type_string(type_map) != self.return_type_string(type_map):
            message.append("the operands " + self._operand1.pretty_print() + \
                       " and " + self._operand2.pretty_print() + " are not of the correct type")

        return message

    # get the dependencies of both operands
    def get_dependency_collection(self):
        l = []
        l += (self._operand1.get_dependency_collection())
        l += (self._operand2.get_dependency_collection())
        return l

    # get the dependencies of both operands
    def eval_expression(self, type_map):
        x = self._operand1.eval_expression(type_map)
        y = self._operand2.eval_expression(type_map)
        if x is None or y is None:
            z = None
        else:
            z = self.eval(x, y)
        return z

    def eval(self, x, y):
        raise Exception("Not implemented by sub class")

