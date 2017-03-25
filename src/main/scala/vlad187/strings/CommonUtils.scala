package vlad187.strings

/**
  * Created by Vlad187 on 2/25/2014.
  */
object CommonUtils {
  implicit class Quotes(a: String) {
    def doublequoted: String = '"'+a+'"'
    def singlequoted: String = s"'$a'"
    def quoted: String = doublequoted
  }
}
