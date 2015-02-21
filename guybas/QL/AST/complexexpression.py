# AST for expressions
from Grammar.expressions import *
import operator


# Expression interface
class Expression:
    def __init__(self):
        pass

    def return_type(self):
        types = []
        b = False
        op = None
        last = None
        for e in self.expression:
            x = e.return_type()
            if b:
                if e.return_type in op.compatible and last.return_type in op.compatible:
                    last = op.return_type()
                    b = False
            elif x == "operator":
                b = True
                op = x
            else:
                last = e
        print(self.expression)
        print(last)
        return types

    def pretty_print(self):
        pass

    def get_dependencies(self):
        pass


# Expression without parenthesis
class SimpleExpression(Expression):
    def __init__(self, expression):
        self.expression = expression

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
        self.expression = expression
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

    def return_type(self):
        types = []
        for e in self.expression:
            types.append(e.return_type())
        return types