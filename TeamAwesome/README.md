### Note
*To reduce the risk of problems from merges that change other peoples
projects, we have tagged our final deliverable with* **TeamAwesome-release**

### Who are these guys?
* Jelle van Assema (10200363)
* Guido Loupias (10837345)

### What's implemented?
QL **without** QLS.

### Where's the code?
* `ql/ql/` is the implementation of the language.
* `ql/ql.py` is an executable interpreter.
* `ql/unittest/` contains all the unit tests.

### What are the runtime dependencies?
1. **Python 3.4**: https://www.python.org/downloads/
2. **ANTLR 4.5 Python 3 runtime**: `pip install antlr4-python3-runtime`

### I have both Python 2 and Python 3 installed
**Make sure you run this project with *Python 3* otherwise you might
experience weird behaviour.**
For example, if you run the unit tests with **Python 2** it will not
complain but it will run 0 unit tests because it cannot discover them.

On Ubuntu you can run `python3` instead of `python` to run **Python 3**
if you have both installed.

### How do I run the interpreter?
Run `python ql.py <ql_file>` from inside the `ql/` directory.

Example: `python ql.py examples/tax_office.ql`

### How do I run the unit tests?
Run `python -m unittest` from inside `ql/unittest/`.

### What if I want to regenerate the parser?
Make sure the **ANTLR 4.5 tool** is installed (a copy is in `antlr/`).
Installation instructions: http://antlr.org under *Quickstart*.

The grammar is in `ql/antlr/QL.g4`.

Run `python generateParser.py` from inside `ql/antlr/` to regenerate
the parser.
It should put the generated code in the proper directory
(`ql/ql/parser/antlr_generated/`).
