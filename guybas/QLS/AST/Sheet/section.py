import QLS.AST.Sheet.sheet_element as e


# AST for section
class Section(e.SheetElement):
    def __init__(self, name, question_styles):
        self._name = name
        self._question_styles = question_styles
        self._ids = Section.id_collection(self._question_styles)
        self._widget_dict = Section.id_widget_dict(self._question_styles)

    def pretty_print(self, level=0):
        s = "    " * level + "Section " + self._name + "\n"
        for p in self._question_styles:
            s += p.string_presentation(level + 1)
        return s

    def get_ids(self):
        return self._ids

    def get_widget_dict(self):
        return self._widget_dict

    def get_question_styles(self):
        return self._question_styles

    @staticmethod
    def id_collection(question_styles):
        ids = []
        for q in question_styles:
            ids += q.get_ids()
        return ids

    @staticmethod
    def id_widget_dict(question_styles):
        d = {}
        for s in question_styles:
            d = dict(list(d.items()) + list(s.get_widget_dict().items()))
        return d