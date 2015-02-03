# Design

## Choice of Technology

Our aim when choosing the technology is to minimize the
amount of dependencies the user needs to run the program
while adhering to the requirements of the QL language.

The basic requirements of the QL language can be
implemented in most programming languages but we do need to
pay attention to the requirements on the implementation:

1. The parser of the DSL is implemented using a
   grammar-based parser generator.
2. The internal structure of a DSL program is represented
   using abstract syntax trees.
3. QL programs are executed as GUI programs, not
   command-line dialogues.
4. QL programs are executed by interpretation, not code
   generation.

### ANTLR

From the alternatives on the Github page we decided to use
ANTLR as our grammar-based parser generator because we have
limited expertise on the topic and this one seems to be
popular and widely supported.

This will also take care of requirement number 2 for us
because ANTLR can generate ASTs.

### Python 3 + PyQt5

At first we wanted to generate HTML5 + JavaScript so we
could use DOM widgets but the solution that would make it
possible to skip the code generation phase looks
rather complicated (referring to node-webkit).

Because we needed to find a language we both were familiar
with, we decided to choose between Java and Python and we
chose Python because:

* It has some rules that contribute greatly to code
  readability.
* PyQt5 library support which aligns nicely with our
  requirements for QL and later also for QLS because of
  its support for stylesheets.
