# Grammar of expressions
from Grammar.basic_types import *
from AST.factory import *


class Expressions:

    # id :: characters
    id = Word("1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_")
    bool = Literal("True") | Literal("False")
    number = Word(nums)

    # value :: bool | number | id
    value = bool.setParseAction(ExpressionFactory.make_bool) | \
            number.setParseAction(ExpressionFactory.make_number) | \
            id.setParseAction(ExpressionFactory.make_variable)

    # operators   :: + | - | / | * | > | >= | < | <= | == | && | || | !
    operator = oneOf('+ - / * > >= < <= == && || !').setParseAction(ExpressionFactory.make_operator)
    operator_name = 'operator'

    expr = Forward()

    # atom :: ( expr ) | value
    atom = Group(Suppress("(") + expr + Suppress(")")) | value

    # expr :: atom | (operator expr)*
    expr << atom + ZeroOrMore(operator + expr)

    # condition :: expr
    condition = Group(expr)