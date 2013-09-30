package avocet 
package types
import tags._
import scala.reflect.generic._

case class TypeRefTpe_Any(thisTpe_scala: ThisTpe_scala, scala: ExtModClassRef_scala) extends Tpe {
  var position = 0
  var polyTpePosition = 0
  var annotPos = 0
  def write(myPickleBuffer: PickleBuffer) = {
    position = Position.current
    TypeRefTpe_nonGeneric(thisTpe_scala.position, Position.current + 1).writeEntry(myPickleBuffer)
    ExtRef_nested(Position.current + 1, scala.position).write(myPickleBuffer)
    TypeName("Any").write(myPickleBuffer)
  }
}
