import tkinter as tk
import QL.Runtime.processor as processor
import QL.Runtime.mapper as mapper
import QL.CoreTools.exceptions as exc
from QL.GUI.Elements import *


class GUI:
    def __init__(self, form):
        self.qGui = tk.Tk()
        self._form = form
        self._statements = self._form.get_statements()
        self._dependencies = self._form.get_dependencies()
        self._answersMap = mapper.Mapper()
        self.intro_element = self.intro_label()

    def generate_gui(self):
        print("_" * 50)
        self.create_title()
        #introduction
        # l.configure(font="Helvetica 15 bold")
        self.intro_element.grid(row=0, column=0, sticky=tk.W)

        self.draw_statements(self._statements)
        tk.Button(text="Submit", width=10, command=lambda: processor.Processor.export_answers(self._answersMap, self)
                  ).grid(row=999, column=0)

    def create_title(self):
        self.qGui.title(self._form.get_name())

    def intro_label(self):
        l = label.Label(self._form.get_introduction())
        intro_row = l.get_row()
        return intro_row[0]

    def draw_statements(self, statements):
        for statement in statements:
            if statement.is_conditional():
                self.draw_statements(statement.get_c_statements())
                self.draw_statements(statement.get_e_statements())
            else:
                self.draw_statement(statement)

    def draw_statement(self, statement):
        self._answersMap.update(statement, None)
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
            c_results = p.eval_expression(condition.pretty_print(), self._answersMap)
        if not c_results:
            return False

        colspan = 1
        if len(elements) is 2:
            colspan = 2
        for i in range(0, len(elements)):
            elements[i].grid(row=statement.get_order() + 1, column=i, columnspan=colspan, sticky=tk.W)

    def update(self, question, new_answer):
        self._answersMap.update(question, new_answer)
        for qid in self._dependencies:
            if question.get_id() in self._dependencies[qid]:
                self.elements_recreate(qid)

    def elements_recreate(self, qid):
        statements_dict = self._form.get_statement_dict()
        if qid not in statements_dict:
            raise exc.QException("Fatal Error: no such _condition _id " + qid)
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