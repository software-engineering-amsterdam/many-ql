# AST for expressions


class Operator:
    def __init__(self, operator):
        self.operator = operator

    def __str__(self):
        return str(self.operator)


class Expression:
    def __init__(self, expression):
        self.expression = expression[0]
        self.is_else = False
        self.dependencies = Expression.analyze(self.expression)

    def analyze(expr):
        dependencies = []
        for element in expr:
            if isinstance(element, str):
                dependencies.append(element)
            elif isinstance(element, list):
                dependencies += Expression.analyze(element)
        return dependencies

    def sub_expression(expr):
        s = ""
        for e in expr:
            if isinstance(e, list):
                s += "( " + Expression.sub_expression(e) + ") "
            else:
                s += str(e) + " "
        return s

    def check(self):
        return self.dependencies

    def pretty_print(self, level=0):
        return "   " * level + Expression.sub_expression(self.expression)

    def as_list(self):
        return self.expression