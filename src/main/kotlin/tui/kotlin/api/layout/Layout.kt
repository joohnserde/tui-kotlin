package tui.kotlin.layout

import tui.kotlin.Layer
import java.awt.Color

interface Layout {

    val layer: Layer

    fun buildCanvas(
        charCanvas: Char,
        fgColor: Color,
        bgColor: Color
    )
}
