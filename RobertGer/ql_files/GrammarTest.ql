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
    	Question: "income1" {
    		Text: "How much money did you earn through employer paid wages during 2014?"
    		Answer: integer
    		Range: >0
    	}
    	If: partner == 1 || partner == "Cohabitation" {
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
            Calculation: "ttl_income_tax" {
                		If: partner == "Married" || partner == "Cohabitation" {
                			Input: (income1 + income_partner) * 2
                		} Else: {
                			Input: income1 * 2
                		}
                	}
        }

        Form: "withConditionalAndCalculation" {
        	Question: "income1" {
        		Text: "How much money did you earn through employer paid wages during 2014?"
        		Answer: integer
        		Range: >0
        	}
        	If: generic.partner == "Married" || generic.partner == "Cohabitation" {
            	Question: "income_partner" {
            		Text: "How much money did your partner earn through employer paid wages during 2014?"
            		Answer: integer
            		Range: >0
            	}
            }
            Calculation: "ttl_income_tax" {
                		If: generic.partner == "Married" || generic.partner == "Cohabitation" {
                			Input: (income1 + income_partner) * 20
                		} Else: {
                			Input: income1 * 15
                		}
                	}
        }

           Form: "withIfElse" {
                Calculation: "ttl_taxes" {
                	Input: ttl_income_tax - 50
                }
                Label: "ttl_taxes" {
                	If: ttl_taxes > 0 {
                		Text: "[ttl_taxes] euro in taxes are due, you will receive payment information through the regular mail."
                	} Else If: ttl_taxes < 0 {
                		Text: "You will recieve [ttl_taxes] euro in return from the Tax Administration within two months."
                	} Else: {
                		Text: "You have paid exactly the right amount of taxes in 2013, no actions remain."
                	}
                }
                Label: "simple_label"{
                    Text: "Such simple, many amaze, wow!"
                }
            }

                       Form: "withIfElseAndMultipleElseIf" {
                            Calculation: "ttl_taxes" {
                            	Input: ttl_income_tax - 50
                            }
                            Label: "ttl_taxes" {
                            	If: ttl_taxes > 0 {
                            		Text: "[ttl_taxes] euro in taxes are due, you will receive payment information through the regular mail."
                            	} Else If: ttl_taxes < 0 {
                            		Text: "You will recieve [ttl_taxes] euro in return from the Tax Administration within two months."
								} Else If: ttl_taxes < 10 {
									Text: "You will recieve [ttl_taxes] euro in return from the Tax Administration within three months."
                            	} Else: {
                            		Text: "You have paid exactly the right amount of taxes in 2013, no actions remain."
                            	}
                            }
                            Label: "simple_label"{
                                Text: "Such simple, many amaze, wow!"
                            }
                        }
}