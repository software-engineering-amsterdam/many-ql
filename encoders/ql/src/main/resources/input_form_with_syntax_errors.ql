fom taxOfficeExample { 
  "Did you sell a house in 2010?"
    hasSoldHouse: boolean
  "Did you buy a house in 2010?"
    hasBoughtHouse: boolean
  "Did you enter a loan?"
    hasMaintLoan: boolean
  "What is the percentage?"
    percentage: money
  "What is the commissioning?"
    commissioning: money
  "Do you have a contract?"
    hasContract: boolean

  if (hasSoldHouse) {
    "What was the selling price?"
      sellingPrice: money
    "Private debts for the sold house:"
      privateDebt: money
    "Value residue:"
      valueResidue: money = 
        (sellingPrice - privateDebt * ( percentage - commissioning ) )
  
  
  if hasContract) {
    "Do you have a contract for longer than 1 year?"
      yearContract: int
    "Did you have an unlimited contract with your employer?"
      unlimitedContract: int
    "Employer followed rules according CAO:"
      rulesFollowed: boolean =
        yearContract >= unlimitedContract 
  }

