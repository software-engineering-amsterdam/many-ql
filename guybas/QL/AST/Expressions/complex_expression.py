import QL.AST.Expressions.expression as e


# Expressions with sub-expressions
class ComplexExpression(e.Expression):

    # initialization
    def __init__(self, expr):
        self._expression = expr
        self._dependencies = ComplexExpression.dependency_collection(self._expression)

    # get the return _type of the _expression
    def return_type_string(self, type_dict):
        types = ""
        for x in self._expression:
            types += "(" + x.return_type_string(type_dict) + ")"
        return types

    # return a pretty printed string of the _expression
    def pretty_print(self, level=0):
        s = ""
        for x in self._expression:
            s += "(" + x.pretty_print() + ")"
        return s

    # get all variables in the _expression
    def get_dependencies(self):
        return self._dependencies

    # return the expressions as a list of lists
    def as_list(self):
        l = []
        for x in self._expression:
            l.append(x.as_list())
        return l

    # static helper method to get the _dependencies once
    @staticmethod
    def dependency_collection(expression):
        dependencies = []
        for x in expression:
            dependencies += x.get_dependencies()
        return dependencies














