package qls.gui

import ql.ast.{BooleanType, NumberType, StringType, Type}
import qls.ast._
import qlsTypes.StyleEnvironment
import types.TypeEnvironment

class FieldStyle {

  val DefaultWidth = Width(100)
  val DefaultFont = Font("Arial")
  val DefaultFontColor = FontColor(HexadecimalColor("0000000"))
  val DefaultFontSize = FontSize(13)

  def setStyles(s: StyleSheet, env: StyleEnvironment, typeEnv: TypeEnvironment): StyleSheet = {
    val updatedStyleSheet = s.elements.foldLeft((List[StyleSheetElement](), env)) {
      case ((accumulatedElements, accumulatedEnv), element) =>
        val (updatedElement, updatedEnv) = setStyles(element, accumulatedEnv, typeEnv)
        (accumulatedElements :+ updatedElement, updatedEnv)
    }._1

    StyleSheet(s.label, updatedStyleSheet)
  }

  def setStyles(e: StyleSheetElement, env: StyleEnvironment, typeEnv: TypeEnvironment): (StyleSheetElement, StyleEnvironment) = e match {
    // TODO: Zie Spec: return StyleSheet with default checkbox widget and a question checkbox widget
    case Page(v, sections) =>
      val updatedSections = sections.map(e => setStyles(e, env, typeEnv))
      (Page(v, updatedSections), env)
    case dw: DefaultWidget =>
      // TODO: what if widget is defined multiple times? (now it is just added to the env and later on we just pick the one that is defined first)
      val updatedEnv = env :+ dw
      (dw, updatedEnv)
  }

  def setStyles(e: Section, env: StyleEnvironment, typeEnv: TypeEnvironment): Section = e match {
    case Section(t, sectionElements) =>
      val updatedSectionElements = sectionElements.map(e => setStyles(e, env, typeEnv))
      Section(t, updatedSectionElements)
  }

  def setStyles(e: SectionElement, env: StyleEnvironment, typeEnv: TypeEnvironment): SectionElement = {
    e match {
      case q: Question =>
        val name = q.variable.name
        val _type = typeEnv getOrElse(name, throw new AssertionError(s"Error in type checker. Undefined variable $name."))
        val defaultStyles = getDefaultStyles(_type, q.widget, env)
        val updatedWidget = setStyles(q.widget, defaultStyles)
        Question(q.variable, updatedWidget)
      case s: Section => setStyles(s, env, typeEnv)
    }
  }

  def setStyles(w: Widget, defaultStyles: List[Style]): Widget = {
    val styles = getStyles(w.styles, defaultStyles)
    w match {
      case Slider(p) => Slider(styles)
      case SpinBox(p) => SpinBox(styles)
      case Text(p) => Text(styles)
      case TextBlock(p) => TextBlock(styles)
      case Radio(p) => Radio(styles)
      case CheckBox(p) => CheckBox(styles)
      case DropDown(p) => DropDown(styles)
    }
  }

  def getDefaultStyles(t: Type, w: Widget, env: StyleEnvironment): List[Style] = {
    // TODO: .toString compare is flaky. Probably a widget needs to get a type, or there should be one case class Widget(WidgetType, List[Style])
    env.filter(dw => dw._type == t && dw.widget.toString == w.toString) match {
      case Nil => Nil
      case dw :: dws => dw.widget.styles
    }
  }

  def getStyles(styles: List[Style], defaultStyles: List[Style]): List[Style] = {
    val allStyles = styles ++ defaultStyles
    List(
      findWidth(allStyles).getOrElse(DefaultWidth),
      findFont(allStyles).getOrElse(DefaultFont),
      findFontColor(allStyles).getOrElse(DefaultFontColor),
      findFontSize(allStyles).getOrElse(DefaultFontSize)
    )
  }

  def findWidth(styles: List[Style]): Option[Style] = {
    styles.find({
      case _: Width => true
      case _ => false
    })
  }

  def findFont(styles: List[Style]): Option[Style] = {
    styles.find({
      case _: Font => true
      case _ => false
    })
  }

  def findFontColor(styles: List[Style]): Option[Style] = {
    styles.find({
      case _: FontColor => true
      case _ => false
    })
  }

  def findFontSize(styles: List[Style]): Option[Style] = {
    styles.find({
      case _: FontSize => true
      case _ => false
    })
  }
}
