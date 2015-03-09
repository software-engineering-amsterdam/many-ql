form taxOfficeExample { 
  question "Did you sell a house in 2010?" hasSoldHouse : Boolean
  question "Did you buy a house in 2010?"  hasBoughtHouse : Boolean
  question "Did you enter a loan?" hasMaintLoan : Boolean
  if hasSoldHouse == "" && hasBoughtHouse == true then question "Test?" hasTest : Boolean end
  if hasSoldHouse then question "Test2?" hasTest2: Boolean end
}