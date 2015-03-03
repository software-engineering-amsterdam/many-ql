from QL.AST.Expressions.expression import *
from QL.AST.Expressions.simple_expression import *
from QL.AST.Expressions.complex_expression import *
from QL.AST.Elements.element import *
from QL.AST.Elements.operators import *
from QL.AST.Elements.variable import *
from QL.AST.Elements.bool import *
from QL.AST.Elements.number import *
from QL.AST.Elements.text import *


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
    def make_extra_operator(tokens):
        return ExtraOperator(tokens[0])

    @staticmethod
    def make_bool(tokens):
        if tokens[0] == "True":
            return Bool(True)
        else:
            return Bool(False)

    @staticmethod
    def make_text(tokens):
        return Text(FormFactory.make_sentence(tokens))

    @staticmethod
    def make_sub_expression(tokens):
        e = SimpleExpression(tokens)
        return e

    @staticmethod
    def make_expression(tokens):
        x = ComplexExpression(tokens)
        return x