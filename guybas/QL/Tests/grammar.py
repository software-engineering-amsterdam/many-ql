import unittest

import QL.Grammar.basic_types as basic_types
import QL.Grammar.grammar as forms
import QL.Grammar.expression as expressions
import QL.AST.Expressions.expression_interface as simple_expression
import QL.AST.Statements.AnswerTypes.bool as b
import QL.AST.Statements.AnswerTypes.text as t
import QL.AST.Statements.AnswerTypes.number as n
import QL.Grammar.Factory.expressions as efactory


class TestBasicGrammar(unittest.TestCase):
    def test_grammar_id(self):
        # Test simple _id
        result = basic_types.BasicTypes.characters.parseString("this_is_an_id").asList()
        self.assertEqual(result, ["this_is_an_id"])

        # ids cannot have spaces
        result = basic_types.BasicTypes.characters.parseString("this_is_an_id a").asList()
        self.assertIsNot(result, ["this_is_and_id a"])

    def test_grammar_sentence(self):
        # Test simple sentence, btw between every word (or punctuation) comes a space
        result = basic_types.BasicTypes.sentence.parseString("this is a sentence.").asList()
        self.assertEqual(result, ["this is a sentence ."])

    @unittest.expectedFailure
    def test_grammar_sentence_fail(self):
        # This sentence has no end sign and therefore will fail
        result = basic_types.BasicTypes.sentence.parseString("this is a sentence").asList()
        self.assertEqual(result, ["this is a sentence"])

    def test_grammar_sentences(self):
        # Multiple sentences with escaped characters
        result = basic_types.BasicTypes.sentences.parseString("this is a sentence. Is this another one? Can we escape \? , \!  and \. ?").asList()
        self.assertEqual(result, ["this is a sentence .", "Is this another one ?", 'Can we escape ? , ! and . ?'])

    def test_grammar_answer_format(self):
        # Test the three different _type of _answer possibilities
        result = forms.Grammar.answerR.parseString("bool")
        self.assertIsInstance(result[0], b.Bool)

        result = forms.Grammar.answerR.parseString("text")
        self.assertIsInstance(result[0], t.Text)

        result = forms.Grammar.answerR.parseString("number")
        self.assertIsInstance(result[0], n.Number)

    @unittest.expectedFailure
    def test_grammar_answer_format_fail(self):
        # Not an _answer possibility
        result = forms.Grammar.answerR.parseString("set").asList()
        self.assertEqual(result, ["set"])


class TestExpressionGrammar(unittest.TestCase):

    def test_expression_simple(self):
        result = expressions.Expressions.expr.parseString(" statement_id == True")
        result = efactory.ExpressionFactory.make_sub_expression(result)
        self.assertIsInstance(result, simple_expression.IExpression)

        s = result.as_list()
        self.assertEqual(s, ["statement_id", "==", True])

    def test_expression_complex(self):
        result = expressions.Expressions.expr.parseString("4 / 2 + (3 - 1) * 4")
        self.assertEquals(result[0].as_list(), [4, "/", 2, "+", [3, "-", 1], "*", 4])

    @unittest.expectedFailure
    def test_expression_complex_fail1(self):
        result = expressions.Expressions.expr.parseString("4 * - 1")
        self.assertEquals(result[0].as_list(), [4, "*", "-", 1])

    def test_expression_malformed(self):
        # not valid _expression, but it is valid syntax
        result = expressions.Expressions.expr.parseString("4 + True")
        self.assertEquals(result[0].as_list(), [4, "+", True])

    def test_expression_print(self):
        result = expressions.Expressions.expr.parseString("1 + 2 - (3 * 4) / 6")
        self.assertEqual(result[0].string_presentation(), "1 + 2 - (3 * 4) / 6")

    def test_expression_type(self):
        result = expressions.Expressions.expr.parseString("1 + 2 - (3 * 4) / 6 == True")
        self.assertEqual(result[0].return_type_string({}),
                         "number + number - "
                         "(number * number) "
                         "/ number == bool")

    def test_expression_type_variable(self):
        result = expressions.Expressions.expr.parseString("bas + 5 == True")
        self.assertEqual(result[0].return_type_string({"bas" : "number"}),
                         "number + number == bool")

    def test_expression_dependencies(self):
        result = expressions.Expressions.expr.parseString("cool + awesome && 1 == True")
        self.assertEqual(result[0].get_dependencies(), ["cool", "awesome"])
