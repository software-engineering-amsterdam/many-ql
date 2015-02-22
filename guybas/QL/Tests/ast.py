import unittest
from Grammar.form import *
from AST.form import *
from AST.operators import *


class TestAST(unittest.TestCase):

    def generate_statements(self):
        q1 = Question("1a", "bool", "Is this a statements?")
        q2 = Question("2a", "text", "What?")
        q3 = Question("3a", "number", "Why!")
        q4 = Question("4a", "bool", "when")
        q5 = Question("5a", "text", "who.")
        q6 = Question("6a", "number", "where?")

        is_op = Operator("==")
        plus_op = Operator("+")

        i1 = IfBlock(["q1", is_op, True], [q2, q3])
        i2 = IfElseBlock("q2",  plus_op, "q6", [q4], [q5])

        f = Form("example", "", [q1, i1, q6, i2])
        return f

    def test_question(self):
        result = (FormFormat.question.parseString("Question why (text) : What do you like about hummus?")).asList()
        self.assertIsInstance(result[0], Question)
        self.assertEqual(result[0].id, "why")
        self.assertEqual(result[0].type, "text")
        self.assertEqual(result[0].label, "What do you like about hummus ?")

    def test_if_question(self):
        result = (FormFormat.pIf.parseString("if (con == True) {  Question trans (bool) : Will transitive closure work? }")).asList()
        self.assertIsInstance(result[0], IfBlock)

    @unittest.expectedFailure
    def test_if_question_fail(self):
        result = (FormFormat.pIfElse.parseString("if (con == True) {  Question trans (bool) : Will transitive closure work? }")).asList()
        self.assertIsInstance(result[0], IfBlock)

    def test_else_questions(self):
        result = (FormFormat.pIfElse.parseString("if (con == True) {  Question trans (bool) : Will transitive closure work? } else { Question iselse (bool) : Is this an else statements? }")).asList()
        self.assertIsInstance(result[0], IfElseBlock)

    def test_form(self):
        form_as_parse_results = FormFormat.form.ignore(BasicTypes.comment).parseFile("test_example.ql")
        result = FormFactory.make_form(form_as_parse_results)
        self.assertIsInstance(result, Form)

        self.assertEqual(result.introduction,"Welcome to my questionnaire .")
        self.assertEqual(result.name, "Name_of_Questionnaire")
        self.assertTrue(len(result.questions) == 5)

    def test_dependency_collection(self):
        pass

    def test_id_collection(self):
        pass

    def test_label_collection(self):
        pass