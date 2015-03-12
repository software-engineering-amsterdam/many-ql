class Element:
    def __init__(self, statement, gui):
        if type(self) == Element:
            raise Exception("Element must be sub-classed.")
        self.statement = statement
        self.gui = gui
        self.rowElements = self.create()

    def get_row(self):
        return self.rowElements

    def create(self):
        raise NotImplementedError("Not implemented by sub class")