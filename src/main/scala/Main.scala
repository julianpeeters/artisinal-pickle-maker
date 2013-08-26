package avocet
import models._
import methods.cls._
import methods.module._
import scala.reflect.internal.pickling._
import scala.tools.nsc.util.ShowPickled
import java.util.Arrays
import java.io.{PrintStream, File}

class dd{println("Hello World")}

object ArtisinalPickleMaker extends App {
//first, output what I know to be a correct scala signature
  val correctBytes: Array[Byte] = {
    val scalaSigAnnot = classOf[MyRecord_ByteByteByteByte].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes.getBytes
    val len           = ByteCodecs.decode(encodedBytes)

    Arrays.copyOf(encodedBytes, len)
  }
 // val pickleBuffer = new PickleBuffer(bytes, 0, bytes.length)
  //val p = new PrintStream(new File("output/ShowPickled.MyRecord_AnyAny"))
 // ShowPickled.printFile(pickleBuffer, p)
//


  //val mySig = new ScalaSig(List("models", "MyRecord"), List(("x", "String")))

 // val mySig = new ScalaSig(List("models", "MyRecord_Byte"), List(("a", "Byte")))
 // val mySig_Short = new ScalaSig(buf_Short, pos_Short, List("models", "MyRecord_Short"), List(("c", "Int")))
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_ByteByteByteByte"), List(("a1", "Byte"), ("a2", "Byte"), ("a3", "Byte"), ("a4", "Byte")))
 // val mySig = new ScalaSig(List("models", "MyRecord_Long"), List(("d", "Long")))
 // val mySig = new ScalaSig(List("models", "MyRecord_Byte"), List(("a", "Byte")))
 // val mySig = new ScalaSig(List("models", "MyRecord_Byte"), List(("a", "Byte")))
 // val mySig = new ScalaSig(List("models", "MyRecord_Byte"), List(("a", "Byte")))
 // val mySig = new ScalaSig(List("models", "MyRecord_Byte"), List(("a", "Byte")))
 // val mySig = new ScalaSig(List("models", "MyRecord_Byte"), List(("a", "Byte")))
 // val mySig = new ScalaSig(List("models", "MyRecord_Byte"), List(("a", "Byte")))
 // val mySig = new ScalaSig(List("models", "MyRecord_Byte"), List(("a", "Byte")))
 // val mySig = new ScalaSig(List("models", "MyRecord_Byte"), List(("a", "Byte")))
 // val mySig = new ScalaSig(List("models", "MyRecord_Byte"), List(("a", "Byte")))


///view results
 // val pickleBuffer = new PickleBuffer(correctBytes, 0, correctBytes.length)
//  val ps = new PrintStream(new File("output/ShowPickled.MyRecord_ByteByteByteByte"))
//  ShowPickled.printFile(pickleBuffer, ps)

  //val myPickleBuffer = new PickleBuffer(mySig.bytes, 0, mySig.bytes.length-1)
  //val myPs = new PrintStream(new File("output/ShowPickled.myPickleBuffer"))

 // ShowPickled.printFile(myPickleBuffer, myPs)

 

/*
 val duplicateBuffer = new PickleBuffer(bytes, 0, bytes.length)
  val index: Array[Int] = {
    val i = duplicateBuffer.createIndex
    duplicateBuffer.readIndex = 0
    i
  }
  val entryNumber = 129//an arbitrary entry to inspect
  val entryBuffer = new PickleBuffer(duplicateBuffer.toIndexedSeq(entryNumber)._2, 0, duplicateBuffer.toIndexedSeq(entryNumber)._2.length)
  entryBuffer.readNat
  entryBuffer.readNat
  println("flag: " + entryBuffer.readLongNat)
*/

}


