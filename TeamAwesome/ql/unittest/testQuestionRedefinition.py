import sys
sys.path.append('..')

import unittest

from ql.ast.Nodes import *
from ql.core.QLTypes import *

from ql.typechecking import Typechecking, ErrorsWarningsResult, checkers
import TestMessage



class NoRedefinition(unittest.TestCase):
    def test(self):
        result = Typechecking.check(
            self.questionnaire,
            ErrorsWarningsResult.factory(),
            TestMessage.factory(),
            [checkers.QuestionRedefinitions]
        )
        self.assertEqual(0, len(result.errors))


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



class Redefinition(unittest.TestCase):
    def test(self):
        result = Typechecking.check(
            self.questionnaire,
            ErrorsWarningsResult.factory(),
            TestMessage.factory(),
            [checkers.QuestionRedefinitions]
        )
        self.assertEqual(1, len(result.errors))
        _assertRedefinition(self, result.errors[0], QLBoolean, QLString)


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
                Identifier('foo',1),
                'Foo',
                QLString,
                1
            )
        ],0)])
   


def _assertRedefinition(testCase, message, expectedType, actualType):
    testCase.assertEqual('questionRedefinition', message['message'])
    testCase.assertEqual(expectedType, message['expectedType'])
    testCase.assertEqual(actualType, message['actualType'])