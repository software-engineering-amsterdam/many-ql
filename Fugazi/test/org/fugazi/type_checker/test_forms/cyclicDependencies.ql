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
  // with (2) undefined errors
  // with (2) assignment type mismatch errors
  int x("")=z;
  int z("")=y;
  int y("")=x;

}