import QL.GUI.gui as ql_gui
import tkinter as tk
import QL.Tools.converters as converters


class GUI(ql_gui.GUI):
    def __init__(self, form, pages):
        ql_gui.GUI.__init__(self, form)
        self.frames = []
        self.__pages = pages

    def resize_window(self, height, width):
        self.qGui.geometry(str(height) + 'x' + str(width))

    def set_intro_font_style(self, font_style):
        """
        set introduction font style
        :param font_style: family size weight (expression_factory.g. Helvetica 15 bold)
        :return:
        """
        self.intro_element.configure(font=font_style)

    def generate_gui(self):
        print("_" * 50)
        self.create_title()
        self.qGui.geometry('500x500')
        windowFrame = tk.Frame(self.qGui)

        #introduction
        # l.configure(font="Helvetica 15 bold")
        intro_element = self.intro_label(windowFrame)
        intro_element.grid(row=0, column=0, sticky=tk.W)


        page_i = 0
        for page in self.__pages:
            self.draw_page(windowFrame, page, page_i)
            page_i += 1


        # tk.Button(windowFrame, text="Submit", width=10, command=lambda: converters.export_answers(self.__answersMap, self)
        #           ).grid(row=999, column=0)

        # windowFrame.grid()
        windowFrame.pack(side="top", fill="both", expand=True)

    # def draw_pages(self, pages):
    #     container = tk.Frame(self.qGui)
    #     self.qGui.geometry('500x500')
    #
    #     page_i = 1
    #     for page in pages:
    #         GUI.draw_page(container, page, page_i)
    #         page_i += 1
    #
    #     container.pack(side="top", fill="both", expand=True)

    def draw_page(self, container, page, page_i):
        f = tk.Frame(container, width="300px", height="300px") # , pady="100"
        f.place(in_=container, x=0, y=0, width=0, height=0)
        self.draw_questions(page, f)
        # tk.Label(f, text="This is page " + str(page_i), font="Arial 26 bold").grid(side="left", fill="both", expand=True)
        # f.grid(row=1, columnspan=2) # TODO: should be len of pages
        if page_i == 0:
            f.grid(row=1, columnspan=len(self.__pages))
        self.frames.append(f)
        tk.Button(container, text="Page " + str(page_i), width=10, command=lambda: self.show_frame(f)
                  ).grid(row=2, column=0 + page_i)

    def show_frame(self, frame):
        for f in self.frames:
            f.grid_forget()
        frame.grid(row=1, columnspan=2)
        # frame.lift()