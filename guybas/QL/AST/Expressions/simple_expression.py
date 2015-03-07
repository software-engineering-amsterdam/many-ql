import QL.AST.Expressions.expression as e
import QL.AST.Elements.operators as operators
import QL.AST.Expressions.complex_expression as c


# Expression without parenthesis
class SimpleExpression(e.Expression):
    def __init__(self, expression):
        self.expression = expression

    def return_type(self, type_dict):
        types = ""
        for x in self.expression:
            types += x.return_type(type_dict)
        return types

    def pretty_print(self, level = 0):
        s = ""
        if self.expression:
            for x in self.expression:
                s += x.pretty_print()
        return s

    def get_dependencies(self):
        dependencies = []
        for element in self.expression:
            dependencies += element.get_dependencies()
        return dependencies

    def as_list(self):
        l = []
        for x in self.expression:
            l += x.as_list()
        return l

    # Return the negative of the expression
    def add_not(self):
        l = [SimpleExpression(self.expression)]
        return SimpleExpression([operators.ExtraOperator("not"), c.ComplexExpression(l)])