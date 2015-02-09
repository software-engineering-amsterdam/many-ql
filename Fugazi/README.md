UvA - Software Construction 2014-2015
=======
## Fugazi Team

- Theologos Zacharopoulos (10850619)
- Lukasz Harezlak (10630171)


Tools
========

## Programming Language

As a programming language we use `Java`, the reason is that both members of the team haven't worked before extensively in this
language and since Java is considered as a "broadly-used and "must-know" language we saw this as an opportunity to get our dirty with Java. 
Also, Java provides numerous of documentation resources in the field of DSL's and a lot of tools for parsing. It is very intuitive as
an Object oriented language, and is a common ground for object oriented developers.

## Parser Generator

As a parser generator we chose `ANTLR4`, since there is a great resources base online, more specifically we follow the official Antlr4 book
`The definitive antlr4 reference, Terrence Parr, 2012` which is a good place to start.
Also, `ANTLR` has been used a lot in big projects including *Twitter search*, *Hive & Pig of Hadoop*, *SQL Developer IDE* and many more, has a lot
of support and many active online communities.

## Unit Tests

//TODO: JUnit?

## IDE

Both contributors use the `IntelliJ IDEA` IDE for their development process, the reason is that we both have worked on *JetBrains* IDE's
before and we feel more comfortable by using it.

## Build tools

//TODO: Gradle, Maven, Makefile?

## UI

//TODO: JavaFX, Swing, JFrame?

## External Tools

For our help we use some external tools that help our development process:

- **ANTLR4 plugin** for IntelliJ IDEA: provides tools for generationg, testing, visualising the ANTLR project files.


Development
=======

## Setting up the environment (UNIX)

**Install ANTLR4 to your system:**
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

## Build
//TODO

## Tests
//TODO


Architecture
=======
//TODO

QL & QLS
=========

##### QL Requirements

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
//TODO

## QLS Grammar
//TODO