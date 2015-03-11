form taxOfficeExample { 
  question "Did you sell a house in 2010?" hasSoldHouse : Boolean
  question "Did you buy a house in 2010?"  hasBoughtHouse : Boolean
  question "Did you enter a loan?" hasMaintLoan : Boolean
  if hasSoldHouse then question "Test1?" hasTest1: Boolean end
  if hasSoldHouse then question "Test2?" hasTest2: Boolean end  
  if hasSoldHouse then question "Test3?" hasTest3: Boolean end
}