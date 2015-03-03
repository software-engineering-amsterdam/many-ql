form taxOfficeExample { 
  question hasSoldHouse {
    "Did you sell a house in 2010?"
    boolean
  }

  if !hasSoldHouse {
    question hasBoughtHouse {
      "Did you buy a house1"
      boolean = false
    }
  }

  question hasBoughtHouse {
    "Did you buy a house2"
    boolean
  }
  
  question intValueQuestion {
     "intValueQuestion"
     integer = 3
  }

  question noValueQuestion {
     "noValueQuestion"
     string
  }

  question stringValueQuestion {
     "StringValueQuestion"
     string = ("bla")
  }
}

form second_form {
  
}