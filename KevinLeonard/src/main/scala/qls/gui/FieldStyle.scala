package qls.gui

import ql.ast.{StringType, NumberType, BooleanType, Type}
import qls.ast._
import qlsTypes.StyleEnvironment

class FieldStyle {

  val DEFAULT_PROPERTY_WIDTH = Width(100)
  val DEFAULT_PROPERTY_FONT = Font("Arial")
  val DEFAULT_PROPERTY_FONT_COLOR = FontColor(HexadecimalColor("0000000"))
  val DEFAULT_PROPERTY_FONT_SIZE = FontSize(13)

  def extract (s: StyleSheet, env: StyleEnvironment): StyleSheet = s match {
    case StyleSheet(l, es) => StyleSheet(l, es.map(extract(_, env)._1))
  }

  def extract(e: StyleSheetElement, env: StyleEnvironment): (StyleSheetElement, StyleEnvironment) = e match {
    // TODO: DefaultWidget case update StyleEnvironment, maar de ge-update StyleEnvironment wordt niet meegegeven aan de Page case!
    // TODO: Zie Spec: return StyleSheet with default checkbox widget and a question checkbox widget
    case Page(v, es) => (Page(v, es.map(e => extract(e, env))), env)
    case dw: DefaultWidget => (dw, updateStyleEnvironment(dw, env))
  }

  def updateStyleEnvironment(defaultWidget: DefaultWidget, env: StyleEnvironment): StyleEnvironment = {
    if (env contains defaultWidget._type) {
      env + (defaultWidget._type -> (env(defaultWidget._type) + (defaultWidget.widget.toString() -> defaultWidget.widget.properties)))
    } else {
      env + (defaultWidget._type -> Map(defaultWidget.widget.toString() -> defaultWidget.widget.properties))
    }
  }

  def extract(e: Section, env: StyleEnvironment): Section = e match {
    case Section(t, es) => Section(t, es.map(e => extract(e, env)))
  }

  def extract(e: SectionElement, env: StyleEnvironment): SectionElement = {
    e match {
      // TODO: Get question Type from QL ast + replace match based on widget type.
      case q: Question => {
        q.widget.toString() match {
          case "spin box" => Question(q.variable, extract(q.widget, getDefaultStyleProperties(NumberType(), q.widget, env)))
          case "slider" => Question(q.variable, extract(q.widget, getDefaultStyleProperties(NumberType(), q.widget, env)))
          case "text" => Question(q.variable, extract(q.widget, getDefaultStyleProperties(StringType(), q.widget, env)))
          case "text block" => Question(q.variable, extract(q.widget, getDefaultStyleProperties(StringType(), q.widget, env)))
          case "radio" => Question(q.variable, extract(q.widget, getDefaultStyleProperties(BooleanType(), q.widget, env)))
          case "check box" => Question(q.variable, extract(q.widget, getDefaultStyleProperties(BooleanType(), q.widget, env)))
          case "drop down" => Question(q.variable, extract(q.widget, getDefaultStyleProperties(BooleanType(), q.widget, env)))
        }
      }
      case s: Section => extract(s, env)
    }
  }

  def getDefaultStyleProperties(t: Type, w: Widget, env: StyleEnvironment): List[StyleProperty] = {
    if (env contains t) {
      env(t) getOrElse(w.toString(), List())
    } else {
      List()
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
    styles.find(style => style match {
      case p: Width => true
      case _ => false
    }) match {
      case Some(p) => p
      case None => defaultStyles.find(style => style match {
        case p: Width => true
        case _ => false
      }) match {
        case Some(p) => p
        case None => DEFAULT_PROPERTY_WIDTH
      }
    }
  }

  def getFont(defaultStyles: List[StyleProperty], styles: List[StyleProperty]): StyleProperty = {
    styles.find(style => style match {
      case p: Font => true
      case _ => false
    }) match {
      case Some(p) => p
      case None => defaultStyles.find(style => style match {
        case p: Font => true
        case _ => false
      }) match {
        case Some(p) => p
        case None => DEFAULT_PROPERTY_FONT
      }
    }
  }

  def getFontColor(defaultStyles: List[StyleProperty], styles: List[StyleProperty]): StyleProperty = {
    styles.find(style => style match {
      case p: FontColor => true
      case _ => false
    }) match {
      case Some(p) => p
      case None => defaultStyles.find(style => style match {
        case p: FontColor => true
        case _ => false
      }) match {
        case Some(p) => p
        case None => DEFAULT_PROPERTY_FONT_COLOR
      }
    }
  }

  def getFontSize(defaultStyles: List[StyleProperty], styles: List[StyleProperty]): StyleProperty = {
    styles.find(style => style match {
      case p: FontSize => true
      case _ => false
    }) match {
      case Some(p) => p
      case None => defaultStyles.find(style => style match {
        case p: FontSize => true
        case _ => false
      }) match {
        case Some(p) => p
        case None => DEFAULT_PROPERTY_FONT_SIZE
      }
    }
  }
}
