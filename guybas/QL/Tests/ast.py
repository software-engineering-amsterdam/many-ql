import unittest

# import folders
from QL.AST.Statements import *
from QL.AST.Expressions.Primitives import *
from QL.AST.Expressions.Operations import *

# import files
import QL.AST.form as f
import QL.Grammar.Factory.expressions as ef
import QL.Grammar.grammar as fg
import QL.Grammar.constants as c


class GenerateStatements:

    @staticmethod
    def generate_statements():

        q1 = question.Question("1a", "bool", "Is this a statement?")
        q2 = question.Question("2a", "text", "What?")
        q3 = question.Question("3a", "number", "Why!")
        q4 = question.Question("4a", "bool", "when")
        q5 = question.Question("5a", "text", "who.")
        q6 = question.Question("6a", "number", "where?")

        e1 = equal.Equal(variable.Variable("1a"), bool_prim.Bool(True))
        e2 = add.Add(variable.Variable("2a"), variable.Variable("6a"))

        i1 = if_statement.IfBlock(e1, [q2, q3])
        i2 = if_else_statement.IfElseBlock(e2, [q4], [q5])

        form = f.Form("example", "Introduction", [q1, i1, q6, i2])
        return form


class Tests(unittest.TestCase):

    def test_factory_variable(self):
        v = ef.make_variable("hello")
        self.assertIsInstance(v, variable.Variable)

    def test_factory_bool(self):
        b = ef.make_bool(["True"])
        self.assertEqual(b.eval_expression({}), True)

        b = ef.make_bool(["False"])
        self.assertEqual(b.eval_expression({}), False)

    @unittest.expectedFailure
    def test_factory_bool_fail(self):
        b = ef.make_bool(["true"])
        self.assertEqual(b.eval_expression({}), True)

    def test_factory_form(self):

        fm = GenerateStatements.generate_statements()
        self.assertIsInstance(fm, f.Form)

    def test_ast_question(self):
        result = (fg.question.parseString("Question why (text) : What do you like about hummus?")).asList()
        self.assertIsInstance(result[0], question.Question)
        self.assertEqual(result[0].get_id(), "why")
        self.assertEqual(result[0].get_type_string(), c.TEXT)
        self.assertEqual(result[0].get_label(), "What do you like about hummus ?")

    def test_ast_if(self):
        result = (fg.pIf.parseString(
            "if (con == True) {  "
            "Question trans (bool) : Will transitive closure work? "
            "Question two (text) : This is a second q.}"))
        self.assertIsInstance(result[0], if_statement.IfBlock)

        # Get all the ids
        self.assertEqual(result[0].id_collection(), ["trans", "two"])

        # Get the labels
        self.assertEqual(result[0].label_collection(), ["Will transitive closure work ?", "This is a second q ."])

        # Get the _dependencies
        self.assertEqual(result[0].dependency_collection({}), {"trans" : ["con"], "two" : ["con"]})

    @unittest.expectedFailure
    def test_ast_if_fail(self):
        # not a valid if else block
        result = (fg.Grammar.pIfElse.parseString("if (con == True) {  Question trans (bool) : Will transitive closure work? }")).asList()
        self.assertIsInstance(result[0], if_statement.IfBlock)

    def test_ast_else(self):
        result = (fg.pIfElse.parseString(
            "if (con == True) "
            "{  Question trans (bool) : Will transitive closure work? } "
            "else "
            "{ Question iselse (bool) : Is this an else _statements? }")).asList()
        self.assertIsInstance(result[0], if_else_statement.IfElseBlock)

    def test_ast_form(self):
        form = GenerateStatements.generate_statements()

        # The _form has 6 questions, and therefore 6 labels
        self.assertEqual(len(form.get_labels()), 6)

        # The _form has 6 questions, and therefore 6 ids
        self.assertEqual(len(form.get_ids()), 6)

    def test_ast_dependencies(self):
        form = GenerateStatements.generate_statements()

        # The transitive _dependencies of _statements
        self.assertEqual(form.get_dependencies(),
                         {"1a": set(),
                          "2a": {"1a"},
                          "3a": {"1a"},
                          "4a": {"1a", "2a", "6a"},
                          "5a": {"1a", "2a", "6a"},
                          "6a": set()})
