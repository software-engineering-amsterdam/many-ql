from typechecking import Message

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
                Message.Error(
                    'Duplicate definition of question `'\
                   +str(node.identifier)+'` with different type `'\
                   +myTypeString+'` (expected type `'\
                   +expectedTypeString+'`)',
                    node
                )
            )