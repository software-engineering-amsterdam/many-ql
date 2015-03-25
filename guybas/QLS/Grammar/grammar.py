# Grammar for QLS

import pyparsing as pp

import QL.Grammar.grammar as form_grammar

# import all factories
from QLS.Grammar.Factory import *

# import pyparsing functions
word = pp.Word
nums = pp.nums
suppress = pp.Suppress
zero_or_more = pp.ZeroOrMore
optional = pp.Optional
literal = pp.Literal
one_or_more = pp.OneOrMore
group = pp.Group

# standard symbols
opar = suppress("(")
cpar = suppress(")")
obrac = suppress("{")
cbrac = suppress("}")
col = suppress(":")

# hexacolor :: # [A-F0-9]
hexacolor = suppress("#") + word(pp.hexnums, exact=6)

# name is a word (without escape characters)
characters = form_grammar.characters

# number :: [0-9]
number = word(nums)

# properties which can be set for widgets
default_property = (
    (suppress("font") + col + characters).setParseAction(properties.make_font) |
    (suppress("size") + col + number).setParseAction(properties.make_size) |
    (suppress("color") + col + hexacolor).setParseAction(properties.make_color) |
    (suppress("width") + col + number).setParseAction(properties.make_width) |
    (suppress("height") + col + number).setParseAction(properties.make_height))

# there is at least one property and the order doesn't matter
default_properties = group(one_or_more(default_property))

# options is a tuple of two possibilities used for radio box and drop down
options = suppress("(") + characters + suppress(",") + characters + suppress(")")

# widgets
radio = (suppress("Radio") + options).setParseAction(widget.make_radio)
checkbox = suppress("Checkbox").setParseAction(widget.make_checkbox)
spinbox = (suppress("Spinbox") + number + number).setParseAction(widget.make_spinbox)
slider = (suppress("Slider") + number + number).setParseAction(widget.make_slider)
textbox = (suppress("Textbox")).setParseAction(widget.make_textbox)
drop_down = (suppress("Dropdown") + options).setParseAction(widget.make_drop_down)

# get_widget  :: IWidget : (radio | checkbox | spinbox | slider | textbox | drop_down)
widget_decl = (suppress("Widget") + suppress(":") +
               (radio | checkbox | spinbox | slider | textbox | drop_down) +
                optional(obrac + default_properties + cbrac)).setParseAction(widget.make_widget)

# identifier for questions styles, pages, sections and sheets
identifier = form_grammar.statement_id

question_style = (suppress("Question") + identifier + optional(widget_decl)).setParseAction(qls.make_question_style)

section = \
    (suppress("Section") + identifier + obrac + group(one_or_more(question_style)) + cbrac
    ).setParseAction(qls.make_section)

# default_settings for widgets
default_setting = (suppress("Default") + form_grammar.answerR + widget_decl).setParseAction(qls.make_default)

page = (suppress("Page") + identifier + group(one_or_more(section))).setParseAction(qls.make_page)

sheet = suppress("Sheet") + identifier + group(one_or_more(page | default_setting)) + pp.StringEnd()
