import tkinter as tk
from .Widgets import *
from .Styles import typeStyleTable
from tkinter import messagebox

class View(tk.Frame):
    def __init__(self, master = None, title = 'Questionnaire'):
        tk.Frame.__init__(self, master)
        self.grid()
        self.master.title(title)

    def clear(self):
        for widget in self.winfo_children():
            widget.destroy()

    def render(self, questionModel, callback):
        labelWidget = Label(self, questionModel.text)
        labelWidget.grid()

        widget = typeStyleTable()[questionModel.type](self, questionModel, callback)
        widget.grid()

    def showWarning(self, text):
        messagebox.showwarning("Warning", text)