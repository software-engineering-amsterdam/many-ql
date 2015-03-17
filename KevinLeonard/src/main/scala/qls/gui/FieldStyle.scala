package qls.gui

import qls.ast._

class FieldStyle {
  
  val DEFAULT_PROPERTY_WIDTH = Width(100)
  val DEFAULT_PROPERTY_FONT = Font("Arial")
  val DEFAULT_PROPERTY_FONT_COLOR = FontColor(HexadecimalColor("0000000"))
  val DEFAULT_PROPERTY_FONT_SIZE = FontSize(13)

  def extract (s: StyleSheet, env: List[StyleProperty]): StyleSheet = s match {
    case StyleSheet(l, es) => StyleSheet(l, es.map(e => extract(e, env)))
  }

  def extract(e: StyleSheetElement, env: List[StyleProperty]): Page = e match {
    case Page(v, es) => Page(v, es.map(e => extract(e, env)))
  }

  def extract(e: Section, env: List[StyleProperty]): Section = e match {
    case Section(t, es) => Section(t, es.map(e => extract(e, env)))
  }

  def extract(e: SectionElement, env: List[StyleProperty]): SectionElement = e match {
    case Question(v, w) => Question(v, extract(w, env))
    case s: Section => extract(s, env)
  }

  def extract(w: Widget, env: List[StyleProperty]): Widget = w match {
    case Slider(p) => Slider(getStyleProperties(env, p))
    case SpinBox(p) => SpinBox(getStyleProperties(env, p))
    case Text(p) => Text(getStyleProperties(env, p))
    case TextBlock(p) => TextBlock(getStyleProperties(env, p))
    case Radio(p) => Radio(getStyleProperties(env, p))
    case CheckBox(p) => CheckBox(getStyleProperties(env, p))
    case DropDown(p) => DropDown(getStyleProperties(env, p))
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
