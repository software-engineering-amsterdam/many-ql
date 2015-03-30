import Tkinter as tk

class Widget():
    def __init__(self, Frame, node, answers):
        self.Frame = Frame
        self.node  = node
        self.answers = answers

        self.elements = []

        self.createLabel()

    def createLabel(self):
        text = self.node.labelText()

        label = tk.Label(self.Frame, text=text)
        label.grid(in_=self.Frame, sticky="w")

        self.addElement(label)

    def isReadOnly(self):
        return self.node.function

    def readOnlyValue(self):
        return self.node.function.evaluate(self.answers)

    def _buildReadOnly(self):
        var = tk.StringVar()
        var.set(self.readOnlyValue())

        self.entry = tk.Entry(textvariable=var, state="readonly")
        self.entry.grid(in_=self.Frame, sticky="ew")
        self.addElement(self.entry)

    def addElement(self, elem):
        self.elements.append(elem)

    def tearDown(self):
        for elem in self.elements:
            elem.grid_remove()

    def value(self):
        return { self.node.ID : None }