Name: "Tax" {
    Form: "default" {

		Question: "employment" {
			Text: "Are you currently employed?"
			Answer: boolean
		}

        Question: "martial" {
			Text: "What is your marital status?"
			Answer: string
			}
        Question: "age" {
            Text: "How old are you?"
            Answer: integer
        }
    }
    Form: "withConditional" {
    	Question: "income1" {
    		Text: "How much money did you earn through employer paid wages during 2014?"
    		Answer: integer
    	}
    	If: martial == "Married" || martial == "Cohabitation" {
        	Question: "income_partner" {
        		Text: "How much money did your partner earn through employer paid wages during 2014?"
        		Answer: integer
        	}
        }
        If: employment {
			Question: "income" {
				Text: "How much money did you earn through employer paid wages during 2014?"
				Answer: integer
			}
        }
    }
}