from .Visitor import Visitor
from . import Message
from .Common import typeOfIdentifier
from .Cast import effectiveTypes

from .. import TypeRules
from .. import CustomTypes

from ..ast import Nodes


class Checker(Visitor):
    def __init__(self, ast):
        super().__init__(ast)
        self._operatorTable = TypeRules.OperatorTable()

        # Type of the last checked expression or None if it could
        # not be determined.
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
            self._lastExprType = typeOfIdentifier(
                node.left,
                self._ast.root
            )
            if self._lastExprType is None:
                self._result = self._result.withMessage(
                    Message.Error(
                        'undefined identifier '+node.left,
                        node
                    )
                )
        else:
            self._lastExprType = type(node.left)

    def _visitUnaryExpression(self, node):
        errorsBefore = len(self._result.errors)
        self.visit(node.right)
        errorsAfter = len(self._result.errors)

        if errorsBefore != errorsAfter:
            return

        self._lastExprType = \
            self._operatorTable.unaryOperationType(
                node.op,
                self._lastExprType
            )

        if self._lastExprType is None:
            self._result = self._result.withMessage(
                Message.Error(
                    'invalid operands to unary operator `'+node.op\
                   +'`: '+str(node.right),
                   node
                )
            )

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

        self._lastExprType = \
            self._operatorTable.binaryOperationType(
                node.op,
                leftType,
                rightType
            )

        if self._lastExprType is None: 
            self._result = self._result.withMessage(
                Message.Error(
                    'invalid operands to binary operator `'+node.op\
                   +'`: ('+str(node.left)+','+str(node.right)+')',
                    node
                )
            )


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
