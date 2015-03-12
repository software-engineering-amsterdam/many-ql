form taxOfficeExample { 
  question "Did you sell a house in 2010?" hasSoldHouse : Boolean
  question "Did you buy a house in 2010?"  hasBoughtHouse : Boolean
  question "Did you enter a loan?" hasMaintLoan : Boolean
  if hasSoldHouse == true && hasBoughtHouse then question "Sold and Bought?" hasTest1: Boolean end
  if hasSoldHouse then question "Sold?" hasTest2: Boolean end  
  if hasBoughtHouse then question "Bought?" hasTest3: Boolean end
}