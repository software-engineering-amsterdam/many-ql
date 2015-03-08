import QL.AST.Expressions.expression as e
import QL.AST.Elements.operators as operators
import QL.AST.Expressions.complex_expression as c


# Expression without parenthesis
class SimpleExpression(e.Expression):
    # initialization
    def __init__(self, expression):
        self._expression = expression
        self._dependencies = SimpleExpression.dependency_collection(self._expression)

    # get the return _type of the _expression
    def return_type(self, type_dict):
        types = ""
        for x in self._expression:
            types += x.return_type(type_dict)
        return types

    # return a pretty printed string of the _expression
    def pretty_print(self, level = 0):
        s = ""
        if self._expression:
            for x in self._expression:
                s += x.pretty_print()
        return s

    # get all variables in the _expression
    def get_dependencies(self):
        return self._dependencies

    # return the expressions as a list of lists
    def as_list(self):
        l = []
        for x in self._expression:
            l += x.as_list()
        return l

    # static helper method to get the _dependencies once
    @staticmethod
    def dependency_collection(expression):
        dependencies = []
        for element in expression:
            dependencies += element.get_dependencies()
        return dependencies

    # Return the negative of the _expression
    def add_not(self):
        l = [SimpleExpression(self._expression)]
        return SimpleExpression([operators.ExtraOperator("not"), c.ComplexExpression(l)])