import unittest
from Grammar.form import *


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

    def test_simple_expression(self):
        result = Expressions.expr.parseString("1 + 2").asList()
        self.assertIsInstance(result[1], Operator)

        result[1] = (result[1]).operator
        self.assertEqual(result, [1, "+", 2])

    def test_complex_expression(self):
        result = Expressions.expr.parseString("5 * (3 + 4) - 3 + (2 / 1) == True").asList()
        # create string representations of the operator objects
        result[1] = (result[1]).operator
        result[2][1] = (result[2][1]).operator
        result[3] = result[3].operator
        result[5] = result[5].operator
        result[6][1] = (result[6][1]).operator
        result[7] = result[7].operator
        self.assertEqual(result, [5, "*", [3, "+", 4], "-", 3, "+", [2, "/", 1], "==", True])

    def test_boolean_expression(self):
        result = Expressions.expr.parseString("hummus == True").asList()
        result[1] = (result[1]).operator
        self.assertEqual(result, ["hummus", "==", True])

        result = Expressions.expr.parseString("True == hummus").asList()
        result[1] = (result[1]).operator
        self.assertEqual(result, [True, "==", "hummus"])

        result = Expressions.expr.parseString("True").asList()
        self.assertEqual(result, [True])

        result = Expressions.expr.parseString("hummus").asList()
        self.assertEqual(result, ["hummus"])

    def test_complex_boolean_expression(self):
        result = Expressions.expr.parseString("good && bad || (1 + 3) > (2 * 1) ").asList()
        result[1] = (result[1]).operator
        result[3] = (result[3]).operator

        result[4][1] = (result[4][1]).operator
        result[5] = result[5].operator
        result[6][1] = (result[6][1]).operator
        self.assertEqual(result, ["good", "&&", "bad", "||", [1, "+", 3], ">", [2, "*", 1]])

    def test_answer_format(self):
        result = FormFormat.answerR.parseString("bool").asList()
        self.assertEqual(result, ["bool"])

        result = FormFormat.answerR.parseString("text").asList()
        self.assertEqual(result, ["text"])

        result = FormFormat.answerR.parseString("number").asList()
        self.assertEqual(result, ["number"])

    @unittest.expectedFailure
    def test_answer_format_fail(self):
        result = FormFormat.answerR.parseString("set").asList()
        self.assertEqual(result, ["set"])





# Execute tests
suite = unittest.TestLoader().loadTestsFromTestCase(TestGrammar)
suite.addTests(unittest.TestLoader().loadTestsFromTestCase(TestAST))
unittest.TextTestRunner(verbosity=2).run(suite)