import Tkinter as tk

from Base import Widget

class Money(Widget):
    def __init__(self, Frame, node):
        Widget.__init__(self, Frame, node)

        entry = tk.Entry()
        entry.grid(in_=self.Frame, sticky="ew")

        self.elements.append(entry)