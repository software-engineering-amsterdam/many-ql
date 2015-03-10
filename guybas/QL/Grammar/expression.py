# Grammar of expressions

import pyparsing as pp
import QL.Factory.expressions as e


class Expressions:

    # id :: [1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_]
    id = pp.Word("1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_")

    # bool :: True | False
    bool = pp.Literal("True") | pp.Literal("False")

    # text
    text = pp.Suppress("\"") + pp.OneOrMore(pp.Word(pp.alphanums)) + pp.Suppress("\"")

    # number :: [0-9]
    number = pp.Word(pp.nums)

    # value :: bool | number | id
    value = (bool.setParseAction(e.ExpressionFactory.make_bool) |
             number.setParseAction(e.ExpressionFactory.make_number) |
             id.setParseAction(e.ExpressionFactory.make_variable) |
             text.setParseAction(e.ExpressionFactory.make_text))

    # operator :: + | - | / | * | and | or | not | > | >= | < | <= | ==
    operator = pp.oneOf('+ - / * and or not > >= < <= ==').setParseAction(e.ExpressionFactory.make_operator)

    expr = pp.Forward()

    # atom :: ( expr ) | value
    atom = (pp.Suppress("(") + expr + pp.Suppress(")")).setParseAction(e.ExpressionFactory.make_expression) | value

    # expr :: atom | (operator expr)*
    expr << (atom + pp.ZeroOrMore(operator + expr)).setParseAction(e.ExpressionFactory.make_sub_expression)
