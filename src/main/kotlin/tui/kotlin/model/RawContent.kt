package tui.kotlin

internal class RawContent(private val _content: StringBuilder) {

    constructor() : this(StringBuilder())

    val content: String
        get() = _content.toString()

    fun add(stringBuilder: StringBuilder) {
        _content.append(stringBuilder.toString())
    }

    fun add(string: String) {
        _content.append(string)
    }

}
