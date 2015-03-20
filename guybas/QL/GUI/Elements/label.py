import QL.GUI.Elements.element as i_element
import tkinter as tk


class Label(i_element.Element):
    def __init__(self, text, frame):
        self.frame = frame
        self.text = text
        self.rowElements = self.create()

    def create(self):
        p = self.frame
        l = tk.Label(self.frame, text=self.text)  # height=x, fg='#00FFFF', bg='#000000',
        # l.grid(row=statement.get_order(), column=0, sticky=W)
        return [l]