from ...ast.Visitor import StatementVisitor



class AbstractBase(StatementVisitor):
    def __init__(self, resultFactory, messageFactory):
        self._resultFactory = resultFactory
        self._messageFactory = messageFactory
        self._result = resultFactory.empty()
        self._questionnaire = None


    def visitQuestionnaireBegin(self, questionnaire):
        self._questionnaire = questionnaire


    def visitQuestionnaireEnd(self, questionnaire):
        return self._result