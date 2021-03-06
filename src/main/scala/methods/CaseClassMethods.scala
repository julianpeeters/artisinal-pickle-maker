/*
 * Copyright 2013 Julian Peeters
 *   
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package artisanal.pickle.maker
import methods.cls._
import methods.module._
import scala.reflect.internal.pickling._
import stores._
import tags._
import types._

class CaseClassMethods(position: Position, stores: Stores, classSym: ClassSym, sigResources: SigResources, valueMembers: List[ValueMember]) {

//write class methods that we get for free with a case class

  val copyMethod = Copy(position, classSym,sigResources, valueMembers)

  val copyDefaultMethod = CopyDefault(position, stores, classSym, sigResources, valueMembers)

  val productPrefixMethod = ProductPrefix(position, stores, classSym, sigResources)

  val productArityMethod = ProductArity(
    position, 
    classSym,
    sigResources.myPickleBuffer, 
    sigResources.typeRefTpes.int)
  val productElementMethod = ProductElement(
    position, 
    classSym,
    sigResources.myPickleBuffer, 
    sigResources.typeRefTpes.any, 
    sigResources.typeRefTpes.int)
  val productIteratorMethod = ProductIterator(
    position, 
    classSym,
    sigResources.myPickleBuffer, 
    sigResources.typeRefTpes.iterator)
  val canEqualMethod = CanEqual(
    position, 
    classSym,
    sigResources.myPickleBuffer, 
    productElementMethod, 
    sigResources.typeRefTpes.boolean, 
    sigResources.typeRefTpes.any)
  val hashCodeMethod = HashCode(
    position, 
    classSym,
    sigResources.myPickleBuffer, 
    sigResources.typeRefTpes.int)
  val toStringMethod = ToString(
    position,
    classSym,
    sigResources.myPickleBuffer, 
    sigResources.typeRefTpes.javaLangString)
  val equalsMethod  = Equals(
    position, 
    classSym,
    sigResources.myPickleBuffer, 
    productElementMethod, 
    sigResources.typeRefTpes.boolean, 
    sigResources.typeRefTpes.any)
}
