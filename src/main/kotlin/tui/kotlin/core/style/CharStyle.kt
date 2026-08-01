package tui.kotlin.style

import java.awt.Color
import tui.kotlin.AnsiEscape

internal class CharStyle(private val _stylish: StringBuilder) {

    constructor() : this(_stylish = StringBuilder())

    fun resetStyle(): StringBuilder {
        return _stylish.append(
            AnsiEscape.TextStyle.RESET_STYLE
        )
    }

    fun bold(): StringBuilder {
        return _stylish.append(
            AnsiEscape.TextStyle.BOLD
        )
    }

    fun italic(): StringBuilder {
        return _stylish.append(
            AnsiEscape.TextStyle.ITALIC
        )
    }

    fun underLine(): StringBuilder {
        return _stylish.append(
            AnsiEscape.TextStyle.UNDERLINE
        )
    }

    fun strikeThrough(): StringBuilder {
        return _stylish.append(
            AnsiEscape.TextStyle.STRIKETHROUGH
        )
    }

    fun fgColor(color: Color): StringBuilder {
        return _stylish.append(
            AnsiEscape.TextStyle.fgColor(color)
        )
    }

    fun bgColor(color: Color): StringBuilder {
        return _stylish.append(
            AnsiEscape.TextStyle.bgColor(color)
        )
    }
}
