import org.apache.flink.api.common.eventtime.WatermarkStrategy
import org.apache.flink.configuration.{Configuration, RestOptions}
import org.apache.flink.formats.csv.CsvReaderFormat
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment
import org.apache.flink.connector.file.src.FileSource
import org.apache.flink.core.fs.Path
import org.apache.flink.streaming.api.datastream.DataStream

object App {
  def main(args:Array[String]):Unit = {
    println("Simple Example to read csv!!")

    val conf:Configuration = new Configuration()
    conf.setInteger(RestOptions.PORT,9018)

    val env:StreamExecutionEnvironment = StreamExecutionEnvironment.createLocalEnvironmentWithWebUI(conf)
    env.setParallelism(1)

    val readFormat:CsvReaderFormat[CityTemperature] = CsvReaderFormat.forPojo(classOf[CityTemperature])
    val csvSource:FileSource[CityTemperature] = FileSource.forRecordStreamFormat(readFormat,new Path("/Users/mayanksinghrana/Downloads/city_temperature.csv")).build()
    val csvInputStream:DataStream[CityTemperature] = env.fromSource(csvSource,WatermarkStrategy.noWatermarks(),"csv-source")
    val starTime = System.currentTimeMillis()
    val s1 = csvInputStream.filter(_.AvgTemperature>=40.0)
    s1.print()
    env.execute("flink-csv-reader")
    val endTime = System.currentTimeMillis()
    println(s"time taken is ${endTime-starTime} ms")
    env.close()

  }
}
