import tkinter as tk
import QL.Tools.converters as converters
import QL.Runtime.mapper as mapper
import QL.AST.Statements.assignment as ast_assign
import QL.Runtime.form as enriched_form
from QL.GUI.Elements import *


class GUI:
    def __init__(self, form):
        assert isinstance(form, enriched_form.Form), "the input is not of type Form"
        self.qGui = tk.Tk()
        self.__form = form
        self.__questions = self.__form.get_questions()
        self.__dependencies = self.__form.ast.get_dependencies()
        self.__answersMap = mapper.Mapper()
        self.__assignments = self.__form.get_assignments()

    def generate_gui(self):
        print("_" * 50)
        self.create_title()
        windowFrame = tk.Frame(self.qGui)
        #introduction
        intro_element = self.intro_label(windowFrame)
        intro_element.grid(row=0, column=0, sticky=tk.W)
        self.draw_questions(self.__questions, windowFrame)
        self.map_assignments()
        tk.Button(windowFrame, text="Submit", width=10, command=lambda: converters.export_answers(self.__answersMap, self)
                  ).grid(row=999, column=0)

        windowFrame.pack(side="top", fill="both", expand=True)

    def create_title(self):
        self.qGui.title(self.__form.ast.get_name())

    def intro_label(self, frame):
        l = label.Label(self.__form.ast.get_introduction(), frame)
        intro_row = l.get_row()
        return intro_row[0]

    def map_assignments(self):
        for ass in self.__assignments:
            self.__answersMap.update(ass.get_id(), None)

    def draw_questions(self, questions, content_frame):
        for question in questions:
            self.draw_question(question, content_frame)
        self.__update_assignments_ref()

    def draw_question(self, question, content_frame):
        self.__answersMap.update(question.ast.get_id(), None)
        question.set_gui_element(self, content_frame)
        elements = question.get_gui_element()
        # don't print anything if has no elements (expression_factory.g. assignment)
        if elements is None:
            return False

        # check if condition holds
        condition = question.get_condition()
        if condition and not condition.eval_expression(self.__answersMap):
            return False

        colspan = 1
        if len(elements) is 2:
            colspan = 2
        for i in range(0, len(elements)):
            elements[i].grid(row=question.get_order() + 1, column=i, columnspan=colspan, sticky=tk.W)

    def update(self, question, new_answer):
        self.__answersMap.update(question.ast.get_id(), new_answer)
        self.__update_assignments_ref()
        for qid in self.__dependencies:
            if question.ast.get_id() in self.__dependencies[qid]:
                self.elements_recreate(qid)

    def __update_assignments_ref(self):
        for assignment in self.__assignments:
            ass_id = assignment.get_id()
            answer = assignment.evaluate_expression(self.__answersMap)
            self.__answersMap.update(ass_id, answer)

    def elements_recreate(self, qid):
        statements_dict = self.__form.get_statement_dict()
        question = statements_dict[qid]

        if isinstance(question, ast_assign.Assignment):
            return None

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