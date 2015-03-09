# Expression validator
from pyparsing import *
from QL.Factory.forms import *
import QL.AST.Elements.constants as econstants

class ExpressionValidator:

    @staticmethod
    def validator(expression):
        try:
            b = Literal(econstants.ElementsConstants.BOOL)
            number = Literal(econstants.ElementsConstants.NUMBER)
            text = Literal(econstants.ElementsConstants.TEXT)
            op = Literal(econstants.ElementsConstants.CALC_OP)
            compare = Literal(econstants.ElementsConstants.COMP_OP)
            extra = Literal(econstants.ElementsConstants.EXTRA_OP)

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
            comp_expr_advanced = Literal("(") + comp_expr + Literal(")") | comp_expr

            # _condition :: calc_expr comp_operator | comp_expr
            condition = Forward()
            condition << \
                (calc_expr + compare + calc_expr | \
                 comp_expr_advanced | text_expr) + ZeroOrMore(extra + condition)

            # final_condition :: _condition (full input used)
            final_condition = condition + stringEnd()

            final_condition.parseString(expression).asList()
            return True

        except Exception as e:
            return False