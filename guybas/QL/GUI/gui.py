import tkinter as tk
import QL.Tools.converters as converters
import QL.Runtime.answers_map as answers_map
import QL.Runtime.assignment as ast_assign
import QL.Runtime.form as enriched_form
from QL.GUI.Elements import *


class GUI:
    def __init__(self, runtime_form):
        assert isinstance(runtime_form, enriched_form.Form), "the input is not of type Form"
        self.qGui = tk.Tk()
        self.__form = runtime_form
        self.__questions = self.__form.statements()
        self.__dependencies = self.__form._form_ast.dependencies()
        self.__answersMap = answers_map.AnswersMap()

    def generate_gui(self):
        """
        creates gui window, draws elements etc.
        :return:
        """
        print("_" * 50)  # for debugging purposes
        self.create_title()
        window_frame = tk.Frame(self.qGui)

        intro_element = self.intro_label(window_frame)
        intro_element.grid(row=0, column=0, sticky=tk.W)

        self.eval_assignments()
        self.draw_questions(self.__questions, window_frame)
        tk.Button(window_frame, text="Submit", width=10,
                  command=lambda: converters.export_answers(self.__answersMap, self)
                  ).grid(row=999, column=0)

        window_frame.pack(side="top", fill="both", expand=True)

    def create_title(self):
        """
        window title
        :return:
        """
        self.qGui.title(self.__form.name())

    def intro_label(self, frame):
        """
        Questionnaire introduction text
        :param frame: Where to draw the label
        :return:
        """
        l = label.Label(self.__form.introduction(), frame)
        intro_row = l.get_row()
        return intro_row[0]

    #
    # Below is the main loop
    #

    def draw_questions(self, questions, content_frame):
        """
        Takes list of questions and draw them in defined frame
        :param questions: list of questions
        :param content_frame:  Where to draw
        :return:
        """
        for question in questions:
            self.draw_question(question, content_frame)

    def draw_question(self, question, content_frame):
        """
        Draws a single question
        :param question: question object
        :param content_frame: Where to draw
        :return:
        """
        question.set_gui_element(self, content_frame)
        elements = question.get_gui_element()
        if elements is None:  # assignment
            return None

        # check if condition holds
        condition = question.get_condition()
        if condition and not condition.eval_expression(self.__answersMap):
            return None

        elements_list = elements.get_row()
        for i in range(0, len(elements_list)):
            elements_list[i].grid(row=question.get_order() + 1, column=i, columnspan=len(elements_list), sticky=tk.W)

    def eval_assignments(self):
        """
        takes all assignments and eval their statement.
        answer is added to the answers map.
        :return:
        """
        for question in self.__questions:
            if isinstance(question, ast_assign.Assignment):
                self.update_assignment(question)

    # called from the widgets when they receive new answers, or when assignment is changed
    def update(self, question, new_answer):
        """
        Update the answers map when an input was changed
        :param question: Which question was answered
        :param new_answer: What is the new answer
        :return:
        """
        self.__answersMap.update(question.ast.ids()[0], new_answer)

        # For every element which has the changing answer as dependency, update it
        for qid in self.__dependencies:
            if question.ast.ids()[0] in self.__dependencies[qid]:
                self.elements_recreate(qid)

    def update_assignment(self, assignment):
        """
        Update assignments value in the answers map
        :param assignment: assignment object
        :return:
        """
        answer = assignment.evaluate_expression(self.__answersMap)
        self.update(assignment, answer)

    def elements_recreate(self, qid):
        """
        When input was changed, re-check the conditions and draw relevant elements.
        :param qid:
        :return:
        """
        statements_map = self.__form.statement_map()
        question = statements_map[qid]

        if isinstance(question, ast_assign.Assignment):
            self.update_assignment(question)

        elements = question.get_gui_element()
        if elements is None:
            return None

        elements_list = elements.get_row()
        for e in elements_list:
            e.destroy()

        self.draw_question(question, question.get_gui_element_frame())

    def show(self):
        """
        show the window
        :return:
        """
        self.qGui.mainloop()

    def close(self):
        """
        hide the window
        :return:
        """
        self.qGui.destroy()