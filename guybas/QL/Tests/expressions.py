import unittest

import QL.Grammar.grammar as grammar
from QL.AST.Expressions.Operations import *
from QL.AST.Expressions.Primitives import *

import QL.Grammar.Factory.expressions as factory


class TestExpressionGrammar(unittest.TestCase):

    def test_expression_simple(self):
        result = grammar.expr.parseString(" statement_id == True")
        result = factory.make_sub_expression(result)
        self.assertIsInstance(result, simple_expression.IExpression)

        s = result.as_list()
        self.assertEqual(s, ["statement_id", "==", True])

    def test_expression_complex(self):
        result = grammar.expr.parseString("4 / 2 + (3 - 1) * 4")
        self.assertEquals(result[0].as_list(), [4, "/", 2, "+", [3, "-", 1], "*", 4])

    @unittest.expectedFailure
    def test_expression_complex_fail1(self):
        result = grammar.expr.parseString("4 * - 1")
        self.assertEquals(result[0].as_list(), [4, "*", "-", 1])

    def test_expression_malformed(self):
        # not valid _expression, but it is valid syntax
        result = grammar.expr.parseString("4 + True")
        self.assertEquals(result[0].as_list(), [4, "+", True])

    def test_expression_print(self):
        result = grammar.expr.parseString("1 + 2 - (3 * 4) / 6")
        self.assertEqual(result[0].string_presentation(), "1 + 2 - (3 * 4) / 6")

    def test_expression_type(self):
        result = grammar.expr.parseString("1 + 2 - (3 * 4) / 6 == True")
        self.assertEqual(result[0].return_type_string({}),
                         "number + number - "
                         "(number * number) "
                         "/ number == bool")

    def test_expression_type_variable(self):
        result = grammar.expr.parseString("bas + 5 == True")
        self.assertEqual(result[0].return_type_string({"bas" : "number"}),
                         "number + number == bool")

    def test_expression_dependencies(self):
        result = grammar.expr.parseString("cool + awesome && 1 == True")
        self.assertEqual(result[0].get_dependencies(), ["cool", "awesome"])