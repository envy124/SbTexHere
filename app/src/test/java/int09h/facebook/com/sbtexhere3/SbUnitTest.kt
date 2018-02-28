package int09h.facebook.com.sbtexhere3

import int09h.facebook.com.sbtexhere3.api.Sberbank
import int09h.facebook.com.sbtexhere3.models.Point
import int09h.facebook.com.sbtexhere3.models.Triangle
import org.junit.Assert.*
import org.junit.Test
import java.net.InetSocketAddress
import java.net.Proxy

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class SbUnitTest {

    @Test
    fun getAtm_isCorrect() {
        val proxy = Proxy(Proxy.Type.SOCKS, InetSocketAddress("192.168.0.104", 8889))
        val client = HttpClientBuilderFactory().createHttpClientBuilder()
                .proxy(proxy)
                .build()
        val geo = Triangle(
                Point(55.78630908896398, 37.67243220355226),
                Point(55.79839815416208, 37.71268679644777),
                Point(55.750518899999996, 37.9878976))
        val atms = Sberbank().fetchAtms(geo)!!
        assertNotEquals("atms from custom geo is empty", 0, atms.size)
    }

    @Test
    fun getAtmFromPoint_isCorrect() {
        val proxy = Proxy(Proxy.Type.SOCKS, InetSocketAddress("192.168.0.104", 8889))
        val client = HttpClientBuilderFactory().createHttpClientBuilder()
                .proxy(proxy)
                .build()
        val geo = Triangle.createFromPointAndRadius(Point(55.76839815416208, 37.81268679644777), 5.6)
        val atms = Sberbank().fetchAtms(geo)!!
        assertNotEquals("atms from point is empty", 0, atms.size)
    }
}
