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
  
    
    		question boolean hasRentHouse ("Did you rent a house in 2015?") { 
	     		hasRentHouse : true;
		}
	
		question boolean hasBoughtHouse ("Did you bought a house in 2015?") {
			hasBoughtHouse : false;
		}
	
		question boolean hasSoldHouse ("Did you sell a house in 2014 ?");
    
     		if (hasSoldHouse == true && hasRentHouse == true && hasBoughtHouse == true){
    	
    			question string firstName ("Please enter your first name:");
    	
    			question string lastName ("Please enter your last name:");
    	
    			question integer sellingPrice ("What was the selling price?"){
    				sellingPrice : 300;
    			}
    	
    		question money privateDebt ("What was the value of the private debt?");
    	
    		question money valueResidue ("Value residue:") {
    			valueResidue : (sellingPrice * privateDebt) / 100;
    			}
	  	}
     		}


Project: QLS

#####QLS Requirements

- QLS allows you to place questions of a base QL program in pages and sections. Furthermore, you can define default widget types   and styles for questions of a particular type (e.g. boolean questions). Such default styles can be overridden on a per widget   basis.

- The type checker detects:

- No references to questions that are not in the QL program

- All questions of the QL program are placed by the QLS program.

- (default) widget assignments are compatible with question types (e.g. no radio button for integer widgets).

- You cannot place a single question multiple times.

- The execution of a QL + QLS program should be the same as executing the QL program individually, except for where questions     appear (page/secion), what font-styles etc. are used, and what widget types are used.

- As widget types you're supposed to support at least: slider, spinbox (for numbers), text (for numbers and strings),             yesno-radios, checkbox, yesno-dropdown (for booleans).


Here's an example QLS description for the simple Tax Form:

      stylesheet taxOfficeExample 
        page Housing {
         section "Buying" {
          question hasBoughtHouse  
            widget checkbox ("yes")
          } 
          section "Loaning" {  
            question hasMaintLoan
            }    
       }

        page Selling { 
          section "Selling" {
            question hasSoldHouse
              widget radio("Yes", "No")
            section "You sold a house" {
              question sellingPrice
                widget spinbox
              question privateDebt
                widget spinbox {
                	width : 400
                	fontsize: 14
                	color: #999999
                }
              question valueResidue
                 widget spinbox
              default money {
                width: 400
                font: "Arial" 
                fontsize: 14
                color: #999999
              }
              default integer {
                width: 200
              }        
              default string {
                color: #999999
              }
            }
          }
          default string widget textbox
        }
