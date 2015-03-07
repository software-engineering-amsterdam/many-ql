# Question style AST
class QuestionStyle:
    def __init__(self, qid, widget):
        self.id = qid
        self.widget = widget

    def pretty_print(self, level=0):
        s = "    " * level + "Question " + self.id + "\n"
        s += self.widget.pretty_print(level + 1)
        return s

    def id_collection(self):
        return [self.id]
