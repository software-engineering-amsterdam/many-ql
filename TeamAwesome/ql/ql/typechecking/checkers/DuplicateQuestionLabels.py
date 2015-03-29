from .AbstractBase import AbstractBase



class Checker(AbstractBase):
    def __init__(self, resultFactory, messageFactory):
        super().__init__(resultFactory, messageFactory)
        self._labels = {}


    def visitQuestionnaireEnd(self, questionnaire):
        for label, occuringLines in self._labels.items():
            if len(occuringLines) > 1:
                for lineNumber in occuringLines:
                    self._result = self._resultFactory.withWarning(
                        self._result,
                        self._messageFactory.duplicateLabel(
                            label, lineNumber
                        )
                    )

        return super().visitQuestionnaireEnd(questionnaire)
        

    def visitQuestionStatement(self, node):
        if node.text not in self._labels:
            self._labels[node.text] = []
        self._labels[node.text].append(node.lineNumber)
