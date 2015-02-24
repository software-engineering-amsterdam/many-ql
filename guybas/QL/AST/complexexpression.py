# AST for expressions
from Grammar.expressions import *
import operator


# Expression interface
class Expression:
    def __init__(self):
        pass

    def return_type(self, type_dict):
        types = ""
        for e in self.expression:
            types += e.return_type(type_dict)
        return types

    def pretty_print(self):
        pass

    def get_dependencies(self):
        pass

    def as_list(self):
        return self.expression


# Expression without parenthesis
class SimpleExpression(Expression):
    def __init__(self, expression):
        self.expression = expression.asList()

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


# Expressions with sub-expressions
class ComplexExpression(Expression):
    def __init__(self, expression):
        self.expression = expression.asList()
        self.is_else = False

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
        return self.expression

    def return_type(self, type_dict):
        types = ""
        for e in self.expression:
            types += "( " + (e.return_type(type_dict)) + " )"
        return types