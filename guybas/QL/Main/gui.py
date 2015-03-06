import tkinter as tk
import QL.Main.processor as processor
import QL.Main.mapper as mapper


class QuestionnaireGUI:
    def __init__(self, form):
        self.qGui = tk.Tk()
        self.form = form
        self.statements = self.form.get_statements()
        self.dependencies = self.form.get_dependencies()
        self.answersMap = mapper.Mapper()

    def generate_gui(self):
        print("_" * 50)
        # self.qGui.geometry('450x450')
        self.qGui.title(self.form.get_name())
        tk.Label(text=self.form.get_introduction(), height=2).grid(row=0, column=0, sticky=tk.W)
        self.draw_statements(self.statements)
        tk.Button(text="Submit", width=10, command=lambda: processor.export_answers(self.answersMap, self)
                  ).grid(row=999, column=0)

    def draw_statements(self, statements):
        for statement in statements:
            if statement.is_conditional():
                self.draw_statements(statement.get_c_statements())
                self.draw_statements(statement.get_e_statements())
            else:
                self.draw_statement(statement)

    def draw_statement(self, statement):
        self.answersMap.update(statement, None)
        statement.set_element(self)
        elements = statement.get_element()
        # don't print anything if has no elements (e.g. assignment)
        if elements is None:
            return False

        # check if _condition holds
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
        for qid in self.dependencies:
            if question.get_id() in self.dependencies[qid]:
                self.elements_recreate(qid)

    def elements_recreate(self, qid):
        statements_dict = self.form.get_statement_dict()
        if qid not in statements_dict:
            raise tk.QException("Fatal Error: no such _condition id " + qid)
        statement = statements_dict[qid]
        elements = statement.get_element()
        if elements is None:
            return None
        for e in elements:
            # print(e.grid_info())
            e.destroy()

        self.draw_statement(statement)

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
        e = tk.Spinbox(from_=0, to_=10000, command=lambda: gui.update(statement, None if e.get() is '' else int(e.get())))
        e.bind("<KeyPress><KeyRelease>", lambda event: gui.update(statement, None if e.get() is '' else int(e.get())))
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
        # e.grid(row=statement.get_order(), column=1, columnspan=2, sticky=W) #validate="key" ,validatecommand=(vcmd, '%S')
        e_list.append(e)
        return e_list