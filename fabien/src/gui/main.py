
from src.QL.parser import Parser
from src.Typechecker import QLTypeChecker
from FormBuilder import FormBuilder

import Tkinter as tk
from tkFileDialog import askopenfile
import tkMessageBox

import os

class GUI(tk.Tk):
    def __init__(self, debug=False, *args, **kwargs):
        tk.Tk.__init__(self, *args, **kwargs)
        self.title('Questionnaire Language (QL)')

        self.questionWidgets = []
        self.parser = Parser(debug=debug)

        self.buildWidgets()

    def run(self):
        self.mainloop()

    def buildWidgets(self):
        self.frame = tk.Frame()
        self.frame.pack(side="top", fill="both", expand=True)
        self.frame.grid_columnconfigure(0, weight=1)

        self.fileSelect = tk.Button(text="Select file", command=self.loadFile)
        self.fileSelect.pack()

    def loadFile(self):
        try:
            with askopenfile(mode='r') as file:
                self._parseContents(file.read())
                file.close()
        except AttributeError:
            # User cancels file selection
            pass
        except Exception as p:
            print p

    def _parseContents(self, contents="", callback=None):
        try:
            parsed = self.parser.parse(contents)
        except Exception as parseError:
            return tkMessageBox.showerror(
                "Parsing file",
                "Cannot parse file `%s`\n\n%s" % (self.fileName, parseError)
            )

        self._typeCheck(parsed)

    def _typeCheck(self, parsed):
        checker = QLTypeChecker(parsed)

        if checker.hasErrors:
            errors = checker.getErrorMessages()

            tkMessageBox.showerror(
                "Typechecking",
                "\n\n".join(errors)
            )

        else:
            self._buildForm(parsed)

    def _buildForm(self, parsed):
        # Hide file select
        self.fileSelect.pack_forget()

        # Display button for progress
        self.nextButton = tk.Button(text="Next question", command=self._next)
        self.nextButton.pack()

        # Start initial question
        self.builder = FormBuilder(self.frame, parsed)
        self._nextQuestion()


    def _next(self):
        current = self.questionWidgets[-1]
        #print current.get()

        self._nextQuestion()


    def _nextQuestion(self):
        questionWidget = self.builder.nextQuestion()

        if questionWidget:
            self.questionWidgets.append(questionWidget)

        else:
            # TODO display form results?
            print "Done!"
            self._reset()


    def _reset(self):
        # Reset frame height
        #self.frame.pack(side="top", fill="both", expand=True)
        self.frame.grid_columnconfigure(0, weight=1)

        # Display fileSelect button
        self.fileSelect.pack()

        for entry in self.questionWidgets:
            entry.tearDown()

        self.nextButton.pack_forget()

