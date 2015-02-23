from .Visitor import Visitor
from . import Message
from .common import typeOfIdentifier
from .Cast import effectiveTypes

import OperatorTypes
import CustomTypes
import ASTNodes


class Checker(Visitor):
    def __init__(self, ast):
        super().__init__(ast)
        self._operatorTable = OperatorTypes.Table()

        # The type of the last WELL-TYPED expression.
        # i.e. if the last checked expression was for some reason
        # invalid then this variable remains what it was before
        # that check happened.
        # So don't rely on this after you encounter an error
        # in a sub expression.
        self._lastExprType = None

    def _visitIfStatement(self, node):
        errorsBefore = len(self._result.errors)
        self.visit(node.expr)
        errorsAfter = len(self._result.errors)

        if errorsBefore == errorsAfter:
            self._allowExpression(
                [bool],
                self._lastExprType,
                node.expr
            )

        for n in node.getChildren():
            self.visit(n)

    def _visitQuestionStatement(self, node):
        if node.expr is not None:
            errorsBefore = len(self._result.errors)
            self.visit(node.expr)
            errorsAfter = len(self._result.errors)

            if errorsBefore == errorsAfter:
                self._allowExpression(
                    [typeOfIdentifier(node.identifier, node)],
                    self._lastExprType,
                    node.expr
                ) 

        for n in node.getChildren():
            self.visit(n)

    def _visitAtomicExpression(self, node):
        if isinstance(node.left, CustomTypes.Identifier):
            identType = typeOfIdentifier(
                node.left,
                self._ast.root
            )
            if identType is None:
                self._result = self._result.withMessage(
                    Message.Error(
                        'undefined identifier '+node.left,
                        node
                    )
                )
            else:
                self._lastExprType = identType
        else:
            self._lastExprType = type(node.left)

    def _visitUnaryExpression(self, node):
        errorsBefore = len(self._result.errors)
        self.visit(node.right)
        errorsAfter = len(self._result.errors)

        if errorsBefore != errorsAfter:
            return

        opType = \
            self._operatorTable.unaryOperationType(
                node.op,
                self._lastExprType
            )

        if opType is None:
            self._result = self._result.withMessage(
                Message.Error(
                    'invalid operands to unary operator `'+node.op\
                   +'`: '+str(node.right),
                   node
                )
            )
        else:
            self._lastExprType = opType

    def _visitBinaryExpression(self, node):
        errorsBefore = len(self._result.errors)
        self.visit(node.left)
        errorsAfter = len(self._result.errors)

        if errorsBefore != errorsAfter:
            return

        leftType = self._lastExprType

        errorsBefore = errorsAfter
        self.visit(node.right)
        errorsAfter = len(self._result.errors)

        if errorsBefore != errorsAfter:
            return

        rightType = self._lastExprType

        opType = \
            self._operatorTable.binaryOperationType(
                node.op,
                leftType,
                rightType
            )

        if opType is None: 
            self._result = self._result.withMessage(
                Message.Error(
                    'invalid operands to binary operator `'+node.op\
                   +'`: ('+str(node.left)+','+str(node.right)+')',
                    node
                )
            )
        else:
            self._lastExprType = opType


    def _allowExpression(self, allowedTypes, exprType, node):
        allowedEffectiveTypeExists = any(map(
            lambda t: t in allowedTypes,
            effectiveTypes(exprType)
        ))
        if not allowedEffectiveTypeExists:
            self._result = self._result.withMessage(
                Message.Error(
                    'got an expression of type `'+str(exprType)\
                   +'` which is not castable to any of the '\
                   +'following types which are allowed here '\
                   +'here: '+str(allowedTypes),
                   node
                )
            )
