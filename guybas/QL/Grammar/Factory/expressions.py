# Factory for creating Expression elements out of parsed subtrees

# TODO fix these imports
import QL.AST.Expressions.Primitives.variable as variable
import QL.AST.Expressions.Primitives.bool as boolean
import QL.AST.Expressions.Primitives.number as number
import QL.AST.Expressions.Primitives.text as text
import QL.Grammar.Factory.forms as form

# import all expression operations
from QL.AST.Expressions.Operations import *


#
# Primitive types
#

def make_variable(subtrees):
    v = subtrees[0]
    return variable.Variable(v)


def make_number(subtrees):
    n = int(subtrees[0])
    return number.Number(n)


def make_bool(subtrees):
    value = subtrees[0]
    if value == "True":
        return boolean.Bool(True)
    else:
        return boolean.Bool(False)


def make_text(subtrees):
    t = form.make_sentence(subtrees)
    return text.Text(t)


#
# Operations
#

# As pyparsing is not able to make a distinction between operators with the same precedence we need to do it manually
# Also a sub expression can exist out of multiple operators (+ or - here) and operands so therefore the for loop
# Every operator is made using the last operator (or first primitive) on the left and the found operand on the right
# (When left associative)
def make_add_min_expression(subtrees):
    subtrees = subtrees[0]
    x = subtrees[0]
    for i in range(1, len(subtrees)-1, 2):
        if subtrees[i] == "+":
            x = add.Add(x, subtrees[i + 1])
        else:
            x = minus.Minus(x, subtrees[i + 1])
    return x


def make_mul_expression(subtrees):
    subtrees = subtrees[0]
    x = subtrees[0]
    for i in range(1, len(subtrees)-1, 2):
        if subtrees[i] == "*":
            x = multiplication.Multiplication(x, subtrees[i + 1])
        else:
            x = division.Division(x, subtrees[i + 1])
    return x


# TODO check if this is done correctly w.r.t. associativity
def make_compare(subtrees):
    subtrees = subtrees[0]
    x = subtrees[0]
    print(len(subtrees))
    for i in range(1, len(subtrees)-1, 2):
        if subtrees[i] == ">":
            x = greater.Greater(x, subtrees[i + 1])
        elif subtrees[i] == "<":
            x = less.Less(x, subtrees[i + 1])
        elif subtrees[i] == ">=":
            x = greater_equal.GreaterEqual(x, subtrees[i + 1])
        elif subtrees[i] == "<=":
            return less_equal.LessEqual( x, subtrees[i + 1])
        elif subtrees[i] == "==":
            x = equal.Equal(x, subtrees[i + 1])
        else:
            raise Exception("make_compare got wrong input")
    return x


def make_compare2(subtrees):
    subtrees = subtrees[0]
    expressions = []
    for i in range(0, len(subtrees)-1, 2):

        if subtrees[i + 1] == ">":
            expressions.append(greater.Greater(subtrees[i], subtrees[i + 2]))
        elif subtrees[i+ 1] == "<":
            expressions.append(less.Less(subtrees[i], subtrees[i + 2]))
        elif subtrees[i+ 1] == ">=":
            expressions.append(greater_equal.GreaterEqual(subtrees[i], subtrees[i + 2]))
        elif subtrees[i+ 1] == "<=":
            expressions.append(less_equal.LessEqual(subtrees[i], subtrees[i + 2]))
        elif subtrees[i+ 1] == "==":
            expressions.append(equal.Equal(subtrees[i], subtrees[i + 2]))
        else:
            raise Exception("make_compare got wrong input")
    x = expressions[0]
    # create for every compare expression a new and expression
    # so, for example 1 < 2 < 3 becomes (1 < 2) and (2  < 3)
    for i in range(1, len(expressions)):
        x = and_op.And(x, expressions[i])
    return x


def make_extra(subtrees):
    subtrees = subtrees[0]
    x = subtrees[0]
    for i in range(1, len(subtrees)-1, 2):
        if subtrees[i] == "and":
            x = and_op.And(x, subtrees[i + 1])
        else:
            x = or_op.Or(x, subtrees[i + 1])
    return x


def make_not(subtrees):
    subtrees = subtrees[0]
    return not_op.Not("not", subtrees[1])