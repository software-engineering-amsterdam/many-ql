import Tkinter as tk

from Radio import Radio

class Gender(Radio):
    def __init__(self, *args):
        options = ([
            ("Undisclosed", "none"),
            ("Male",  "male"),
            ("Female", "female")
        ])

        default = "none"

        Radio.__init__(self, options, default, *args)
