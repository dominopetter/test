import io.fabric8.kubernetes.client.DefaultKubernetesClient
import okhttp3.internal.http2.Http2
import java.util.logging.ConsoleHandler
import java.util.logging.Level
import java.util.logging.LogRecord
import java.util.logging.Logger
import java.util.logging.SimpleFormatter
import collection.JavaConverters._

object Fabric8ClientTest {
  def main(args: Array[String]): Unit = {
    val logger = Logger.getLogger("")
    val c = new ConsoleHandler()
    c.setLevel(Level.FINE)
    logger.addHandler(c)
    logger.setLevel(Level.FINEST)

    val client = new DefaultKubernetesClient()
    try {
      client.namespaces.list.getItems.asScala.map(println(_))
    } finally {
      client.close()
    }
  }
}
