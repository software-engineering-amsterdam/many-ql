import Tkinter as tk

from LabelWidget import LabelWidget

class Radio(LabelWidget):
    def __init__(self, options, default=None, *args):
        LabelWidget.__init__(self, *args)

        self.options = options
        self.default = default

        self._build()

    def _build(self):
        self.choiceVar = tk.StringVar()
        self.choiceVar.set(self.default)
        self.choiceVar.trace("w", self._onChange)

        for text, mode in self.options:
            button = tk.Radiobutton(
                self.Frame,
                text=text,
                variable=self.choiceVar,
                value=mode
            )

            button.bind("<Enter>", self.mouseEnter)
            self.addElement(button)

    def _onChange(self, ID=None, callback=None, mode=None):
        self.onChange(None)

    # Fix hover bug that selects options
    # http://stackoverflow.com/a/6447497/951517
    def mouseEnter(self, event):
        pass

    def value(self):
        return self.choiceVar.get()
