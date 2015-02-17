form taxOfficeExample { 
  question hasSoldHouse {
    "Did you sell a house in 2010?"
    boolean = 3.012
  }

  if "h" * 2 + 6 > "hhhh" {
    question hasBoughtHouse {
      "Did you buy a house1"
      boolean = "no"
    }
  }

  question hasBoughtHouse {
    "Did you buy a house2"
    boolean = "no"
  }
  
}

form second_form {
  
}