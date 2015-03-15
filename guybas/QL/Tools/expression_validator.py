# Expression validator
import pyparsing as pp
import QL.Grammar.constants as constants


def validator(expression):
    try:
        b = pp.Literal(constants.GrammarConstants.BOOL)
        number = pp.Literal(constants.GrammarConstants.NUMBER)
        text = pp.Literal(constants.GrammarConstants.TEXT)

        plus_op = pp.Literal("+")
        calc_ops = pp.oneOf("- / *") | plus_op

        compare_ops = pp.oneOf("> >= < <= == not")
        extra_ops = pp.oneOf("and or")
        calc_expr = pp.Forward()

        # atom :: ( calc_expr ) | number
        calc_atom = (pp.Literal("(") + calc_expr + pp.Literal(")")) | number

        # calc_expr :: atom (calc_operator + calc_expr)*
        calc_expr << calc_atom + pp.ZeroOrMore(calc_ops + calc_expr)

        #
        text_expr = pp.Forward()
        text_expr << pp.OneOrMore(text + compare_ops) + text

        # comp_expr :: bool (comp_operator bool)*
        comp_expr = b + pp.ZeroOrMore((compare_ops | extra_ops) + b)
        comp_expr_advanced = pp.Literal("(") + comp_expr + pp.Literal(")") | comp_expr

        # _condition :: calc_expr comp_operator | comp_expr
        condition = pp.Forward()
        condition << ((calc_expr + compare_ops + calc_expr | comp_expr_advanced | text_expr)
                      + pp.ZeroOrMore(extra_ops + condition))

        # final_condition :: _condition (full input used)
        final_condition = condition + pp.stringEnd()

        final_condition.parseString(expression).asList()
        return True

    except Exception as e:
        return False