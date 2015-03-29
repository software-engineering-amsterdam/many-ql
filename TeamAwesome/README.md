### What's implemented?
QL without QLS.

### Where's the code?
* `ql/ql/` is our implementation of the language.
* `ql/unittest/` contains all the unit tests.
* `ql/ql.py` is an executable interpreter.

### What are the runtime dependencies?
1. **Python 3.4**: https://www.python.org/downloads/
2. **ANTLR 4.5 Python 3 runtime**: `pip install antlr4-python3-runtime`

### How do I run the interpreter?
Run `python ql.py <ql_file>` from inside the `ql/` directory.

Example: `python ql.py examples/tax_office.ql`

### How do I run the unit tests?
Run `python -m unittest` from inside `ql/unittest/`.

### What if I want to regenerate the parser?
Make sure the **ANTLR 4.5 tool** is installed (a copy is in `antlr/`).

The grammar is in `ql/antlr/QL.g4`.

Run `python generateParser.py` from inside `ql/antlr/` to regenerate the
parser.
It should put the generated code in the proper directory
(`ql/ql/parser/antlr_generated/`).
