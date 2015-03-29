# What's implemented?
QL, not QLS.

# Where's the code?
The `ql/ql/` folder is the python module for all of the code except for
`ql/main.py`.

# What are the runtime dependencies?
## Python 3.4
https://www.python.org/downloads/

## ANTLR 4.5 Python 3 runtime
`pip install antlr4-python3-runtime`

# How do I run it?
Run `python ql.py <ql_file>` from inside the `ql/` directory.

Example: `python ql.py examples/tax_office.ql`

# How do I run the unit tests?
Go into `ql/unittest/` and do `python -m unittest`.

# What if I want to rebuild the grammar?
The grammar for QL is in `ql/antlr/`.
Assuming ANTLR 4.5 and Python 3 are already installed, the grammar can be
rebuilt by running the `generateParser.py` script from `ql/antlr/`.
