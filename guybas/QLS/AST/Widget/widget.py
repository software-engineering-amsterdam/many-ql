class Widget:
    def __init__(self):
        raise NotImplementedError("Not implemented by sub class")

    def pretty_print(self, level=0):
        raise NotImplementedError("Not implemented by sub class")

    def get_compatible(self):
        raise NotImplementedError("Not implemented by sub class")


