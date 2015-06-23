import Tkinter as tk

from LabelWidget import LabelWidget

class String(LabelWidget):
    def __init__(self, *args):
        LabelWidget.__init__(self, *args)

        self._build()

    def _build(self):
        self.inputVar = tk.StringVar()
        self.inputVar.trace("w", self._onChange)

        self.entry = tk.Entry(textvariable=self.inputVar)
        self.addElement(self.entry)

    def _onChange(self, ID=None, callback=None, mode=None):
        self.onChange(None)

    def value(self):
        value = self.inputVar.get()
        return value.encode('utf8').strip()