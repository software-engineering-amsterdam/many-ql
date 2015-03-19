import QLS.AST.Sheet.sheet_element as e


class Page(e.SheetElement):

    def __init__(self, name, sections):
        self._name = name
        self._sections = sections
        self._ids = Page.id_collection(self._sections)
        self._widget_dict = Page.id_widget_dict(self._sections)

    def pretty_print(self, level=0):
        s = "    " * level + "Page " + self._name + "\n"
        for p in self._sections:
            s += p.string_presentation(level+1)
        return s

    def get_ids(self):
        return self._ids

    def get_widget_dict(self):
        return self._widget_dict

    def is_default(self):
        return False

    def get_sections(self):
        return self._sections

    @staticmethod
    def id_collection(sections):
        ids = []
        for q in sections:
            ids += q.get_ids()
        return ids

    @staticmethod
    def id_widget_dict(sections):
        d = {}
        for s in sections:
            d = dict(list(d.items()) + list(s.get_widget_dict().items()))
        return d

    def is_default(self):
        return False