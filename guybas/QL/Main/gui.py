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
        self.elementsMap = {}  # structure: {parent_id: {_statements:List, guiElements:List} .. }
        self.varsCondMap = {}

    def generate_gui(self):
        print("_" * 50)
        # self.qGui.geometry('450x450')
        self.qGui.title(self.title)
        Label(text=self.intro, height=2).grid(row=self.row_counter, column=0, sticky=W)
        self.draw_statements(self.statements)

    def draw_statements(self, statements):
        for statement in statements:
            self.row_counter += 1
            parent_id = statement.get_parent_id()
            if parent_id not in self.elementsMap:
                self.elementsMap[parent_id] = {'statements': [], 'guiElements': []}
            if statement.is_conditional():  # TODO: fix statement condition drawing
                self.elementsMap[parent_id]['statements'] = [statement]
                self.draw_conditional_q(statement)
            else:
                if statement.get_id() not in self.varsCondMap:
                    # self.elementsMap[parent_id]['statements'] = [statement]
                    self.varsCondMap[statement.get_id()] = []
                self.draw_statement(statement)

    def draw_statement(self, statement):
        parent_id = statement.get_parent_id()
        int_var = IntVar()
        str_var = StringVar()
        l = Label(text=statement.get_label(), height=2) #fg='#00FFFF', bg='#000000',
        l.grid(row=self.row_counter, column=0, sticky=W)
        # vcmd = self.qGui.register(self.validate) # we have to wrap the commandQ
        self.elementsMap[parent_id]['guiElements'] += [l]
        if statement.get_type() is BasicTypes.bool_name:
            e1 = Radiobutton(text="True", value=1, variable=self.row_counter,
                             command=lambda: self.update(statement, True))
            e2 = Radiobutton(text="False", value=0, variable=self.row_counter,
                             command=lambda: self.update(statement, False))
            # e2.select()  # set default as False
            # e2.deselect()  # clean selection
            e1.grid(row=self.row_counter, column=1, sticky=W)
            e2.grid(row=self.row_counter, column=2, sticky=W)
            self.column_span = 2
            self.elementsMap[parent_id]['guiElements'] += [e1, e2]
        elif statement.get_type() is BasicTypes.number_name:
            e = Spinbox(from_=0, to_=10000)
            e.bind("<KeyPress><KeyRelease>", lambda event: self.update(statement, e.get()))
            e.grid(row=self.row_counter, column=1, columnspan=self.column_span, sticky=W)
            self.elementsMap[parent_id]['guiElements'] += [e]
        elif statement.get_type() is BasicTypes.text_name:
            e = Entry(textvariable=str_var)
            e.bind("<KeyPress><KeyRelease>", lambda event: self.update(statement, e.get()))
            e.grid(row=self.row_counter, column=1, columnspan=self.column_span, sticky=W) # , validate="key" , validatecommand=(vcmd, '%S')
            self.elementsMap[parent_id]['guiElements'] += [e]
        # str_var.set("a default value")
        # s = str_var.get()

    def update(self, question, new_answer):
        print(new_answer)
        self.answersMap.update(question, new_answer)
        pointers = self.varsCondMap[question.get_id()]
        # self.elements_recreate(pointers[0])
        for pointer in pointers:
            # print(pointer)
            self.elements_recreate(pointer)

    def elements_recreate(self, parent_id):
        if parent_id not in self.elementsMap:
            raise QException("Fatal Error: no such condition id " + parent_id)
        # idx = len(self.elementsMap[parent_id]['guiElements'])
        for e in self.elementsMap[parent_id]['guiElements']:
            e.destroy()
        # self.elementsMap[parent_id]['guiElements'] = []
        statements_to_recreate = list(self.elementsMap[parent_id]['statements'])
        del self.elementsMap[parent_id]
        self.draw_statements(statements_to_recreate)

    def draw_conditional_q(self, c_question):
        processor = Processor()
        condition = processor.conditions_proc(c_question.get_condition(), self.answersMap)

        # map variables/question id to conditions where they are used
        vars = processor.extract_variables(c_question.get_condition())
        for v in vars:
            if v in self.varsCondMap:
                if c_question.get_parent_id() not in self.varsCondMap[v]:
                    self.varsCondMap[v].append(c_question.get_parent_id())
            else:
                self.varsCondMap[v] = [c_question.get_parent_id()]

        # get_dependencies if condition holds
        if condition:
            # print condition's - depended statements
            self.draw_statements(c_question.get_c_statements())
        else:
            self.draw_statements(c_question.get_e_statements())

    def show(self):
        self.qGui.mainloop()