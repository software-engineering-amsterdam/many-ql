# Expression validator
from pyparsing import *
from QL.Factory.forms import *


class ExpressionValidator:

    @staticmethod
    def validator(expression):
        try:
            b = Literal("bool")
            number = Literal("number")
            op = Literal("calc_operator")
            calc_expr = Forward()

            # atom :: ( calc_expr ) | number
            atom = (Literal("(") + calc_expr + Literal(")")) | number

            # calc_expr :: atom (calc_operator + calc_expr)*
            calc_expr << atom + ZeroOrMore(op + calc_expr)

            compare = Literal("comp_operator")

            # comp_expr :: bool (comp_operator bool)*
            comp_expr = b + ZeroOrMore(compare + b)

            # condition :: calc_expr comp_operator | comp_expr
            condition = calc_expr + compare + calc_expr | comp_expr

            # final_condition :: condition (full input used)
            final_condition = condition + stringEnd()

            final_condition.parseString(expression).asList()
            return True

        except Exception as e:
            return False