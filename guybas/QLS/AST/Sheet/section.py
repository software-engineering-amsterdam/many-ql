# AST for section
class Section:
    def __init__(self, name, question_styles):
        self.name = name
        self.question_styles = question_styles

    def pretty_print(self, level=0):
        s = "\n" + "    " * level + "Section " + self.name + "\n"
        for p in self.question_styles:
            s += p.pretty_print(level + 1)
        return s

    def id_collection(self):
        ids = []
        for q in self.question_styles:
            ids += q.id_collection()
        return ids