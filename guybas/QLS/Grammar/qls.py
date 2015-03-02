# Grammar for QLS

from pyparsing import *
from QL.Grammar.basic_types import *
from QL.Grammar.expressions import *
from QL.Grammar.form import *



class Widget:
    # name :: [0-9a-zA-Z!@#$%^&*(){}[]:;"'
    name = BasicTypes.characters

    # number :: [0-9]
    number = Expressions.number

    # options :: ( (name,)* name )
    options = Suppress("(") + ZeroOrMore(name + Suppress(",")) + name + Suppress(")")

    # radio :: Radio options
    radio = Suppress("Radio") + Group(options)

    # checkbox :: Checkbox options
    checkbox = Suppress("Checkbox") + Group(options)

    # spinbox :: Spinbox number number number?
    spinbox = Suppress("Spinbox") + number + number + Optional(number)

    # slider :: Slider number number
    slider = Suppress("Slider") + number + number

    # textbox :: Textbox number?
    textbox = Suppress("Textbox") + Optional(number)

    # drop_down :: Dropdown
    drop_down = Suppress("Dropdown") + options

    # widget  :: Widget : (radio | checkbox | spinbox | slider | textbox | drop_down)
    widget = Suppress("Widget") + Suppress(":") + (radio | checkbox | spinbox | slider | textbox | drop_down)


class QLS:

    # end_sign :: . | ? | !
    end_sign = oneOf(". ? !")

    # end_sign_esc :: \ end_sign
    end_sign_esc = Suppress("\\") + end_sign

    # characters :: [0-9a-zA-Z()[]{},@#$%^&*-+=/\'\"`~_-;]
    characters = Word(alphanums + "()[]{},@#$%^&*-+=/\'\"`~_-;")

    # word :: end_sign_esc | characters
    word = BasicTypes.word

    # name :: [0-9a-zA-Z!@#$%^&*()_-~`{}[]'"
    name = Widget.name

    # integer :: [0-9]
    integer = Word(nums)

    # ( ) { } :
    opar = Suppress("(")
    cpar = Suppress(")")
    obrac = Suppress("{")
    cbrac = Suppress("}")
    col = Suppress(":")

    # hexacolor :: # [A-F0-9]
    hexacolor = Suppress("#") + Word(hexnums, exact=6)

    # font_prop :: font : word | size : integer | color : hexacolor
    font_prop = (
        Literal("font") + col + word |
        Literal("size") + col + integer |
        Literal("color") + col+ hexacolor)

    # font :: font_prop+
    font = OneOrMore(font_prop)

    # optionals :: (font | widget)*
    optionals = ZeroOrMore(font | Widget.widget)

    # question_style = question : name widget?
    question_style = Suppress("Question") + name + optionals

    # section :: Section name { question_style+ }
    section = Suppress("Section") + name + obrac + OneOrMore(question_style) + cbrac

    # default_settings :: Default answerR widget
    default_setting = Suppress("Default") + FormFormat.answerR + Widget.widget

    # page :: page name { section+ }
    page = Suppress("Page") + name + obrac + OneOrMore(section) + cbrac

    # sheet = Sheet name page+
    sheet = Suppress("Sheet") + name + OneOrMore(page)


qls = Widget.checkbox.parseString("Checkbox ( yes, no )").asList()
print(qls)