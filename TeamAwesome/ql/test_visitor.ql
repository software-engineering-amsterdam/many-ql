form taxOfficeExample { 
  question hasSoldHouse {
    "Did you sell a house in 2010?"
    boolean = 3.012
  }

  if 2 + 4 > 7 {
    question hasBoughtHouse {
      "Did you buy a house"
      boolean = "no"
    }
  }
}