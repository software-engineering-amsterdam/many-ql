import QLS.AST.Sheet.sheet_element as e


# AST for sheets
class Sheet(e.SheetElement):

    #
    # Override methods
    #

    def __init__(self, name, pages):
        self._name = name
        self._pages = pages

    def string_presentation(self, level=0):
        s = "    " * level + "Sheet " + self._name + "\n"
        for p in self._pages:
            s += p.string_presentation(level + 1)
        return s

    def get_ids(self):
        ids = []
        for p in self._pages:
            ids += p.get_ids()
        return ids

    def get_widget_dict(self):
        d = {}
        for p in self._pages:
            d = dict(list(d.items()) + list(p.get_widget_dict().items()))
        return d

    #
    # Sheet methods
    #

    def get_property_names(self):
        l = []
        for x in self._pages:
            if x.is_default():
                prop = x.get_property_names()
                l += prop
        return l

    def get_property_dict(self):
        d = {}
        for x in self._pages:
            if x.is_default():
                d = dict(list(d.items()) + list(x.get_property_dict().items()))
        return d

    def get_defaults(self):
        d = {}
        for x in self._pages:
            if x.is_default():
                d = dict(list(d.items()) + list(x.get_property_dict().items()))
        return d

    def get_pages(self):
        return self._pages