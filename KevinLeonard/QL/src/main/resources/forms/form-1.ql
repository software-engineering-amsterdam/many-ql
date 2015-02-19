form TaxForm {
    
    // SINGLE LINE COMMENT
    question A "How many houses did you sell in 2014?"
    answer number is (199)
    
    question B "How many houses did you sell in 2014?"
    answer number is (1 / 0)

    question C "How many houses did you sell in 2014?"
    answer boolean

    if C {
       
        question D "How many houses did you sell in 2014?"
        answer string is ("Test")
        
    } else {
       
        question E "What was the selling price?"
        answer number

        question F "To whom did you sell the house?"
        answer boolean is (E > 100 and C)
        
        if F {
            question G "How many houses did you sell in 2014?"
            answer number
        }
        
    }
    
    if C {
        question H "How many houses did you sell in 2014?"
        answer number
    }
    
    /* MULTI LINE COMMENTS
    question I "How many houses did you sell in 2014?"
    answer number
    */
}
