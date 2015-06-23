
from Errors import DuplicationError

class DuplicateQuestions:
    def __init__(self, IDs=None, types=None):
        self.errors = []
        self.questionIDs = IDs

    def Question(self, node):
        if node.ID in self.questionIDs:
            if node.type != self.questionIDs[node.ID].type:
                error = DuplicationError(self.questionIDs[node.ID], node)
                self.errors.append(error)