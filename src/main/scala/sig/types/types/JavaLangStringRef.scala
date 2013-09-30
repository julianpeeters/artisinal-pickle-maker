package avocet 
package types
import tags._
import scala.reflect.generic._

case class TypeRefTpe_javaLangString(thisTpes: ThisTpes) extends Tpe{
  var position = 0
  var polyTpePosition = 0
  var annotPos = 0
  def write(myPickleBuffer: PickleBuffer) = {
    position = Position.current
    thisTpes.lang.position match {
      case 0 => TypeRefTpe_nonGeneric(Position.current + 1, Position.current + 6).writeEntry(myPickleBuffer)
      case i: Int => TypeRefTpe_nonGeneric(thisTpes.lang.position, Position.current + 1).writeEntry(myPickleBuffer)
    }
  }
}
