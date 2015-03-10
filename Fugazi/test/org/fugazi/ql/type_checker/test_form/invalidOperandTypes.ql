/**
 * Invalid operand types (15).
 */
form taxOfficeExample {

  int i("i");
  bool b("b");
  string s("s");
  
  // corect operations
  int aa("aa") = i + i;
  int ab("ab") = i - i;
  int ac("ac") = i * i;
  int ad("ad") = i / i;
  bool ae("ae") = b || b;
  bool af("af") = b && b;
  bool ag("ag") = i <= i;
  bool ah("ah") = i == i;
  bool ai("ai") = i >= i;
  bool aj("aj") = !b;
  int ak("ak") = -i;
  int al("al") = +i;
  string am("am") = s;

  // incorrect - operand types (9 + 1 = 10)
  int za("za") = i / b;
  int zb("zb") = i + s;
  int zc("zc") = b - s; // * 2, two incompatible operands
  int zd("zd") = i + b;
  bool ze("ze") = i && b;
  bool zf("zf") = s || b;
  bool zg("zg") = b == s;
  bool zh("zh") = b > i;
  bool zi("zi") = s < b;

  // incorrect - assignments (5)
  string zj("zj") = i;
  string zm("zm") = b;
  int zn("zn") = !b;
  bool zo("zo") = +i;
  string zp("zp") = -b;

  }
}