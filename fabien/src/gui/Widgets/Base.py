import Tkinter as tk

class Widget():
    def __init__(self, Frame, node):
        self.Frame = Frame
        self.node  = node
        self.elements = []

        self.createLabel()


    def createLabel(self):
        text = self.node.labelText()

        label = tk.Label(self.Frame, text=text)
        label.grid(in_=self.Frame, sticky="w")

        self.addElement(label)


    def addElement(self, elem):
        self.elements.append(elem)


    def tearDown(self):
        for elem in self.elements:
            elem.grid_remove()
