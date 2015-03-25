class SheetElement:
    def __init__(self):
        raise NotImplementedError("Not implemented by sub class")

    def string_presentation(self, level=0):
        raise NotImplementedError("Not implemented by sub class")

    def get_ids(self):
        raise NotImplementedError("Not implemented by sub class")

    def get_widget_dict(self):
        raise NotImplementedError("Not implemented by sub class")
