import QLS.AST.Sheet.page as p


# Create default setting for a question _type
class Default(p.Page):

    def __init__(self, qtype, widget, properties):
        self._type = qtype.pretty_print()
        self._widget = widget
        self._properties = properties
        self._property_names = Default.property_names(properties)

    def pretty_print(self, level=0):
        s = "    " * level + "Default " + self._type
        s += " " + self._widget.pretty_print(0)
        for i in self._properties:
            s += i.pretty_print(level + 1)
        return s

    def get_ids(self):
        return []

    def get_widget_dict(self):
        return {}

    def get_properties(self):
        return self._properties

    def get_property_names(self):
        return self._property_names

    def is_default(self):
        return True

    @staticmethod
    def id_collection(elements):
        raise NotImplementedError("Not implemented by sub class")

    @staticmethod
    def id_widget_dict(elements):
        raise NotImplementedError("Not implemented by sub class")

    @staticmethod
    def property_names(elements):
        l = []
        for e in elements:
            l.append(e.prop_name())
        return l
