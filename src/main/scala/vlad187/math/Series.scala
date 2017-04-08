package vlad187.math
import org.joda.time._

/**
  * Created by Vlad187 on 2/28/2014.
  */
case class Metric(name: String)
case class Measurement[T <: Numeric[T]](metric: Metric, value: T, time: DateTime)
case class Serial[T <: Numeric[T]](measurement: Measurement[T], measurements: Measurement[T]*) {
  val allMeasurements: Seq[Measurement[T]] = measurement +: measurements
  lazy val interval: Interval = new Interval(allMeasurements.head.time, allMeasurements.last.time)
  lazy val duration: Duration = interval.toDuration
  lazy val isEmpty: Boolean = allMeasurements.isEmpty
  lazy val nonEmpty: Boolean = allMeasurements.nonEmpty
}

class ComparableSeries[T <: Numeric[T]](series: Array[Serial[T]]) {
  lazy val comparables: Array[Serial[T]] = series.filter(_.nonEmpty)
  lazy val latestSerial: Serial[T] = comparables.maxBy(_.interval.getStartMillis)
  lazy val longestSerial: Serial[T] = comparables.maxBy(_.duration.getMillis)
  lazy val timeShifts: Array[Duration] =
    comparables.map(current =>
      new Duration(latestSerial.interval.getStart, current.interval.getStart)
    )
}

