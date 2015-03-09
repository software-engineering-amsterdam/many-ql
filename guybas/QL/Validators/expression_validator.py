# Expression validator
from pyparsing import *
import QL.AST.Elements.constants as constants


class ExpressionValidator:

    @staticmethod
    def validator(expression):
        try:
            print(expression)
            b = Literal(constants.ElementsConstants.BOOL)
            number = Literal(constants.ElementsConstants.NUMBER)
            text = Literal(constants.ElementsConstants.TEXT)

            plus_op = Literal("+")
            calc_ops = oneOf("- / *") | plus_op

            compare_ops = oneOf("> >= < <= == not")
            extra_ops = oneOf("and or")
            calc_expr = Forward()

            # atom :: ( calc_expr ) | number
            calc_atom = (Literal("(") + calc_expr + Literal(")")) | number

            # calc_expr :: atom (calc_operator + calc_expr)*
            calc_expr << calc_atom + ZeroOrMore(calc_ops + calc_expr)

            #
            text_expr = Forward()
            text_expr << OneOrMore(text + compare_ops) + text

            # comp_expr :: bool (comp_operator bool)*
            comp_expr = b + ZeroOrMore((compare_ops | extra_ops) + b)
            comp_expr_advanced = Literal("(") + comp_expr + Literal(")") | comp_expr

            # _condition :: calc_expr comp_operator | comp_expr
            condition = Forward()
            condition << ((calc_expr + compare_ops + calc_expr | comp_expr_advanced | text_expr)
                          + ZeroOrMore(extra_ops + condition))

            # final_condition :: _condition (full input used)
            final_condition = condition + stringEnd()

            final_condition.parseString(expression).asList()
            return True

        except Exception as e:
            return False