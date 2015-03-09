import QL.Exceptions.exceptions as exceptions


class Element:
    def ___init__(self, statement, gui):
        if type(self) == Element:
            raise Exception("Element must be sub-classed.")
        self.statement = statement
        self.gui = gui
        self.element = self.create()

    def set_height(self, height=2):
        if not isinstance(height, int):
            raise exceptions.QException("height must be integer!")
        self.element.configure(height=height)

    def create(self):
        raise NotImplementedError("Not implemented by sub class")