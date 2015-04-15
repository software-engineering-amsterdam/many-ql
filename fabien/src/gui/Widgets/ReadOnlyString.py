import Tkinter as tk

from String import String

class ReadOnlyString(String):

    def _build(self):
        self.inputVar = tk.StringVar()
        self.entry = tk.Entry(textvariable=self.inputVar, state="readonly")
        self.addElement(self.entry)

    def setValue(self, answers):
        value = self.node.evaluate(answers)
        self.inputVar.set(value)