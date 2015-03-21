import tkinter as tk
import QL.Tools.converters as converters
import QL.Runtime.mapper as mapper
import QL.Tools.exceptions as exc
import QL.Runtime.form as enriched_form
from QL.GUI.Elements import *


class GUI:
    def __init__(self, form):
        if not isinstance(form, enriched_form.Form):
            raise exc.QException("Input must be an enriched form object!")
        self.qGui = tk.Tk()
        self.__form = form
        self.__questions = self.__form.get_questions()
        self.__dependencies = self.__form.ast.get_dependencies()
        self.__answersMap = mapper.Mapper()

    def generate_gui(self):
        print("_" * 50)
        self.create_title()
        windowFrame = tk.Frame(self.qGui)
        #introduction
        # l.configure(font="Helvetica 15 bold")
        intro_element = self.intro_label(windowFrame)
        intro_element.grid(row=0, column=0, sticky=tk.W)
        self.draw_questions(self.__questions, windowFrame)
        tk.Button(windowFrame, text="Submit", width=10, command=lambda: converters.export_answers(self.__answersMap, self)
                  ).grid(row=999, column=0)

        windowFrame.pack(side="top", fill="both", expand=True)

    def create_title(self):
        self.qGui.title(self.__form.ast.get_name())

    def intro_label(self, frame):
        l = label.Label(self.__form.ast.get_introduction(), frame)
        intro_row = l.get_row()
        return intro_row[0]

    def draw_questions(self, questions, content_frame):
        for question in questions:
            self.draw_question(question, content_frame)

    def draw_question(self, question, content_frame):
        self.__answersMap.update(question, None)
        question.set_gui_element(self, content_frame)
        elements = question.get_gui_element()
        # don't print anything if has no elements (expression_factory.g. assignment)
        if elements is None:
            return False

        # check if _condition holds
        condition = question.get_condition()

        c_results = True
        if condition:
            # c_results = processor.eval_expression(condition.string_presentation(), self.__answersMap)
            # print(condition.string_presentation())
            # print(c_results)
            c_results = condition.eval_expression(self.__answersMap)
            # print(c_results)
            # print("--------")
        if not c_results:
            return False

        colspan = 1
        if len(elements) is 2:
            colspan = 2
        for i in range(0, len(elements)):
            elements[i].grid(row=question.get_order() + 1, column=i, columnspan=colspan, sticky=tk.W)

    def update(self, question, new_answer):
        self.__answersMap.update(question, new_answer)
        for qid in self.__dependencies:
            if question.ast.get_id() in self.__dependencies[qid]:
                self.elements_recreate(qid)

    def elements_recreate(self, qid):
        statements_dict = self.__form.get_statement_dict()
        if qid not in statements_dict:
            raise exc.QException("Fatal Error: no such condition id " + qid)
        question = statements_dict[qid]
        row_elements = question.get_gui_element()
        if row_elements is None:
            return None
        for e in row_elements:
            # print(expression_factory.grid_info())
            e.destroy()

        self.draw_question(question, question.get_gui_element_frame())

    def show(self):
        self.qGui.mainloop()

    def close(self):
        self.qGui.destroy()