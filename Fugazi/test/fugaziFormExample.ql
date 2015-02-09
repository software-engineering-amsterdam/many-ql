/*
form "formName" {
    "variableType" "variableName" ("variableDisplayQuestion");
    if (condition) {
        "variableType" "variableName" ("variableDisplayQuestion") = "variableDerivedValue";
    }
}
*/

// The sample tax office example with our grammar.

form "taxOfficeExample" {
  bool hasSoldHouse("Did you sell a house in 2010?");
  bool hasBoughtHouse("Did you buy a house in 2010?");
  bool hasMaintLoan("Did you enter a loan?");
  
  if (hasSoldHouse) {
    money sellingPrice ("What was the selling price?");
    money privateDebt ("Private debts for the sold house:");
    money valueResidue ("Value residue:") = (sellingPrice - privateDebt);
  }

}