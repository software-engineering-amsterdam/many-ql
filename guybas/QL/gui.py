from tkinter import *


class QuestionnaireGUI:
    def __init__(self, form):
        self.fGui      = Tk()
        self.form      = form
        self.name      = form.name
        self.questions = form.get_questions()

    def generate_gui(self):
        for question in self.questions:
            print(question.get_answertype())

# mGui = Tk()
# mGui.geometry('450x450')
# mGui.title('Hello World')
# mVar = IntVar()
# mVar2 = IntVar()
#
# def echoHello():
#     print("Shalom Le Kolam!!")
#
# def food():
#     print("Yummy!!")
#
# # mLabel = Label(text='Welcome to my questionnaire !', fg='#00FFFF', bg='#000000', height=2).place(x=0,y=0)
# # check1 = Checkbutton(mGui, state=ACTIVE, variable=mVar, onvalue=1, offvalue=0, height=2, width=2, command=print("hello!")).place(x=400,y=0)
# Label(text='Welcome to my questionnaire !', fg='#FF0000', bg='#000000', height=2).grid(row=0,column=0, sticky=W)
#
# Label(text='What do you like to eat?', fg='#00FFFF', bg='#000000', height=2).grid(row=1,column=0, sticky=W)
# Label(text='Falafel', fg='#00FFFF', bg='#000000', height=2).grid(row=1,column=1, sticky=W)
# c1 = Checkbutton(state=ACTIVE, variable=mVar, onvalue=1, offvalue=0, height=2, width=2, command=food).grid(row=1,column=2)
# Label(text='Pizza', fg='#00FFFF', bg='#000000', height=2).grid(row=1,column=3, sticky=W)
# c2 = Checkbutton(state=ACTIVE, variable=mVar2, onvalue=1, offvalue=0, height=2, width=2, command=food).grid(row=1,column=4)
# Button(text='submit', width=10, command=echoHello).place(x=180, y=300)
#
#
# mGui.mainloop()