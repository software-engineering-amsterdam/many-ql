import tkinter as tk

class Dropdown(tk.OptionMenu):
    def __init__(self, master, questionModel, callback):
        self._value = tk.StringVar()
        tk.OptionMenu.__init__(self, master, self._value, "yes", "no", command = lambda _ : callback(self.value()))
        self.update(questionModel)
        
    def update(self, questionModel):
        self.config(state = "disabled" if questionModel.isConstant else tk.NORMAL)
        self._value.set("yes" if questionModel.value else "no")

        if questionModel.isVisible:
            self.grid()
        else:
            self.grid_remove()
            
    def value(self):
        return self._value.get() == "yes"

class RadioButtons(tk.Frame):
    def __init__(self, master, questionModel, callback):
        tk.Frame.__init__(self, master)
        
        self._value = tk.IntVar()

        self._buttons = []
        
        for answer, value in (("yes", 1), ("no", 0)):
            self._buttons.append(tk.Radiobutton(self, text = answer, variable = self._value, value = value, command = lambda : callback(self.value())))
            self._buttons[-1].grid()

        self.update(questionModel)

    def update(self, questionModel):
        for button in self._buttons:
            button.config(state = "disabled" if questionModel.isConstant else tk.NORMAL)

        self._value.set("1" if questionModel.value else "0")

        if questionModel.isVisible:
            self.grid()
        else:
            self.grid_remove()


    def value(self):
        return bool(self._value.get())

class CheckBox(tk.Checkbutton):
    def __init__(self, master, questionModel, callback):
        self._value = tk.IntVar()
        tk.Checkbutton.__init__(self, master, text = "yes", variable = self._value, onvalue = 1, offvalue = 0, command = lambda : callback(self.value()))

    def update(self, questionModel): 
        if questionModel.isVisible:
            self.grid()
        else:
            self.grid_remove()

        if questionModel.value:
            self.select()
        else:
            self.deselect()

        if questionModel.isConstant:
            self.config(state = "disabled")
        else:
            self.config(state = tk.NORMAL)

    def value(self):
        return bool(self._value.get())

class Slider(tk.Scale):
    def __init__(self, master, questionModel, callback, lowerBound = 0, upperBound = 1000, width = 400):
        tk.Scale.__init__(self, master, from_ = lowerBound, to = upperBound, length = width, orient = tk.HORIZONTAL)
        self._defaultValue = lowerBound
        self.bind("<ButtonRelease-1>", lambda event : callback(self.value()))

    def update(self, questionModel): 
        if questionModel.isVisible:
            self.grid()
        else:
            self.grid_remove()

        if questionModel.value:
            self.set(questionModel.value)
        else:
            self.set(self._defaultValue)

        if questionModel.isConstant:
            self.config(state = "disabled")
        else:
            self.config(state = tk.NORMAL)

    def value(self):
        return int(self.get())

class Spinbox(tk.Spinbox):
    def __init__(self, master, questionModel, callback, lowerBound = 0, upperBound = 1000, width = 80):
        tk.Spinbox.__init__(self, master, from_ = lowerBound, to = upperBound, width = width, command = lambda : callback(self.value()))
        self.update(questionModel)
        
    def update(self, questionModel):
        if questionModel.isVisible:
            self.grid()
        else:
            self.grid_remove()

        self.delete(0, tk.END)            
        if questionModel.value:
            self.insert(0, str(questionModel.value))

        if questionModel.isConstant:
            self.config(state = "readonly")
        else:
            self.config(state = tk.NORMAL)

    def value(self):
        return int(self.get())

class TextInput(tk.Entry):
    def __init__(self, master, questionModel, callback, width = 80):
        tk.Entry.__init__(self, master, width = width)
        self.bind("<FocusOut>", lambda event : callback(self.value()))
        self.update(questionModel)

    def update(self, questionModel):
        if questionModel.isVisible:
            self.grid()
        else:
            self.grid_remove()

        self.delete(0, tk.END)   
        if questionModel.value:
            self.insert(0, questionModel.value)

        if questionModel.isConstant:
            self.config(state = "readonly")
        else:
            self.config(state = tk.NORMAL)

    def value(self):
        return self.get()

class Label(tk.Label):
    def __init__(self, master, questionModel, width = 80, height = 1):
        tk.Label.__init__(self, master, width = width, height = height)
        self.update(questionModel)

    def update(self, questionModel):
        if questionModel.isVisible:
            self.grid()
        else:
            self.grid_remove()

        if questionModel.text:
            self.config(text = questionModel.text)