from typechecking import Message
from . import Checker

class Checker(Checker.StatementChecker):
    def __init__(self, ast, resultADT):
        super().__init__(ast, resultADT)
        self._labels = {}

    def _visitRoot(self, node):
        super()._visitRoot(node)

        for text, lines in self._labels.items():
            if len(lines) > 1:
                for l in lines:
                    self._result = self._result.withWarning(
                        Message.Warning(
                            'duplicate question label `'+text+'`',
                            l
                        )
                    )

        return self._result


    def _visitQuestionStatement(self, node):
        if node.text not in self._labels:
            self._labels[node.text] = []
        self._labels[node.text].append(node.lineNumber)
