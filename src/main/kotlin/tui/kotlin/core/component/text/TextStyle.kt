package tui.kotlin.component

import java.awt.Color
import tui.kotlin.AnsiEscape

internal class TextStyle(private val _stylish: StringBuilder) {

    constructor() : this(_stylish = StringBuilder())

    val stylish: String
        get() = _stylish.toString()

    fun resetStyle() {
        _stylish.append(AnsiEscape.TextStyle.RESET_STYLE)
    }

    fun bold() {
        _stylish.append(AnsiEscape.TextStyle.BOLD)
    }

    fun italic() {
        _stylish.append(AnsiEscape.TextStyle.ITALIC)
    }

    fun underLine() {
        _stylish.append(AnsiEscape.TextStyle.UNDERLINE)
    }

    fun strikeThrough() {
        _stylish.append(AnsiEscape.TextStyle.STRIKETHROUGH)
    }

    fun fgColor(color: Color) {
        _stylish.append(AnsiEscape.TextStyle.fgColor(color))
    }

    fun bgColor(color: Color) {
        _stylish.append(AnsiEscape.TextStyle.bgColor(color))
    }
}
