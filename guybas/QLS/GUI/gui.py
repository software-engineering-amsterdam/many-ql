import QL.GUI.gui as ql_gui
import tkinter as tk
import QL.Tools.converters as converters
import QLS.Runtime.section as runtime_section


class GUI(ql_gui.GUI):
    def __init__(self, form):
        ql_gui.GUI.__init__(self, form)
        self.frames = []
        self.__pages = form.gui_pages

    def resize_window(self, height, width):
        self.qGui.geometry(str(height) + 'x' + str(width))

    def draw_questions(self, elements, content_frame):
        for element in elements:
            if isinstance(element, runtime_section.Section):
                tk.Frame(content_frame, height=1, bg="black").grid(row=element.get_order(), columnspan=999, sticky="ew")
                continue
            self.draw_question(element, content_frame)

    def generate_gui(self):
        print("_" * 50)
        self.create_title()
        windowFrame = tk.Frame(self.qGui)

        #introduction
        # l.configure(font="Helvetica 15 bold")
        intro_element = self.intro_label(windowFrame) # self.intro_element.configure(font=font_style)
        intro_element.grid(row=0, column=0, sticky=tk.W)


        page_i = 0
        for page in self.__pages:
            self.draw_page(windowFrame, page, page_i)
            page_i += 1

        # tk.Button(windowFrame, text="Submit", width=10, command=lambda: converters.export_answers(self.__answersMap, self)
        #           ).grid(row=999, column=0)

        windowFrame.pack(side="top", fill="both", expand=True)

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