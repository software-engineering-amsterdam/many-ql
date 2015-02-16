from tkinter import *
from ast import *
from processor import *
from grammar import *
import sys


class QuestionnaireGUI:
    def __init__(self, form):
        self.qGui        = Tk()
        self.questions   = form.get_questions()
        self.title       = form.get_name()
        self.intro       = form.get_introduction()
        self.column_span = 1
        self.row_counter = 0

    def generate_gui(self):
        print("_" * 50)
        # self.qGui.geometry('450x450')
        self.qGui.title(self.title)
        Label(text=self.intro, height=2).grid(row=self.row_counter, column=0, sticky=W)
        self.draw_questions(self.questions)

    def draw_questions(self, questions):
        for question in questions:
            self.row_counter += 1
            if question.is_conditional():
                self.draw_conditional_q(question)
                continue
            self.draw_question(question)

    def draw_question(self, question):
        int_var = IntVar()
        str_var = StringVar()
        # print the question
        Label(text=question.get_label(), height=2).grid(row=self.row_counter, column=0, sticky=W) #fg='#00FFFF', bg='#000000',
        # vcmd = self.qGui.register(self.validate) # we have to wrap the commandQ
        # print the input box
        if question.get_type() is TypesIdentifiers.bool:
            Radiobutton(text="True", value=1, variable=self.row_counter).grid(row=self.row_counter, column=1, sticky=W)
            Radiobutton(text="False", value=0, variable=self.row_counter).grid(row=self.row_counter, column=2, sticky=W)
            self.column_span = 2
        elif question.get_type() is TypesIdentifiers.integer:
            Spinbox(from_=0, to_=10000, ).grid(row=self.row_counter, column=1, columnspan=self.column_span, sticky=W)
        elif question.get_type() is TypesIdentifiers.text:
            e = Entry(textvariable=str_var)
            e.bind("<KeyPress><KeyRelease>", lambda event, data="test": self.validate(e.get()))
            
            e.grid(row=self.row_counter, column=1, columnspan=self.column_span, sticky=W) # , validate="key" , validatecommand=(vcmd, '%S')
        # str_var.set("a default value")
        # s = str_var.get()

    def validate(self, new_text):
        print(new_text)

    def draw_conditional_q(self, c_question):
        processor = Processor()
        condition = processor.conditions_proc(c_question.get_condition())
        # check if condition holds
        if condition:
            # print condition's - depended questions
            self.draw_questions(c_question.get_c_questions())
        else:
            self.draw_questions(c_question.get_e_questions())

    def show(self):
        self.qGui.mainloop()