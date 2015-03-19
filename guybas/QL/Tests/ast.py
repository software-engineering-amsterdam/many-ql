import unittest

import QL.AST.Statements.question as q
import QL.AST.Elements.operator as op
import QL.AST.Statements.if_statement as i
import QL.AST.Statements.if_else_statement as e
import QL.AST.Expressions.expression_interface as se
import QL.AST.Elements.variable as v
import QL.AST.Expressions.Primitives.bool_prim as b
import QL.AST.form as f
import QL.Grammar.Factory.expressions as ef
import QL.Factory.forms as ff
import QL.Grammar.grammar as fg
import QL.AST.Statements.AnswerTypes.bool as ab
import QL.AST.Statements.AnswerTypes.number as an
import QL.AST.Statements.AnswerTypes.text as at
import QL.Grammar.constants as c


class GenerateStatements:
    @staticmethod
    def generate_statements():
        bo = ab.Bool()
        te = at.Text()
        nu = an.Number()

        q1 = q.Question("1a", bo, "Is this a statement?")
        q2 = q.Question("2a", te, "What?")
        q3 = q.Question("3a", nu, "Why!")
        q4 = q.Question("4a", bo, "when")
        q5 = q.Question("5a", te, "who.")
        q6 = q.Question("6a", nu, "where?")

        is_op = op.Operator("==")
        plus_op = op.Operator("+")

        i1 = i.IfBlock(se.IExpression([v.Variable("1a"), is_op, b.Bool(True)]), [q2, q3])
        i2 = e.IfElseBlock(se.IExpression([v.Variable("2a"),  plus_op, v.Variable("6a")]), [q4], [q5])

        form = f.Form("example", "Introduction", [q1, i1, q6, i2])
        return form


class TestFactories(unittest.TestCase):

    def test_factory_variable(self):
        variable = ef.ExpressionFactory.make_variable("hello")
        self.assertIsInstance(variable, v.Variable)

    def test_factory_operators(self):
        plus_op = ef.ExpressionFactory.make_operator("+")
        self.assertIsInstance(plus_op, op.Operator)

        min_op = ef.ExpressionFactory.make_operator("-")
        self.assertIsInstance(min_op, op.Operator)

        mul_op = ef.ExpressionFactory.make_operator("*")
        self.assertIsInstance(mul_op, op.Operator)

        div_op = ef.ExpressionFactory.make_operator("/")
        self.assertIsInstance(div_op, op.Operator)

        and_op = ef.ExpressionFactory.make_operator("==")
        self.assertIsInstance(and_op, op.Operator)

    def test_factory_bool(self):
        b = ef.ExpressionFactory.make_bool(["True"])
        self.assertEqual(b.as_list(), [True])

        b = ef.ExpressionFactory.make_bool(["False"])
        self.assertEqual(b.as_list(), [False])

    @unittest.expectedFailure
    def test_factory_bool_fail(self):
        b = ef.ExpressionFactory.make_bool(["true"])
        self.assertEqual(b.as_list(), [True])

    def test_factory_form(self):
        bo = ab.Bool()
        te = at.Text()
        nu = an.Number()

        q1 = q.Question("1a", bo, "Is this a statement?")
        q2 = q.Question("2a", te, "What?")
        q3 = q.Question("3a", nu, "Why!")
        q4 = q.Question("4a", bo, "when")
        q5 = q.Question("5a", te, "who.")
        q6 = q.Question("6a", nu, "where?")

        is_op = op.Operator("==")
        plus_op = op.Operator("+")

        i1 = i.IfBlock(se.IExpression([v.Variable("1a"), is_op, b.Bool(True)]), [q2, q3])
        i2 = e.IfElseBlock(se.IExpression([v.Variable("2a"),  plus_op, v.Variable("6a")]), [q4], [q5])

        check = ff.FormFactory.make_form(["example", "Introduction", [q1, i1, q6, i2]])
        self.assertIsInstance(check, f.Form)


class TestAST(unittest.TestCase):

    def test_ast_question(self):
        result = (fg.Grammar.question.parseString("Question why (text) : What do you like about hummus?")).asList()
        self.assertIsInstance(result[0], q.Question)
        self.assertEqual(result[0].get_id(), "why")
        self.assertEqual(result[0].get_type(), c.GrammarConstants.TEXT)
        self.assertEqual(result[0].get_label(), "What do you like about hummus ?")

    def test_ast_if(self):
        result = (fg.Grammar.pIf.parseString(
            "if (con == True) {  "
            "Question trans (bool) : Will transitive closure work? "
            "Question two (text) : This is a second q.}"))
        self.assertIsInstance(result[0], i.IfBlock)

        # Get all the ids
        self.assertEqual(result[0].id_collection(), ["trans", "two"])

        # Get the labels
        self.assertEqual(result[0].label_collection(), ["Will transitive closure work ?", "This is a second q ."])

        # Get the _dependencies
        self.assertEqual(result[0].get_variables({}), {"trans" : ["con"], "two" : ["con"]})

    @unittest.expectedFailure
    def test_ast_if_fail(self):
        # not a valid if else block
        result = (fg.Grammar.pIfElse.parseString("if (con == True) {  Question trans (bool) : Will transitive closure work? }")).asList()
        self.assertIsInstance(result[0], i.IfBlock)

    def test_ast_else(self):
        result = (fg.Grammar.pIfElse.parseString(
            "if (con == True) "
            "{  Question trans (bool) : Will transitive closure work? } "
            "else "
            "{ Question iselse (bool) : Is this an else _statements? }")).asList()
        self.assertIsInstance(result[0], e.IfElseBlock)

    def test_ast_form(self):
        form = GenerateStatements.generate_statements()

        # The _form has 6 questions, and therefore 6 labels
        self.assertEqual(len(form.get_labels()), 6)

        # The _form has 6 questions, and therefore 6 ids
        self.assertEqual(len(form.get_ids()), 6)

        # The _form has 2 conditional _statements and thus 2 expressions
        self.assertEqual(len(form.get_expressions()), 2)

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

    def test_ast_type_dictionary(self):
        form = GenerateStatements.generate_statements()

        self.assertEqual(form.get_type_dict(),
            {"1a": "bool",
             "2a": "text",
             "3a": "number",
             "4a": "bool",
             "5a": "text",
             "6a": "number",
            })
