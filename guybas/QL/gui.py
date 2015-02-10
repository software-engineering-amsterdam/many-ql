from tkinter import *
from ast import *
from processor import *
import sys


class QuestionnaireGUI:
    def __init__(self, form):
        self.qGui        = Tk()
        # self.form      = form
        self.questions   = form.get_questions()
        self.title       = form.get_name()
        self.intro       = form.get_introduction()
        self.column_span = 1
        self.row_counter = 0

    def generate_gui(self):
        print("_" * 50)
        # self.qGui.geometry('450x450')
        self.qGui.title(self.title)
        Label(text=self.intro, fg='#00FFFF', bg='#000000', height=2).grid(row=self.row_counter, column=0, sticky=W)
        self.draw_questions(self.questions)

    def draw_questions(self, questions):
        for question in questions:
            self.row_counter += 1
            if isinstance(question, ConditionalQuestions):
                self.draw_conditional_q(question)
                continue
            self.draw_question(question)

    def draw_question(self, question):
        int_var = IntVar()
        str_var = StringVar()
        # print the question
        Label(text=question.get_label(), fg='#00FFFF', bg='#000000', height=2).grid(row=self.row_counter, column=0, sticky=W)
        # print the input box
        if question.get_type() is 'bool':
            Radiobutton(text="True", value=1, variable=self.row_counter).grid(row=self.row_counter, column=1, sticky=W)
            Radiobutton(text="False", value=0, variable=self.row_counter).grid(row=self.row_counter, column=2, sticky=W)
            self.column_span = 2
        elif question.get_type() is 'integer':
            Spinbox(from_=0, to_=10000).grid(row=self.row_counter, column=1, columnspan=self.column_span, sticky=W)
        elif question.get_type() is 'text':
            Entry(textvariable=str_var).grid(row=self.row_counter, column=1, columnspan=self.column_span, sticky=W)

    def draw_conditional_q(self, c_question):
        processor = Processor()
        condition = processor.conditions_proc(c_question.get_condition())
        if condition:
            self.draw_questions(c_question.get_c_questions())

    def show(self):
        self.qGui.mainloop()

# mGui = Tk()
# mGui.geometry('450x450')
# mGui.title('Hello World')
# mVar = IntVar()
# mVar2 = IntVar()
#
# def echoHello():
#     print("Shalom Le Kolam!!")
#
# def food():
#     print("Yummy!!")
#
# # mLabel = Label(text='Welcome to my questionnaire !', fg='#00FFFF', bg='#000000', height=2).place(x=0,y=0)
# # check1 = Checkbutton(mGui, state=ACTIVE, variable=mVar, onvalue=1, offvalue=0, height=2, width=2, command=print("hello!")).place(x=400,y=0)
# Label(text='Welcome to my questionnaire !', fg='#FF0000', bg='#000000', height=2).grid(row=0,column=0, sticky=W)
#
# Label(text='What do you like to eat?', fg='#00FFFF', bg='#000000', height=2).grid(row=1,column=0, sticky=W)
# Label(text='Falafel', fg='#00FFFF', bg='#000000', height=2).grid(row=1,column=1, sticky=W)
# c1 = Checkbutton(state=ACTIVE, variable=mVar, onvalue=1, offvalue=0, height=2, width=2, command=food).grid(row=1,column=2)
# Label(text='Pizza', fg='#00FFFF', bg='#000000', height=2).grid(row=1,column=3, sticky=W)
# c2 = Checkbutton(state=ACTIVE, variable=mVar2, onvalue=1, offvalue=0, height=2, width=2, command=food).grid(row=1,column=4)
# Button(text='submit', width=10, command=echoHello).place(x=180, y=300)
#
#
# mGui.mainloop()