from QL.AST.Expressions.expression import *

# Expression without parenthesis
class SimpleExpression(Expression):
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
        print("bbbbbbbbbbbbbbbbbbbbbbbb")
        # print(self.expression.pretty_print())
        print(self.expression)
        # self.expression
        return self.expression