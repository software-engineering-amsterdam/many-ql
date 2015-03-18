from ...ast.Visitor import StatementVisitor



class AbstractBase(StatementVisitor):
    def __init__(self, parser, resultAlgebra):
        self._parser = parser
        self._resultAlgebra = resultAlgebra
        self._result = resultAlgebra.empty()

    def visitQuestionnaireEnd(self, questionnaire):
        return self._result