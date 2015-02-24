/**
 * Cyclic dependency test.
 */
form taxOfficeExample {
  bool a("a");
  bool b("b") = a;
  bool a("") = b;
  bool c("c") = b;
  bool d("d") = c;
  bool e("e") = d;
  bool a("a2") = e;
}