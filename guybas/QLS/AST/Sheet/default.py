import QLS.AST.Sheet.page as p


# Create default setting for a question _type
class Default(p.Page):

    def __init__(self, qtype, widget, properties):
        self._type = qtype
        self._widget = widget
        self._properties = properties

    def pretty_print(self, level=0):
        s = "\n" + "    " * level + "Default " + self._type
        s += " " + self._widget.pretty_print(0)
        if self._properties:
            s += "    " * level + str(self._properties)
        return s

    def get_ids(self):
        return []

    def get_widget_dict(self):
        return {}

    @staticmethod
    def id_collection(elements):
        raise NotImplementedError("Not implemented by sub class")

    @staticmethod
    def id_widget_dict(elements):
        raise NotImplementedError("Not implemented by sub class")
