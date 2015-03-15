import pyparsing as pp
from QL.Grammar.grammar import *
import QL.Factory.expressions as e


# value :: bool | number | statement_id | text
value = (bool.setParseAction(expression_factory.make_bool) |
         number.setParseAction(expression_factory.make_number) |
         statement_id_var.setParseAction(expression_factory.make_variable) |
         text.setParseAction(expression_factory.make_text))

not_op = pp.Literal("!").setParseAction(e.make_operator)
mul_op = pp.oneOf('* /').setParseAction(e.make_operator)
plus_op = pp.oneOf('+ -').setParseAction(e.make_operator)
comp_op = pp.oneOf('> >= == < <=').setParseAction(e.make_operator)
extra_op = pp.oneOf('&& ||').setParseAction(e.make_operator)

expr = pp.operatorPrecedence(value,
    [(not_op, 1, pp.opAssoc.RIGHT),
     (mul_op, 2, pp.opAssoc.LEFT),
     (plus_op, 2, pp.opAssoc.LEFT),
     (comp_op, 2, pp.opAssoc.RIGHT),
     (extra_op, 2, pp.opAssoc.LEFT)]
    )

test = ["9 + 2 + 3",
        "9 + !2 * 3",
        "(9 + 2) * 3 == 33 && 1"]

for t in test:
    temp = e.make_expression(expr.parseString(t))
