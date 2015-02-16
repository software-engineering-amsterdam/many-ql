form taxOfficeExample { 
  question hasSoldHouse {
    "Did you sell a house in 2010?"
    boolean
  }

  question hasBoughtHouse {
    "Did you buy a house in 2010?"
    boolean
  }

  if 3^4 % 2 > 5 - 2 == true {
    question hasMaintLoan {
      "Did you enter a loan?"
      boolean
    }
  }
}