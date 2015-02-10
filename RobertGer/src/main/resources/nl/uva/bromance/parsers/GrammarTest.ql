Name: "Tax" {
    Form: "default" {
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

        Form: "withCalculation" {
        	Question: "income1" {
        		Text: "How much money did you earn through employer paid wages during 2014?"
        		Answer: Double
        		Range: >0
        	}
            Calculation: "ttl_income_tax" {
                		If: generic.partner == "Married" || "Cohabitation" {
                			Input: (income_1 + income_partner) * 0.43
                		} Else: {
                			Input: income_1 * 0.43
                		}
                	}
        }

        Form: "withConditionalAndCalculation" {
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
            Calculation: "ttl_income_tax" {
                		If: generic.partner == "Married" || "Cohabitation" {
                			Input: (income_1 + income_partner) * 0.43
                		} Else: {
                			Input: income_1 * 0.43
                		}
                	}
        }
}