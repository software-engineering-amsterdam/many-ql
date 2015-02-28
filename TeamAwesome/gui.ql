form taxOfficeExample { 
  question hasSoldHouse {
    "Did you sell a house in 2010?"
    money = -3
  }

  if 5 > 3 {
    if 3 == -hasSoldHouse {
      question hasBoughtHouse {
        "Did you buy a house1"
        boolean = "no"
      }
    }
  }

  question hasBoughtHouse {
    "Did you buy a house2"
    boolean = "no"
  }
  

  question noValueQuestion1 {
     "noValueQuestion1"
     integer
  }

  question noValueQuestion2 {
     "noValueQuestion2"
     boolean
  }
}

form second_form {
  
}