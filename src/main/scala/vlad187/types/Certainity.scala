package vlad187.types

import vlad187.strings.CommonUtils.Quotes
import scala.language.implicitConversions

/**
  * Created by odmin on 2/28/2014.
  */
abstract class Certainity
case object Yes extends Certainity
case object No extends Certainity
case object Maybe extends Certainity
case object NotSure extends Certainity

object CertainityConverters {
  implicit def certainityToBoolean[T <: Certainity](c: T): Boolean = c match {
    case Yes => true
    case No => false
    case unknown => throw new ClassCastException(s"Can't convert Certainity ${unknown.quoted} to Boolean")
  }
}