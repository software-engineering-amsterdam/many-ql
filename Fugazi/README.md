UvA - Software Construction 2014-2015
=======

## Fugazi Team

- Theologos Zacharopoulos (10850619)
- Lukasz Harezlak (10630171)

Usage
========

To run the application you need `java` installed o you machine, the usage is the following:
```
java -jar Fugazi.jar qlfilename.ql [qlsfilename.qls]
```

An example:
```
java -jar <Fugazi Folder>/out/artifacts/Fugazi_jar/Fugazi.jar <Fugazi Folder>/test/input_forms/fugaziFormExample.ql <Fugazi Folder>/test/input_forms/fugaziStyleExample.qls
```

Tools
========

## Programming Language

As a programming language we use `Java`, the reason is that both members of the team haven't worked before extensively in this
language and since Java is considered as a "broadly-used and "must-know" language we saw this as an opportunity to get our hands dirty for real with Java.
Also, Java provides numerous of documentation resources in the field of DSLs and a lot of tools for parsing. It is very intuitive as
an Object oriented language, and is a common ground for object oriented developers.

## Parser Generator

As a parser generator we chose `ANTLR4`, since there is a great resources base online, more specifically we follow the official Antlr4 book
`The definitive antlr4 reference, Terrence Parr, 2012` which is a good place to start and gives some good insight on the topic in general.
Also, `ANTLR` has been used a lot in big projects including *Twitter search*, *Hive & Pig of Hadoop*, *SQL Developer IDE* and many more, has a lot
of support and many active online communities.

## Unit Tests

For the tests we use the JUnit4 framework.

## IDE

Both contributors use the `IntelliJ IDEA` IDE for their development process, the reason is that we both have worked on *JetBrains* IDE's
before and we feel more comfortable by using it.

## UI

For the UI we use the Java Swing framework.

## External Tools

For our help we use some external tools that help our development process:

- **ANTLR4 plugin** for IntelliJ IDEA: provides tools for generating, testing, visualising the ANTLR project files.


Development
=======

## Setting up the environment (UNIX)

**Install ANTLR4:**
```
cd /usr/local/lib
curl -O http://www.antlr.org/download/antlr-4.5-complete.jar
export CLASSPATH=".:/usr/local/lib/antlr-4.5-complete.jar:$CLASSPATH"
java -jar /usr/local/lib/antlr-4.5-complete.jar
java org.antlr.v4.Tool
alias antlr4='java -jar /usr/local/lib/antlr-4.5-complete.jar'
antlr4
alias grun='java org.antlr.v4.runtime.misc.TestRig'
grun
```

**Customize the bash .profile:**
```
export CLASSPATH=".:/usr/local/lib/antlr-4.5-complete.jar:$CLASSPATH"
alias antlr4='java -jar /usr/local/lib/antlr-4.5-complete.jar'
alias grun='java org.antlr.v4.runtime.misc.TestRig'
```

**Use ANTLR4 form cmd:**
- Generate parser from grammar, generate listener:
`antlr4 <GrammarFile>.g4`

- Generate parser from gramar, generate visitor and no listener:
`antlr4 -no-listener -visitor <GrammarFile>.g4`


**Test grammar form cmd:**

-See the tree:
`grun <GrammarFile> <StartRule> -tree`


-See the tree in gui:
`grun <GrammarFile> <StartRule> -gui`

**Jetbrains setup:**
*Select project from the left -> press F4 -> Modules -> Dependencies -> + from the bottom left -> add antlr4 from /usr/local/lib/antlr-4.5-complete.jar*

**Jetbrains Antlr configuration:**
*Inside of a g4 file -> Tools -> configure ANTLR*

**Jetbrains Antlr execution:**
*Inside of a g4 file -> Tools -> Generate ANTLR Recognizer
OR cmd+shift+G*

**Jetbrains Antlr test:**
*Inside of a g4 file -> right click on the token you want to test -> Test Rule <token>*

QL & QLS
=========

#### QL Requirements

- Questions are enabled and disabled when different values are
  entered.
  
- The type checker detects:
   * reference to undefined questions
   * duplicate question declarations with different types
   * conditions that are not of the type boolean
   * operands of invalid type to operators
   * references to questions with an undefined value
   * cyclic dependencies between questions
   * duplicate labels (warning)
   * understands operator precedence (3 - 2 + 1 != 0)

- The language supports booleans, integers and string values.

- Different data types in QL map to different (default) GUI widgets.   

Requirements on the implementation:

- The parser of the DSL is implemented using a grammar-based parser
  generator. 

- The internal structure of a DSL program is represented using
  abstract syntax trees.

- QL programs are executed as GUI programs, not command-line
  dialogues. 

- QL programs are executed by interpretation, not code generation.


#### QLS Requirements

- QLS allows you to place questions of a base QL program in pages and
  sections.  Furthermore, you can define default widget types and
  styles for questions of a particular type (e.g. boolean
  questions). Such default styles can be overridden on a per widget
  basis.

