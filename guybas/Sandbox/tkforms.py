import sys
from tkinter import *
mGui = Tk()
mGui.geometry('450x450')
mGui.title('Hello World')
mVar = IntVar()
check1 = Checkbutton(mGui, state=ACTIVE, variable=mVar, onvalue=1, offvalue=0, height=10, width=10, command=print("hello!")).pack()
# check1.se()
mGui.mainloop()
