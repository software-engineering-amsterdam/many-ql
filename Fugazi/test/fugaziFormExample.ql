/**
 * The tax Office form.
 *
 */
form taxOfficeExample {
  bool hasSoldHouse("Did you sell a house in 2010?");
  bool hasBoughtHouse("Did you buy a house in 2010?");
  bool hasMaintLoan("Did you enter a loan?");

  // If a house has been sold.
  if (hasSoldHouse) {
    money sellingPrice ("What was the selling price?");
    money privateDebt ("Private debts for the sold house:");
    money valueResidue ("Value residue:") = (sellingPrice - privateDebt);
  }
}