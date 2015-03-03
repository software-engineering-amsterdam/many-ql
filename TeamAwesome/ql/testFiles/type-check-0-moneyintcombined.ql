form foo {
    question intQ {
        "I haz integer"
        integer = 1.0
    }

    question moneyQ {
        "I haz money"
        money = 2.0
    }

    question wtfQ {
        "I dont know"
        money = (intQ + moneyQ)
    }

    question notAllowedQ {
        "O h my god"
        integer = (intQ + moneyQ)
    }
}