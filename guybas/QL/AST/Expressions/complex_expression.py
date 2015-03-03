import QL.AST.Expressions.expression as e
import QL.AST.Elements.operators as operators


# Expressions with sub-expressions
class ComplexExpression(e.Expression):
    def __init__(self, expr):
        self.expression = expr

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
