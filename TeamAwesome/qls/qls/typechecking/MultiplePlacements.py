from typechecking import Message
from . import Checker

class Checker(Checker.StatementChecker):
    def __init__(self, qlAst, qlsAst, resultAlg):
        super().__init__(qlAst, qlsAst, resultAlg)
        self._questions = {}


    def _visitQLS(self, node):
        super()._visitQLS(node)

        for identifier, lines in self._questions.items():
            if len(lines) > 1:
                for l in lines:
                    self._result = self._resultAlg.withError(
                        self._result,
                        Message.Error(
                            'duplicate question placement `'+identifier+'`',
                            l
                        )
                    )

        return self._result


    def _visitQuestionStatement(self, node):
        if node.identifier not in self._questions:
            self._questions[node.identifier] = []

        self._questions[node.identifier].append(node.lineNumber)