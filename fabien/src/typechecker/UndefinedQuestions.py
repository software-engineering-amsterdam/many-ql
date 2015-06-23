
from Errors import UndefinedError

class UndefinedQuestions:
    def __init__(self, IDs=None, types=None):
        self.errors = []
        self.questionIDs = IDs

    def ID(self, node):
        if not node.ID in self.questionIDs:
            error = UndefinedError(node)
            self.errors.append(error)
