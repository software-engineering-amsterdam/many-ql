# Grammar of expressions

from pyparsing import nums, Forward, ZeroOrMore
from Factory.expressions import *


class Expressions:

    # id :: characters
    id = Word("1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_")

    # bool :: True | False
    bool = Literal("True") | Literal("False")

    # number :: [0-9]
    number = Word(nums)

    # value :: bool | number | id
    value = \
        bool.setParseAction(ExpressionFactory.make_bool) | \
        number.setParseAction(ExpressionFactory.make_number) | \
        id.setParseAction(ExpressionFactory.make_variable)

    # operators   :: + | - | / | * | > | >= | < | <= | == | && | || | !
    operator = \
        oneOf('+ - / *').setParseAction(ExpressionFactory.make_calc_operator) | \
        oneOf(" > >= < <= == && || !").setParseAction(ExpressionFactory.make_comp_operator)

    operator_name = 'operator'

    expr = Forward()

    # atom :: ( expr ) | value
    atom = (Suppress("(") + expr + Suppress(")")).setParseAction(ExpressionFactory.make_expression) | value

    # expr :: atom | (operator expr)*
    expr << (atom + ZeroOrMore(operator + expr)).setParseAction(ExpressionFactory.make_sub_expression)
