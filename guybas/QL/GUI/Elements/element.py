import QL.Exceptions.exceptions as exceptions


class Element:
    def __init__(self, statement, gui):
        if type(self) == Element:
            raise Exception("Element must be sub-classed.")
        self.statement = statement
        self.gui = gui
        self.rowElements = self.create()

    def set_height(self, height=2):
        if not isinstance(height, int):
            raise exceptions.QException("height must be an integer!")
        for i in range(0, len(self.rowElements) - 1):
            self.rowElements[i].configure(height=height)

    def get_row(self):
        return self.rowElements

    def create(self):
        raise NotImplementedError("Not implemented by sub class")