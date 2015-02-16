
from src.QL.parser import Parser

from Tkinter import *
from tkFileDialog import askopenfile

import os

class GUI(Frame):
    def __init__(self, debug=False):
        self.buildWidgets()

        self.parser = Parser(debug=debug)

    def buildWidgets(self):
        self.main = Frame.__init__(self, padx=6, pady=6)
        self.master.title('Questionnaire Language (QL)')

        self.columnconfigure(3)
        self.rowconfigure(2, pad=8)
        self.grid()

        # First row
        Label(self, text="Filename: ") \
            .grid(row=0, column=0, sticky=W)

        self.filename = StringVar()
        Entry(self, textvariable=self.filename, width=70) \
            .grid(row=0, column=1, sticky=W+E)

        Button(self, text="Browse", command=self.loadFile, width=14) \
            .grid(row=0, column=2, sticky=E, pady=10)

        # Output textarea

        self.console = Text(self, height=20, padx=8, pady=8)
        self.console.grid(row=1, column=0, columnspan=3)


    def loadFile(self):
        try:
            with askopenfile(mode='r') as file:
                fileName = os.path.basename(file.name)
                contents = file.read()

                self.filename.set(fileName)
                self.console.insert(END, fileName + ":\n")

                try:
                    parsed = self.parser.parse(contents)
                    self.console.insert(END, parsed)

                except Exception as p:
                    self.console.insert(END, "ParseError\n")
                    self.console.insert(END, contents)

                    self.console.tag_add('err', END - p.lineno, END - p.lineno + 1)
                    self.console.tag_configure('err', background='yellow')

                self.console.insert(END, "\n\n")

                file.close()
        except:
            pass