
import unittest

from src.QL.parser import Parser
from src.Typechecker import *

import lib

# Simple tests that check if the parser does not crash on valid input
class TypecheckingTests(unittest.TestCase):
    def setUp(self):
        self.duplicateQuestions = DuplicateQuestions()
        self.undefinedQuestions = UndefinedQuestions()
        self.nonBoolean         = NonBooleanTypes()
        self.nonOperand         = NonOperandTypes()
        self.nonExpressions     = NonExpressions()

        self.parser = Parser()
        self.checker = TypeChecker()

        self.checker.register(self.duplicateQuestions)
        self.checker.register(self.undefinedQuestions)
        self.checker.register(self.nonBoolean)
        self.checker.register(self.nonOperand)
        self.checker.register(self.nonExpressions)


    def testDuplicateQuestions(self):
        with open(lib.formFilePath("duplicateQuestions.txt"), "r") as file:
            parsed = self.parser.parse(file.read())

        self.checker.checkAST(parsed)

        self.assertEqual(len(self.duplicateQuestions.errors), 1)
        self.assertEqual(len(self.undefinedQuestions.errors), 0)

    def testDuplicateQuestionsNested(self):
        with open(lib.formFilePath("duplicateQuestionsNested.txt"), "r") as file:
            parsed = self.parser.parse(file.read())

        self.checker.checkAST(parsed)

        self.assertEqual(len(self.duplicateQuestions.errors), 1)

    def testUndefinedQuestions(self):
        with open(lib.formFilePath("undefinedQuestions.txt"), "r") as file:
            parsed = self.parser.parse(file.read())

        self.checker.checkAST(parsed)

        self.assertEqual(len(self.duplicateQuestions.errors), 0)
        self.assertEqual(len(self.undefinedQuestions.errors), 1)


    def testUndefinedQuestionsNested(self):
        with open(lib.formFilePath("undefinedQuestionsNested.txt"), "r") as file:
            parsed = self.parser.parse(file.read())

        self.checker.checkAST(parsed)

        self.assertEqual(len(self.duplicateQuestions.errors), 0)
        self.assertEqual(len(self.undefinedQuestions.errors), 1)


    def testIncompatibleTypes(self):
        with open(lib.formFilePath("expressionTypes.txt"), "r") as file:
            parsed = self.parser.parse(file.read())

        self.checker.checkAST(parsed)

        self.assertEqual(len(self.duplicateQuestions.errors), 0)
        self.assertEqual(len(self.undefinedQuestions.errors), 0)
        self.assertEqual(len(self.nonExpressions.errors), 1)

    def testIncompatibleNestedTypes(self):
        with open(lib.formFilePath("expressionTypesNested.txt"), "r") as file:
            parsed = self.parser.parse(file.read())

        self.checker.checkAST(parsed)

        self.assertEqual(len(self.duplicateQuestions.errors), 0)
        self.assertEqual(len(self.undefinedQuestions.errors), 0)
        self.assertEqual(len(self.nonExpressions.errors), 4)

