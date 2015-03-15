import QL.AST.Expressions.expression_interface as e


# Expressions with sub-expressions
class SubExpression(e.IExpression):

    # initialization
    def __init__(self, expr):
        self._expression = expr

    # get the return _type of the _expression
    def return_type_string(self, type_dict):
        types = "(" + self._expression.return_type_string(type_dict) + ")"
        return types

    # return a pretty printed string of the _expression
    def pretty_print(self, level=0):
        s = ""
        s += "(" + self._expression.pretty_print() + ")"
        return s

    # get all variables in the _expression
    def get_dependencies(self):
        dependencies = self._expression.get_dependencies()
        return dependencies















