# Grammar for QLS

import pyparsing as pp

import QL.Grammar.grammar as form
import QL.Grammar.grammar as grammar

from QLS.Grammar.Factory import *

# import pyparsing functions
Word = pp.Word
nums = pp.nums
Suppress = pp.Suppress
ZeroOrMore = pp.ZeroOrMore
Optional = pp.Optional
Literal = pp.Literal
OneOrMore = pp.OneOrMore
Group = pp.Group

# _name :: [0-9a-zA-Z!@#$%^&*(){}[]:;"'
name = form.characters

# number :: [0-9]
number = Word(nums)

# options :: ( (_name,)* _name )
options = Suppress("(") + name + Suppress(",") + name + Suppress(")")

# radio :: Radio options
radio = \
    (Suppress("Radio") + options + Optional(Suppress("default") + Suppress(":") + name)
    ).setParseAction(widget.make_radio)

# checkbox :: Checkbox options
checkbox = (Suppress("Checkbox")).setParseAction(widget.make_checkbox)

# spinbox :: Spinbox number number number?
spinbox = (Suppress("Spinbox") + number + number).setParseAction(widget.make_spinbox)

# slider :: Slider number number
slider = (Suppress("Slider") + number + number).setParseAction(widget.make_slider)

# textbox :: Textbox number?
textbox = (Suppress("Textbox")).setParseAction(widget.make_textbox)

# drop_down :: Dropdown
drop_down = (Suppress("Dropdown") + options).setParseAction(widget.make_drop_down)

# _widget  :: Widget : (radio | checkbox | spinbox | slider | textbox | drop_down)
widget_decl = Suppress("Widget") + Suppress(":") + (radio | checkbox | spinbox | slider | textbox | drop_down)

# characters :: [0-9a-zA-Z()[]{},@#$%^&*-+=/\'\"`~_-;]
characters = grammar.characters

# word :: end_sign_esc | characters
word = grammar.word

opar = Suppress("(")
cpar = Suppress(")")
obrac = Suppress("{")
cbrac = Suppress("}")
col = Suppress(":")

# hexacolor :: # [A-F0-9]
hexacolor = Suppress("#") + Word(pp.hexnums, exact=6)

# optionals :: (font | _widget)*
optionals = Optional(widget_decl)

# question_style = q : _name _widget?
question_style = (Suppress("Question") + name + optionals).setParseAction(qls.make_question_style)

# section :: Section _name { question_style+ }
section = \
    (Suppress("Section") + name + obrac + Group(OneOrMore(question_style)) + cbrac
    ).setParseAction(qls.make_section)

default_property = (
    (Suppress("font") + col + word).setParseAction(properties.make_font) |
    (Suppress("size") + col + number).setParseAction(properties.make_size) |
    (Suppress("color") + col + hexacolor).setParseAction(properties.make_color) |
    (Suppress("width") + col + number).setParseAction(properties.make_width) |
    (Suppress("height") + col + number).setParseAction(properties.make_height))

#
default_properties = OneOrMore(default_property)

# default_settings :: Default answerR _widget
default_setting = \
    (Suppress("Default") + form.answerR + widget_decl +
     Optional(Group(obrac + default_properties + cbrac) )
    ).setParseAction(qls.make_default)

# page :: page _name { section+ }
page = (Suppress("Page") + name + Group(OneOrMore(section))).setParseAction(qls.make_page)

# sheet = Sheet _name page+
sheet = Suppress("Sheet") + name + Group(OneOrMore(page | default_setting))
