import QL.GUI.gui as ql_gui
import tkinter as tk


class GUI(ql_gui.GUI):
    def resize_window(self, height, width):
        self.qGui.geometry(str(height) + 'x' + str(width))

    def set_intro_font_style(self, font_style):
        """
        set introduction font style
        :param font_style: family size weight (expression_factory.g. Helvetica 15 bold)
        :return:
        """
        self.intro_element.configure(font=font_style)

    @staticmethod
    def draw_pages(pages):
        qGui = tk.Tk()
        container = tk.Frame(qGui)
        qGui.geometry('500x500')

        page_i = 1
        for page in pages:
            GUI.draw_page(container, page, page_i)
            page_i += 1

        container.pack(side="top", fill="both", expand=True)
        qGui.mainloop()

    @staticmethod
    def draw_page(container, page, page_i):
        p = tk.Frame(container)
        p.place(in_=container, x=0, y=0)
        tk.Label(p, text="This is page " + str(page), font="Arial 26 bold").pack(side="left", fill="both", expand=True)
        tk.Button(container, text="Page " + str(page_i), width=10, command=lambda: p.lift()).pack(side="left")