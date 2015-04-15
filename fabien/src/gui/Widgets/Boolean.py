import Tkinter as tk

from Radio import Radio

class Boolean(Radio):
    def __init__(self, *args):
        options = ([
            ("Yes", 1),
            ("No",  0)
        ])

        default = 1

        Radio.__init__(self, options, default, *args)

    def value(self):
        return self.choiceVar.get() in [True, 1, '1', 'true']
