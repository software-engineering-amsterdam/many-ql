# Grammar for QLS

from pyparsing import *
from QL.Grammar.basic_types import *
from QL.Grammar.expressions import *
from QL.Grammar.form import *

from QLS.Factory.qls import *


class Widget:
    # name :: [0-9a-zA-Z!@#$%^&*(){}[]:;"'
    name = BasicTypes.characters

    # number :: [0-9]
    number = Word(nums)

    # options :: ( (name,)* name )
    options = \
        (Suppress("(") + ZeroOrMore(name + Suppress(",")) + name + Suppress(")")
        ).setParseAction(WidgetFactory.make_option)

    # radio :: Radio options
    radio = \
        (Suppress("Radio") + options + Optional(Suppress("default") + Suppress(":") + name)
        ).setParseAction(WidgetFactory.make_radio)

    # checkbox :: Checkbox options
    checkbox = (Suppress("Checkbox") + options).setParseAction(WidgetFactory.make_checkbox)

    # spinbox :: Spinbox number number number?
    spinbox = \
        (Suppress("Spinbox") + number + number + Optional(Suppress("default") + Suppress(":") + number)
        ).setParseAction(WidgetFactory.make_spinbox)

    # slider :: Slider number number
    slider = (Suppress("Slider") + number + number).setParseAction(WidgetFactory.make_slider)

    # textbox :: Textbox number?
    textbox = (Suppress("Textbox") + Optional(number)).setParseAction(WidgetFactory.make_textbox)

    # drop_down :: Dropdown
    drop_down = (Suppress("Dropdown") + options).setParseAction(WidgetFactory.make_dropdown)

    # widget  :: Widget : (radio | checkbox | spinbox | slider | textbox | drop_down)
    widget = \
        (Suppress("Widget") + Suppress(":") + (radio | checkbox | spinbox | slider | textbox | drop_down)
        ).setParseAction(WidgetFactory.make_widget)


class QLS:

    # characters :: [0-9a-zA-Z()[]{},@#$%^&*-+=/\'\"`~_-;]
    characters = BasicTypes.characters

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

    # optionals :: (font | widget)*
    optionals = Optional(Widget.widget)

    # question_style = q : name widget?
    question_style = (Suppress("Question") + name + optionals).setParseAction(QLSFactory.make_question_style)

    # section :: Section name { question_style+ }
    section = \
        (Suppress("Section") + name + obrac + Group(OneOrMore(question_style)) + cbrac
        ).setParseAction(QLSFactory.make_section)

    #
    default_property = (
        Literal("font") + col + word |
        Literal("size") + col + integer |
        Literal("color") + col + hexacolor |
        Literal("width") + col + integer)

    #
    default_properties = OneOrMore(default_property)

    # default_settings :: Default answerR widget
    default_setting = \
        (Suppress("Default") + FormFormat.answerR + Widget.widget +
         Optional(Group(obrac + default_properties + cbrac) )
        ).setParseAction(QLSFactory.make_default)

    # page :: page name { section+ }
    page = (Suppress("Page") + name + Group(OneOrMore(section))).setParseAction(QLSFactory.make_page)

    # sheet = Sheet name page+
    sheet = Suppress("Sheet") + name + Group(OneOrMore(page | default_setting))


