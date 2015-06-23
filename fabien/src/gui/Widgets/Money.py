import Tkinter as tk

from LabelWidget import LabelWidget

class Money(LabelWidget):
    def __init__(self, *args):
        LabelWidget.__init__(self, *args)

        self._build()

    def _build(self):
        self.inputVar = tk.DoubleVar()
        self.inputVar.trace("w", self._onChange)

        self.entry = tk.Entry(textvariable=self.inputVar)
        self.addElement(self.entry)

    # tkInter 'trace' is not a real event
    def _onChange(self, ID=None, callback=None, mode=None):
        self.onChange(None)

    def value(self):
        try:
            val = self.inputVar.get()
            return val
        except ValueError:
            self.setInvalid()
            return 0