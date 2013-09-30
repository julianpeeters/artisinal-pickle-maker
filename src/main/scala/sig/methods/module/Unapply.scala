package avocet
package methods
package module

import tags._
import types._
import cls._
import scala.reflect.generic._

case class Unapply(sigResources: SigResources, valueMembers: List[ValueMember], init: Init) { 

  val valSymPosition = Position.current
  val valueMemberTypeRefPositions = valueMembers.map(vm => vm.typeRefPosition)

  ValSym(Position.current + 1, ClassSym_Module.position, 2097728L, Position.current + 2).write(sigResources.myPickleBuffer)
  TermName("unapply").write(sigResources.myPickleBuffer)
  
  valueMembers.length match {
    case 1          => {  // if there is only 1 value member, have the option typereftpe ref the value member
      sigResources.typeRefTpes.option.position match {
        case 0      => {
          MethodTpe(List(Position.current + 1, Position.current + 4)).write(sigResources.myPickleBuffer)
          TypeRefTpe_unapplyOption(sigResources.thisTpes.scala.position, Position.current + 1, valueMembers(0).typeRefPosition).writeEntry(sigResources.myPickleBuffer)
          ExtRef_nested(Position.current + 1, sigResources.extModClassRefs.scala.position).write(sigResources.myPickleBuffer)
          TypeName("Option").write(sigResources.myPickleBuffer)

        }
        case i: Int => {
          MethodTpe(List(Position.current + 1, Position.current + 2)).write(sigResources.myPickleBuffer)  
          TypeRefTpe_unapplyOption(sigResources.thisTpes.scala.position, sigResources.typeRefTpes.option.position + 1, valueMembers(0).typeRefPosition).writeEntry(sigResources.myPickleBuffer)
        }
      }
    }
    case x if x > 1 =>{ // if there is more than 1 value member, have the option's typereftpe ref TupleRef
      sigResources.typeRefTpes.option.position match {
        case 0      => {
          MethodTpe(List(Position.current + 1, Position.current + 7)).write(sigResources.myPickleBuffer)
          TypeRefTpe_unapplyOption(sigResources.thisTpes.scala.position, Position.current + 1,  Position.current + 3).writeEntry(sigResources.myPickleBuffer)
          ExtRef_nested(Position.current + 1, sigResources.extModClassRefs.scala.position).write(sigResources.myPickleBuffer)
          TypeName("Option").write(sigResources.myPickleBuffer)
          TypeRefTpe_Tuple(valueMembers, sigResources.thisTpes.scala, sigResources.extModClassRefs.scala).write(sigResources.myPickleBuffer)
        }
        case i: Int => {
          MethodTpe(List(Position.current + 1, Position.current + 5)).write(sigResources.myPickleBuffer)  
          TypeRefTpe_unapplyOption(sigResources.thisTpes.scala.position, sigResources.typeRefTpes.option.position + 1, Position.current + 1).writeEntry(sigResources.myPickleBuffer)
          TypeRefTpe_Tuple(valueMembers, sigResources.thisTpes.scala, sigResources.extModClassRefs.scala).write(sigResources.myPickleBuffer)
        }
      }
    }
    case _          => println("Hmm. what's wrong with your value members? Do you have any?") 
  }


  ValSym(Position.current + 1, valSymPosition, 2105344L, init.typeRefTpePosition).write(sigResources.myPickleBuffer)
  TermName("x$0").write(sigResources.myPickleBuffer)

}
