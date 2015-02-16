form {
  "Bent u getrouwd?" {
    getrouwd?: integer
  }
  if getrouwd? {
    "Wat is de naam van uw partner?" {
      naam_partner: string
    }
  }
}
