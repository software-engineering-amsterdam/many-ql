import QL.AST.Expressions.Elements.element as e


class Add(e.Element):
    def __init__(self, operand1, operand2):
        self._operand1 = operand1
        self._operand2 = operand2

    def pretty_print(self, level=0):
        return self._operand1 + " + " + self._operand2

    # get the return _type of the _expression
    def return_type_string(self, type_dict):
        raise NotImplementedError("Not implemented by sub class")

    # get all variables in the _expression
    def get_dependencies(self):
        raise NotImplementedError("Not implemented by sub class")