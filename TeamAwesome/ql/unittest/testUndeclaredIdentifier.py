import sys
sys.path.append('..')

import unittest

from ql.ast.Nodes import *
from ql.core.QLTypes import *

from ql.typechecking import Typechecking, ErrorsWarningsResult, checkers
import TestMessage



class NoUndeclaredIdentifier(unittest.TestCase):
    def test(self):
        result = Typechecking.check(
            self.questionnaire,
            ErrorsWarningsResult.Factory(),
            TestMessage.Factory(),
            [checkers.TypesOfExpressions]
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
                1,
                Identifier('foo',1)
            )
        ],0)])



class UndeclaredIdentifier(unittest.TestCase):
    def test(self):
        result = Typechecking.check(
            self.questionnaire,
            ErrorsWarningsResult.Factory(),
            TestMessage.Factory(),
            [checkers.TypesOfExpressions]
        )
        self.assertEqual(1, len(result.errors))
        _assertUndeclaredIdentifier(
            self, result.errors[0], QLIdentifier('baz')
        )


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
                1,
                Identifier('baz',1)
            )
        ],0)])
   


def _assertUndeclaredIdentifier(testCase, message, expectedIdentifier):
    testCase.assertEqual('undeclaredIdentifier', message['message'])
    testCase.assertEqual(expectedIdentifier, message['identifier'].value)