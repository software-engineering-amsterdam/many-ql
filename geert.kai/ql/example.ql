form {
  "Wat is je leeftijd?" {
    leeftijd: integer
  }

  "Ben je getrouwd?" {
    getrouwd?: boolean
  }

  if getrouwd? {
    "Wat is de naam van je partner?" {
      naam_partner: string
    }
  }
}
