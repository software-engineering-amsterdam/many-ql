class Page:
    def __init__(self, name, sections):
        self.name = name
        self.sections = sections

    def pretty_print(self, level=0):
        s = "\n" + "    " * level + "Page " + self.name + "\n"
        for p in self.sections:
            s += p.pretty_print(level+1)
        return s

    def id_collection(self):
        ids = []
        for q in self.sections:
            ids += q.id_collection()
        return ids