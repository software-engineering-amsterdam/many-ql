import pyparsing as pp
import QL.Grammar.grammar as ql_type
import QLS.Factory.widget as factory


class Widget:
    # import pyparsing functions
    Word = pp.Word
    nums = pp.nums
    Suppress = pp.Suppress
    ZeroOrMore = pp.ZeroOrMore
    Optional = pp.Optional

    # _name :: [0-9a-zA-Z!@#$%^&*(){}[]:;"'
    name = ql_type.characters

    # number :: [0-9]
    number = Word(nums)

    # options :: ( (_name,)* _name )
    options = \
        (Suppress("(") + ZeroOrMore(name + Suppress(",")) + name + Suppress(")")
        ).setParseAction(factory.WidgetFactory.make_option)

    # radio :: Radio options
    radio = \
        (Suppress("Radio") + options + Optional(Suppress("default") + Suppress(":") + name)
        ).setParseAction(factory.WidgetFactory.make_radio)

    # checkbox :: Checkbox options
    checkbox = (Suppress("Checkbox") + options).setParseAction(factory.WidgetFactory.make_checkbox)

    # spinbox :: Spinbox number number number?
    spinbox = \
        (Suppress("Spinbox") + number + number + Optional(Suppress("default") + Suppress(":") + number)
        ).setParseAction(factory.WidgetFactory.make_spinbox)

    # slider :: Slider number number
    slider = (Suppress("Slider") + number + number).setParseAction(factory.WidgetFactory.make_slider)

    # textbox :: Textbox number?
    textbox = (Suppress("Textbox") + Optional(number)).setParseAction(factory.WidgetFactory.make_textbox)

    # drop_down :: Dropdown
    drop_down = (Suppress("Dropdown") + options).setParseAction(factory.WidgetFactory.make_drop_down)

    # _widget  :: Widget : (radio | checkbox | spinbox | slider | textbox | drop_down)
    widget = \
        (Suppress("Widget") + Suppress(":") + (radio | checkbox | spinbox | slider | textbox | drop_down)
         )
