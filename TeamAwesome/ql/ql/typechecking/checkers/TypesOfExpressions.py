from typechecking import Message

from .AbstractBase import AbstractBase

from ...core import TypeRules, QLTypes

from ...ast.Visitor import ExpressionVisitor
from ...ast.Functions import typeOfIdentifier



class Checker(AbstractBase):
    def __init__(self, resultAlgebra):
        super().__init__(resultAlgebra)
        self._questionnaire = None


    def visitQuestionnaireBegin(self, questionnaire):
        self._questionnaire = questionnaire
    

    def visitIfStatementBegin(self, node):
        typeOfExpression = self._typeOfExpression(node.expression)

        if typeOfExpression is not None:
            self._allowExpression(
                [QLTypes.QLBoolean],
                typeOfExpression,
                node.expression
            )


    def visitQuestionStatement(self, node):
        if node.expression is None:
            return
            
        typeOfExpression = self._typeOfExpression(node.expression)

        if typeOfExpression is not None:
            self._allowExpression(
                [typeOfIdentifier(node.identifier, node)],
                typeOfExpression,
                node.expression
            ) 


    def _typeOfExpression(self, expression):
        visitor = TypeOfExpressionVisitor(
            self._questionnaire,
            self._resultAlgebra
        )
        expression.accept(visitor)
        self._result = self._resultAlgebra.merge([
            self._result,
            visitor.result
        ])
        return visitor.typeOfExpression


    def _allowExpression(self, allowedTypes, exprType, node):
        allowedEffectiveTypeExists = any(map(
            lambda t: t in allowedTypes,
            _effectiveTypes(exprType)
        ))
        if not allowedEffectiveTypeExists:
            self._result = self._resultAlgebra.withError(
                self._result,
                Message.Error(
                    'got an expression of type `'+exprType.typeString()\
                   +'` which is not castable to any of the '\
                   +'following types which are allowed here '\
                   +'here: '+','.join(map(lambda t: '`'+t.typeString()+'`', allowedTypes)),
                   node
                )
            )


        
class TypeOfExpressionVisitor(ExpressionVisitor):
    def __init__(self, questionnaire, resultAlgebra):
        super().__init__()
        self._operatorTable = TypeRules.OperatorTable()
        self._questionnaire = questionnaire
        self._result = resultAlgebra.empty()
        self._resultAlgebra = resultAlgebra
        self._typesOfSeenExpressions = []


    @property
    def result(self):
        return self._result


    @property
    def typeOfExpression(self):
        return self._typeOfLastSeenExpression


    @property
    def _typeOfLastSeenExpression(self):
        return self._typesOfSeenExpressions[-1]


    def visitIdentifier(self, node):
        self._typesOfSeenExpressions.append(typeOfIdentifier(
            node,
            self._questionnaire
        ))

        if self._typeOfLastSeenExpression is None:
            self._result = self._resultAlgebra.withError(
                self._result,
                Message.Error(
                    'undeclared identifier '+str(node),
                    node
                )
            )


    def visitString(self, node):
        self._typesOfSeenExpressions.append(QLTypes.QLString)



    def visitInteger(self, node):
        self._typesOfSeenExpressions.append(QLTypes.QLInteger)


    def visitMoney(self, node):
        self._typesOfSeenExpressions.append(QLTypes.QLMoney)


    def visitBoolean(self, node):
        self._typesOfSeenExpressions.append(QLTypes.QLBoolean)


    def visitUnaryExpressionEnd(self, node):
        if self._typeOfLastSeenExpression is None:
            self._typesOfSeenExpressions.append(None)
        else:
            self._typesOfSeenExpressions.append(
                self._operatorTable.unaryOperationType(
                    node.operator,
                    self._typeOfLastSeenExpression
                )
            )

        if self._typeOfLastSeenExpression is None:
            self._result = self._resultAlgebra.withError(
                self._result,
                Message.Error(
                    'invalid operands to unary operator `'+str(node.operator)\
                   +'`: '+str(node.expression),
                   node
                )
            )


    def visitBinaryExpressionEnd(self, node):
        typeOfLeftExpression = self._typesOfSeenExpressions[-2]
        typeOfRightExpression = self._typesOfSeenExpressions[-1]

        if typeOfLeftExpression is None or typeOfRightExpression is None:
            self._typesOfSeenExpressions.append(None)
        else:
            self._typesOfSeenExpressions.append(
                self._operatorTable.binaryOperationType(
                    node.operator,
                    typeOfLeftExpression,
                    typeOfRightExpression
                )
            )

        if self._typeOfLastSeenExpression is None: 
            self._result = self._resultAlgebra.withError(
                self._result,
                Message.Error(
                    'invalid operands to binary operator `'+node.operator\
                   +'`: ('+str(node.left)+','+str(node.right)+')',
                    node
                )
            )


def _castableTo(fromType):
    castingSpec = {
        QLTypes.QLInteger: [QLTypes.QLMoney],
        QLTypes.QLMoney: [QLTypes.QLInteger]
    }

    if fromType in castingSpec:
        return castingSpec[fromType]

    return []


def _effectiveTypes(actualType):
    return [actualType] + _castableTo(actualType)
