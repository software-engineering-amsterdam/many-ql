import ql.ast.Type
import qls.ast.StyleProperty

package object qlsTypes {

  type DefaultWidgetStyleProperties = Map[String, List[StyleProperty]]

  type StyleEnvironment = Map[Type, DefaultWidgetStyleProperties]

}
