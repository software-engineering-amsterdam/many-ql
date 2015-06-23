## QL 
The QL program is divided into six modules. The main file in the root uses these modules to execute the whole program.
The purpose of each module will be given in order of execution:
* Grammar: contains the grammar to be parsed 
  * factory: contains functions to convert the list of subtrees to AST objects
* AST: the hierarchy of the parsing in objects
  * Expressions: expression objects being expression operations or primitives
    * Primitives: the lowest level of elements in expressions (number, bool, text, variable)
    * Operations: expressions (mostly binary) who have operands which are again operations or primitives
  * Statements: statement objects being questions, assignmentsm if-blocks or if-else-blocks
  * form: the overarching object containing all the AST parts. Also contains type checker functions and error messages
  to check if the file is of the right format.
* Runtime: uses the form from the AST and flattens it for easier use in the gui. contains a runtime form and run time 
questions containing relevant information for visualisation
* GUI: responsible for showing the questionnaire and handling answers
* Tools: used for exception handling and general converting
* Tests: unit tests 

## QLS


