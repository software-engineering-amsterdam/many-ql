from QL.AST.operators import *


# Factory for creating expressions
class ExpressionFactory:

    @staticmethod
    def make_variable(tokens):
        return Variable(tokens[0])

    @staticmethod
    def make_number(tokens):
        return Number(int(tokens[0]))

    @staticmethod
    def make_calc_operator(tokens):
        return CalcOperator(tokens[0])

    @staticmethod
    def make_comp_operator(tokens):
        return CompareOperator(tokens[0])

    @staticmethod
    def make_bool(tokens):
        if tokens[0] == "True":
            return Bool(True)
        else:
            return Bool(False)

    @staticmethod
    def make_sub_expression(tokens):
        e = SimpleExpression(tokens)
        return e

    @staticmethod
    def make_expression(tokens):
        x = ComplexExpression(tokens)
        return x