# AST for expressions


class Expression:
    def __init__(self):
        pass

    def get_type(self):
        pass

    def pretty_print(self):
        pass


class SubExpression(Expression):
    def __init__(self, sub_expression):
        self.sub_expression = sub_expression

    def get_type(self):
        pass

    def pretty_print(self):
        pass


class ComplexExpression(Expression):
    def __init__(self, expression):
        self.expression = expression
        self.is_else = False
        self.dependencies = ComplexExpression.analyze(self.expression)

    @staticmethod
    def analyze(expr):
        dependencies = []
        for element in expr:
            if isinstance(element, str):
                dependencies.append(element)
            elif isinstance(element, list):
                dependencies += ComplexExpression.analyze(element)
        return dependencies

    @staticmethod
    def sub_expression(expr):
        s = ""
        for e in expr:
            if isinstance(e, list):
                s += "( " + ComplexExpression.sub_expression(e) + ") "
            else:
                s += str(e) + " "
        return s

    def check(self):
        return self.dependencies

    def pretty_print(self, level=0):
        return "   " * level + ComplexExpression.sub_expression(self.expression)

    def as_list(self):
        return self.expression