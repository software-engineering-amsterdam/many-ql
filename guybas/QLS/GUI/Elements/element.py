import QL.GUI.Elements.element as i_element
import tkinter as tk


class Element(i_element.Element):
    def set_font_style(self, style):
        for i in range(0, len(self.rowElements)):
            self.rowElements[i].configure(font=style)

    def set_bg_colour(self, bg_colour):
        for i in range(0, len(self.rowElements)):
            self.rowElements[i].configure(bg=bg_colour)

    def set_fg_colour(self, fg_colour):
        for i in range(0, len(self.rowElements)):
            self.rowElements[i].configure(fg=fg_colour)