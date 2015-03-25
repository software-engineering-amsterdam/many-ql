import QL.AST.Expressions.Operations.Arithmetic.number_expression as n


class Add(n.NumberExpression):

    def set_string_operator(self):
        return "+"

    def eval(self, x, y):
        return x + y