package avocet 

import models._
import java.util.Arrays
import scala.reflect.internal.pickling._

import org.specs2._
import mutable._
import specification._

class AnyRefAnyRefSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_AnyRefAnyRef"), List(("n1", "AnyRef"), ("n2", "AnyRef")))
  val correctBytes: Array[Byte] = {
    val scalaSigAnnot = classOf[MyRecord_AnyRefAnyRef].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes.getBytes
    val len           = ByteCodecs.decode(encodedBytes)
    Arrays.copyOf(encodedBytes, len)
  }

  "a ScalaSig for case class MyRecord_AnyRefAnyRef(n1: AnyRef, n2: AnyRef)" should {
    "have the correct bytes" in {
      mySig.bytes === correctBytes
    }
  }

}