from grammar import *
from ast import *
import unittest


class TestGrammar(unittest.TestCase):
    def test_id(self):
        result = str(BasicTypes.characters.parseString("this_is_an_id"))
        self.assertEqual(result, "[\'this_is_an_id\']")

        result = str(BasicTypes.characters.parseString("this_is_an_id a"))
        self.assertIsNot(result, "[\'this_is_an_id a\']")

    def test_sentence(self):
        result = str(BasicTypes.sentence.parseString("this is a sentence."))
        self.assertEqual(result, "[\'this is a sentence .']")

    @unittest.expectedFailure
    def test_sentence_fail(self):
        result = str(BasicTypes.sentence.parseString("this is a sentence"))
        self.assertEqual(result, "[\'this is a sentence ']")

    def test_sentences(self):
        result = str(BasicTypes.sentences.parseString("this is a sentence. Is this another one? Can we escape \? ?"))
        self.assertEqual(result, "['this is a sentence .', 'Is this another one ?', 'Can we escape ? ?']" )

    def test_number(self):
        result = QuestionTypes.number.parseString("1").asList()
        self.assertEqual(result, [1])

    def test_boolean(self):
        result = QuestionTypes.boolean.parseString("True").asList()
        self.assertEqual(result, [True])

    @unittest.expectedFailure
    def test_boolean_fail(self):
        result = QuestionTypes.boolean.parseString("False").asList()
        self.assertEqual(result, ["False"])

    def test_expressions(self):
        result = Expressions.expr.parseString("1 + 2").asList()
        self.assertIsInstance(result[1], Operator)

        result[1] = (result[1]).operator
        self.assertEqual(result, [1, "+", 2])

        result = Expressions.expr.parseString("(3 * (4 - 1) == 9)").asList()
        result[1] = (result[1]).operator
        result[3] = (result[3]).operator
        self.assertEqual(result, [3, [4, "-", 1], "==", 9])

suite = unittest.TestLoader().loadTestsFromTestCase(TestGrammar)
unittest.TextTestRunner(verbosity=2).run(suite)