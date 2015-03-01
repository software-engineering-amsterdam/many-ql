import tkinter as tk

class Dropdown(tk.OptionMenu):
    def __init__(self, master, questionModel, callback):
        self._value = tk.StringVar()

        if questionModel.value:
            self._value.set("yes")
        else:
            self._value.set("no")

        tk.OptionMenu.__init__(self, master, self._value, "yes", "no", command = lambda _ : callback(self.value()))

        if questionModel.isConstant:
            self.config(state = "disabled")

    def value(self):
        return self._value.get() == "yes"

class RadioButtons(tk.Frame):
    def __init__(self, master, questionModel, callback):
        tk.Frame.__init__(self, master)
        
        self._value = tk.IntVar()

        if questionModel.value:
            self._value.set("1")
        else:
            self._value.set("0")
        
        for answer, value in (("yes", 1), ("no", 0)):
            button = tk.Radiobutton(self, text = answer, variable = self._value, value = value, command = lambda : callback(self.value()))

            if questionModel.isConstant:
                button.config(state = "disabled")

            button.grid()

    def value(self):
        return bool(self._value.get())

class CheckBox(tk.Checkbutton):
    def __init__(self, master, questionModel, callback):
        self._value = tk.IntVar()
        tk.Checkbutton.__init__(self, master, text = "yes", variable = self._value, onvalue = 1, offvalue = 0, command = lambda : callback(self.value()))

        if questionModel.value:
            self.select()

        if questionModel.isConstant:
            self.config(state = "disabled")

    def value(self):
        return bool(self._value.get())

class Slider(tk.Scale):
    def __init__(self, master, questionModel, callback, lowerBound = 0, upperBound = 1000, width = 400):
        tk.Scale.__init__(self, master, from_ = lowerBound, to = upperBound, length = width, orient = tk.HORIZONTAL)
        self.bind("<ButtonRelease-1>", lambda event : callback(self.value()))

        if questionModel.value:
            self.set(questionModel.value)

        if questionModel.isConstant:
            self.config(state = "disabled")

    def value(self):
        return int(self.get())

class Spinbox(tk.Spinbox):
    def __init__(self, master, questionModel, callback, lowerBound = 0, upperBound = 1000, width = 80):
        tk.Spinbox.__init__(self, master, from_ = lowerBound, to = upperBound, width = width, command = lambda : callback(self.value()))
        
        if questionModel.value:
            self.delete(0, tk.END)
            self.insert(0, str(questionModel.value))

        if questionModel.isConstant:
            self.config(state = "readonly")
        
    def value(self):
        return int(self.get())

class TextInput(tk.Entry):
    def __init__(self, master, questionModel, callback, width = 80):
        tk.Entry.__init__(self, master, width = width)

        if questionModel.value:
            self.insert(0, questionModel.value)

        if questionModel.isConstant:
            self.config(state = "readonly")

        self.bind("<FocusOut>", lambda event : callback(self.value()))

    def value(self):
        return self.get()

class Label(tk.Label):
    def __init__(self, master, text, width = 80, height = 1):
        tk.Label.__init__(self, master, text = text, width = width, height = height)