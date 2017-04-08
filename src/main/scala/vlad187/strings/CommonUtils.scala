package vlad187.strings

/**
  * Created by Vlad187 on 2/28/2014.
  */
object CommonUtils {
  implicit class Quotes[T](a: T) {
    def doublequoted: String = '"'+a.toString+'"'
    def singlequoted: String = s"'$a'"
    def quoted: String = doublequoted
  }
}
