package qls.gui

import ql.ast.{BooleanType, NumberType, StringType, Type}
import qls.ast._
import qlsTypes.StyleEnvironment

class FieldStyle {

  val DEFAULT_PROPERTY_WIDTH = Width(100)
  val DEFAULT_PROPERTY_FONT = Font("Arial")
  val DEFAULT_PROPERTY_FONT_COLOR = FontColor(HexadecimalColor("0000000"))
  val DEFAULT_PROPERTY_FONT_SIZE = FontSize(13)

  def extract(s: StyleSheet, env: StyleEnvironment): StyleSheet = {
    val updatedStyleSheet = s.elements.foldLeft((List[StyleSheetElement](), env)) {
      case ((accumulatedElements, accumulatedEnv), element) =>
        val (extractedElement, updatedEnv) = extract(element, accumulatedEnv)
        (accumulatedElements :+ extractedElement, updatedEnv)
    }._1

    StyleSheet(s.label, updatedStyleSheet)
  }

  def extract(e: StyleSheetElement, env: StyleEnvironment): (StyleSheetElement, StyleEnvironment) = e match {
    // TODO: Zie Spec: return StyleSheet with default checkbox widget and a question checkbox widget
    case Page(v, sections) =>
      val extractedSections = sections.map(e => extract(e, env))
      (Page(v, extractedSections), env)
    case dw: DefaultWidget =>
      val updatedEnv = updateStyleEnvironment(dw, env)
      (dw, updatedEnv)
  }

  def updateStyleEnvironment(defaultWidget: DefaultWidget, env: StyleEnvironment): StyleEnvironment = {
    env :+ defaultWidget // TODO: what if widget is defined multiple times? (now it is just added to the env and later on we just pick the one that is defined first)
  }

  def extract(e: Section, env: StyleEnvironment): Section = e match {
    case Section(t, sectionElements) =>
      val extractedSectionElements = sectionElements.map(e => extract(e, env))
      Section(t, extractedSectionElements)
  }

  def extract(e: SectionElement, env: StyleEnvironment): SectionElement = {
    e match {
      // TODO: Get question Type from QL ast + replace match based on widget type.
      case q: Question => {
        q.widget match {
          case SpinBox(_) => Question(q.variable, extract(q.widget, getDefaultStyleProperties(NumberType(), q.widget, env)))
          case Slider(_) => Question(q.variable, extract(q.widget, getDefaultStyleProperties(NumberType(), q.widget, env)))
          case Text(_) => Question(q.variable, extract(q.widget, getDefaultStyleProperties(StringType(), q.widget, env)))
          case TextBlock(_) => Question(q.variable, extract(q.widget, getDefaultStyleProperties(StringType(), q.widget, env)))
          case Radio(_) => Question(q.variable, extract(q.widget, getDefaultStyleProperties(BooleanType(), q.widget, env)))
          case CheckBox(_) => Question(q.variable, extract(q.widget, getDefaultStyleProperties(BooleanType(), q.widget, env)))
          case DropDown(_) => Question(q.variable, extract(q.widget, getDefaultStyleProperties(BooleanType(), q.widget, env)))
        }
      }
      case s: Section => extract(s, env)
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
