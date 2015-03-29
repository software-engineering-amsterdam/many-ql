
from Errors import UndefinedError

class UndefinedQuestions:
    def __init__(self, questionIDs=None):
        self.errors = []
        self.questionIDs = questionIDs

    def Leaf(self, node):
        if node.tokenType == "ID" and not node.ID in self.questionIDs:
            error = UndefinedError(node)
            self.errors.append(error)
