import QL.GUI.Elements.element as i_element
import tkinter as tk
import QL.GUI.Elements.label as e_label


class TextEntry(i_element.Element):
    def create(self):
        e_list = []
        label = e_label.Label(self.statement.get_label())
        e_list += label.get_row()
        str_var = tk.StringVar()
        e = tk.Entry(textvariable=str_var)
        e.bind("<KeyPress><KeyRelease>", lambda event: self.gui.update(self.statement, e.get()))
        # expression_factory.grid(row=statement.get_order_number(), column=1, columnspan=2, sticky=W) #validate="key" ,validatecommand=(vcmd, '%S')
        e_list.append(e)
        return e_list