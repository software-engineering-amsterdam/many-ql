import Tkinter as tk

class Widget():
    def __init__(self, Frame, node, onChange=None, row=0):
        self.visible = False

        self.Frame = Frame
        self.node  = node
        self.onChange = onChange

        self.row = row

        self.answers  = {}
        self.elements = []

    def _onChange(self, ID=None, callback=None, mode=None):
        pass

    def isReadOnly(self):
        return self.node.isReadOnly

    def addElement(self, elem):
        self.elements.append(elem)

    def setValid(self):
        pass

    def setInvalid(self):
        pass

    @property
    def rowCount(self):
        return len(self.elements)

    def show(self):
        self.visible = True
        startRow = self.row

        for elem in self.elements:
            elem.grid(in_=self.Frame, sticky="w", row=startRow)
            startRow += 1

    def hide(self):
        self.visible = False

        for elem in self.elements:
            elem.grid_forget()

    def tearDown(self):
        self.visible = False

        for elem in self.elements:
            elem.grid_remove()
