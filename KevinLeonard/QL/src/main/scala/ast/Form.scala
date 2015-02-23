package ast

// TODO: should this be a case class? It doesn't extend anything.
case class Form(label: String, s: Statement)
