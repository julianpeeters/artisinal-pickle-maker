import artisanal.pickle.maker.parser._
//import models._

import org.specs2._
import mutable._
import specification._

import scala.reflect.internal.pickling.ByteCodecs
import scala.tools.scalap.scalax.rules.scalasig._

import com.novus.salat.annotations.util._
import scala.reflect.ScalaSignature

case class Rec(x: Int)
case class MyRecord_NoNamespaceUser(rec: Rec)

class NoNamespaceUserSpec extends mutable.Specification {


  "a ScalaSig for case class MyRecord_NoNamespaceUser(rec: Rec)" should {
    "have the correct string" in {
  

  
      val mySig = new artisanal.pickle.maker.ScalaSig(List("case class"), List("<empty>", "MyRecord_NoNamespaceUser"), List(("rec", "Rec")))

      val correctParsedSig = SigParserHelper.parseByteCodeFromAnnotation(classOf[MyRecord_NoNamespaceUser]).map(ScalaSigAttributeParsers.parse(_)).get
      val myParsedSig = SigParserHelper.parseByteCodeFromMySig(mySig).map(ScalaSigAttributeParsers.parse(_)).get
      correctParsedSig.toString === myParsedSig.toString
    }
  }

}

