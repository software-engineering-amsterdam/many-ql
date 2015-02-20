from .Visitor import Visitor
from . import Message

class Checker(Visitor):
    def __init__(self, ast):
        super().__init__(ast)
        self._labels = {}

    def _visitRoot(self, node):
        super()._visitRoot(node)

        for text, lines in self._labels.items():
            if len(lines) > 1:
                for l in lines:
                    self._result = self._result.withMessage(
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
