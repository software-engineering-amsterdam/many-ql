import Tkinter as tk

from Base import Widget

class String(Widget):
    def __init__(self, Frame, node):
        Widget.__init__(self, Frame, node)

        self.entry = tk.Entry()
        self.entry.grid(in_=self.Frame, sticky="ew")

        self.elements.append(self.entry)

    def value(self):
        return { self.node.ID : self.entry.get() }