form foo {

    question q1 {
        "Hello, how are you?"
        string
    }

    if q1 {
    }

    question q2 {
        "I love you so much"
        boolean = q3
    }

    question q3 {
        "I love you too"
        boolean = q2
    }

    question q3 {
        "No I don't"
        boolean = false
    }

    question q4 {
        "I'm all alone"
        boolean
    }

    question q4 {
        "I cannot help you" 
        string
    }

    question q5 {
        "We are identical twins"
        money
    }

    question q6 {
        "We are identical twins"
        money = q5
    }

    question q7 {
        "I will try magic"
        string = 42
    }

    question q8 {
        "This is not the aproach to riches"
        money = 42 ^ "infinity" 
    }

}
