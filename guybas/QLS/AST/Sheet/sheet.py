# AST for sheets
class Sheet:
    def __init__(self, name, pages):
        self.name = name
        self.pages = pages

    def pretty_print(self, level=0):
        s = "    " * level + "Sheet " + self.name + "\n"
        for p in self.pages:
            s += p.pretty_print(level + 1)
        return s

    def get_ids(self):
        ids = []
        for q in self.pages:
            ids += q.id_collection()
        return ids

    def get_id_widget_dict(self):
        pass












