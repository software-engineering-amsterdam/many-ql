import Tkinter as tk

from Widget import Widget

class Text(Widget):
    def __init__(self, *args):
        Widget.__init__(self, *args)

        self._build()

    def _build(self):
        text = self.node.labelText()

        element = tk.Text(master=self.Frame, wrap=tk.WORD, height=6)
        element.insert(tk.END, text.strip())
        element.config(state=tk.DISABLED)

        self.addElement(element)

    def value(self):
        return ""