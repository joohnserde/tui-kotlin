package tui.kotlin.navigation

import tui.kotlin.Offset
import tui.kotlin.AnsiEscape

class Cursor {

    fun saveCursor() = LiteralCursor.SAVE_CURSOR

    fun restoreCursor() = LiteralCursor.RESTORE_CURSOR

    fun requestCursor() = LiteralCursor.REQUEST_CURSOR

    fun hideCursor() = LiteralCursor.HIDE_CURSOR

    fun showCursor() = LiteralCursor.SHOW_CURSOR

    fun clear() = LiteralCursor.CLEAR

    fun moveTo(offset: Offset) = LiteralCursor.moveTo(offset)
}
