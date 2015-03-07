# Grammar for QLS

import pyparsing as pp
import QL.Grammar.basic_types as b
import QL.Grammar.form as form
from QLS.Factory.qls import *
from QLS.Grammar.widget import *


class QLS:

    Suppress = pp.Suppress
    Word = pp.Word
    nums = pp.nums
    Literal = pp.Literal
    OneOrMore = pp.OneOrMore
    Optional = pp.Optional
    Group = pp.Group

    # characters :: [0-9a-zA-Z()[]{},@#$%^&*-+=/\'\"`~_-;]
    characters = b.BasicTypes.characters

    # word :: end_sign_esc | characters
    word = b.BasicTypes.word

    # _name :: [0-9a-zA-Z!@#$%^&*()_-~`{}[]'"
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
    hexacolor = Suppress("#") + Word(pp.hexnums, exact=6)

    # optionals :: (font | _widget)*
    optionals = Optional(Widget.widget)

    # question_style = q : _name _widget?
    question_style = (Suppress("Question") + name + optionals).setParseAction(QLSFactory.make_question_style)

    # section :: Section _name { question_style+ }
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

    # default_settings :: Default answerR _widget
    default_setting = \
        (Suppress("Default") + form.FormFormat.answerR + Widget.widget +
         Optional(Group(obrac + default_properties + cbrac) )
        ).setParseAction(QLSFactory.make_default)

    # page :: page _name { section+ }
    page = (Suppress("Page") + name + Group(OneOrMore(section))).setParseAction(QLSFactory.make_page)

    # sheet = Sheet _name page+
    sheet = Suppress("Sheet") + name + Group(OneOrMore(page | default_setting))
