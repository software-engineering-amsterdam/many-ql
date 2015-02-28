import unittest
from Grammar.form import *
from AST.operators import *


class TestBasicGrammar(unittest.TestCase):
    def test_id(self):
        # Test simple id
        result = BasicTypes.characters.parseString("this_is_an_id").asList()
        self.assertEqual(result, ["this_is_an_id"])

        # ids cannot have spaces
        result = BasicTypes.characters.parseString("this_is_an_id a").asList()
        self.assertIsNot(result, ["this_is_and_id a"])

    def test_sentence(self):
        # Test simple sentence, btw between every word (or punctuation) comes a space
        result = BasicTypes.sentence.parseString("this is a sentence.").asList()
        self.assertEqual(result, ["this is a sentence ."])

    @unittest.expectedFailure
    def test_sentence_fail(self):
        # This sentence has no end sign and therefore will fail
        result = BasicTypes.sentence.parseString("this is a sentence").asList()
        self.assertEqual(result, ["this is a sentence"])

    def test_sentences(self):
        # Multiple sentences with escaped characters
        result = BasicTypes.sentences.parseString("this is a sentence. Is this another one? Can we escape \? , \!  and \. ?").asList()
        self.assertEqual(result, ["this is a sentence .", "Is this another one ?", 'Can we escape ? , ! and . ?'])

    def test_answer_format(self):
        # Test the three different type of answer possibilities
        result = FormFormat.answerR.parseString("bool").asList()
        self.assertEqual(result, ["bool"])

        result = FormFormat.answerR.parseString("text").asList()
        self.assertEqual(result, ["text"])

        result = FormFormat.answerR.parseString("number").asList()
        self.assertEqual(result, ["number"])

    @unittest.expectedFailure
    def test_answer_format_fail(self):
        # Not an answer possibility
        result = FormFormat.answerR.parseString("set").asList()
        self.assertEqual(result, ["set"])


class TestExpressionGrammar(unittest.TestCase):

    def test_simple_expression(self):
        result = Expressions.expr.parseString(" id == True")
        result = ExpressionFactory.make_sub_expression(result)
        self.assertIsInstance(result, SimpleExpression)

        s = result.as_list()
        self.assertEqual(s, ["id", "==", True])

    def test_complex_expression(self):
        result = Expressions.expr.parseString("4 / 2 + (3 - 1) * 4")
        result = ExpressionFactory.make_sub_expression(result)
        self.assertEquals(result.as_list(), [4, "/", 2, "+", [3, "-", 1], "*", 4])

    @unittest.expectedFailure
    def test_complex_expression_fail1(self):
        result = Expressions.expr.parseString("4 * - 1")
        result = ExpressionFactory.make_sub_expression(result)
        self.assertEquals(result.as_list(), [4, "*", "-", 1])

    def test_expression_malformed(self):
        # not valid expression, but it is valid syntax
        result = Expressions.expr.parseString("4 + True")
        result = ExpressionFactory.make_sub_expression(result)
        self.assertEquals(result.as_list(), [4, "+", True])



# Execute tests
suite = unittest.TestLoader().loadTestsFromTestCase(TestBasicGrammar)
suite.addTests(unittest.TestLoader().loadTestsFromTestCase(TestExpressionGrammar))

unittest.TextTestRunner(verbosity=2).run(suite)
