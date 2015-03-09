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
        hasSoldHouse : "Did you sell a house in 2015?";
        hasSoldHouse : false;
      }
      question hasRentHouse typeof boolean {
        hasRentHouse : "Did you bought a house in 2015?";
        hasRentHouse : false;
      }
      question hasMaintLoan typeof boolean {
    	  hasMaintLoan : "Did you sell a house in 2014 ?";
      }
    
      if (hasSoldHouse == true){
    
    	  question sellingPrice typeof int {
    		  sellingPrice : "What was the selling price?";
    	  }
    	  question privateDebt typeof int {
    		  privateDebt : "What was the value of the private debt?";
    	  }
    	  question valueResidue typeof int {
    		  valueResidue : "Value residue:";
    		  valueResidue : sellingPrice - privateDebt;
    	  }
    }
