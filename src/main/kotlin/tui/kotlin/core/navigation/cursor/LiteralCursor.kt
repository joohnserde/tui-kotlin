package tui.kotlin.navigation

import tui.kotlin.Offset
import tui.kotlin.AnsiEscape

internal object LiteralCursor {

    const val SAVE_CURSOR = "${AnsiEscape.ESC}s"

    const val RESTORE_CURSOR = "${AnsiEscape.ESC}u"

    const val REQUEST_CURSOR = "${AnsiEscape.ESC}6n"

    const val HIDE_CURSOR = "${AnsiEscape.ESC}?25l"

    const val SHOW_CURSOR = "${AnsiEscape.ESC}?25h"

    const val CLEAR = "${AnsiEscape.ESC}2J"

    fun moveTo(offset: Offset): String {
        return "${AnsiEscape.ESC}${offset.row};${offset.col}H"
    }
}
