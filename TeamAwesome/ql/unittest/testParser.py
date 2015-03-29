import sys
sys.path.append('..')

import unittest

from ql.ast.Nodes import *
from ql.parser.ANTLR import Parser

class NoQuestions(unittest.TestCase):
    def test(self):
        questionnaire = Parser("parserTestFiles/noQuestions.ql").questionnaire
        form = questionnaire.statements[0]
        self.assertEqual(0, len(form.statements))

class OneQuestion(unittest.TestCase):
	def test(self):
		questionnaire = Parser("parserTestFiles/oneQuestion.ql").questionnaire
		
		form = questionnaire.statements[0]
		self.assertEqual(1, len(form.statements))

		question = form.statements[0]
		self.assertEqual(type(question), QuestionStatement)
        