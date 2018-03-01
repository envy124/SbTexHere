package int09h.facebook.com.sbtexhere3.models

/**
 * A dummy item representing a piece of content.
 */
data class SbEntity(
        val street: String,
        val type: String,
        val description: String,
        val distance: Double,
        val position: Point)