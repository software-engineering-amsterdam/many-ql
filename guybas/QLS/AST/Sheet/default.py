import QLS.AST.Sheet.page as p


# Create default setting for a question _type
class Default(p.Page):

    def __init__(self, qtype, widget, properties):
        self._type = qtype
        self._widget = widget
        self._properties = properties

    def string_presentation(self, level=0):
        s = "    " * level + "Default " + self._type
        s += "    " * level + self._widget.string_presentation()
        for i in self._properties:
            s += i.string_presentation(level + 1)
        return s

    def get_ids(self):
        return []

    def get_widget_dict(self):
        return {}

    def get_properties(self):
        return self._properties

    def get_property_names(self):
        l = []
        for e in self._properties:
            l.append(e.prop_name())
        return l

    def is_default(self):
        return True

    def get_property_dict(self):
        d = {}
        for x in self._propertieselements:
            d[x.prop_name()] = x.prop_value()
        return {self._widget.widget_name(): d}
