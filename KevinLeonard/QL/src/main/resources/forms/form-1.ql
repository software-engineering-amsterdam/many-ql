form TaxForm {
    
    // SINGLE LINE COMMENT
    question hasSoldHouse2 "How many houses did you sell in 2014?"
    answer number is (100)
    
    question hasSoldHouse3 "How many houses did you sell in 2014?"
    answer string is ("Dummy" + hasSoldHouse)

    question hasSoldHouse "How many houses did you sell in 2014?"
    answer boolean is (fieldA and fieldB < fieldC)

    if hasSoldHouse {
        question totalHousesSold "How many houses did you sell in 2014?"
        answer number
        
        if hasSoldHouse {
            question totalHousesSold "How many houses did you sell in 2014?"
            answer number
        }

        
    } else {
        question sellingPrice "What was the selling price?"
        answer number

        question houseBuyer "To whom did you sell the house?"
        answer string
        
        if hasSoldHouse {
            question totalHousesSold "How many houses did you sell in 2014?"
            answer number
        }

        
    }
    
    if hasSoldHouse {
        question totalHousesSold "How many houses did you sell in 2014?"
        answer number
    }
    
    /* MULTI LINE COMMENTS
    question hasSoldHouse2 "How many houses did you sell in 2014?"
    answer number
    */
}