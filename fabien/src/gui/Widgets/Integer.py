import Tkinter as tk

from Base import Widget

class Integer(Widget):
    def __init__(self, *args):
        Widget.__init__(self, *args)

        if self.isReadOnly():
            self._buildReadOnly()
        else:
            self._build()

    def _build(self):
        self.inputVar = tk.IntVar()
        self.inputVar.set(0)

        self.entry = tk.Entry(textvariable=self.inputVar)
        self.entry.grid(in_=self.Frame, sticky="ew")

        self.addElement(self.entry)


    def value(self):
        return { self.node.ID : self.entry.get() }
