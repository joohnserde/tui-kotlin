package tui.kotlin.core.component

import tui.kotlin.Arrangement
import tui.kotlin.TermManager
import tui.kotlin.Offset
import tui.kotlin.RawContent
import tui.kotlin.exception.BorderException
import tui.kotlin.navigation.Cursor
import tui.kotlin.style.CharStyle
import java.awt.Color

internal class Border(

    val charBorder: Char,

    val charHorizontal: Char,

    val charVertical: Char,

    val charTopLeft: Char,

    val charTopRight: Char,

    val charBottomLeft: Char,

    val charBottomRight: Char,

    val height: Int,

    val width: Int,

) {

    private val cursorNav = Cursor()

    fun buildBorder(
        arrangement: Arrangement,
        fgColor: Color,
        bgColor: Color
    ): RawContent {

        val charStyle = CharStyle()

        return RawContent().apply {
            charStyle.apply {
                add(fgColor(fgColor))
                add(bgColor(bgColor))
            }
            when (arrangement) {

                Arrangement.FULL -> add(buildBorderLine())

                Arrangement.VERTICAL -> add(buildVerticalLine())

                Arrangement.HORIZONTAL -> add(buildHorizontalLine())

                Arrangement.RIGHT -> add(buildRightLine())

                Arrangement.LEFT -> add(buildLeftLine())

                Arrangement.TOP -> add(buildTopLine())

                Arrangement.BOTTOM -> add(buildBottomLine())

                else -> throw BorderException("apalah coba")
            }
            add(charStyle.resetStyle())
        }
    }

    fun buildBorderLine(): RawContent {
        return RawContent().apply {
            add(buildHorizontalLine().content)
            add(buildVerticalLine().content)
        }
    }


// horizontal border line
//
//
    fun buildHorizontalLine(): RawContent {

        val horizontalLine = charHorizontal.toString().repeat(width)
        
        return RawContent().apply {
            add(cursorNav.moveTo(Offset(1, 1)))
            add(horizontalLine)
            add(cursorNav.moveTo(Offset(height, 1)))
            add(horizontalLine)
        }
    }

    fun buildTopLine(): RawContent {

        val horizontalLine = charHorizontal.toString().repeat(width)

        return RawContent().apply {
            add(cursorNav.moveTo(Offset(1, 1)))
            add(horizontalLine)
        }
    }

    fun buildBottomLine(): RawContent {

        val horizontalLine = charHorizontal.toString().repeat(width)

        return RawContent().apply {
            add(cursorNav.moveTo(Offset(height, 1)))
            add(horizontalLine)
        }
    }


// vertical border line
//
//
    fun buildVerticalLine(): RawContent {

        val rawContent = RawContent()

        return try {
            var tmpRowsLoc = height
            do {
                rawContent.apply {
                    cursorNav.apply {
                        add(moveTo(Offset(tmpRowsLoc, 1)).plus(charVertical))
                        add(moveTo(Offset(tmpRowsLoc, width)).plus(charVertical))
                    }
                }
                tmpRowsLoc--
            } while (!tmpRowsLoc.equals(0))
            rawContent
        } catch (exception: BorderException) {
            println("")
            throw exception
        }
    }

    fun buildLeftLine(): RawContent {

        val rawContent = RawContent()

        return try {
            var tmpRowsLoc = height
            do {
                rawContent.add(
                    cursorNav.moveTo(Offset(tmpRowsLoc, 1)).plus(charBorder)
                )
                tmpRowsLoc--
            } while (!tmpRowsLoc.equals(0))
            rawContent
        } catch (exception: BorderException) {
            println("")
            throw exception
        }
    }

    fun buildRightLine(): RawContent {

        val rawContent = RawContent()

        return try {
            var tmpRowsLoc = height
            do {
                rawContent.add(
                    cursorNav.moveTo(Offset(tmpRowsLoc, width)).plus(charBorder)
                )
                tmpRowsLoc--
            } while (!tmpRowsLoc.equals(0))
            rawContent
        } catch (exception: BorderException) {
            println("")
            throw exception
        }
    }
}
