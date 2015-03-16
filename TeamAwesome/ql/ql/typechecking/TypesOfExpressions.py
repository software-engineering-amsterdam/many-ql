from typechecking import Message

from . import Checker
from .Identifier import typeOfIdentifier
from .Cast import effectiveTypes

from .. import TypeRules, CustomTypes

from ..ast import Nodes


class Checker(Checker.FullChecker):
    def __init__(self, ast, resultAlg):
        super().__init__(ast, resultAlg)
        self._operatorTable = TypeRules.OperatorTable()


    def _visitIfStatement(self, node):
        typeOfExpression = self.visit(node.expr)

        if typeOfExpression is not None:
            self._allowExpression(
                [bool],
                typeOfExpression,
                node.expr
            )

        for n in node.getChildren():
            self.visit(n)


    def _visitQuestionStatement(self, node):
        if node.expr is None:
            return
            
        typeOfExpression = self.visit(node.expr)

        if typeOfExpression is not None:
            self._allowExpression(
                [typeOfIdentifier(node.identifier, node)],
                typeOfExpression,
                node.expr
            ) 

        
    def _visitIdentifier(self, node):
        typeOfExpression = typeOfIdentifier(
            node,
            self._ast.root
        )

        if typeOfExpression is None:
            self._result = self._resultAlg.withError(
                self._result,
                Message.Error(
                    'undeclared identifier '+node,
                    node
                )
            )

        return typeOfExpression
        

    def _visitStr(self, node):
        return str


    def _visitInt(self, node):
        return int


    def _visitMoney(self, node):
        return CustomTypes.Money


    def _visitBool(self, node):
        return bool


    def _visitUnaryExpression(self, node):
        typeOfExpression = self.visit(node.right)

        if typeOfExpression is None:
            return None

        typeOfExpression = \
            self._operatorTable.unaryOperationType(
                node.op,
                typeOfExpression
            )

        if typeOfExpression is None:
            self._result = self._resultAlg.withError(
                self._result,
                Message.Error(
                    'invalid operands to unary operator `'+node.op\
                   +'`: '+str(node.right),
                   node
                )
            )

        return typeOfExpression


    def _visitBinaryExpression(self, node):
        typeOfLeftExpression = self.visit(node.left)
        if typeOfLeftExpression is None:
            return None

        typeOfRightExpression = self.visit(node.right)
        if typeOfRightExpression is None:
            return None

        typeOfExpression = \
            self._operatorTable.binaryOperationType(
                node.op,
                typeOfLeftExpression,
                typeOfRightExpression
            )

        if typeOfExpression is None: 
            self._result = self._resultAlg.withError(
                self._result,
                Message.Error(
                    'invalid operands to binary operator `'+node.op\
                   +'`: ('+str(node.left)+','+str(node.right)+')',
                    node
                )
            )

        return typeOfExpression


    def _allowExpression(self, allowedTypes, exprType, node):
        allowedEffectiveTypeExists = any(map(
            lambda t: t in allowedTypes,
            effectiveTypes(exprType)
        ))
        if not allowedEffectiveTypeExists:
            self._result = self._resultAlg.withError(
                self._result,
                Message.Error(
                    'got an expression of type `'+str(exprType)\
                   +'` which is not castable to any of the '\
                   +'following types which are allowed here '\
                   +'here: '+str(allowedTypes),
                   node
                )
            )
