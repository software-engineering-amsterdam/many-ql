/**
 * Correct form.
 */
form taxOfficeExample {

  bool hasSoldHouse("Did you sell a house in 2010?");
  bool hasMaintLoan("Did you buy a house in 2010?");
  string name("what is your name");
  int age("How old are you?");
  // Check if a house has been sold.
  if (hasSoldHouse || (age > 15 && age <= 55)) {
    int sellingPrice ("What was the selling price?");
    int privateDebt ("Private debts for the sold house:");
    int valueResidue ("Value residue:") = (sellingPrice * privateDebt - 77);

  }
}