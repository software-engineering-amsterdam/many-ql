import tkinter as tk

import QL.Main.processor as processor
import QL.Main.mapper as mapper


class QuestionnaireGUI:
    def __init__(self, form):
        self.qGui = tk.Tk()
        self.form = form
        self.statements = self.form.get_statements()
        self.title = self.form.get_name()
        self.intro = self.form.get_introduction()
        self.dependencies = self.form.get_dependencies()
        self.column_span = 1
        self.row_counter = 0
        self.answersMap = mapper.Mapper()
        self.elementsMap = {}  # structure: {parent_id: {_statements:List, guiElements:List} .. }
        self.varsCondMap = {}
        # self.statements_dict = form.get_statement_dict()
        # print(form.get_statement_dict())

    def generate_gui(self):
        print("_" * 50)
        # self.qGui.geometry('450x450')
        self.qGui.title(self.title)
        tk.Label(text=self.intro, height=2).grid(row=0, column=0, sticky=tk.W)
        self.draw_statements(self.statements)
        tk.Button(text="Submit", width=10, command=lambda: processor.export_answers(self.answersMap, self)).grid(row=999,column=0)

    def draw_statements(self, statements):
        for statement in statements:
            if statement.is_conditional():
                self.draw_statements(statement.get_c_statements())
                self.draw_statements(statement.get_e_statements())
            else:
                self.draw_statement(statement)
            # self.row_counter += 1
            # parent_id = statement.get_parent_id()
            # if parent_id not in self.elementsMap:
            #     self.elementsMap[parent_id] = {'statements': [], 'guiElements': []}
            # if statement.is_conditional():
            #     self.elementsMap[parent_id]['statements'].append(statement)
            #     self.draw_conditional_q(statement)
            # else:
            #     if statement.get_id() not in self.varsCondMap:
            #         self.elementsMap[parent_id]['statements'] = [statement]
                    # self.varsCondMap[statement.get_id()] = []
                # self.draw_statement(statement)

    def draw_statement(self, statement):
        # parent_id = statement.get_parent_id()
        # int_var = IntVar()
        # str_var = StringVar()
        # row = statement.get_order()
        # l = Label(text=statement.get_label(), height=2) #fg='#00FFFF', bg='#000000',
        # l.grid(row=row, column=0, sticky=W)
        self.answersMap.update(statement, None)
        # vcmd = self.qGui.register(self.validate) # we have to wrap the commandQ

        # e = statement.get_element(u)
        # print(BasicTypes.bool_name)
        # self.elementsMap[parent_id]['guiElements'] += [l]
        # if statement.get_type() is 'bool':
        #     e1 = Radiobutton(text="True", value=1, variable=self.row_counter,
        #                      command=lambda: self.update(statement, True))
        #     e2 = Radiobutton(text="False", value=0, variable=self.row_counter,
        #                      command=lambda: self.update(statement, False))
        #     # e2.select()  # set default as False
        #     # e2.deselect()  # clean selection
        #     e1.grid(row=row, column=1, sticky=W)
        #     e2.grid(row=row, column=2, sticky=W)
        #     self.column_span = 2
        #     self.elementsMap[parent_id]['guiElements'] += [e1, e2]
        # elif statement.get_type() is 'number': #BasicTypes.number_name
        #     e = Spinbox(from_=0, to_=10000)
        #     e.bind("<KeyPress><KeyRelease>", lambda event: self.update(statement, int(e.get())))
        #     e.grid(row=row, column=1, columnspan=self.column_span, sticky=W)
        #     self.elementsMap[parent_id]['guiElements'] += [e]
        # elif statement.get_type() is 'text': #BasicTypes.text_name
        #     e = Entry(textvariable=str_var)
        #     e.bind("<KeyPress><KeyRelease>", lambda event: self.update(statement, e.get()))
        #     e.grid(row=row, column=1, columnspan=self.column_span, sticky=W) # , validate="key" , validatecommand=(vcmd, '%S')
        #     self.elementsMap[parent_id]['guiElements'] += [e]
        # str_var.set("a default value")
        # s = str_var.get()

        statement.set_element(self)
        elements = statement.get_element()
        # don't print anything if has no elements (e.g. assignment)
        if elements is None:
            return False

        # check if condition holds
        condition = statement.get_parent_condition()
        c_results = True
        if condition is not None:
            p = processor.Processor()
            print(condition.pretty_print())
            c_results = p.eval_expression(condition.pretty_print(), self.answersMap)

        if not c_results:
            return False

        colspan = 1
        if len(elements) is 2:
            colspan = 2
        for i in range(0, len(elements)):
            elements[i].grid(row=statement.get_order() + 1, column=i, columnspan=colspan, sticky=tk.W)

    def update(self, question, new_answer):
        self.answersMap.update(question, new_answer)
        # pointers = self.varsCondMap[q.get_id()]
        # for pointer in pointers:
        #     self.elements_recreate(pointer)
        pointers = []
        for qid in self.dependencies:
            if question.get_id() in self.dependencies[qid]:
                self.elements_recreate(qid)

    def elements_recreate(self, qid): #parent_id
        statements_dict = self.form.get_statement_dict()
        if qid not in statements_dict:
            raise tk.QException("Fatal Error: no such condition id " + qid)
        statement = statements_dict[qid]
        elements = statement.get_element()
        if elements is None:
            return None
        for e in elements:
            # print(e.grid_info())
            e.destroy()

        self.draw_statements([statement])

        # if parent_id not in self.elementsMap:
        #     raise QException("Fatal Error: no such condition id " + parent_id)
        # idx = len(self.elementsMap[parent_id]['guiElements'])
        # for e in self.elementsMap[parent_id]['guiElements']:
        #     print(e.grid_info())
        #     e.destroy()
        # self.elementsMap[parent_id]['guiElements'] = []
        # statements_to_recreate = list(self.elementsMap[parent_id]['statements'])

        # for statement in statements_to_recreate:
        #     print(statement.pretty_print())
        # print("---" * 50)

        # del self.elementsMap[parent_id]
        # self.draw_statements(statements_to_recreate)

    # def draw_conditional_q(self, c_question):
    #     processor = Processor()
    #     condition = processor.eval_expression(c_question.get_str_condition(), self.answersMap)
    #
    #     # map variables/q id to conditions where they are used
    #     variables = c_question.get_condition().get_dependencies()
    #     for v in variables:
    #         if v in self.varsCondMap:
    #             if c_question.get_parent_id() not in self.varsCondMap[v]:
    #                 self.varsCondMap[v].append(c_question.get_parent_id())
    #         else:
    #             self.varsCondMap[v] = [c_question.get_parent_id()]
    #
    #     # get_dependencies if condition holds
    #     if condition:
    #         # print condition's - depended statements
    #         self.draw_statements(c_question.get_c_statements())
    #     else:
    #         self.draw_statements(c_question.get_e_statements())

    def show(self):
        self.qGui.mainloop()

    def close(self):
        self.qGui.destroy()

    @staticmethod
    def e_label(statement, gui):
        l = tk.Label(text=statement.get_label(), height=2) #fg='#00FFFF', bg='#000000',
        # l.grid(row=statement.get_order(), column=0, sticky=W)
        return [l]

    @staticmethod
    def e_radio(statement, gui):
        e_list = []
        e_list += QuestionnaireGUI.e_label(statement, gui)
        e1 = tk.Radiobutton(text="True", value=1, variable=statement.get_order(),
                         command=lambda: gui.update(statement, True))
        e2 = tk.Radiobutton(text="False", value=0, variable=statement.get_order(),
                         command=lambda: gui.update(statement, False))
        # e2.select()  # set default as False
        # e2.deselect()  # clean selection
        # e1.grid(row=statement.get_order(), column=1, sticky=W)
        e_list.append(e1)
        # e2.grid(row=statement.get_order(), column=2, sticky=W)
        e_list.append(e2)
        return e_list

    @staticmethod
    def e_spin(statement, gui):
        e_list = []
        e_list += QuestionnaireGUI.e_label(statement, gui)
        e = tk.Spinbox(from_=0, to_=10000)
        e.bind("<KeyPress><KeyRelease>", lambda event: gui.update(statement, e.get()))
        # e.grid(row=statement.get_order(), column=1, columnspan=2, sticky=W)
        e_list.append(e)
        return e_list

    @staticmethod
    def e_entry(statement, gui):
        e_list = []
        e_list += QuestionnaireGUI.e_label(statement, gui)
        str_var = tk.StringVar()
        e = tk.Entry(textvariable=str_var)
        e.bind("<KeyPress><KeyRelease>", lambda event: gui.update(statement, e.get()))
        # e.grid(row=statement.get_order(), column=1, columnspan=2, sticky=W) # , validate="key" , validatecommand=(vcmd, '%S')
        e_list.append(e)