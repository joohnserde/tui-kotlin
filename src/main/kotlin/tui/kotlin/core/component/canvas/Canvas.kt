package tui.kotlin.core.component

import tui.kotlin.RawContent
import tui.kotlin.style.CharStyle
import java.awt.Color

class Canvas(

    val charCanvas: Char,

    val termSize: Pair<Int, Int>

) {

    fun buildCanvas(
        fgColor: Color,
        bgColor: Color
    ): RawContent {

        val charStyle = CharStyle()

        return RawContent().apply {
            add(charStyle.fgColor(fgColor))
            add(charStyle.bgColor(bgColor))
            add(charCanvas.toString().repeat(
                termSize.first * termSize.second
            ))
            add(charStyle.resetStyle())
        }
    }
}
