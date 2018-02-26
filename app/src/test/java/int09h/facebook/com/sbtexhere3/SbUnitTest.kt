package int09h.facebook.com.sbtexhere3

import int09h.facebook.com.sbtexhere3.api.Sberbank
import int09h.facebook.com.sbtexhere3.models.Point
import int09h.facebook.com.sbtexhere3.models.Triangle
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class SbUnitTest {
    @Test
    fun getAtmQuery_isCorrect() {
        val api = Sberbank()
//        val geo = Triangle.createFromPointAndRadius(Point(0.0f, 0.0f), 3.14159f)
        val geo = Triangle(
                Point(55.78630908896398f, 37.67243220355226f),
                Point(55.79839815416208f, 37.71268679644777f),
                Point(55.750518899999996f, 37.9878976f))
        api.getAtms(geo)
    }
}
