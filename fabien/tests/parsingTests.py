
import unittest

from src.QL.parser import Parser
from src.typechecker.errors import ParseError


# Simple tests that check if the parser does not crash on valid input
class TestCases(unittest.TestCase):
    def setUp(self):
        self.app = Parser(DEBUG=False)

    def testEmptyForm(self):
        parsed = self.app.parse("form taxOfficeExample {}")
        self.assertEquals(parsed.type, "form")
        self.assertEquals(len(parsed.children), 0)


    def testNonClosingForm(self):
        self.assertRaises(ParseError, self.app.parse, "form taxOfficeExample {")


    def testSimpleForm(self):
        with open("tests/forms/simple.txt", "r") as file:
            parsed = self.app.parse(file.read())

            self.assertEquals(parsed.type, "form")
            self.assertEquals(len(parsed.children), 3)

            file.close()

    def testSkipComments(self):
        with open("tests/forms/comments.txt", "r") as file:
            parsed = self.app.parse(file.read())

            self.assertEquals(parsed.type, "form")
            self.assertEquals(len(parsed.children), 1)

            file.close()

    def testTypes(self):
        with open("tests/forms/types.txt", "r") as file:
            parsed = self.app.parse(file.read())

            self.assertEquals(parsed.type, "form")
            self.assertEquals(len(parsed.children), 5)

            file.close()


    def testUndefinedType(self):
        with open("tests/forms/undefinedType.txt", "r") as file:
            self.assertRaises(ParseError, self.app.parse, file.read())

            file.close()


    def testIfBlocks(self):
        with open("tests/forms/simpleIf.txt", "r") as file:
            parsed = self.app.parse(file.read())

            self.assertEquals(parsed.type, "form")
            self.assertEquals(len(parsed.children), 2)

            file.close()


    def testNestedIfBlocks(self):
        with open("tests/forms/nestedIf.txt", "r") as file:
            parsed = self.app.parse(file.read())

            self.assertEquals(parsed.type, "form")
            self.assertEquals(len(parsed.children), 1)

            self.assertEquals(parsed.children[0].type, "if")
            self.assertEquals(len(parsed.children[0].children), 2)

            file.close()


    def testExpressions(self):
        with open("tests/forms/expressions.txt", "r") as file:
            parsed = self.app.parse(file.read())

            self.assertEquals(parsed.type, "form")
            self.assertEquals(len(parsed.children), 10)

            file.close()
