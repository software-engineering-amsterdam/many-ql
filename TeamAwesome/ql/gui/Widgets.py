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
    def __init__(self, master, lowerBound = 0, upperBound = 10, callback = None):
        if callback == None:
            callback = defaultCallback
        tk.Spinbox.__init__(self, master, from_ = lowerBound, to = upperBound, command = lambda : callback(self))

    def value(self):
        return int(self.get())

class TextInputWidget(tk.Entry):
    def __init__(self, master, width = 80, text = "", callback = None):
        tk.Entry.__init__(self, master, width = width)
        self.insert(0, text)

        if callback == None:
            callback = defaultCallback
        self.bind("<Return>", lambda x : callback(self))
        self.bind("<FocusOut>", lambda x : callback(self))

    def value(self):
        return self.get('0.0', tk.END)

def defaultCallback(widget):
    print(widget.__class__.__name__ + " was pressed!")

if __name__ == "__main__":
    gui = GUI()
    gui.master.title('Hello, World!')
    gui.mainloop()  