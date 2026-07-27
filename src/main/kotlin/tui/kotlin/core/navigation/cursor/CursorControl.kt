package tui.kotlin.navigation

import tui.kotlin.Offset
import tui.kotlin.AnsiEscape

internal class CursorControl(private var _cursorInstruc: StringBuilder) {

    constructor() : this(_cursorInstruc = StringBuilder())

    val cursorInstruc: String
        get() = _cursorInstruc.toString()

    fun saveCursor() {
        _cursorInstruc.append(AnsiEscape.CursorNav.SAVE_CURSOR)
    }

    fun restoreCursor() {
        _cursorInstruc.append(AnsiEscape.CursorNav.RESTORE_CURSOR)
    }

    fun requestCursor() {
        _cursorInstruc.append(AnsiEscape.CursorNav.REQUEST_CURSOR)
    }

    fun hideCursor() {
        _cursorInstruc.append(AnsiEscape.CursorNav.HIDE_CURSOR)
    }

    fun showCursor() {
        _cursorInstruc.append(AnsiEscape.CursorNav.SHOW_CURSOR)
    }

    fun clear() {
        _cursorInstruc.append(AnsiEscape.CursorNav.CLEAR)
    }

    fun moveTo(offset: Offset) {
        _cursorInstruc.append(AnsiEscape.CursorNav.moveTo(offset))
    }
}
