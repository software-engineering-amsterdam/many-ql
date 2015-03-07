# Grammar for QLS

from pyparsing import *
from QL.Grammar.basic_types import *
from QL.Grammar.expressions import *
from QL.Grammar.form import *
from QLS.Factory.qls import *
from QLS.Grammar.widget import *

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


