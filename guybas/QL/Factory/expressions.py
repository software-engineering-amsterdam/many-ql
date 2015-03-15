# Factory for creating Expression elements out of parsed tokens

import QL.AST.Expressions.simple_expression as simple_expression
import QL.AST.Expressions.complex_expression as complex_expression
import QL.AST.Elements.operator as operator
import QL.AST.Elements.variable as variable
import QL.AST.Elements.bool as boolean
import QL.AST.Elements.number as number
import QL.AST.Elements.text as text
import QL.Factory.forms as form


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


def make_sub_expression(tokens):
    return simple_expression.SimpleExpression(tokens)


def make_expression(tokens):
    return complex_expression.ComplexExpression(tokens)
