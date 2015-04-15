import Tkinter as tk

from Integer import Integer

class ReadOnlyInteger(Integer):

    def _build(self):
        self.inputVar = tk.IntVar()
        self.entry = tk.Entry(textvariable=self.inputVar, state="readonly")
        self.addElement(self.entry)

    def setValue(self, answers):
        value = self.node.evaluate(answers)
        self.inputVar.set(value)

        if value is not None:
            self.setValid()
