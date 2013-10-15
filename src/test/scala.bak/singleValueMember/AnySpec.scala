package avocet 

import models._
import java.util.Arrays
import scala.reflect.internal.pickling._

import org.specs2._
import mutable._
import specification._

class AnySpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_Any"), List(("m", "Any")))
  val correctSig: String = {
    val scalaSigAnnot = classOf[MyRecord_Any].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes
    encodedBytes
  }

  "a ScalaSig for case class MyRecord_Any(m: Any)" should {
    "have the correct string" in {
      mySig.bytes === correctSig
    }
  }

}
