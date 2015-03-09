class SheetElement:
    def __init__(self):
        raise NotImplementedError("Not implemented by sub class")

    def pretty_print(self, level=0):
        raise NotImplementedError("Not implemented by sub class")

    def get_ids(self):
        raise NotImplementedError("Not implemented by sub class")

    def get_widget_dict(self):
        raise NotImplementedError("Not implemented by sub class")

    @staticmethod
    def id_collection(elements):
        raise NotImplementedError("Not implemented by sub class")

    @staticmethod
    def id_widget_dict(elements):
        raise NotImplementedError("Not implemented by sub class")
