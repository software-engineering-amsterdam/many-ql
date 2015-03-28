Name: "Tax" {
    Form: "default" {

		Question: "employment" {
			Text: "Are you currently employed?"
			Answer: boolean
		}

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
    Form: "withConditional" {
		If: employment == true {
			Question: "income1" {
				Text: "How much money did you earn through employer paid wages during 2014?"
				Answer: integer
				Range: >0
			}
		}
    	If: partner == "Married" || partner == "Cohabitation" {
        	Question: "income_partner" {
        		Text: "How much money did your partner earn through employer paid wages during 2014?"
        		Answer: integer
        		Range: >0
        	}
        }
    }
    Form: "withCalculation" {
		Question: "income1" {
			Text: "How much money did you earn through employer paid wages during 2014?"
			Answer: integer
			Range: >0
		}
    }

}