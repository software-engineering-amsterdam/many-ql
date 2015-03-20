class Element:
    def __init__(self, statement, gui, frame):
        if type(self) == Element:
            raise Exception("Primitive must be sub-classed.")
        self.statement = statement
        self.gui = gui
        self.frame = frame
        self.rowElements = self.create()

    def get_row(self):
        return self.rowElements

    def create(self):
        raise NotImplementedError("Not implemented by sub class")