import com.urosjarc.mapmaster.domain.SrtmMap
import java.io.FileInputStream
import java.nio.ByteBuffer
import java.nio.ByteOrder


object SrtmParser {
    fun parse(path: String, lat: Int, lon: Int, resolution: Int = 3601): SrtmMap {
        FileInputStream(path).use { fis ->
            fis.channel.use { fc ->
                val bb: ByteBuffer = ByteBuffer.allocateDirect(fc.size().toInt())
                while (bb.remaining() > 0) {
                    fc.read(bb)
                }

                bb.flip()

                return SrtmMap(
                    lat = lat,
                    lon = lon,
                    resolution = resolution,
                    data = bb.order(ByteOrder.BIG_ENDIAN).asShortBuffer()
                )
            }
        }
    }
}
