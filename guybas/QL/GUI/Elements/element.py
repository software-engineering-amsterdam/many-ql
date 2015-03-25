class Element:
    def __init__(self, statement, gui, frame):
        assert type(self) != Element, "The element is not sub classed"
        self.statement = statement
        self.gui = gui
        self.frame = frame
        self.rowElements = self.create()

    def get_row(self):
        return self.rowElements

    def create(self):
        raise NotImplementedError("Not implemented by sub class")