import Tkinter as tk
from Money import Money

class ReadOnlyMoney(Money):

    def _build(self):
        self.inputVar = tk.IntVar()
        self.entry = tk.Entry(textvariable=self.inputVar, state="readonly")
        self.addElement(self.entry)

    def setValue(self, answers):
        try:
            value = self.node.evaluate(answers)
            self.inputVar.set("{:20,.2f}".format(value))

            if value is not None:
                self.setValid()

        except Exception:
            pass
