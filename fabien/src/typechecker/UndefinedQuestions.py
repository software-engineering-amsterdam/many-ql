
from errors import UndefinedError

class UndefinedQuestions:
    def __init__(self):
        self.errors = []
        self.questionIDs = set()

    def Question(self, node):
        self.questionIDs.add(node.ID)

    def Leaf(self, node):
        if node.tokenType == "ID" and not node.ID in self.questionIDs:
            error = UndefinedError(node)
            self.errors.append(error)
