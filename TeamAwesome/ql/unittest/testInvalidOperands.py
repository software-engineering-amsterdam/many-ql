import sys
sys.path.append('..')

import unittest

from ql.ast.Nodes import *
from ql.core.QLTypes import *
from ql.core.QLOperators import *

from ql.typechecking import Typechecking, ErrorsWarningsResult, checkers
import TestMessage



class ValidIdentifier(unittest.TestCase):
    def test(self):
        result = Typechecking.check(
            self.questionnaire,
            ErrorsWarningsResult.factory(),
            TestMessage.factory(),
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
                Identifier('bar',0),
                'Bar',
                QLBoolean,
                0,
                UnaryExpression(QLLogicalNot, Identifier('foo',0), 0)
            )
        ],0)])



class ValidConstant(unittest.TestCase):
    def test(self):
        result = Typechecking.check(
            self.questionnaire,
            ErrorsWarningsResult.factory(),
            TestMessage.factory(),
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
                0,
                UnaryExpression(QLLogicalNot, Boolean('true',0), 0)
            )
        ],0)])



class ValidExpression(unittest.TestCase):
    def test(self):
        result = Typechecking.check(
            self.questionnaire,
            ErrorsWarningsResult.factory(),
            TestMessage.factory(),
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
                0,
                UnaryExpression(QLLogicalNot,
                    UnaryExpression(QLLogicalNot, Boolean('true',0), 0),
                0)
            )
        ],0)])


class InvalidIdentifier(unittest.TestCase):
    def test(self):
        result = Typechecking.check(
            self.questionnaire,
            ErrorsWarningsResult.factory(),
            TestMessage.factory(),
            [checkers.TypesOfExpressions]
        )
        self.assertEqual(1, len(result.errors))
        _assertInvalidOperandsError(
            self, result.errors[0], QLLogicalNot
        )


    @property
    def questionnaire(self):
        return Questionnaire([FormStatement(Identifier('form',0),[
            QuestionStatement(
                Identifier('foo', 0),
                'Foo',
                QLString,
                0
            ),
            QuestionStatement(
                Identifier('bar',0),
                'Bar',
                QLString,
                0,
                UnaryExpression(QLLogicalNot, Identifier('foo',0), 0)
            )
        ],0)])



class InvalidConstant(unittest.TestCase):
    def test(self):
        result = Typechecking.check(
            self.questionnaire,
            ErrorsWarningsResult.factory(),
            TestMessage.factory(),
            [checkers.TypesOfExpressions]
        )
        self.assertEqual(1, len(result.errors))
        _assertInvalidOperandsError(
            self, result.errors[0], QLLogicalNot
        )


    @property
    def questionnaire(self):
        return Questionnaire([FormStatement(Identifier('form',0),[
            QuestionStatement(
                Identifier('foo', 0),
                'Foo',
                QLBoolean,
                0,
                UnaryExpression(QLLogicalNot, Integer(0,0), 0)
            )
        ],0)])



class InvalidExpression(unittest.TestCase):
    def test(self):
        result = Typechecking.check(
            self.questionnaire,
            ErrorsWarningsResult.factory(),
            TestMessage.factory(),
            [checkers.TypesOfExpressions]
        )
        self.assertEqual(1, len(result.errors))
        _assertInvalidOperandsError(
            self, result.errors[0], QLLogicalNot
        )


    @property
    def questionnaire(self):
        return Questionnaire([FormStatement(Identifier('form',0),[
            QuestionStatement(
                Identifier('foo', 0),
                'Foo',
                QLBoolean,
                0,
                UnaryExpression(QLLogicalNot,
                    UnaryExpression(QLUnaryPlus, Integer(0,0), 0),
                0)
            )
        ],0)])



def _assertInvalidOperandsError(testCase, message, operator):
    testCase.assertEqual('invalidOperands', message['message'])
    testCase.assertEqual(operator, message['operator'])