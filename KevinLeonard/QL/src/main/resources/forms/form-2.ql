form TaxForm {

    question hasSoldHouse "How many houses did you sell in 2014?"
    answer boolean

    if hasSoldHouse {
        question totalHousesSold "How many houses did you sell in 2015?"
        answer integer

        if totalHousesSold {
            question totalHousesSold "How many houses did you sell in 2016?"
            answer integer
        }
    }
}