import QL.AST.Expressions.Elements.element as e


class BinaryExpression(e.Element):
    def __init__(self, symbol, operand1, operand2):
        self._operand1 = operand1
        self._operand2 = operand2
        self.symbol = symbol

    def pretty_print(self, level=0):
        return "(" + self._operand1.pretty_print() + self.symbol + self._operand2.pretty_print() + ")"

    # get the return _type of the _expression
    def return_type_string(self, type_dict):
        raise Exception("Not implemented by sub class")

    def is_valid_expression_message(self, td):
        message = ""
        message += self._operand1.is_valid_expression_message(td)
        message += self._operand2.is_valid_expression_message(td)
        if self._operand1.return_type_string(td) != self._operand2.return_type_string(td):
            message += self._operand1.pretty_print() + " is not the same type as " + self._operand2.pretty_print() + "\n"
        elif self._operand1.return_type_string(td) != self.return_type_string(td):
            message += "the operands " + self._operand1.pretty_print() + \
                       " and "  + self._operand2.pretty_print() + " are not of the correct type\n"
        return message

    def get_dependency_collection(self):
        l = []
        l += (self._operand1.get_dependency_collection())
        l += (self._operand2.get_dependency_collection())
        return l