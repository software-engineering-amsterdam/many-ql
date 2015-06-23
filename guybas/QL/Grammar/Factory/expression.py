# Factory for creating Expression elements out of parsed subtrees
# As pyparsing returns a list of subtrees the factory is needed so the AST is independent of the parsing process

# import all expression operations and primitives
from QL.AST.Expressions.Operations.Arithmetic import *
from QL.AST.Expressions.Operations.Compare import *
from QL.AST.Expressions.Operations.Logical import *
from QL.AST.Expressions.Primitives import *
from QL.AST.Expressions.Types import *

# to create sentences
import QL.Grammar.Factory.form as form


#
# Types of expressions
#

def make_bool_type():
    return bool_type.Bool()


def make_number_type():
    return number_type.Number()


def make_text_type():
    return text_type.Text()


#
# Primitive values of expressions
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
        return bool_prim.Bool(True)
    else:
        return bool_prim.Bool(False)


def make_text(subtrees):
    t = form.make_sentence(subtrees)
    return text.Text(t)


#
# Operations
#

# As pyparsing is not able to make a distinction between operators with the same precedence we need to do it manually.
# Also a sub expression can exist out of multiple operators (+ or - below) and operands so therefore a for loop
# is needed. Every operator is made using the last operator (or first primitive) on the left and the found operand on
# the right.
def make_add_min_expression(subtrees):
    subtrees = subtrees[0]  # it returns always a list of lists with the outer list having just one element..
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


def make_compare_expression(subtrees):
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
    x = expressions[0]

    # create for every compare expression a new and-expression
    # so, for example 1 < 2 < 3 becomes (1 < 2) and (2  < 3)
    for i in range(1, len(expressions)):
        x = and_op.And(x, expressions[i])
    return x


def make_logic_expression(subtrees):
    subtrees = subtrees[0]
    x = subtrees[0]
    for i in range(1, len(subtrees)-1, 2):
        if subtrees[i] == "and":
            x = and_op.And(x, subtrees[i + 1])
        else:
            x = or_op.Or(x, subtrees[i + 1])
    return x


def make_not_expression(subtrees):
    subtrees = subtrees[0]
    return not_op.Not(subtrees[1])