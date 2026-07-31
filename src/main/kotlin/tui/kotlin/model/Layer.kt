package tui.kotlin

import tui.kotlin.Offset

class Layer {

    internal val stringLayer: StringBuilder = StringBuilder()

    val getRawLayer: String
        get() = stringLayer.toString()

}
