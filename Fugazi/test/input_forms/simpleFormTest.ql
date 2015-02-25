/**
 * A simple form.
 */
form taxOfficeExample {

  bool hasSoldHouse("Did you sell a house in 2010?");
  int age("How old are you?");

  // check
  if (age > 5) {
    int valueResidue ("Value residue:") = (age - 1);
  }
}