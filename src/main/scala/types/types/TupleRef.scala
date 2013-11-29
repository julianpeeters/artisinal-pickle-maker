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
package artisinal.pickle.maker 
package types
import tags._
import scala.reflect.internal.pickling._

case class TypeRefTpe_Tuple(valueMembers: List[ValueMember], thisTpe_scala: ThisTpe_scala, scala: ExtModClassRef_scala) extends Tpe {
  var position = 0
  var polyTpePosition = 0
  def write(myPickleBuffer: PickleBuffer) = {
    position = Position.current
    TypeRefTpe_tuple(thisTpe_scala.position + 1, Position.current + 1, valueMembers.map(_.typeRefPosition)).writeEntry(myPickleBuffer)
    ExtRef_nested(Position.current + 1, scala.position).write(myPickleBuffer)
    TypeName("Tuple" + valueMembers.length).write(myPickleBuffer)
  }
}