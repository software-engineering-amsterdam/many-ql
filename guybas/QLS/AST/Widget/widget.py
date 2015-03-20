class Widget:
    def __init__(self):
        raise NotImplementedError("Not implemented by sub class")

    def string_presentation(self, level=0):
        raise NotImplementedError("Not implemented by sub class")

    def get_compatible(self):
        raise NotImplementedError("Not implemented by sub class")

    def get_settings(self):
        raise NotImplementedError("Not implemented by sub class")

    def set_settings(self, dictionary):
        raise NotImplementedError("Not implemented by sub class")

    def widget_name(self):
        raise NotImplementedError("Not implemented by sub class")





