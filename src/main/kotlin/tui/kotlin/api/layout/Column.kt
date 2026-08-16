package tui.kotlin.layout

import tui.kotlin.Arrangement
import tui.kotlin.TermManager
import tui.kotlin.Layer
import tui.kotlin.component.Text
import tui.kotlin.core.component.Border
import tui.kotlin.navigation.Cursor
import tui.kotlin.layout.Layout
import java.awt.Color
import tui.kotlin.Offset
import tui.kotlin.exception.BorderException

class Column(

    override val layer: Layer = Layer(),

    private val termManager: TermManager = TermManager(),

) : Layout {

    override fun canvas(charCanvas: Char) {

        val (heigth, width) = termManager.getTerminalDimension()

        val canvas = charCanvas.toString().repeat(heigth.times(width))

        layer.stringLayer.insert(0, canvas)
    }

    //border

    fun border(
        charHorizontal: Char = '#',
        charVertical: Char = '#',
        charTopLeft: Char = '#',
        charTopRight: Char = '#',
        charBottomLeft: Char = '#',
        charBottomRight: Char = '#',
        arrangement: Arrangement,
        fgColor: Color = Color.WHITE,
        bgColor: Color = Color(0,0,0,0)
    ) {
        val border = Border(
            charHorizontal = charHorizontal,
            charVertical = charVertical,
            charTopLeft = charTopLeft,
            charTopRight = charTopRight,
            charBottomLeft = charBottomLeft,
            charBottomRight = charBottomRight,
        ).buildBorder(
            arrangement = arrangement,
            fgColor = fgColor,
            bgColor = bgColor
        )

        layer.stringLayer.append(border.content)
    }

    //text

    fun text(
        textString: String,
        offset: Offset,
        italic: Boolean = false,
        bold: Boolean = false,
        underLine: Boolean = false,
        fgColor: Color = Color.WHITE,
        bgColor: Color = Color(0,0,0,0),
        strikeThrough: Boolean = false
    ) {
        val text = Text(
            textString = textString,
            offset = offset,
            italic = italic,
            bold = bold,
            underLine = underLine,
            fgColor = fgColor,
            bgColor = bgColor,
            strikeThrough = strikeThrough
        ).buildText()
        layer.stringLayer.append(text.content)
    }

}
