package tui.kotlin.core.component

import tui.kotlin.RawContent
import tui.kotlin.style.CharStyle
import java.awt.Color

class Canvas(val charCanvas: Char) {

    fun buildCanvas(
        termSize: Int,
        fgColor: Color,
        bgColor: Color
    ): RawContent {

        val charStyle = CharStyle()

        return RawContent().apply {
            add(charStyle.fgColor(fgColor))
            add(charStyle.bgColor(bgColor))
            add(charCanvas.toString().repeat(termSize))
            add(charStyle.resetStyle())
        }
    }

}
