#!/usr/bin/env python

from QL import QL

if __name__ == '__main__':
    app = QL()

    test = app.parse(
      "form taxOfficeExample { \
        \"Did you sell a house in 2010?\" \
           hasSoldHouse: boolean \
        \"Did you buy a house in 2010?\" \
           hasBoughtHouse: boolean \
        \"Did you enter a loan?\" \
           hasMaintLoan: boolean \
      }"
    )

    print test
