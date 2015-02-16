
import unittest

from src.QL.parser import Parser
from src.typechecker.errors import ParseError


# Simple tests that check if the parser does not crash on valid input
class TestCases(unittest.TestCase):
    def setUp(self):
        self.parser = Parser()

    def testEmptyForm(self):
        parsed = self.parser.parse("form taxOfficeExample {}")
        self.assertEquals(parsed.__class__.__name__, "Form")
        self.assertEquals(len(parsed.children), 0)

    def testNonClosingForm(self):
        self.assertRaises(ParseError, self.parser.parse, "form taxOfficeExample {")

    def testSimpleForm(self):
        with open("tests/forms/simple.txt", "r") as file:
            parsed = self.parser.parse(file.read())

            self.assertEquals(parsed.__class__.__name__, "Form")
            self.assertEquals(len(parsed.children), 3)

            file.close()

    def testSkipComments(self):
        with open("tests/forms/comments.txt", "r") as file:
            parsed = self.parser.parse(file.read())

            self.assertEquals(parsed.__class__.__name__, "Form")
            self.assertEquals(len(parsed.children), 1)

            file.close()

    def testTypes(self):
        with open("tests/forms/types.txt", "r") as file:
            parsed = self.parser.parse(file.read())

            self.assertEquals(parsed.__class__.__name__, "Form")
            self.assertEquals(len(parsed.children), 5)

            file.close()


    def testUndefinedType(self):
        with open("tests/forms/undefinedType.txt", "r") as file:
            self.assertRaises(ParseError, self.parser.parse, file.read())

            file.close()


    def testIfBlocks(self):
        with open("tests/forms/simpleIf.txt", "r") as file:
            parsed = self.parser.parse(file.read())

            self.assertEquals(parsed.__class__.__name__, "Form")
            self.assertEquals(len(parsed.children), 2)

            file.close()

    def testIfElse(self):
        with open("tests/forms/ifElse.txt", "r") as file:
            parsed = self.parser.parse(file.read())

            self.assertEquals(parsed.__class__.__name__, "Form")
            self.assertEquals(len(parsed.children), 1)

            file.close()

    def testNestedIfBlocks(self):
        with open("tests/forms/nestedIf.txt", "r") as file:
            parsed = self.parser.parse(file.read())

            self.assertEquals(parsed.__class__.__name__, "Form")
            self.assertEquals(len(parsed.children), 1)

            self.assertEquals(parsed.children[0].__class__.__name__, "Branch")
            self.assertEquals(len(parsed.children[0].ifChildren), 2)

            file.close()


    def testExpressions(self):
        with open("tests/forms/expressions.txt", "r") as file:
            parsed = self.parser.parse(file.read())

            self.assertEquals(parsed.__class__.__name__, "Form")
            self.assertEquals(len(parsed.children), 11)

            file.close()