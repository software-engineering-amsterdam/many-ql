from ..ast.Visitor import StatementVisitor



class AbstractBase(StatementVisitor):
    def __init__(self, resultAlgebra):
        self._result = resultAlgebra.empty()
        self._resultAlgebra = resultAlgebra

    def visitQuestionnaireEnd(self, questionnaire):
        return self._result