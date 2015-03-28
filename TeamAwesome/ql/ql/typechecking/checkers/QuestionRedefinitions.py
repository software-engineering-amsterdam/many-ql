from .. import Message

from .AbstractBase import AbstractBase

from ...ast.Functions import typeOfIdentifier



class Checker(AbstractBase):
    def visitQuestionStatement(self, node):
        myType = node.type
        expectedType = typeOfIdentifier(
            node.identifier, self._parser.questionnaire
        )

        if myType != expectedType:
            myTypeString = self._parser.expressionTypeToken(myType)
            expectedTypeString = self._parser.expressionTypeToken(expectedType)

            self._result = self._resultAlgebra.withError(
                self._result,
                RedefinitionError(
                    str(node.identifier),
                    myTypeString,
                    expectedTypeString,
                    node.lineNumber
                )
            )



class RedefinitionError(Message.Message):
    def __init__(self, identifier, actualType, expectedType, lineNumber):
        super().__init__(
            Message.Local(lineNumber),
            Message.Error(),
            'duplicate definition of question `'+identifier+'` with '\
           +'different type `'+actualType+'` (expected type `'\
           +expectedType+'`)'
        )