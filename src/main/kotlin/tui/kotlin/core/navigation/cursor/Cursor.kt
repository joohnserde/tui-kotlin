package tui.kotlin.navigation

import tui.kotlin.Offset
import tui.kotlin.AnsiEscape

internal class Cursor {

    fun saveCursor() = AnsiEscape.CursorNav.SAVE_CURSOR

    fun restoreCursor() = AnsiEscape.CursorNav.RESTORE_CURSOR

    fun requestCursor() = AnsiEscape.CursorNav.REQUEST_CURSOR

    fun hideCursor() = AnsiEscape.CursorNav.HIDE_CURSOR

    fun showCursor() = AnsiEscape.CursorNav.SHOW_CURSOR

    fun clear() = AnsiEscape.CursorNav.CLEAR

    fun moveTo(offset: Offset) = AnsiEscape.CursorNav.moveTo(offset)
}
