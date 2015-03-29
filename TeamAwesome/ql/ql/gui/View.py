import tkinter as tk
from .Widgets import *
from .Styles import typeStyleTable
from tkinter import messagebox



class View(tk.Frame):
    def __init__(self, master = None, title = 'Questionnaire'):
        tk.Frame.__init__(self, master)
        self.grid()
        self.master.title(title)
        self.widgets = {}


    def render(self, questionModel, callback):
        labelWidget = Label(self, questionModel)
        labelWidget.grid()

        widget = typeStyleTable()[questionModel.type](self, questionModel, callback)
        widget.grid()

        self.widgets[questionModel] = (labelWidget, widget)


    def update(self, questionModel):
        for widget in self.widgets[questionModel]:
            widget.update(questionModel)


    def showWarning(self, text):
        messagebox.showwarning("Warning", text)