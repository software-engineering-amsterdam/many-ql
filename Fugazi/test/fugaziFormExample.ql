form taxOfficeExample {
  bool hasSoldHouse("Did you sell a house in 2010?");
  bool hasBoughtHouse("Did you buy a house in 2010?");
  bool hasMaintLoan("Did you enter a loan?");
 }

  if (hasSoldHouse) {
    float sellingPrice ("What was the selling price?");
    float privateDebt ("Private debts for the sold house:");
    float valueResidue ("Value residue:") = (sellingPrice - privateDebt);
  }
}