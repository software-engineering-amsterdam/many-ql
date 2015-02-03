form ExampleForm
  "Wat is uw naam?"
    naam: string
  "Bent u getrouwd?"
    getrouwd?: boolean
  "Hoeveel kinderen heeft u?"
    aantal_kinderen: integer
  
  if getrouwd?
    "Wat is de naam van uw partner?"
      naam_partner: string
