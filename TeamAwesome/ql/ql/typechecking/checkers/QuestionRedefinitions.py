from typechecking import Message

from .AbstractBase import AbstractBase

from ...ast.Functions import typeOfIdentifier



class Checker(AbstractBase):
    def __init__(self, resultAlgebra):
        super().__init__(resultAlgebra) 
        self._questionnaire = None


    def visitQuestionnaireBegin(self, questionnaire):
        self._questionnaire = questionnaire


    def visitQuestionStatement(self, node):
        myType = node.type
        expectedType = typeOfIdentifier(
            node.identifier, self._questionnaire
        )

        if myType != expectedType:
            self._result = self._resultAlgebra.withError(
                self._result,
                Message.Error(
                    'Duplicate definition of question `'\
                   +str(node.identifier)+'` with different type `'\
                   +myType.typeString()+'` (expected type `'\
                   +expectedType.typeString()+'`)',
                    node
                )
            )