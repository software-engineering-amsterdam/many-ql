
import unittest

from src.QL.parser import Parser
from src.Typechecker import *

# Simple tests that check if the parser does not crash on valid input
class TypecheckingTests(unittest.TestCase):
    def setUp(self):
        self.duplicateQuestions = DuplicateQuestions()
        self.undefinedQuestions = UndefinedQuestions()
        self.nonBoolean         = NonBooleanExpressions()

        self.parser = Parser()
        self.checker = TypeChecker()

        self.checker.register(self.duplicateQuestions)
        self.checker.register(self.undefinedQuestions)
        self.checker.register(self.nonBoolean)


    def testDuplicateQuestions(self):
        with open("tests/forms/duplicateQuestions.txt", "r") as file:
            parsed = self.parser.parse(file.read())

        self.checker.checkAST(parsed)

        self.assertEqual(len(self.duplicateQuestions.errors), 1)
        self.assertEqual(len(self.undefinedQuestions.errors), 0)

    def testDuplicateQuestionsNested(self):
        with open("tests/forms/duplicateQuestionsNested.txt", "r") as file:
            parsed = self.parser.parse(file.read())

        self.checker.checkAST(parsed)

        self.assertEqual(len(self.duplicateQuestions.errors), 1)

    def testUndefinedQuestions(self):
        with open("tests/forms/undefinedQuestions.txt", "r") as file:
            parsed = self.parser.parse(file.read())

        self.checker.checkAST(parsed)

        self.assertEqual(len(self.duplicateQuestions.errors), 0)
        self.assertEqual(len(self.undefinedQuestions.errors), 1)


    def testUndefinedQuestionsNested(self):
        with open("tests/forms/undefinedQuestionsNested.txt", "r") as file:
            parsed = self.parser.parse(file.read())

        self.checker.checkAST(parsed)

        self.assertEqual(len(self.duplicateQuestions.errors), 0)
        self.assertEqual(len(self.undefinedQuestions.errors), 1)


    def testIncompatibleTypes(self):
        with open("tests/forms/expressionTypes.txt", "r") as file:
            parsed = self.parser.parse(file.read())

        self.checker.checkAST(parsed)

        self.assertEqual(len(self.duplicateQuestions.errors), 0)
        self.assertEqual(len(self.undefinedQuestions.errors), 0)
        self.assertEqual(len(self.nonBoolean.errors), 1)

    def testIncompatibleNestedTypes(self):
        with open("tests/forms/expressionTypesNested.txt", "r") as file:
            parsed = self.parser.parse(file.read())

        self.checker.checkAST(parsed)

        self.assertEqual(len(self.duplicateQuestions.errors), 0)
        self.assertEqual(len(self.undefinedQuestions.errors), 0)
        self.assertEqual(len(self.nonBoolean.errors), 5)


