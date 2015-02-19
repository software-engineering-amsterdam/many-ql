# Grammar of expressions
from Grammar.basic_types import *
from AST.factory import *


class Expressions:

    # id :: characters
    id = BasicTypes.characters

    # value :: bool | number | id
    value = QuestionTypes.bool | QuestionTypes.number | id

    # operators   :: + | - | / | * | > | >= | < | <= | == | && | || | !
    operator = oneOf('+ - / * > >= < <= == && || !').setParseAction(ExpressionFactory.make_operator)
    operatorName = 'operator'

    expr = Forward()

    # atom :: ( expr ) | value
    atom = Group(Suppress("(") + expr + Suppress(")")) | value

    # expr :: atom | (operator expr)*
    expr << atom + ZeroOrMore(operator + expr)

    # condition :: expr
    condition = Group(expr)