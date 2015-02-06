require "citrus"
Citrus.load("query_language")

file = QueryLanguage.parse("ex")

# reference to undefined questions
# duplicate question declarations with different types
# conditions that are not of the type boolean
# operands of invalid type to operators
# references to questions with an undefined value
# cyclic dependencies between questions
# duplicate labels (warning)