from tkinter import *

from Main.processor import *
from Main.mapper import *


class QuestionnaireGUI:
    def __init__(self, form):
        self.qGui        = Tk()
        self.statements   = form.get_statements()
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
        self.draw_statements(self.statements)

    def draw_statements(self, statements, condition_id=False):
        for statement in statements:
            self.row_counter += 1
            if statement.is_conditional():  # TODO: fix statement condition drawing
                self.draw_conditional_q(statement, condition_id)
            else:
                self.draw_statement(statement, condition_id)

    def draw_statement(self, statement, condition_id=False):
        print(statement.get_parent_id())
        int_var = IntVar()
        str_var = StringVar()
        # print the question
        Label(text=statement.get_label(), height=2).grid(row=self.row_counter, column=0, sticky=W) #fg='#00FFFF', bg='#000000',
        # vcmd = self.qGui.register(self.validate) # we have to wrap the commandQ
        # print the input box
        if statement.get_type() is BasicTypes.bool_name:
            Radiobutton(text="True", value=1, variable=self.row_counter).grid(row=self.row_counter, column=1, sticky=W)
            Radiobutton(text="False", value=0, variable=self.row_counter).grid(row=self.row_counter, column=2, sticky=W)
            self.column_span = 2
        elif statement.get_type() is BasicTypes.number_name:
            Spinbox(from_=0, to_=10000).grid(row=self.row_counter, column=1, columnspan=self.column_span, sticky=W)
        elif statement.get_type() is BasicTypes.text_name:
            e = Entry(textvariable=str_var)
            e.bind("<KeyPress><KeyRelease>", lambda event: self.update(statement, e.get()))

            e.grid(row=self.row_counter, column=1, columnspan=self.column_span, sticky=W) # , validate="key" , validatecommand=(vcmd, '%S')
        # str_var.set("a default value")
        # s = str_var.get()

    # TODO: use update for radio button as well
    def update(self, question, new_answer):
        self.answersMap.update(question, new_answer)
        print(new_answer)

    def draw_conditional_q(self, c_question, condition_id=False):
        processor = Processor()
        condition = processor.conditions_proc(c_question.get_condition(), self.answersMap)
        # get_dependencies if condition holds
        if condition:
            # print condition's - depended statements
            self.draw_statements(c_question.get_c_statements())
        else:
            self.draw_statements(c_question.get_e_statements())

    def show(self):
        self.qGui.mainloop()