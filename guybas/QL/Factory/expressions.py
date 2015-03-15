# Factory for creating Expression elements out of parsed tokens

import QL.AST.Expressions.Elements.operator as operator
import QL.AST.Expressions.Elements.variable as variable
import QL.AST.Expressions.Elements.bool as boolean
import QL.AST.Expressions.Elements.number as number
import QL.AST.Expressions.Elements.text as text
import QL.Factory.forms as form
import QL.AST.Expressions.expression as expression
import QL.AST.Expressions.sub_expression as ce
import QL.AST.Expressions.Elements.element as el
import pyparsing as pp

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

def remove_parenthesis(e):
    l = []
    for x in e:
        if type(x) == list:
            l += (remove_parenthesis(x[0]))
        else:
            l.append(x)
    return l

def make_add_expression(tokens):
    print("add" + str(tokens))

def make_mul_expression(tokens):
    print(tokens)

def make_expression2(tokens):
    print("new expression")
    print(tokens)

def make_sub_expression(tokens):
    return ce.SubExpression(tokens)


def make_expression(tokens):
    l = []
    for x in tokens:
        if type(x) == pp.ParseResults:
            l.append(expression.Expression(make_expression(x)))
        elif isinstance(x, el.Element):
            l.append(x)
        else:
            l.append(ce.SubExpression(x))
    return l


