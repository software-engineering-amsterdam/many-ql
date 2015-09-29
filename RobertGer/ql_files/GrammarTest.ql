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
			Input: income1+income2+income_partner
		}
		Label: "totalincome" {
			If: ttl_income  < 50000 {
				Text: "Total income: [ttl_income] Euro"
			} Else: {
				Text: "MANY INCOME WOW : [ttl_income] Euro"
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