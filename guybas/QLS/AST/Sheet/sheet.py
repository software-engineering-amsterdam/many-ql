import QLS.AST.Sheet.sheet_element as e


# AST for sheets
class Sheet(e.SheetElement):

    def __init__(self, name, pages):
        self._name = name
        self._pages = pages
        self._widget_dict = Sheet.id_widget_dict(self._pages)
        self._ids = Sheet.id_collection(self._pages)
        self._properties = Sheet.property_names(self._pages)
        self._property_dict = Sheet.property_dict_set(self._pages)

    def pretty_print(self, level=0):
        s = "    " * level + "Sheet " + self._name + "\n"
        for p in self._pages:
            s += p.pretty_print(level + 1)
        return s

    def get_ids(self):
        return self._ids

    def get_widget_dict(self):
        return self._widget_dict

    def get_property_names(self):
        return self._properties

    def get_property_dict(self):
        return self._property_dict

    def get_pages(self):
        return self._pages

    @staticmethod
    def id_collection(pages):
        ids = []
        for p in pages:
            ids += p.get_ids()
        return ids

    @staticmethod
    def id_widget_dict(pages):
        d = {}
        for p in pages:
            d = dict(list(d.items()) + list(p.get_widget_dict().items()))
        return d

    @staticmethod
    def property_names(elements):
        l = []
        for x in elements:
            if x.is_default():
                prop = x.get_property_names()
                l += prop
        return l

    @staticmethod
    def property_dict_set(elements):
        d = {}
        for x in elements:
            if x.is_default():
                d = dict(list(d.items()) + list(x.get_property_dict().items()))
        return d

    @staticmethod
    def property_dict_default(elements):
        l = []
        for x in elements:
            l += x.get_widgets
        return l
