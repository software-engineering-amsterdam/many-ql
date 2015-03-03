import QL.AST.Expressions.expression as expression
import QL.AST.Expressions.complex_expression as complex_expression
import QL.AST.Elements.operators as operators


# Expression without parenthesis
class SimpleExpression(expression.Expression):
    def __init__(self, expression):
        self.expression = expression

    def return_type(self, type_dict):
        types = ""
        for e in self.expression:
            types += e.return_type(type_dict)
        return types

    def pretty_print(self, level = 0):
        s = ""
        for e in self.expression:
            s += e.pretty_print()
        return s

    def get_dependencies(self):
        dependencies = []
        for element in self.expression:
            dependencies += element.get_dependencies()
        return dependencies

    def as_list(self):
        l = []
        for v in self.expression:
            l += v.as_list()
        return l

    def not_expression(self):
        # self.expression
        x = complex_expression.ComplexExpression([operators.ExtraOperator("not"), self.expression])
        return x.expression