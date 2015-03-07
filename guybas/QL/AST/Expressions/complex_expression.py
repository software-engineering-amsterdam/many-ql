import QL.AST.Expressions.expression as e
import QL.AST.Elements.operators as operators


# Expressions with sub-expressions
class ComplexExpression(e.Expression):
    def __init__(self, expr):
        self.expression = expr

    def return_type(self, type_dict):
        types = ""
        for x in self.expression:
            types += x.return_type(type_dict)
        return types

    def get_dependencies(self):
        dependencies = []
        for x in self.expression:
            dependencies += x.get_dependencies()
        return dependencies

    def pretty_print(self, level=0):
        s = ""
        for x in self.expression:
            s += "(" + x.pretty_print() + ")"
        return s

    def as_list(self):
        l = []
        for x in self.expression:
            l.append(x.as_list())
        return l

    def return_type(self, type_dict):
        types = ""
        for x in self.expression:
            types += "( " + (x.return_type(type_dict)) + " )"
        return types
