import Tkinter as tk

from Widget import Widget

class LabelWidget(Widget):
    def __init__(self, *args):
        Widget.__init__(self, *args)
        self.createLabel()

    def createLabel(self):
        text = self.node.labelText()
        self.label = tk.Label(self.Frame, text=text, pady=6, font=("Helvetica", 10, "bold"))
        self.originalColor = self.label.cget('fg')

        self.addElement(self.label)

    def setValid(self):
        self.label.config(fg=self.originalColor)

    def setInvalid(self):
        self.label.config(fg='red')