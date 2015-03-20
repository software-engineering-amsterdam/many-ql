import QLS.AST.Sheet.sheet_element as e


# Question style AST
class QuestionStyle(e.SheetElement):

    def __init__(self, qid, widget, properties=None):
        self._id = qid
        self._widget = widget
        self._properties = properties

    def string_presentation(self, level=0):
        s = "    " * level + "Question " + self._id + "\n"
        s += self._widget.string_presentation(level + 1)
        if self._properties:
            s += self._properties.string_presentation(level + 1)
        return s

    def get_ids(self):
        return [self._id]

    def get_widget_dict(self):
        return {self._id : self._widget}

    def is_default(self):
        return False



