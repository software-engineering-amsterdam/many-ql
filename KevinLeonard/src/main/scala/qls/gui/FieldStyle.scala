package qls.gui

import ql.ast.{BooleanType, NumberType, StringType, Type}
import qls.ast._
import qlsTypes.StyleEnvironment
import types.TypeEnvironment

class FieldStyle {

  val DEFAULT_PROPERTY_WIDTH = Width(100)
  val DEFAULT_PROPERTY_FONT = Font("Arial")
  val DEFAULT_PROPERTY_FONT_COLOR = FontColor(HexadecimalColor("0000000"))
  val DEFAULT_PROPERTY_FONT_SIZE = FontSize(13)

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
        val definedStyles = getDefaultStyleProperties(_type, q.widget, env)
        val updatedWidget = extract(q.widget, definedStyles)
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

  def extract(w: Widget, defaultStyles: List[StyleProperty]): Widget = w match {
    case Slider(p) => Slider(getStyleProperties(defaultStyles, p))
    case SpinBox(p) => SpinBox(getStyleProperties(defaultStyles, p))
    case Text(p) => Text(getStyleProperties(defaultStyles, p))
    case TextBlock(p) => TextBlock(getStyleProperties(defaultStyles, p))
    case Radio(p) => Radio(getStyleProperties(defaultStyles, p))
    case CheckBox(p) => CheckBox(getStyleProperties(defaultStyles, p))
    case DropDown(p) => DropDown(getStyleProperties(defaultStyles, p))
  }

  def getStyleProperties(defaultStyles: List[StyleProperty], styles: List[StyleProperty]): List[StyleProperty] = {
    List(
      getWidth(defaultStyles, styles),
      getFont(defaultStyles, styles),
      getFontColor(defaultStyles, styles),
      getFontSize(defaultStyles, styles)
    )
  }

  def getWidth(defaultStyles: List[StyleProperty], styles: List[StyleProperty]): StyleProperty = {
    styles.find({
      case p: Width => true
      case _ => false
    }) match {
      case Some(p) => p
      case None => defaultStyles.find({
        case p: Width => true
        case _ => false
      }) match {
        case Some(p) => p
        case None => DEFAULT_PROPERTY_WIDTH
      }
    }
  }

  def getFont(defaultStyles: List[StyleProperty], styles: List[StyleProperty]): StyleProperty = {
    styles.find({
      case p: Font => true
      case _ => false
    }) match {
      case Some(p) => p
      case None => defaultStyles.find({
        case p: Font => true
        case _ => false
      }) match {
        case Some(p) => p
        case None => DEFAULT_PROPERTY_FONT
      }
    }
  }

  def getFontColor(defaultStyles: List[StyleProperty], styles: List[StyleProperty]): StyleProperty = {
    styles.find({
      case p: FontColor => true
      case _ => false
    }) match {
      case Some(p) => p
      case None => defaultStyles.find({
        case p: FontColor => true
        case _ => false
      }) match {
        case Some(p) => p
        case None => DEFAULT_PROPERTY_FONT_COLOR
      }
    }
  }

  def getFontSize(defaultStyles: List[StyleProperty], styles: List[StyleProperty]): StyleProperty = {
    styles.find({
      case p: FontSize => true
      case _ => false
    }) match {
      case Some(p) => p
      case None => defaultStyles.find({
        case p: FontSize => true
        case _ => false
      }) match {
        case Some(p) => p
        case None => DEFAULT_PROPERTY_FONT_SIZE
      }
    }
  }
}
