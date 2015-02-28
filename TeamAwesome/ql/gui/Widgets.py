import tkinter as tk

class GUI(tk.Frame):
    def __init__(self, master=None):
        tk.Frame.__init__(self, master)
        self.grid()
        self.createWidgets()

    def createWidgets(self):
        self.spinbox1 = NumberSpinbox(self)
        self.spinbox1.grid()

        self.text1 = TextInputWidget(self, text = "hello!")
        self.text1.grid()

        self.quitButton = tk.Button(self, text='Quit', command=self.quit)
        self.quitButton.grid()

class NumberSpinbox(tk.Spinbox):
    def __init__(self, master, questionModel, callback, lowerBound = 0, upperBound = 1000):
        tk.Spinbox.__init__(self, master, from_ = lowerBound, to = upperBound, command = lambda : callback(self.value()))
        
        if questionModel.value:
            self.delete(0, tk.END)
            self.insert(0, str(questionModel.value))

        if questionModel.isConstant:
            self.config(state = "readonly")
        
    def value(self):
        return int(self.get())

class TextInputWidget(tk.Entry):
    def __init__(self, master, questionModel, callback, width = 80):
        tk.Entry.__init__(self, master, width = width)

        if questionModel.value:
            self.insert(0, questionModel.value)

        if questionModel.isConstant:
            self.config(state = "readonly")

        self.bind("<Return>", lambda event : callback(self.value()))
        self.bind("<FocusOut>", lambda event : callback(self.value()))

    def value(self):
        return self.get()

class LabelWidget(tk.Label):
    def __init__(self, master, text, width = 80, height = 1):
        tk.Label.__init__(self, master, text = text, width = width, height = height)