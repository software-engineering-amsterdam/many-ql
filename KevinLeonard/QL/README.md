## QL Requirements

- Questions are enabled and disabled when different values are entered.

- The type checker detects:
    reference to undefined questions
    duplicate question declarations with different types
    conditions that are not of the type boolean
    operands of invalid type to operators
    references to questions with an undefined value
    cyclic dependencies between questions
    duplicate labels (warning)
    The language supports booleans, integers and string values.

- Different data types in QL map to different (default) GUI widgets.

## Requirements on the implementation:

The parser of the DSL is implemented using a grammar-based parser generator.

The internal structure of a DSL program is represented using abstract syntax trees.

QL programs are executed as GUI programs, not command-line dialogues.

QL programs are executed by interpretation, not code generation.


## QLS Requirements

- QLS allows you to place questions of a base QL program in pages and sections. Furthermore, you can define default widget types and styles for questions of a particular type (e.g. boolean questions). Such default styles can be overridden on a per widget basis.

- The type checker detects:
    no references to questions that are not in the QL program
    all questions of the QL program are placed by the QLS program.
    (default) widget assignments are compatible with question types (e.g. no radio button for integer widgets).
    you cannot place a single question multiple times.

- The execution of a QL + QLS program should be the same as executing the QL program individually, except for where questions appear (page/secion), what font-styles etc. are used, and what widget types are used.
- As widget types you're supposed to support at least: slider, spinbox (for numbers), text (for numbers and strings), yesno-radios, checkbox, yesno-dropdown (for booleans).

## Requirements on the implementation:

You could say QLS defines an "aspect" of questionnaires, i.e. its appearance. The challenge is to implement QLS
without (invasively) changing the code pertaining to QL, and without duplicating or reimplementing the QL code.
(Copying and/or duplicating is not allowed, but some changes might be needed at certain join points...).

The QL code, and especially, the QL ASTs should be oblivious to the QLS code. Think about how you can achieve that.






####### QL LANGUAGE DESCRIPTION


## INDENT BASED

form TaxForm

    question hasSoldHouse "How many houses did you sell in 2014?"
    answer boolean required

    if hasSoldHouse
        question totalHousesSold "How many houses did you sell in 2014?"
        answer integer required from 0 to 100
    else
        question sellingPrice "What was the selling price?"
        answer integer required from 0

        question houseBuyer "To whom did you sell the house?"
        answer string required

    question hasSoldHouse "How many houses did you sell in 2014?"
    answer boolean required


## BLOCK BASED

form TaxForm {

    question hasSoldHouse1 "How many houses did you sell in 2014?"
    answer boolean

    question hasSoldHouse2 "How many houses did you sell in 2014?"
    answer integer

    question hasSoldHouse3 "How many houses did you sell in 2014?"
    answer string

    if hasSoldHouse {
        question totalHousesSold "How many houses did you sell in 2014?"
        answer integer
    } else {
        question sellingPrice "What was the selling price?"
        answer integer

        question houseBuyer "To whom did you sell the house?"
        answer string
    }

    question hasSoldHouse "How many houses did you sell in 2014?"
    answer boolean

}

form TaxForm {

    question hasSoldHouse1 "How many houses did you sell in 2014?"
    answer boolean

}

form TaxForm {

    question hasSoldHouse2 "How many houses did you sell in 2014?"
    answer integer

    question hasSoldHouse3 "How many houses did you sell in 2014?"
    answer string

    question hasSoldHouse "How many houses did you sell in 2014?"
    answer boolean

}

form TaxForm {

    if hasSoldHouse {
        question totalHousesSold "How many houses did you sell in 2014?"
        answer integer
    } else {
        question sellingPrice "What was the selling price?"
        answer integer

        question houseBuyer "To whom did you sell the house?"
        answer string
    }

    if hasSoldHouse {
        question totalHousesSold "How many houses did you sell in 2014?"
        answer integer
    }

}

form TaxForm {

    question hasSoldHouse2 "How many houses did you sell in 2014?"
    answer integer

    question hasSoldHouse3 "How many houses did you sell in 2014?"
    answer string

    question hasSoldHouse "How many houses did you sell in 2014?"
    answer boolean

    if hasSoldHouse {
        question totalHousesSold "How many houses did you sell in 2014?"
        answer integer
    } else {
        question sellingPrice "What was the selling price?"
        answer integer

        question houseBuyer "To whom did you sell the house?"
        answer string
    }

    if hasSoldHouse {
        question totalHousesSold "How many houses did you sell in 2014?"
        answer integer
    }

    question hasSoldHouse2 "How many houses did you sell in 2014?"
    answer integer

}

## BLOCK BASED : GRAMMAR

# http://www.scala-lang.org/api/2.10.2/index.html#scala.util.parsing.combinator.Parsers

def form: Parser[String] = "form" ~> formName ~ "{" ~> rep(questionBlock) ~ rep(ifStatement) <~ "}"
def formName: Parser[String] = ident

def questionBlock: Parser[(String, String), String] = question ~ answer

def question: Parser[(String, String)] = "question" ~> questionKey ~ stringLiteral
def questionKey: Parser[String] = ident

def answer: Parser[String] = "answer" ~> answerType
def answerType: Parser[String] = "boolean" | "integer" | "string"



def ifStatement: Parser[String] = ifBlock ~ elseBlock?
def ifBlock: Parser[String] = "if" ~ "{" ~> rep(questionBlock) <~ "}"
def elseBlock: Parser[String] = "else" ~ "{" ~> rep(questionBlock) <~ "}"

## EXAMPLE GIVEN IN GUIDE

form taxOfficeExample {
  "Did you sell a house in 2010?"
    hasSoldHouse: boolean
  "Did you buy a house in 2010?"
    hasBoughtHouse: boolean
  "Did you enter a loan?"
    hasMaintLoan: boolean

  if (hasSoldHouse) {
    "What was the selling price?"
      sellingPrice: money
    "Private debts for the sold house:"
      privateDebt: money
    "Value residue:"
      valueResidue: money =
        (sellingPrice - privateDebt)
  }

}


## Run QL file instructions.
QLParser.main(Array("src/main/resources/forms/form-1.ql"))
