import QL.GUI.Elements.element as i_element
import tkinter as tk


class Label(i_element.Element):
    def create(self):
        l = tk.Label(text=self.statement.get_label())  # height=x, fg='#00FFFF', bg='#000000',
        # l.grid(row=statement.get_order(), column=0, sticky=W)
        return [l]