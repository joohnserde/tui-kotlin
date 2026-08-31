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

    val dimension = termManager.getTerminalDimension()

    // component canvas
    override fun canvas(charCanvas: Char) {
        layer.stringLayer.insert(0, 
            charCanvas.toString().repeat(
                dimension.first.times(dimension.second)
            )
        )
    }

    // border
    fun border(
        charBorder: Char = '#',
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
            charBorder = charBorder,
            charHorizontal = charHorizontal,
            charVertical = charVertical,
            charTopLeft = charTopLeft,
            charTopRight = charTopRight,
            charBottomLeft = charBottomLeft,
            charBottomRight = charBottomRight,
            height = dimension.first,
            width = dimension.second
        ).buildBorder(
            arrangement = arrangement,
            fgColor = fgColor,
            bgColor = bgColor
        )

        layer.stringLayer.append(border.content)
    }


    // text
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
