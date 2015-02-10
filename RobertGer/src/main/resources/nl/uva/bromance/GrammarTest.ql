Name: "Tax" {
    Form: "generic" {
        Question: "partner" {
			Text: "What is your marital status?"
			Answer: ["Single" || "Married" || "Cohabitation"]
        }
        Question: "age" {
            Text: "How old are you?"
            Answer: Integer
            Range: 0 - 150
        }
    }
    Form: "income_work" {
    	Question: "income1" {
    		Text: "How much money did you earn through employer paid wages during 2014?"
    		Answer: Double
    		Range: >0
    	}
    	If: generic.partner == "Married" || generic.partner == "Cohabitation" && (iets == iets || iets >= iets ) {
        	Question: "income_partner" {
        		Text: "How much money did your partner earn through employer paid wages during 2014?"
        		Answer: double
        		Range: >0
        	}
        }
    }
    Form: "results" {
    }
}