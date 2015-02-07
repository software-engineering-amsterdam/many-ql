form TaxForm {

    question hasSoldHouse2 "How many houses did you sell in 2014?"
    answer integer

    question hasSoldHouse3 "How many houses did you sell in 2014?"
    answer string

    question hasSoldHouse "How many houses did you sell in 2014?"
    answer boolean

    if hasSoldHouse {
        question totalHousesSold "How many houses did you sell in 2014?"
        answer integer
    } else {
        question sellingPrice "What was the selling price?"
        answer integer

        question houseBuyer "To whom did you sell the house?"
        answer string
    }

    if hasSoldHouse {
        question totalHousesSold "How many houses did you sell in 2014?"
        answer integer
    }

    question hasSoldHouse2 "How many houses did you sell in 2014?"
    answer integer
}