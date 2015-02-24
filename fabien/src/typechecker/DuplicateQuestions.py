
class DuplicateQuestions():
    def __init__(self):
        self.errors = []
        self.questionTypes = {}

    def Question(self, node):
        if node.label in self.questionTypes:
            if node.type != self.questionTypes[node.label]:
                errors.add(node) # Error object
            else:
                # Warning object, duplicate question but similar type
                pass
        else:
            self.questionTypes[node.label] = node.type