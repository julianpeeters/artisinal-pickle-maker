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
package tags
import scala.reflect.internal.pickling._

object ClassSym_Module {
  var position = 0
  def write(myPickleBuffer: PickleBuffer)  = {
    position = Position.current
  //tag
      myPickleBuffer.writeByte(6)
  //len
     // myPickleBuffer.writeNat(7)
    if (Position.current + 1 > 127) myPickleBuffer.writeNat(8); else myPickleBuffer.writeNat(7)
  //data {
    //reference to entry 1, the class name                 
      myPickleBuffer.writeByte(1)

    //reference to the owner of the class
      myPickleBuffer.writeNat(2)
    //pickledflags 
      myPickleBuffer.writeLongNat(2098176L)
    //reference
      myPickleBuffer.writeNat(Position.current + 1)

      Position.current += 1
  }
}