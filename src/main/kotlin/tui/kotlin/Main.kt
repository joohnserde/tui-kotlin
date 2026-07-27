import tui.kotlin.Offset
import tui.kotlin.layout.Column
import tui.kotlin.TuiManager
import java.awt.Color

fun main() {
    val homeScreen = Column()
    homeScreen.apply {
        text(
            textString = "test 121e31r3fqc",
            offset = Offset(2,4),
            fgColor = Color(0,0,0),
            bgColor = Color(180, 235, 52)
        )
        border()
    }
    TuiManager().write(homeScreen)
}
