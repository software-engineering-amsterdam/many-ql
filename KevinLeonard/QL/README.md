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
    form TaxForm {

        question hasSoldHouse "Did you sell your house in 2014?"
        answer boolean is (false)

        if hasSoldHouse {
            question totalHousesSold "How many houses did you sell in 2014?"
            answer number

            if totalHousesSold == 1 {
                question priceHouseSold "At what price did you sell your house?"
                answer number
            } else {
                if totalHousesSold == 2 {
                    question priceHouseSold1 "At what price did you sell your first house?"
                    answer number

                    question priceHouseSold2 "At what price did you sell your second house?"
                    answer number
                }
            }
        }
    }

## Running it
Start the Scala console and run: `QLInterpreter.main(Array("<path to *.ql file>"))`
