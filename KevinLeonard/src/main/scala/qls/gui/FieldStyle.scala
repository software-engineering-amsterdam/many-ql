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

  def extract(s: StyleSheet, env: StyleEnvironment, typeEnv: TypeEnvironment): StyleSheet = {
    val updatedStyleSheet = s.elements.foldLeft((List[StyleSheetElement](), env)) {
      case ((accumulatedElements, accumulatedEnv), element) =>
        val (extractedElement, updatedEnv) = extract(element, accumulatedEnv, typeEnv)
        (accumulatedElements :+ extractedElement, updatedEnv)
    }._1

    StyleSheet(s.label, updatedStyleSheet)
  }

  def extract(e: StyleSheetElement, env: StyleEnvironment, typeEnv: TypeEnvironment): (StyleSheetElement, StyleEnvironment) = e match {
    // TODO: Zie Spec: return StyleSheet with default checkbox widget and a question checkbox widget
    case Page(v, sections) =>
      val extractedSections = sections.map(e => extract(e, env, typeEnv))
      (Page(v, extractedSections), env)
    case dw: DefaultWidget =>
      val updatedEnv = updateStyleEnvironment(dw, env)
      (dw, updatedEnv)
  }

  def updateStyleEnvironment(defaultWidget: DefaultWidget, env: StyleEnvironment): StyleEnvironment = {
    env :+ defaultWidget // TODO: what if widget is defined multiple times? (now it is just added to the env and later on we just pick the one that is defined first)
  }

  def extract(e: Section, env: StyleEnvironment, typeEnv: TypeEnvironment): Section = e match {
    case Section(t, sectionElements) =>
      val extractedSectionElements = sectionElements.map(e => extract(e, env, typeEnv))
      Section(t, extractedSectionElements)
  }

  def extract(e: SectionElement, env: StyleEnvironment, typeEnv: TypeEnvironment): SectionElement = {
    e match {
      case q: Question =>
        val name = q.variable.name
        val _type = typeEnv getOrElse(name, throw new AssertionError(s"Error in type checker. Undefined variable $name."))
        val defaultStyleProperties = getDefaultStyleProperties(_type, q.widget, env)
        val updatedWidget = extract(q.widget, defaultStyleProperties)
        Question(q.variable, updatedWidget)
      case s: Section => extract(s, env, typeEnv)
    }
  }

  def getDefaultStyleProperties(t: Type, w: Widget, env: StyleEnvironment): List[StyleProperty] = {
    // TODO: .toString compare is flaky. Probably a widget needs to get a type, or there should be one case class Widget(WidgetType, List[StyleProperties])
    env.filter(dw => dw._type == t && dw.widget.toString == w.toString) match {
      case Nil => Nil
      case dw :: dws => dw.widget.properties
    }
  }

  def extract(w: Widget, defaultStyles: List[StyleProperty]): Widget = {
    val styles = getStyles(w.properties, defaultStyles)
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

  def getStyles(styles: List[StyleProperty], defaultStyles: List[StyleProperty]): List[StyleProperty] = {
    val allStyles = styles ++ defaultStyles
    List(
      findWidth(allStyles).getOrElse(DefaultWidth),
      findFont(allStyles).getOrElse(DefaultFont),
      findFontColor(allStyles).getOrElse(DefaultFontColor),
      findFontSize(allStyles).getOrElse(DefaultFontSize)
    )
  }

  def findWidth(styles: List[StyleProperty]): Option[StyleProperty] = {
    styles.find({
      case _: Width => true
      case _ => false
    })
  }

  def findFont(styles: List[StyleProperty]): Option[StyleProperty] = {
    styles.find({
      case _: Font => true
      case _ => false
    })
  }

  def findFontColor(styles: List[StyleProperty]): Option[StyleProperty] = {
    styles.find({
      case _: FontColor => true
      case _ => false
    })
  }

  def findFontSize(styles: List[StyleProperty]): Option[StyleProperty] = {
    styles.find({
      case _: FontSize => true
      case _ => false
    })
  }
}
