import QLS.AST.Sheet.sheet_element as e


class Page(e.SheetElement):

    def __init__(self, name, sections):
        self._name = name
        self._sections = sections

    def string_presentation(self, level=0):
        s = "    " * level + "Page " + self._name + "\n"
        for p in self._sections:
            s += p.__str__(level+1)
        return s

    def get_ids(self):
        ids = []
        for q in self._sections:
            ids += q.ids()
        return ids

    def get_widget_dict(self):
        d = {}
        for s in self._sections:
            d = dict(list(d.items()) + list(s.get_widget_dict().items()))
        return d

    def is_default(self):
        return False

    def get_sections(self):
        return self._sections

    def is_default(self):
        return False