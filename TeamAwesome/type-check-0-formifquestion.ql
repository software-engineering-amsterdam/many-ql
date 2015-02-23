form taxOfficeExample {

    question bla {
        "Gaat het goed?"
        boolean
    }

    if !bla {
        question foo {
            "Wat is er?"
            string
        }

        if foo == "Ik weet het niet." {
            question bar {
                "Heeft u last van uw keel?"
                boolean
            }
        }
    }
    
}