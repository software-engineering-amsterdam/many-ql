# Grammar of the basic and question types

import pyparsing as pp
import QL.Factory.forms as f


class BasicTypes:

    # end_sign :: . | ? | !
    end_sign = pp.oneOf(". ? !")

    # end_sign_esc :: \ end_sign
    end_sign_esc = pp.Suppress("\\") + end_sign

    # characters :: [0-9a-zA-Z()[]{},@#$%^&*-+=/\'\"`~_]
    characters = pp.Word("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890@#$%^&*-+=/\'\"`~_") | pp.Word(",")

    # word :: end_sign_esc | characters
    word = end_sign_esc | characters

    # sentence :: word+ end_sign
    sentence = (pp.OneOrMore(word) + end_sign).setParseAction(f.FormFactory.make_sentence)

    # sentences :: sentence+
    sentences = pp.OneOrMore(sentence)

    # comment :: // ....\n  | /* .... */
    comment = pp.Literal("//") + pp.restOfLine | pp.cStyleComment