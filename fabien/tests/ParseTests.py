
import unittest

from src.QL.parser import Parser
from src.Errors import ParseError

import lib

# Simple tests that check if the parser does not crash on valid input
class ParseTests(unittest.TestCase):
    def setUp(self):
        self.parser = Parser()

    def testEmptyFile(self):
        formText = "   \t   \r\n   \n \n "
        parsed = self.parser.parse(formText)

        self.assertEquals(parsed, None)

    def testEmptyForm(self):
        formText = "form taxOfficeExample {}"
        parsed = self.parser.parse(formText)

        self.assertEquals(parsed.__class__.__name__, "Form")
        self.assertEquals(len(parsed.block), 0)

    def testNonClosingForm(self):
        formText = "form taxOfficeExample {"
        parsed = self.parser.parse(formText)

        self.assertEquals(True, self.parser.hasErrors)

    # Parser does not accept multiple forms in single file
    def testMultipleForms(self):
        formText = "form taxOfficeExample {} form taxExampleB {}"
        parsed = self.parser.parse(formText)

        self.assertEquals(True, self.parser.hasErrors)

    def testSimpleForm(self):
        with open(lib.formFilePath("simple.txt"), "r") as file:
            parsed = self.parser.parse(file.read())

            self.assertEquals(parsed.__class__.__name__, "Form")
            self.assertEquals(len(parsed.block), 4)

            file.close()

    def testSkipComments(self):
        with open(lib.formFilePath("comments.txt"), "r") as file:
            parsed = self.parser.parse(file.read())

            self.assertEquals(parsed.__class__.__name__, "Form")
            self.assertEquals(len(parsed.block), 1)

            file.close()

    def testTypes(self):
        with open(lib.formFilePath("types.txt"), "r") as file:
            parsed = self.parser.parse(file.read())

            self.assertEquals(parsed.__class__.__name__, "Form")
            self.assertEquals(len(parsed.block), 5)

            file.close()

    def testUndefinedType(self):
        with open(lib.formFilePath("undefinedType.txt"), "r") as file:
            parsed = self.parser.parse(file.read())
            self.assertEquals(True, self.parser.hasErrors)

            file.close()

    def testIfBlocks(self):
        with open(lib.formFilePath("simpleIf.txt"), "r") as file:
            parsed = self.parser.parse(file.read())

            self.assertEquals(parsed.__class__.__name__, "Form")
            self.assertEquals(len(parsed.block), 2)

            file.close()

    def testIfElse(self):
        with open(lib.formFilePath("ifElse.txt"), "r") as file:
            parsed = self.parser.parse(file.read())

            self.assertEquals(parsed.__class__.__name__, "Form")
            self.assertEquals(len(parsed.block), 1)

            file.close()

    def testNestedIfBlocks(self):
        with open(lib.formFilePath("nestedIf.txt"), "r") as file:
            parsed = self.parser.parse(file.read())

            self.assertEquals(parsed.__class__.__name__, "Form")
            self.assertEquals(len(parsed.block), 1)

            self.assertEquals(parsed.block[0].__class__.__name__, "Branch")
            self.assertEquals(len(parsed.block[0].ifChildren), 2)

            file.close()

    def testExpressions(self):
        with open(lib.formFilePath("expressions.txt"), "r") as file:
            parsed = self.parser.parse(file.read())

            self.assertEquals(parsed.__class__.__name__, "Form")
            self.assertEquals(len(parsed.block), 13)

            file.close()
