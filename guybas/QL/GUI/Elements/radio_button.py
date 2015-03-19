import QL.GUI.Elements.element as i_element
import tkinter as tk
import QL.GUI.Elements.label as e_label


class RadioButton(i_element.Element):
    def create(self):
        e_list = []
        label = e_label.Label(self.statement.get_label())
        e_list += label.get_row()
        e1 = tk.Radiobutton(text="True", value=1, variable=self.statement.get_order_number(),
                         command=lambda: self.gui.update(self.statement, True))
        e2 = tk.Radiobutton(text="False", value=0, variable=self.statement.get_order_number(),
                         command=lambda: self.gui.update(self.statement, False))
        # e2.select()  # set default as False
        # e2.deselect()  # clean selection
        # e1.grid(row=statement.get_order_number(), column=1, sticky=W)
        e_list.append(e1)
        # e2.grid(row=statement.get_order_number(), column=2, sticky=W)
        e_list.append(e2)
        return e_list

