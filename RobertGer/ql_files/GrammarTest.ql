Name: "Tax" {
    Form: "default" {

		Question: "employment" {
			Text: "Are you currently employed?"
			Answer: boolean
		}

        Question: "age" {
            Text: "How old are you?"
            Answer: integer
        }
    }
    Form: "withConditional" {
		If: employment {
			Question: "income1" {
				Text: "How much money did you earn through employer paid wages during 2014?"
				Answer: integer
			}
		} Else: {
			Question: "income2" {
				Text: "How much money did you earn through non-employer paid wages during 2014"
				Answer: integer
			}
		}
		Calculation: "ttl_income" {
			Input: income1+income2
		}
		If: ttl_income > 50 {
			Question "notrlyaquesiton" {
				Text: "WOW MORE THAN 50 income, are you proud?"
				Answer: boolean
			}
		}
    }
    Form: "derp" {
    	Question: "age" {
        	Text: "How old are you?"
            Answer: integer
        }
    }
}