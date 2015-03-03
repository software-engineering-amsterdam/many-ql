from QL.AST.Expressions.expression import *

# Expressions with sub-expressions
class ComplexExpression(Expression):
    def __init__(self, expression):
        self.expression = expression
        self.is_else = False

    def return_type(self, type_dict):
        types = ""
        for e in self.expression:
            types += e.return_type(type_dict)
        return types

    def get_dependencies(self):
        dependencies = []
        for element in self.expression:
            dependencies += element.get_dependencies()
        return dependencies

    def pretty_print(self, level=0):
        s = ""
        for e in self.expression:
            s += "(" + e.pretty_print() + ")"
        return s

    def as_list(self):
        l = []
        for v in self.expression:
            l.append(v.as_list())
        return l

    def return_type(self, type_dict):
        types = ""
        for e in self.expression:
            types += "( " + (e.return_type(type_dict)) + " )"
        return types

    def not_expression(self):
        # print(self.expression.pretty_print())
        #print(self.expression.pretty_print())
        print("here")
        print(self.expression)
        return self.expression.as_list()