
import unittest

from src.QL.parser import Parser
from src.Errors import ParseError
from src.Gui import GUI

import lib

class EvaluationTests(unittest.TestCase):
    def setUp(self):
        self.parser = Parser()

    def testTrueExpressions(self):
        with open(lib.formFilePath("trueExpressions.txt"), "r") as file:
            parsed = self.parser.parse(file.read())

        gui = GUI()
        gui._buildForm(parsed)

        # Fire 'change' event
        gui.onChange()

        for node in gui.branches:
            if not node.evaluate(gui.answers):
                print node
                print node.evaluate(gui.answers)
                print gui.answers
                print "-----"

            self.assertEqual(True, bool(node.evaluate(gui.answers)))


    def testFalseExpressions(self):
        with open(lib.formFilePath("falseExpressions.txt"), "r") as file:
            parsed = self.parser.parse(file.read())

        gui = GUI()
        gui._buildForm(parsed)

        # Fire 'change' event
        gui.onChange()

        for node in gui.branches:
            if node.evaluate(gui.answers):
                print node
                print node.evaluate(gui.answers)
                print gui.answers
                print "-----"

            self.assertEqual(False, bool(node.evaluate(gui.answers)))
