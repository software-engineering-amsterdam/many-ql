#!/usr/bin/env python

from src.QL.parser import Parser
from src.gui.app import GUI

# Dummy GUI app:
# File dialog to select "form" to be parsed (output displayed in terminal)
if __name__ == '__main__':
    parser = Parser()

    gui = GUI(Parser=parser)
    gui.mainloop()

