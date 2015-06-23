/**
 * Cyclic dependency test.
 */
form taxOfficeExample {
  // 2 circular dependencies

  // spin one way
  bool a("a");
  bool b("b") = a;
  bool c("c") = b;
  bool d("d") = c;
  bool e("e") = d;
  bool a("a2") = e;

  // spin the other way
  int x("x")=z;
  int z("z")=y;
  int y("y")=x;

}