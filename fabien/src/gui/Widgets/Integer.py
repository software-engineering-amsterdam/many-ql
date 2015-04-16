import Tkinter as tk

from LabelWidget import LabelWidget

class Integer(LabelWidget):
    def __init__(self, *args):
        LabelWidget.__init__(self, *args)

        self._build()

    def _build(self):
        self.inputVar = tk.IntVar()
        self.inputVar.set(0)
        self.inputVar.trace("w", self._onChange)

        self.entry = tk.Entry(textvariable=self.inputVar)
        self.addElement(self.entry)

    def _onChange(self, ID=None, callback=None, mode=None):
        self.onChange(None)

    def value(self):
        try:
            val = self.inputVar.get()
            return val
        except ValueError:
            self.setInvalid()
            return 0