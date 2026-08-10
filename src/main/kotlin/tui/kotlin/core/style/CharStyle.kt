package tui.kotlin.style

import java.awt.Color
import tui.kotlin.AnsiEscape

internal class CharStyle {

    fun resetStyle() = AnsiEscape.TextStyle.RESET_STYLE

    fun bold() = AnsiEscape.TextStyle.BOLD

    fun italic() = AnsiEscape.TextStyle.ITALIC

    fun underLine() = AnsiEscape.TextStyle.UNDERLINE

    fun strikeThrough() = AnsiEscape.TextStyle.STRIKETHROUGH

    fun fgColor(color: Color) = AnsiEscape.TextStyle.fgColor(color)

    fun bgColor(color: Color) = AnsiEscape.TextStyle.bgColor(color)
}
