# QL

QL is a DSL for questionnaires.

## QL Language Description
- QL is block-structured, blocks are delimited by curly braces.
- QL has tree types of values: booleans, numbers (i.e. whole numbers) and strings.
- QL uses declare before use.
- QL supports boolean operations (i.e. and, or, not) on booleans.
- QL supports equality operations (i.e. ==, !=) on booleans, numbers and strings.
- QL supports relational operations (i.e. <, <=, >, >=) on numbers.
- QL supports arithmetic operations (i.e. +, -, *, /) on numbers.
- QL supports parenthesis in expressions.

## QL Example
    /*
     * Wanna throw a party?
     */
    form PartyForm {
        question comesToParty "Will you come to my party?"
        answer boolean is true

        if comesToParty {
            question numberOfFriends "How many friends will you bring with you?"
            answer number

            // Only ask if they want to crash if they come with less than 3 persons
            if numberOfFriends < 3 {
                question needPlaceToCrash "Do you need a place to crash?"
                answer boolean
            }

            question preferences "Do you have any special preferences?"
            answer string
        } else {
            question reason "Why not?"
            answer string
        }
    }

## Running it
Start the Scala console and run: `QLInterpreter.main(Array("<path to *.ql file>"))`
