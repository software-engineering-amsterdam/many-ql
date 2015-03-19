import QL.GUI.Elements.element as i_element
import tkinter as tk


class Label(i_element.Element):
    def __init__(self, text):
        self.text = text
        self.rowElements = self.create()

    def create(self):
        l = tk.Label(text=self.text)  # height=x, fg='#00FFFF', bg='#000000',
        # l.grid(row=statement.get_order_number(), column=0, sticky=W)
        return [l]