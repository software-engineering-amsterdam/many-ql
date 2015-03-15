import pyparsing as pp

el = pp.Word(pp.alphanums)
expr = pp.Forward()

ex = el | expr

ex1 = pp.Forward()
ex1 <<= pp.ZeroOrMore(ex + pp.Literal("not")) + ex

ex2 = pp.Forward()
ex2 <<= pp.ZeroOrMore(ex1 + pp.oneOf("* /")) + ex1

ex3 = pp.Forward()
ex3 <<= pp.ZeroOrMore(ex2 + pp.oneOf("+ -")) + ex2

ex4 = pp.Forward()
ex4 <<= pp.ZeroOrMore(ex3 + pp.oneOf(">= > == < <=")) + ex3

ex5 = pp.Forward()
ex5 <<= pp.ZeroOrMore(ex4 + pp.oneOf("and or")) + ex4


expr <<= pp.Group(pp.Suppress("(") + ex5 + pp.Suppress(")")) | ex5
exxxxx = expr + pp.stringEnd()

test = ["( 1 )", "1 / (2 - 1)", "1 + 2 / 3", "3 - ((2 / 3)) + 2", "1 * (2 + 3) * 4 == 3"]

for t in test:
    temp = exxxxx.parseString(t)
    print(temp)

# import pyparsing as pp
# from QL.Grammar.grammar import *
# import QL.Factory.expressions as e
#
#
# # value :: bool | number | statement_id | text
# value = (bool.setParseAction(expression_factory.make_bool) |
#          number.setParseAction(expression_factory.make_number) |
#          statement_id_var.setParseAction(expression_factory.make_variable) |
#          text.setParseAction(expression_factory.make_text))
#
# not_op = pp.Literal("!").setParseAction(e.make_operator)
# mul_op = pp.oneOf('* /').setParseAction(e.make_operator)
# plus_op = pp.oneOf('+ -').setParseAction(e.make_operator)
# comp_op = pp.oneOf('> >= == < <=').setParseAction(e.make_operator)
# extra_op = pp.oneOf('&& ||').setParseAction(e.make_operator)
#
# expr = pp.infixNotation\
#         (value,
#          [(not_op, 1, pp.opAssoc.RIGHT),
#              (mul_op, 2, pp.opAssoc.LEFT),
#              (plus_op, 2, pp.opAssoc.LEFT),
#              (comp_op, 2, pp.opAssoc.RIGHT),
#              (extra_op, 2, pp.opAssoc.LEFT)
#          ]
#     ).setParseAction(e.make_sub_expression)
#
# test = ["9 + 2 + 3",
#         "(9 + !2 * 3)",
#         "((9 + 2) * 3 == 33 && 1)"]
#
#
# def make_expressions(tokens):
#     l = []
#     for t in tokens:
#         if type(t) == pp.ParseResults:
#             l.append(e.make_sub_expression(make_expressions(t)))
#         else:
#             l.append(e.make_expression(t))
#     return l
#
# for t in test:
#     temp = expr.parseString(t)
#     print(temp)
