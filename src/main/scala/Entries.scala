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

class Entries(position: Position, stores: Stores, classSym: ClassSym, sigResources: SigResources, flags: List[String], names: List[String], args: List[(String, String)]) {



  //write the class info
  val classInfo = new ClassInfo(position, stores, classSym, sigResources, flags, names)

  //write the value members
  val valueMembers = args.map(arg => new ValueMember(position, stores, classSym, sigResources.myPickleBuffer, names, arg._1, arg._2, sigResources.typeRefTpes))

  //write the <init> method
  val initMethod = Init(position, stores, classSym, sigResources, valueMembers)

  //then we're done unless there are flags
  if (flags.contains("case class")) {

    //write the class methods that case classes give us for free
    val caseClassMethods = new CaseClassMethods(position, stores, classSym, sigResources, valueMembers)

    //write module  (i.e. companion object methods) that we get for free with a case class
    val moduleSig = new ModuleSig(position, stores, sigResources, names, valueMembers, initMethod, caseClassMethods)

  }
}
