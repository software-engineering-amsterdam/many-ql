import Tkinter as tk

from Boolean import Boolean

class ReadOnlyBoolean(Boolean):

    def _build(self):
        self.choiceVar = tk.BooleanVar()
        self.entry = tk.Entry(textvariable=self.choiceVar, state="readonly")
        self.addElement(self.entry)

    def setValue(self, answers):
        value = self.node.evaluate(answers)
        self.choiceVar.set(value)