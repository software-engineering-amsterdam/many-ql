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
    Form: "BooleanTests" {
        If: true {
			Question: "boolean stuff" {
				Text: "Ever seen boolean stuff??"
				Answer: integer
			}
        }
		If: employment == true {
			Question: "income" {
				Text: "How much money did you earn through employer paid wages during 2014??"
				Answer: integer
			}
		}
		If: employment {
			Question: "income2" {
				Text: "How much money did you earn through employer paid wages during 2014??"
				Answer: integer
			}
		}
    }
	Form: "IntegerTests" {
		If: age == 10 {
			Question: "parents" {
				Text: "Get your parents please"
				Answer: integer
			}
		}

		If: age < 10 {
			Question: "young" {
				Text: "How are you even filing a tax form??"
				Answer: integer
			}
		}
		If: age > 90 {
			Question: "old" {
				Text: "Are the questions readable??"
				Answer: integer
			}
		}
		If: age >= 30 {
			Question: "ageing" {
				Text: "Want some anti-ageing cream??"
				Answer: integer
			}
		}
		If: age <= 50 {
			Question: "midlife" {
				Text: "Mid-life crisis in coming??"
				Answer: integer
			}
		}
	}

	Form: "LogicalExpresions" {
		If: age >= 30 || age <= 50  {
			Question: "anything" {
				Text: "Well you could be any age really.."
				Answer: integer
			}
		}
		If: age >= 30 && age <= 50  {
			Question: "definitelyageing" {
				Text: "Definitely ageing??"
				Answer: integer
			}
		}
	}
}