package tui.kotlin.component

import tui.kotlin.TermManager
import tui.kotlin.Offset
import tui.kotlin.RawContent
import tui.kotlin.exception.BorderException
import tui.kotlin.navigation.Cursor

internal class Border(

    val charHorizontal: Char,

    val charVertical: Char,

    val charTopLeft: Char,

    val charTopRight: Char,

    val charBottomLeft: Char,

    val charBottomRight: Char,
) {

    fun buildBorderLine(): RawContent = RawContent().apply {
            add(buildHorizontalLine().content)
            add(buildVerticalLine().content)
    }

    fun buildHorizontalLine(): RawContent {
        val (rows, cols) = TermManager().getTerminalDimension()

        val cursorNavToUp = Cursor()
        cursorNavToUp.moveTo(Offset(1, 1))

        val cursorNavToDown = Cursor()
        cursorNavToDown.moveTo(Offset(rows, 1))

        val horizontalLine = charHorizontal.toString().repeat(cols)

        return RawContent().apply {
            add(cursorNavToUp.cursorInstruc)
            add(horizontalLine)
            add(cursorNavToDown.cursorInstruc)
            add(horizontalLine)
        }
    }

    fun buildVerticalLine(): RawContent {
        val (rows, cols) = TermManager().getTerminalDimension()

        val rawContent = RawContent()

        var tmpSizeRows = rows

        try {
            do {
                rawContent.add(
                    Cursor().apply {
                        moveTo(Offset(tmpSizeRows, 1))
                    }.cursorInstruc.plus(charVertical)
                )
                rawContent.add(
                    Cursor().apply {
                        moveTo(Offset(tmpSizeRows, cols))
                    }.cursorInstruc.plus(charVertical)
                )
                tmpSizeRows--
            } while (!tmpSizeRows.equals(0))
        } catch (exception: BorderException) {
            throw exception
        }

        return rawContent
    }

}
