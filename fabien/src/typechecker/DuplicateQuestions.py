
from errors import DuplicationError

class DuplicateQuestions:
    def __init__(self):
        self.errors = []
        self.questionTypes = {}

    def Question(self, node):
        if node.ID in self.questionTypes:
            if node.type != self.questionTypes[node.ID].type:
                error = DuplicationError(self.questionTypes[node.ID], node)
                self.errors.append(error)
            else:
                # TODO Warning object, duplicate question but same type
                pass
        else:
            self.questionTypes[node.ID] = node