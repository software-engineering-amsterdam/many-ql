
from Errors import DuplicationError

class DuplicateQuestions:
    def __init__(self, questionIDs=None):
        self.errors = []
        self.questionIDs = questionIDs

    def Question(self, node):
        if node.ID in self.questionIDs:
            if node.type != self.questionIDs[node.ID].type:
                error = DuplicationError(self.questionIDs[node.ID], node)
                self.errors.append(error)
            else:
                # TODO Warning object, duplicate question but same type
                #error = DuplicationError(self.questionIDs[node.ID], node)
                pass
