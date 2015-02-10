form TaxForm {
    
    // SINGLE LINE COMMENT
    question hasSoldHouse2 "How many houses did you sell in 2014?"
    answer integer is (100)
    
    question hasSoldHouse3 "How many houses did you sell in 2014?"
    answer string is ("Dummy" + hasSoldHouse)

    question hasSoldHouse "How many houses did you sell in 2014?"
    answer boolean is (fieldA and fieldB < fieldC)

    if hasSoldHouse {
        question totalHousesSold "How many houses did you sell in 2014?"
        answer integer
        
        if hasSoldHouse {
            question totalHousesSold "How many houses did you sell in 2014?"
            answer integer
        }

        
    } else {
        question sellingPrice "What was the selling price?"
        answer integer

        question houseBuyer "To whom did you sell the house?"
        answer string
        
        if hasSoldHouse {
            question totalHousesSold "How many houses did you sell in 2014?"
            answer integer
        }

        
    }
    
    if hasSoldHouse {
        question totalHousesSold "How many houses did you sell in 2014?"
        answer integer
    }
    
    /* MULTI LINE COMMENTS
    question hasSoldHouse2 "How many houses did you sell in 2014?"
    answer integer
    */
}