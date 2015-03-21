form taxOfficeExample { 
  "Did you sell a house in 2010?"
    hasSoldHouse: integer
  "Did you buy a house in 2010?"
    hasBoughtHouse: boolean
  "Did you enter a loan?"
    hasMaintLoan: boolean
  "What is the percentage?"
    percentage: integer
  "What is the commissioning?"
    commissioning: boolean

if(!percentage) {
    "What was the selling price?"
      sellingPrice: integer
}

  if (hasSoldHouse) {
    "What was the selling price?"
      sellingPrice: integer
    "Private debts for the sold house:"
      privateDebt: integer
    "Value residue:"
      valueResidue: integer = 
        (sellingPrice - privateDebt * ( percentage - commissioning ) )
  }
  
  if (hasContract) {
    "Do you have a contract for longer than 1 year?"
      yearContract: integer
    "Did you have an unlimited contract with your employer?"
      unlimitedContract: integer
    "Employer followed rules according CAO:"
      rulesFollowed: boolean =
        yearContract >= unlimitedContract 
  }
  
  "Do you have a contract?"
    hasContract: boolean
    
  "Do you have a contract?"
    hasContract2: boolean
    
  "Do you have a duplicate contract with another datatype?"
    hasContract: integer
    
  if(nonExistingQuestion) {
      "Are you happy with this questionnaire?"
      happy: boolean
  }
}