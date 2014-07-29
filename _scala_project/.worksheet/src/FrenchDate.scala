import java.util.{Date, Locale}
 import java.text.DateFormat
 import java.text.DateFormat._

object FrenchDate {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(255); 
   def main(args: Array[String]) {
     val now = new Date
     val df = getDateInstance(LONG, Locale.FRANCE)
     println(df format now)
   };System.out.println("""main: (args: Array[String])Unit""")}
 }
 