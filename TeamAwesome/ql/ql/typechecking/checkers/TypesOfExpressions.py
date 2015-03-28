from .AbstractBase import AbstractBase

from ...core import TypeRules, QLTypes

from ...ast.Visitor import ExpressionVisitor
from ...ast.Functions import typeOfIdentifier



class Checker(AbstractBase):
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
            self._resultFactory,
            self._messageFactory
        )
        expression.accept(visitor)
        self._result = self._resultFactory.merge([
            self._result,
            visitor.result
        ])
        return visitor.typeOfExpression


    def _allowExpression(self, allowedTypes, actualType, node):
        allowedEffectiveTypeExists = any(map(
            lambda t: t in allowedTypes,
            _effectiveTypes(actualType)
        ))
        if not allowedEffectiveTypeExists:
            self._result = self._resultFactory.withError(
                self._result,
                self._messageFactory.incompatibleExpressionType(
                    actualType,
                    allowedTypes,
                    node.lineNumber
                )
            )


        
class TypeOfExpressionVisitor(ExpressionVisitor):
    def __init__(self, questionnaire, resultFactory, messageFactory):
        super().__init__()
        self._operatorTable = TypeRules.OperatorTable()
        self._questionnaire = questionnaire
        self._resultFactory = resultFactory
        self._messageFactory = messageFactory
        self._result = resultFactory.empty()
        self._typesOfSeenExpressions = []


    @property
    def result(self):
        return self._result


    @property
    def typeOfExpression(self):
        return self._typeOfLastSeenExpression()


    def _typeOfLastSeenExpression(self):
        return self._typesOfSeenExpressions[-1]


    def visitIdentifier(self, node):
        myType = typeOfIdentifier(node, self._questionnaire)

        if myType is None:
            self._result = self._resultFactory.withError(
                self._result,
                self._messageFactory.undeclaredIdentifier(
                    node, node.lineNumber
                )
            )

        self._typesOfSeenExpressions.append(myType)


    def visitString(self, node):
        self._typesOfSeenExpressions.append(QLTypes.QLString)


    def visitInteger(self, node):
        self._typesOfSeenExpressions.append(QLTypes.QLInteger)


    def visitMoney(self, node):
        self._typesOfSeenExpressions.append(QLTypes.QLMoney)


    def visitBoolean(self, node):
        self._typesOfSeenExpressions.append(QLTypes.QLBoolean)


    def visitUnaryExpressionEnd(self, node):
        if self._typeOfLastSeenExpression() is None:
            myType = None
        else:
            myType = self._operatorTable.unaryOperationType(
                node.operator,
                self._typeOfLastSeenExpression()
            )

        if myType is None:
            self._result = self._resultFactory.withError(
                self._result,
                self._messageFactory.invalidOperands(
                    node.operator,
                    [node.expression],
                    node.lineNumber
                )
            )

        self._typesOfSeenExpressions.append(myType)


    def visitBinaryExpressionEnd(self, node):
        typeOfLeftExpression = self._typesOfSeenExpressions[-2]
        typeOfRightExpression = self._typesOfSeenExpressions[-1]

        if typeOfLeftExpression is None or typeOfRightExpression is None:
            myType = None
        else:
            myType = self._operatorTable.binaryOperationType(
                node.operator,
                typeOfLeftExpression,
                typeOfRightExpression
            )

        if myType is None: 
            self._result = self._resultFactory.withError(
                self._result,
                self._messageFactory.invalidOperands(
                    node.operator,
                    [node.left, node.right],
                    node.lineNumber
                )
            )

        self._typesOfSeenExpressions.append(myType)



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
