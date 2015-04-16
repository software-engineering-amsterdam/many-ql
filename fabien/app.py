#!/usr/bin/env python

from src.Gui import GUI
import os

if __name__ == '__main__':
    storageDirectory = os.path.dirname("./userData/")

    gui = GUI(storage=storageDirectory)
    gui.run()