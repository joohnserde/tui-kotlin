package tui.kotlin

import tui.kotlin.Offset
import java.awt.Color

internal object AnsiEscape {

    private const val ESC = "\u001B["

    object CursorNav {

        const val SAVE_CURSOR = "${ESC}s"

        const val RESTORE_CURSOR = "${ESC}u"

        const val REQUEST_CURSOR = "${ESC}6n"

        const val HIDE_CURSOR = "${ESC}?25l"

        const val SHOW_CURSOR = "${ESC}?25h"

        const val CLEAR = "${ESC}2J"

        fun moveTo(offset: Offset): String {
            return "${ESC}${offset.row};${offset.col}H"
        }
    }

    object TextStyle {

        const val RESET_STYLE = "${ESC}0m"

        const val BOLD = "${ESC}1m"

        const val ITALIC = "${ESC}3m"

        const val UNDERLINE = "${ESC}4m"

        const val STRIKETHROUGH = "${ESC}9m"

        fun fgColor(color: Color): String {
            return "${ESC}38;2;${color.red};${color.green};${color.blue}m"
        }

        fun bgColor(color: Color): String {
            return "${ESC}48;2;${color.red};${color.green};${color.blue}m"
        }
    }
}
