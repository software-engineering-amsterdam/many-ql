import QL.GUI.Elements.element as i_element
import tkinter as tk
import QL.GUI.Elements.label as e_label


class SpinBox(i_element.Element):
    def create(self):
        e_list = []
        label = e_label.Label(self.statement.get_label(), self.frame)
        e_list += label.get_row()
        e = tk.Spinbox(self.frame, from_=0, to_=10000, command=lambda: self.gui.update(self.statement, None if e.get() is '' else int(e.get())))
        # print(e.winfo_height())
        e.bind("<KeyPress><KeyRelease>", lambda event: self.gui.update(self.statement, None if e.get() is '' else int(e.get())))
        # expression_factory.grid(row=statement.get_order(), column=1, columnspan=2, sticky=W)
        e_list.append(e)
        return e_list