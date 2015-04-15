
from src.QL.parser import Parser
from src.Typechecker import QLTypeChecker

from collections import OrderedDict
import Tkinter as tk
from tkFileDialog import askopenfile
import tkMessageBox

import FormElements as myTk
import Widgets

import uuid

class GUI(tk.Tk):
    def __init__(self, debug=False, storage=None, *args, **kwargs):
        tk.Tk.__init__(self, *args, **kwargs)

        self.storageDirectory = storage
        self.title('Questionnaire Language (QL)')
        self.buildWidgets()

        self.parser = Parser(debug=debug)

        # To keep output in order
        self.widgets = OrderedDict()
        self.answers = OrderedDict()

        self.questions = []
        self.branches  = []


    def run(self):
        self.mainloop()


    def buildWidgets(self):
        self.frame = tk.Frame()
        self.frame.pack(
            side="top",
            fill="both",
            expand=True,
            pady=10,
            padx=10
        )

        self.buttonBarRight = tk.Frame(padx=10, pady=10)
        self.buttonBarRight.pack(side="right", anchor="e")

        self.buttonBarLeft = tk.Frame(pady=10)
        self.buttonBarLeft.pack(side="left", anchor="w")

        self.fileSelect = myTk.FileDialog(
            master=self.frame,
            onFileSelected=self._parseContents
        )

        self.saveButton = tk.Button(
            self.buttonBarRight,
            text="Save form",
            command=self._save,
            bg='#CBE86B',
            cursor="hand2"
        )

        self.resetButton = tk.Button(
            self.buttonBarLeft,
            text="Reset",
            command=self._reset
        )

        self.cancelButton = tk.Button(
            self.buttonBarLeft,
            text="Cancel",
            command=self._cancel
        )


    def _parseContents(self, contents=""):
        self._parsed = self.parser.parse(contents)

        if self.parser.hasErrors:
            errors = self.parser.getErrorMessages()
            tkMessageBox.showerror(
                "Parsing file",
                "\n\n".join(errors)
            )
            return None

        self._typeChecking(self._parsed)


    def _typeChecking(self, parsed):
        checker = QLTypeChecker(parsed)

        if checker.hasErrors:
            errors = checker.getErrorMessages()
            tkMessageBox.showerror(
                "Typechecking",
                "\n\n".join(errors)
            )
            return None

        self._buildForm(parsed)


    def _buildForm(self, parsed):
        self.widgets = OrderedDict()
        self.answers = OrderedDict()
        self.questions = parsed.findAll("Question")
        self.branches  = parsed.findAll("Branch")

        self.fileSelect.hide()
        self.cancelButton.pack(side="left", padx=5)
        self.resetButton.pack(side="right")
        self.saveButton.pack(side="right")

        rowCount = 0
        for node in self.questions:
            try:
                nodeWidget = getattr(Widgets, node.widgetName())(self.frame, node, self.onChange, rowCount)
                self.widgets[node] = nodeWidget
                rowCount += nodeWidget.rowCount
            except Exception as err:
                print err

        # Display top-level questions
        for node in parsed.findChildren("Question"):
            self.widgets[node].show()

        self.onChange()


    def onChange(self, event=None):
        for node, widget in self.widgets.iteritems():
            widget.setValid()

            if widget.visible:
                self.answers[node] = widget.value()

        # Compute & display readOnly values
        for widget in self.widgets.values():
            if widget.isReadOnly():
                widget.setValue(self.answers)

        # Evaluate branches and display children-widgets accordingly
        for node in self.branches:
            if node.evaluate(self.answers):
                toShow = node.ifChildren
                toHide = node.elseChildren
            else:
                toShow = node.elseChildren
                toHide = node.ifChildren

            for child in toShow:
                if child in self.widgets:
                    self.widgets[child].show()

            for child in toHide:
                if child in self.widgets:
                    self.widgets[child].hide()


    def _save(self):
        userId   = uuid.uuid4()
        userFile = "%s/%s.txt" % (self.storageDirectory, userId)

        with open(userFile,'w') as f:
            for question, answer in self.answers.iteritems():
                f.write(question.labelText())
                f.write("\n")
                f.write("Answer: %s" % answer)
                f.write("\n-------------------\n")

            f.close()

        self._cancel()

    def _cancel(self):
        # Remove current widgets
        for node, widget in self.widgets.iteritems():
            widget.tearDown()

        self.saveButton.pack_forget()
        self.resetButton.pack_forget()
        self.cancelButton.pack_forget()

        self.fileSelect.show()


    def _reset(self):
        # Remove current form widgets
        for node, widget in self.widgets.iteritems():
            widget.tearDown()

        # Rebuild form
        self._buildForm(self._parsed)
