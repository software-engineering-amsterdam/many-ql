
import Tkinter as tk

from tkMessageBox import showerror
from tkFileDialog import askopenfile

class FileDialog(tk.Button):
    def __init__(self, onFileSelected, *args, **kwargs):
        tk.Button.__init__(self, *args, **kwargs)

        self['text']    = 'Select file'
        self['command'] = self.openFile

        self.callback = onFileSelected
        self.pack()

    def hide(self):
        self.pack_forget()

    def show(self):
        self.pack()

    def openFile(self):
        try:
            with askopenfile(mode='r') as file:
                self.callback(file.read())
                file.close()
        except AttributeError:
            # User cancels file selection
            pass
        except Exception as err:
            pass