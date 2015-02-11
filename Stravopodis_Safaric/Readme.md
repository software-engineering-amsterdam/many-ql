Students: Dominik Safaric, Panagiotis Stravopodis
Project: QL

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

The code bellow is just a preliminary example of the QL's syntax. 

        form HouseSelling {

                question hasSoldHouse typeof boolean {
                        hasSoldHouse = "Did you sold an house?";
                        hasSoldHouse.questionType = ComputableQuestion;
                        hasSoldHouse.value = false ;
                }
                question hasRentHouse typeof boolean {
                        hasRentHouse = "Did you rent a house?";
                        hasRentHouse.questionType = OrdinaryQuestion;
                        hasRentHouse.value = false;
                }

                if (hasSoldHouse == true){
                        question hasBoughtHouse typeof int {
                            hasBoughtHouse = "What was the price of the house?";
                            hasBoughtHouse.questionType = ComputableQuestion;
                            hasBoughtHouse.value = 100000;
                        }
                }
        }