- The type checker detects:

   * no references to questions that are not in the QL program

   * all questions of the QL program are placed by the QLS program.

   * (default) widget assignments are compatible with question types
     (e.g. no radio button for integer widgets).

   * you cannot place a single question multiple times.

- The execution of a QL + QLS program should be the same as executing
  the QL program individually, _except_ for where questions appear
  (page/secion), what font-styles etc. are used, and what widget types
  are used.
  
- As widget types you're supposed to support at least: slider, spinbox (for numbers), text (for numbers and strings), yesno-radios, checkbox, yesno-dropdown (for booleans).
  
Requirements on the implementation:

- You could say QLS defines an "aspect" of questionnaires, i.e. its appearance. The challenge is to implement QLS without (invasively) changing the code pertaining to QL, and without duplicating or reimplementing the QL code. (Copying and/or duplicating is not allowed, but some changes might be needed at certain join points...). 

- The QL code, and especially, the QL ASTs should be oblivious to the QLS code. Think about how you can achieve that.


Grammars
========

## QL Grammar

### The form

```
form <form_name> {
}
```

example:

```
form testForm {
    ...
}
```

### The simple question

```
<question_type> <question_name>(<question_label>)
```

example:

```
bool hasSold("Have you sold a house?")
```

Supported types:

- bool
- int
- money

### The computed questions

```
<question_type> <question_name>(<question_label>) = <assignment_expression>
```

example:

```
money valueResidue ("Value residue:") = (sellingPrice * privateDebt - 77);
```

Supported expressions:

- logical
- numerical

### If statement

QL supports if statements, also nested if statements and parenthesis.

```
if (<expression>) {
    ...
}
```

example:

```
if (hasSoldHouse) {
    money sellingPrice ("What was the selling price?");
    money privateDebt ("Private debts for the sold house:");
    money valueResidue ("Value residue:") = (sellingPrice - privateDebt);
  }
```

Supported expressions:

- logical (&&, ||, !)
- numerical (*, /, +, -)

### Comments

QL supports both multiline and single line comments:

```
// This is a single line comment.
/*
This is a multiline comment
...
...
*/
```

### A complete example

```
/**
 * The tax Office form 2.
 * Test the logical statements.
 */
form taxOfficeExample {
  bool hasSoldHouse("Did you sell a house in 2010?");
  bool hasBoughtHouse("Did you buy a house in 2010?");
  bool hasMaintLoan("Did you enter a loan?");
  int age("How old are you?");

  // If a house has been sold.
  if (hasSoldHouse || (age > 15 && age <= 55)) {
    money sellingPrice ("What was the selling price?");
    money privateDebt ("Private debts for the sold house:");
    money valueResidue ("Value residue:") = (sellingPrice * privateDebt - 77);
  }
}
```

## QLS Grammar

## Stylesheet

Declares a set of pages that constructs a full stylesheet which can be use in a QL program.

example:

`stylesheet taxOfficeExample`

### Page

Separates segments of the form in to pages, pages may include sections and default style declarations.

example:

```
page Housing {
...
}
```

## Section

Separates segments of the form in to sections, sections may include other sections, questions and default style declarations.

example:

```
section "Selling" {
...
}
```

## Question

Declares a style for a specific QL question.

example:

```
question hasBoughtHouse
        widget checkbox
```

## Default Style Declaration

Declares a default style for a set of QL question types.
The default style declarations may be inserted in Pages or Sections level.
The style declarations can be inherited from parent segments (Pages, Sections), or overwritten form child segments (Sections).

The structure is: `default <ql_type_name> widget <qls_widget>`
also you can se widget properties:

```
default int {
  width: 400
  font: "Arial"
  fontsize: 14
  color: #999999
  widget spinbox
}
```

## Supported widgets

QLS supports the following widgets:
- Checkbox
- TextBox
- SpinBox
- RadioButton
- Slider
- DropDown

## Supported widget style properties

QLS supports the following style properties:
- Width (in pixels)
- Font (string of the font's name)
- Fontsize (A number)
- Color (Hex)

### Comments

QLS supports both multiline and single line comments:

```
// This is a single line comment.
/*
This is a multiline comment
...
...
*/
```

### A complete example

```
stylesheet taxOfficeExample
  page Housing {
    section "Buying"
      question hasBoughtHouse
        widget checkbox
    section "Loaning"
      question hasMaintLoan
  }
  page Selling {
    section "Selling" {
      question hasSoldHouse
        widget radio("Yes", "No")
      section "You sold a house" {
        question sellingPrice
          widget spinbox
        question privateDebt
          widget spinbox
        question valueResidue
        default int {
          width: 400
          font: "Arial"
          fontsize: 14
          color: #999999
          widget spinbox
        }
      }
    }
    default bool widget radio("Yes", "No")
  }
```

Architecture
========

![alt tag](https://raw.githubusercontent.com/software-engineering-amsterdam/many-ql/master/Fugazi/doc/Class%20diagram.png)

_You can also take a better look at it under the `doc` folder of the project_