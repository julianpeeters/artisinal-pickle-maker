package artisanal.pickle.maker 
import models._
import parser._

import org.specs2._
import mutable._
import specification._

import scala.reflect.internal.pickling.ByteCodecs
import scala.tools.scalap.scalax.rules.scalasig._

import com.novus.salat.annotations.util._
import scala.reflect.ScalaSignature

class IteratorIteratorSpec extends mutable.Specification {
/*
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_IteratorIterator"), List(("b", "Iterator"), ("", "Iterator")))
  def SigParserHelper.parseByteCodeFromAnnotation(clazz: Class[_]): Option[ByteCode] = {
    clazz.annotation[ScalaSignature] match {
      case Some(sig) if sig != null => {
        val bytes = sig.bytes.getBytes("UTF-8")
        val len = ByteCodecs.decode(bytes)
        Option(ByteCode(bytes.take(len)))
      }
      case _ => None
    }
  }

  def SigParserHelper.parseByteCodeFromMySig(sig: ScalaSig): Option[ByteCode] = {
    val bytes = sig.bytes.getBytes("UTF-8")
    val len = ByteCodecs.decode(bytes)
    Option(ByteCode(bytes.take(len)))
  }


  "a ScalaSig for case class MyRecord_IteratorIterator(a: Iterator, a2: Iterator)" should {
    "have the correct string" in {
    val correctParsedSig = SigParserHelper.parseByteCodeFromAnnotation(classOf[MyRecord_IteratorIterator]).map(ScalaSigAttributeParsers.parse(_)).get
    val myParsedSig = SigParserHelper.parseByteCodeFromMySig(mySig).map(ScalaSigAttributeParsers.parse(_)).get
 
    correctParsedSig.toString === myParsedSig.toString
    }
  }
*/
}
