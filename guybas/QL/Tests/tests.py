import unittest

from AST.factory import *


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


class TestAST(unittest.TestCase):

    def test_question(self):
        result = (FormFormat.question.parseString("Question why (text) : What do you like about hummus?")).asList()
        self.assertIsInstance(result[0], Question)
        self.assertEqual(result[0].id, "why")
        self.assertEqual(result[0].type, "text")
        self.assertEqual(result[0].label, "What do you like about hummus ?")

    def test_if_question(self):
        result = (FormFormat.pIf.parseString("if (con == True) {  Question trans (bool) : Will transitive closure work? }")).asList()
        self.assertIsInstance(result[0], AdvancedQuestions)

    @unittest.expectedFailure
    def test_if_question_fail(self):
        result = (FormFormat.pIfElse.parseString("if (con == True) {  Question trans (bool) : Will transitive closure work? }")).asList()
        self.assertIsInstance(result[0], AdvancedQuestions)

    def test_else_questions(self):
        result = (FormFormat.pIfElse.parseString("if (con == True) {  Question trans (bool) : Will transitive closure work? } else { Question iselse (bool) : Is this an else statements? }")).asList()
        self.assertIsInstance(result[0], AdvancedQuestions)

    def test_form(self):
        form_as_parse_results = FormFormat.form.ignore(BasicTypes.comment).parseFile("test_example.ql")
        result = Factory.make_form(form_as_parse_results)
        self.assertIsInstance(result, Form)

        self.assertEqual(result.introduction,"Welcome to my questionnaire .")
        self.assertEqual(result.name, "Name_of_Questionnaire")
        self.assertTrue(len(result.questions) == 5)

    def test_get_dependencies(self):
        pass

    def test_all_ids(self):
        pass

    def test_all_dependencies(self):
        pass


# Execute tests
suite = unittest.TestLoader().loadTestsFromTestCase(TestGrammar)
suite.addTests(unittest.TestLoader().loadTestsFromTestCase(TestAST))
unittest.TextTestRunner(verbosity=2).run(suite)