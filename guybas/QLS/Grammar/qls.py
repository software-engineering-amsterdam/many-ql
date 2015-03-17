# Grammar for QLS

import pyparsing as pp
import QL.Grammar.grammar as form
import QLS.Factory.qls as q
from QLS.Grammar.widget import *
import QLS.Factory.properties as p
import QL.Grammar.grammar as b

class QLS:

    Suppress = pp.Suppress
    Word = pp.Word
    nums = pp.nums
    Literal = pp.Literal
    OneOrMore = pp.OneOrMore
    Optional = pp.Optional
    Group = pp.Group

    # characters :: [0-9a-zA-Z()[]{},@#$%^&*-+=/\'\"`~_-;]
    characters = b.characters

    # word :: end_sign_esc | characters
    word = b.word

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
    question_style = (Suppress("Question") + name + optionals).setParseAction(q.QLSFactory.make_question_style)

    # section :: Section _name { question_style+ }
    section = \
        (Suppress("Section") + name + obrac + Group(OneOrMore(question_style)) + cbrac
        ).setParseAction(q.QLSFactory.make_section)

    default_property = (
        (Suppress("font") + col + word).setParseAction(p.PropertyFactory.make_font) |
        (Suppress("size") + col + integer).setParseAction(p.PropertyFactory.make_size) |
        (Suppress("color") + col + hexacolor).setParseAction(p.PropertyFactory.make_color) |
        (Suppress("width") + col + integer).setParseAction(p.PropertyFactory.make_width) |
        (Suppress("height") + col + integer).setParseAction(p.PropertyFactory.make_height))

    #
    default_properties = OneOrMore(default_property)

    # default_settings :: Default answerR _widget
    default_setting = \
        (Suppress("Default") + form.answerR + Widget.widget +
         Optional(Group(obrac + default_properties + cbrac) )
        ).setParseAction(q.QLSFactory.make_default)

    # page :: page _name { section+ }
    page = (Suppress("Page") + name + Group(OneOrMore(section))).setParseAction(q.QLSFactory.make_page)

    # sheet = Sheet _name page+
    sheet = Suppress("Sheet") + name + Group(OneOrMore(page | default_setting))
