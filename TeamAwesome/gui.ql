form taxOfficeExample { 
  question hasSoldHouse {
    "Did you sell a house in 2010?"
    boolean
  }

  if hasSoldHouse {
    question hasBoughtHouse {
      "Did you buy a house1"
      boolean = false
    }
  }

  question hasBoughtHouse {
    "Did you buy a house2"
    boolean
  }
  

  question noValueQuestion1 {
     "noValueQuestion1"
     integer = 3
  }

  question noValueQuestion2 {
     "noValueQuestion2"
     string
  }
}

form second_form {
  
}