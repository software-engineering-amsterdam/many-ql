import sys
sys.path.append('..')

import unittest

from ql.ast.Nodes import *
from ql.core.QLTypes import *

from ql.typechecking import Typechecking, ErrorsWarningsResult, checkers
import TestMessage



class NoCycle(unittest.TestCase):
    def test(self):
        result = Typechecking.check(
            self.questionnaire,
            ErrorsWarningsResult.factory(),
            TestMessage.factory(),
            [checkers.CyclicQuestionDependencies]
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
                Identifier('bar',0),
                'Bar',
                QLBoolean,
                0,
                Identifier('foo',0)
            )
        ],0)])



class Length2Cycle(unittest.TestCase):
    def test(self):
        result = Typechecking.check(
            self.questionnaire,
            ErrorsWarningsResult.factory(),
            TestMessage.factory(),
            [checkers.CyclicQuestionDependencies]
        )
        self.assertEqual(1, len(result.errors))
        _assertQuestionCycle(self, result.errors[0])


    @property
    def questionnaire(self):
        return Questionnaire([FormStatement(Identifier('form',0),[
            QuestionStatement(
                Identifier('foo',0),
                'Foo',
                QLBoolean,
                0,
                Identifier('foo',0)
            )
        ],0)])



class Length3Cycle(unittest.TestCase):
    def test(self):
        result = Typechecking.check(
            self.questionnaire,
            ErrorsWarningsResult.factory(),
            TestMessage.factory(),
            [checkers.CyclicQuestionDependencies]
        )
        self.assertEqual(2, len(result.errors))
        _assertQuestionCycle(self, result.errors[0])
        _assertQuestionCycle(self, result.errors[1])


    @property
    def questionnaire(self):
        return Questionnaire([FormStatement(Identifier('form',0),[
            QuestionStatement(
                Identifier('foo',0),
                'Foo',
                QLBoolean,
                0,
                Identifier('bar',0),
            ),
            QuestionStatement(
                Identifier('bar',0),
                'Bar',
                QLBoolean,
                0,
                Identifier('foo',0)
            )
        ],0)])



def _assertQuestionCycle(testCase, message):
        testCase.assertEqual('questionCycle', message['message'])
        testCase.assertEqual(
            message['questionCycle'][0],
            message['questionCycle'][-1]
        )