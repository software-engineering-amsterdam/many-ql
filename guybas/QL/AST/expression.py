# AST for expressions
from Grammar.expressions import *


# Expression interface
class Expression:
    def __init__(self):
        pass

    def return_type(self, type_dict):
        pass

    def pretty_print(self):
        pass

    def get_dependencies(self):
        pass

    def as_list(self):
        pass


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