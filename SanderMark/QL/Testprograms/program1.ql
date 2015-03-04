form taxOfficeExample { 
  question "Did you sell a house in 2010?" hasSoldHouse : Boolean
  question "Did you buy a house in 2010?"  hasBoughtHouse : String
  question "Did you enter a loan?" hasMaintLoan : Boolean
  if hasSoldHouse == true && hasBoughtHouses == true then question "Test?" hasTest : Boolean end
}