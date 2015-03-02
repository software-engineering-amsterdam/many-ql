form TaxForm {

    // SINGLE LINE COMMENT
    question A "How many houses did you sell in 2014?"
    answer number is (199)

    question B "How many houses did you sell in 2015?"
    answer number is (A / 2)

    question C "How many houses did you sell in 2016?"
    answer boolean is (true)

    if A == 2 {
        question D "How many houses did you sell in 2017?"
        answer string is ("Test")
    } else {
        question E "What was the selling price?"
        answer number

        question F "To whom did you sell the house?"
        answer boolean is (E > 100 and C)

        if F {
            question G "How many houses did you sell in 2018?"
            answer number
        }
    }

    if C {
        question H "How many houses did you sell in 2019?"
        answer number
    }

    /* MULTI LINE COMMENTS
    question I "How many houses did you sell in 2020?"
    answer number
    */
}
