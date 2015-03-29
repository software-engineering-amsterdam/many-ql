import QLS.AST.Sheet.sheet_element as e


# AST for section
class Section(e.SheetElement):
    def __init__(self, name, question_styles):
        self._name = name
        self._question_styles = question_styles

    def string_presentation(self, level=0):
        s = "    " * level + "Section " + self._name + "\n"
        for p in self._question_styles:
            s += p.__str__(level + 1)
        return s

    def get_ids(self):
        ids = []
        for q in self._question_styles:
            ids += q.ids()
        return ids

    def get_widget_dict(self):
        d = {}
        for s in self._question_styles:
            d = dict(list(d.items()) + list(s.get_widget_dict().items()))
        return d

    def get_question_styles(self):
        return self._question_styles

    def get_name(self):
        return self._name