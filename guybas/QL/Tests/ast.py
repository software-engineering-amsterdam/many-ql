import unittest
from QL.Grammar.form import *
from QL.AST.form import *
from QL.AST.Elements import *
from QL.Factory.expressions import *
from QL.Factory.forms import *


class GenerateStatements:
    @staticmethod
    def generate_statements():
            q1 = Question("1a", "bool", "Is this a _statements?")
            q2 = Question("2a", "text", "What?")
            q3 = Question("3a", "number", "Why!")
            q4 = Question("4a", "bool", "when")
            q5 = Question("5a", "text", "who.")
            q6 = Question("6a", "number", "where?")

            is_op = Operator("==")
            plus_op = Operator("+")

            i1 = IfBlock(SimpleExpression([Variable("1a"), is_op, Bool(True)]), [q2, q3], "")
            i2 = IfElseBlock(SimpleExpression([Variable("2a"),  plus_op, Variable("6a")]), [q4], [q5], "")

            f = Form("example", "Introduction", [q1, i1, q6, i2])
            return f


class TestFactories(unittest.TestCase):

    def test_variable(self):
        variable = ExpressionFactory.make_variable("hello")
        self.assertIsInstance(variable, Variable)

    def test_operators(self):
        plus_op = ExpressionFactory.make_calc_operator("+")
        self.assertIsInstance(plus_op, CalcOperator)

        min_op = ExpressionFactory.make_calc_operator("-")
        self.assertIsInstance(min_op, CalcOperator)

        mul_op = ExpressionFactory.make_calc_operator("*")
        self.assertIsInstance(mul_op, CalcOperator)

        div_op = ExpressionFactory.make_calc_operator("/")
        self.assertIsInstance(div_op, CalcOperator)

        and_op = ExpressionFactory.make_comp_operator("==")
        self.assertIsInstance(and_op, CompareOperator)

    def test_bool(self):
        b = ExpressionFactory.make_bool(["True"])
        self.assertEqual(b.as_list(), [True])

        b = ExpressionFactory.make_bool(["False"])
        self.assertEqual(b.as_list(), [False])

    @unittest.expectedFailure
    def test_bool_fail(self):
        b = ExpressionFactory.make_bool(["true"])
        self.assertEqual(b.as_list(), [True])

    def test_form_factory(self):
        q1 = Question("1a", "bool", "Is this a _statements?")
        q2 = Question("2a", "text", "What?")
        q3 = Question("3a", "number", "Why!")
        q4 = Question("4a", "bool", "when")
        q5 = Question("5a", "text", "who.")
        q6 = Question("6a", "number", "where?")

        is_op = Operator("==")
        plus_op = Operator("+")

        i1 = IfBlock(SimpleExpression([Variable("1a"), is_op, Bool(True)]), [q2, q3], "")
        i2 = IfElseBlock(SimpleExpression([Variable("2a"),  plus_op, Variable("6a")]), [q4], [q5], "")

        check = FormFactory.make_form(["example", "Introduction", q1, i1, q6, i2])
        self.assertIsInstance(check, Form)


class TestAST(unittest.TestCase):

    def test_question(self):
        result = (FormFormat.question.parseString("Question why (text) : What do you like about hummus?")).asList()
        self.assertIsInstance(result[0], Question)
        self.assertEqual(result[0].id, "why")
        self.assertEqual(result[0].type, "text")
        self.assertEqual(result[0].label, "What do you like about hummus ?")

    def test_if_question(self):
        result = (FormFormat.pIf.parseString(
            "if (con == True) {  "
            "Question trans (bool) : Will transitive closure work? "
            "Question two (text) : This is a second q.}"))
        self.assertIsInstance(result[0], IfBlock)

        # Get all the ids
        self.assertEqual(result[0].id_collection(), ["trans", "two"])

        # Get the labels
        self.assertEqual(result[0].label_collection(), ["Will transitive closure work ?", "This is a second q ."])

        # Get the dependencies
        self.assertEqual(result[0].dependency_collection({}), {"trans" : ["con"], "two" : ["con"]})

    @unittest.expectedFailure
    def test_if_question_fail(self):
        # not a valid if else block
        result = (FormFormat.pIfElse.parseString("if (con == True) {  Question trans (bool) : Will transitive closure work? }")).asList()
        self.assertIsInstance(result[0], IfBlock)

    def test_else_questions(self):
        result = (FormFormat.pIfElse.parseString(
            "if (con == True) "
            "{  Question trans (bool) : Will transitive closure work? } "
            "else "
            "{ Question iselse (bool) : Is this an else _statements? }")).asList()
        self.assertIsInstance(result[0], IfElseBlock)

    def test_form(self):
        form = GenerateStatements.generate_statements()

        # The form has 6 questions, and therefore 6 labels
        self.assertEqual(len(form.get_labels()), 6)

        # The form has 6 questions, and therefore 6 ids
        self.assertEqual(len(form.get_ids()), 6)

        # The form has 2 conditional statements and thus 2 expressions
        self.assertEqual(len(form.get_expressions()), 2)

    def test_dependencies(self):
        form = GenerateStatements.generate_statements()

        # The transitive dependencies of statements
        self.assertEqual(form.get_dependencies(),
                         {"1a": set(),
                          "2a": {"1a"},
                          "3a": {"1a"},
                          "4a": {"1a", "2a", "6a"},
                          "5a": {"1a", "2a", "6a"},
                          "6a": set()})

    def test_type_dictionary(self):
        form = GenerateStatements.generate_statements()

        self.assertEqual(form.get_type_dict(),
            {"1a": "bool",
             "2a": "text",
             "3a": "number",
             "4a": "bool",
             "5a": "text",
             "6a": "number",
             "bool": "bool",
             "calc_operator": "calc_operator",
             "comp_operator": "comp_operator",
             "number": "number"
            })
