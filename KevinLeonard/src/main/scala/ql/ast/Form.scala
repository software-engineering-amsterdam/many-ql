package ql.ast

import types.Label

case class Form(val label: Label, val statements: Statement)
