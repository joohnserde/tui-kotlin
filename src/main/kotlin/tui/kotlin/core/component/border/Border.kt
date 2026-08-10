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

        val cursorNav = Cursor()

        val (rows, cols) = TermManager().getTerminalDimension()

        val horizontalLine = charHorizontal.toString().repeat(cols)

        return RawContent().apply {
            add(cursorNav.moveTo(Offset(1, 1)))
            add(horizontalLine)
            add(cursorNav.moveTo(Offset(rows, 1)))
            add(horizontalLine)
        }
    }

    fun buildVerticalLine(): RawContent {

        val cursorNav = Cursor()

        val (rows, cols) = TermManager().getTerminalDimension()

        val rawContent = RawContent()

        var tmpSizeRows = rows

        return try {
            do {
                rawContent.apply {
                    cursorNav.apply {
                        add(moveTo(Offset(tmpSizeRows, 1)).plus(charVertical))
                        add(moveTo(Offset(tmpSizeRows, cols)).plus(charVertical))
                    }
                }
                tmpSizeRows--
            } while (!tmpSizeRows.equals(0))
            rawContent
        } catch (exception: BorderException) {
            throw exception
        }
    }
}
