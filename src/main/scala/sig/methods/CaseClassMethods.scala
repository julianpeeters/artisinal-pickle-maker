package avocet
import methods.cls._
import methods.module._
import scala.reflect.internal.pickling._

import tags._
import types._

class CaseClassMethods(sigResources: SigResources, valueMembers: List[ValueMember]) {
//write class methods that we get for free with a case class
  val copyMethod = Copy(sigResources, valueMembers)

  val copyDefaultMethod = CopyDefault(sigResources, valueMembers)

  val productPrefixMethod = ProductPrefix(sigResources)

  val productArityMethod = ProductArity(
    sigResources.myPickleBuffer, 
    sigResources.typeRefTpes.int)
  val productElementMethod = ProductElement(
    sigResources.myPickleBuffer, 
    sigResources.typeRefTpes.any, 
    sigResources.typeRefTpes.int)
  val productIteratorMethod = ProductIterator(
    sigResources.myPickleBuffer, 
    sigResources.typeRefTpes.iterator)
  val canEqualMethod = CanEqual(
    sigResources.myPickleBuffer, 
    productElementMethod, 
    sigResources.typeRefTpes.boolean, 
    sigResources.typeRefTpes.any)
  val hashCodeMethod = HashCode(
    sigResources.myPickleBuffer, 
    sigResources.typeRefTpes.int)
  val toStringMethod = ToString(
    sigResources.myPickleBuffer, 
    sigResources.typeRefTpes.javaLangString)
  val equalsMethod  = Equals(
    sigResources.myPickleBuffer, 
    productElementMethod, 
    sigResources.typeRefTpes.boolean, 
    sigResources.typeRefTpes.any)
}
