from QL.Tools.type_checker import *
from QL.Tests.ast import *
from QL.Grammar.expression import *


class TestTypeChecker(unittest.TestCase):
    def test_duplicates(self):
        l1 = list(range(1, 10))
        self.assertEqual(TypeChecker.check_duplicates(l1), [])

        l2 = [1, 2, 3, 4, 5, 6, 2, 9]
        self.assertEqual(TypeChecker.check_duplicates(l2), [2])

        l3 = [1, 2, 2, 9, 1, 1]
        self.assertEqual(TypeChecker.check_duplicates(l3), [1, 2])

    def test_check_id(self):
        l1 = list(range(1, 10))
        self.assertEqual(TypeChecker.check_ids(l1), "")

        l2 = [1, 2, 3, 4, 5, 6, 2, 9]
        self.assertEqual(TypeChecker.check_ids(l2), "There are duplicate ids: [2]")

        l3 = [1, 2, 2, 9, 1, 1]
        self.assertEqual(TypeChecker.check_ids(l3), "There are duplicate ids: [1, 2]")

    def test_dependencies(self):
        d1 = {1: set(), 2: set()}
        self.assertEqual(TypeChecker.check_dependencies(d1), "")

        d2 = {1: {0,2,3,4}, 2: {1,3,4}}
        self.assertEqual(TypeChecker.check_dependencies(d2), "")

        d3 = {1: {0,2,3,4}, 2: {1,2}}
        self.assertEqual(TypeChecker.check_dependencies(d3), "2 is dependent on itself")

    def test_evaluator(self):
        e1 = Expressions.expr.parseString("4 / 2 + (3 - 1) * 4 == 8")
        self.assertEqual(TypeChecker.check_expressions([e1[0]], {}), "")

        e2 = Expressions.expr.parseString("4 / 2 + (3 - 1) * 4 ==  True")
        self.assertEqual(TypeChecker.check_expressions([e2[0]], {}), "4 / 2 + (3 - 1) * 4 == True is malformed\n")

        e3 = Expressions.expr.parseString("True == True")
        self.assertEqual(TypeChecker.check_expressions([e3[0]], {}), "")

        e4 = Expressions.expr.parseString("True")
        self.assertEqual(TypeChecker.check_expressions([e4[0]], {}), "")

        e5 = Expressions.expr.parseString("4")
        self.assertEqual(TypeChecker.check_expressions([e5[0]], {}), "4 is malformed\n")
