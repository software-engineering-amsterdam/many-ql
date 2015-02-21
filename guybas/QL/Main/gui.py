from tkinter import *

from Main.processor import *
from Main.mapper import *


class QuestionnaireGUI:
    def __init__(self, form):
        self.qGui        = Tk()
        self.questions   = form.get_statements()
        self.title       = form.get_name()
        self.intro       = form.get_introduction()
        self.column_span = 1
        self.row_counter = 0
        self.answersMap  = Mapper()

    def generate_gui(self):
        print("_" * 50)
        # self.qGui.geometry('450x450')
        self.qGui.title(self.title)
        Label(text=self.intro, height=2).grid(row=self.row_counter, column=0, sticky=W)
        self.draw_questions(self.questions)

    def draw_questions(self, questions, condition_id=False):
        for question in questions:
            self.row_counter += 1
            if question.is_conditional():
                self.draw_conditional_q(question, condition_id)
                continue
            self.draw_question(question, condition_id)

    def draw_question(self, question, condition_id=False):
        print(question.get_parent_id())
        int_var = IntVar()
        str_var = StringVar()
        # print the question
        Label(text=question.get_label(), height=2).grid(row=self.row_counter, column=0, sticky=W) #fg='#00FFFF', bg='#000000',
        # vcmd = self.qGui.register(self.validate) # we have to wrap the commandQ
        # print the input box
        if question.get_type() is BasicTypes.bool_name:
            Radiobutton(text="True", value=1, variable=self.row_counter).grid(row=self.row_counter, column=1, sticky=W)
            Radiobutton(text="False", value=0, variable=self.row_counter).grid(row=self.row_counter, column=2, sticky=W)
            self.column_span = 2
        elif question.get_type() is BasicTypes.number_name:
            Spinbox(from_=0, to_=10000).grid(row=self.row_counter, column=1, columnspan=self.column_span, sticky=W)
        elif question.get_type() is BasicTypes.text_name:
            e = Entry(textvariable=str_var)
            e.bind("<KeyPress><KeyRelease>", lambda event: self.update(question, e.get()))

            e.grid(row=self.row_counter, column=1, columnspan=self.column_span, sticky=W) # , validate="key" , validatecommand=(vcmd, '%S')
        # str_var.set("a default value")
        # s = str_var.get()

    def update(self, question, new_answer):
        self.answersMap.update(question, new_answer)
        print(new_answer)

    def draw_conditional_q(self, c_question, condition_id=False):
        processor = Processor()
        condition = processor.conditions_proc(c_question.get_condition(), self.answersMap)
        # get_dependencies if condition holds
        if condition:
            # print condition's - depended statements
            self.draw_questions(c_question.get_c_statements())
        else:
            self.draw_questions(c_question.get_e_statements())

    def show(self):
        self.qGui.mainloop()