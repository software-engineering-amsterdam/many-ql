
class UndefinedQuestions():
    def __init__(self):
        self.errors = []
        self.questionLabels = set()

    def Question(self, node):
        self.questionLabels.add(node.label)

    def Leaf(self, node):
        if not node.Label() in self.questionLabels:
            self.errors += node
