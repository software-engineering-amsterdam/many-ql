import QLS.AST.Sheet.sheet_element as e


# Question style AST
class QuestionStyle(e.SheetElement):

    def __init__(self, qid, widget, properties=[]):
        self._id = qid
        self._widget = widget

    def pretty_print(self, level=0):
        s = "    " * level + "Question " + self._id + "\n"
        s += self._widget.string_presentation(level + 1)
        return s

    def get_ids(self):
        return [self._id]

    def get_widget_dict(self):
        return {self._id : self._widget}

    def is_default(self):
        return False

    @staticmethod
    def id_collection(elements):
        raise NotImplementedError("Not implemented by sub class")

    @staticmethod
    def id_widget_dict():
        raise NotImplementedError("Not implemented by sub class")

