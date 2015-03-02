# Expression validator
from pyparsing import *
from QL.Factory.forms import *


class ExpressionValidator:

    @staticmethod
    def validator(expression):
        try:
            print(expression)
            b = Literal("bool")
            number = Literal("number")
            text = Literal("text")
            op = Literal("calc_operator")
            compare = Literal("comp_operator")
            extra = Literal("extra_operator")

            calc_expr = Forward()

            # atom :: ( calc_expr ) | number
            calc_atom = (Literal("(") + calc_expr + Literal(")")) | number

            # calc_expr :: atom (calc_operator + calc_expr)*
            calc_expr << calc_atom + ZeroOrMore(op + calc_expr)

            #
            text_expr = Forward()
            text_expr << OneOrMore(text + compare) + text

            # comp_expr :: bool (comp_operator bool)*
            comp_expr = b + ZeroOrMore((compare | extra) + b)

            # condition :: calc_expr comp_operator | comp_expr
            condition = Forward()
            condition << (calc_expr + compare + calc_expr | comp_expr | text_expr) + ZeroOrMore(extra + condition)

            # final_condition :: condition (full input used)
            final_condition = condition + stringEnd()

            final_condition.parseString(expression).asList()
            return True

        except Exception as e:
            return False