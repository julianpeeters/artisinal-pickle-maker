package avocet
import methods.cls._
import methods.module._
import scala.reflect.internal.pickling._

import tags._
import types._

//Write a module signature: composed of module info and module methods
class ModuleSig(sigResources: SigResources, names: List[String], valueMembers: List[ValueMember], initMethod: Init, caseClassMethods: CaseClassMethods){

//Write Module Info
  val moduleInfo = new ModuleInfo(
    sigResources.myPickleBuffer, 
    names, 
    valueMembers, 
    sigResources.typeRefTpes.moduleClass, 
    sigResources.typeRefTpes.modelsMyRecord, 
    sigResources.thisTpes.runtime, 
    sigResources.extModClassRefs.runtime, 
    sigResources.extModClassRefs.scala)
//write Module Methods
  val moduleMethods = new ModuleMethods(
    sigResources.myPickleBuffer, 
    valueMembers, 
    initMethod, 
    caseClassMethods.toStringMethod, 
    sigResources.typeRefTpes.moduleClass, 
    sigResources.thisTpes.scala, 
    sigResources.typeRefTpes.option, 
    sigResources.extModClassRefs.scala, 
    sigResources.typeRefTpes.obj, 
    sigResources.typeRefTpes.objectReadResolve)
}

