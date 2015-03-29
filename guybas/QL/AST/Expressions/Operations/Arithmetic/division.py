import QL.AST.Expressions.Operations.Arithmetic.number_expression as number_expression


class Division(number_expression.NumberExpression):

    def set_string_operator(self):
        return "/"

    def concrete_eval(self, x, y):
        return x / y
