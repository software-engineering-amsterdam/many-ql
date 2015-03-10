import QL.GUI.gui as ql_gui


class GUI(ql_gui.GUI):
    def resize_window(self, height, width):
        self.qGui.geometry(height + 'x' + width)

    def set_intro_font_style(self, font_style):
        self.intro_element.configure(font="Helvetica 15 bold")