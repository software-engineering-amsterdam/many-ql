### What's implemented?
QL, not QLS.

### Where's the code?
The `ql/ql/` folder is the python module for most of the code.

`ql/ql.py` is the main executable.

### What are the runtime dependencies?
1. Python 3.4: https://www.python.org/downloads/
2. ANTLR 4.5 Python 3 runtime: `pip install antlr4-python3-runtime`

### How do I run it?
Run `python ql.py <ql_file>` from inside the `ql/` directory.

Example: `python ql.py examples/tax_office.ql`

### How do I run the unit tests?
Go into `ql/unittest/` and run `python -m unittest`.

### What if I want to regenerate the parser?
The grammar for QL is in `ql/antlr/QL.g4`.

To regenerate the parser run `python generateParser.py` from inside
`ql/antlr/` (requires the ANTLR 4.5 tool and Python 3).
