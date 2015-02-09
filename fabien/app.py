#!/usr/bin/env python

from src.QL.parser import Parser

if __name__ == '__main__':
    app = Parser()

    test = app.parse(
      "form taxOfficeExample {                \
                                              \
        if ( 2*a + 55 )  {                      \
          \"Did you enter a loan?\"           \
             hasMaintLoan: boolean            \
        }                                     \
                                              \
        if (hasMaintLoan) {                   \
          \"Did you enter a loan\"           \
             hasMaintLoan: boolean            \
        }                                     \
      }"
    )

    print test
