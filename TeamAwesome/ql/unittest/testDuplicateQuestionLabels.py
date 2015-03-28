import sys
sys.path.append('..')

import unittest

from ql.ast.Nodes import *
from ql.core.QLTypes import *

from ql.typechecking import Typechecking, ErrorsWarningsResult, checkers
import TestMessage



class NoDuplication(unittest.TestCase):
    def test(self):
        result = Typechecking.check(
            self.questionnaire,
            ErrorsWarningsResult.Factory(),
            TestMessage.Factory(),
            [checkers.DuplicateQuestionLabels]
        )
        self.assertEqual(0, len(result.warnings))


    @property
    def questionnaire(self):
        return Questionnaire([FormStatement(Identifier('form',0),[
            QuestionStatement(
                Identifier('foo', 0),
                'Foo',
                QLBoolean,
                0
            ),
            QuestionStatement(
                Identifier('bar',1),
                'Bar',
                QLBoolean,
                1
            )
        ],0)])



class OneDuplicate(unittest.TestCase):
    def test(self):
        result = Typechecking.check(
            self.questionnaire,
            ErrorsWarningsResult.Factory(),
            TestMessage.Factory(),
            [checkers.DuplicateQuestionLabels]
        )
        self.assertEqual(2, len(result.warnings))
        _assertDuplication(self, result.warnings[0], result.warnings[1])


    @property
    def questionnaire(self):
        return Questionnaire([FormStatement(Identifier('form',0),[
            QuestionStatement(
                Identifier('foo', 0),
                'Foo',
                QLBoolean,
                0
            ),
            QuestionStatement(
                Identifier('bar',1),
                'Foo',
                QLBoolean,
                1
            ),
            QuestionStatement(
                Identifier('baz',2),
                'Baz',
                QLBoolean,
                2
            )
        ],0)])
   


def _assertDuplication(testCase, message1, message2):
    testCase.assertEqual('duplicateLabel', message1['message'])
    testCase.assertEqual('duplicateLabel', message2['message'])
    testCase.assertEqual(message1['label'], message2['label'])