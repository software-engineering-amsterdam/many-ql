import sys
sys.path.append('..')

import unittest

from ql.ast.Nodes import *
from ql.core.QLTypes import *
from ql.core.QLOperators import *

from ql.typechecking import Typechecking, ErrorsWarningsResult, checkers
import TestMessage



class BooleanIdentifier(unittest.TestCase):
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
            IfStatement(Identifier('foo',0), [], 0)
        ],0)])



class BooleanConstant(unittest.TestCase):
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
            IfStatement(Boolean('true', 0), [], 0)
        ],0)])



class BooleanExpression(unittest.TestCase):
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
            IfStatement(
                UnaryExpression(QLLogicalNot, Boolean('true',0), 0), [
            ], 0)
        ],0)])



class NonBooleanIdentifier(unittest.TestCase):
    def test(self):
        result = Typechecking.check(
            self.questionnaire,
            ErrorsWarningsResult.factory(),
            TestMessage.factory(),
            [checkers.TypesOfExpressions]
        )
        self.assertEqual(1, len(result.errors))
        _assertNonBooleanConditionError(
            self, result.errors[0], QLString
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
            IfStatement(Identifier('foo',0), [], 0)
        ],0)])



class NonBooleanConstant(unittest.TestCase):
    def test(self):
        result = Typechecking.check(
            self.questionnaire,
            ErrorsWarningsResult.factory(),
            TestMessage.factory(),
            [checkers.TypesOfExpressions]
        )
        self.assertEqual(1, len(result.errors))
        _assertNonBooleanConditionError(
            self, result.errors[0], QLInteger
        )


    @property
    def questionnaire(self):
        return Questionnaire([FormStatement(Identifier('form',0),[
            IfStatement(Integer(0, 0), [], 0)
        ],0)])



class NonBooleanExpression(unittest.TestCase):
    def test(self):
        result = Typechecking.check(
            self.questionnaire,
            ErrorsWarningsResult.factory(),
            TestMessage.factory(),
            [checkers.TypesOfExpressions]
        )
        self.assertEqual(1, len(result.errors))
        _assertNonBooleanConditionError(
            self, result.errors[0], QLInteger
        )


    @property
    def questionnaire(self):
        return Questionnaire([FormStatement(Identifier('form',0),[
            IfStatement(
                UnaryExpression(QLUnaryPlus, Integer(0, 0), 0), [
            ], 0)
        ],0)])



def _assertNonBooleanConditionError(testCase, message, actualType):
    testCase.assertEqual('incompatibleExpressionType', message['message'])
    testCase.assertEqual(1, len(message['allowedTypes']))
    testCase.assertEqual(QLBoolean, message['allowedTypes'][0])
    testCase.assertEqual(actualType, message['actualType'])