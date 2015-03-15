# Factory for creating Expression elements out of parsed tokens

import QL.AST.Expressions.Elements.operator as operator
import QL.AST.Expressions.Elements.variable as variable
import QL.AST.Expressions.Elements.bool as boolean
import QL.AST.Expressions.Elements.number as number
import QL.AST.Expressions.Elements.text as text
import QL.Factory.forms as form
import QL.AST.Expressions.expression as expression

# Factory for creating expressions

def make_variable(tokens):
    v = tokens[0]
    return variable.Variable(v)


def make_number(tokens):
    n = int(tokens[0])
    return number.Number(n)


def make_operator(tokens):
    op = tokens[0]
    return operator.Operator(op)


def make_bool(tokens):
    value = tokens[0]
    if value == "True":
        return boolean.Bool(True)
    else:
        return boolean.Bool(False)


def make_text(tokens):
    t = form.make_sentence(tokens)
    return text.Text(t)


def make_expression(tokens):
    return expression.Expression(tokens)
