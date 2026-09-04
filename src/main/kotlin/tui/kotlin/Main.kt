import tui.kotlin.Offset
import tui.kotlin.layout.Column
import tui.kotlin.TuiManager
import java.awt.Color

fun main() {

    val homeScreen = Column()
    homeScreen.apply {

        canvas(
            charCanvas = '╳',
            fgColor = Color.WHITE,
            bgColor = Color.BLUE
        )

        buildCanvas()

        border(
            charHorizontal = '█',
            charVertical = '█',
            charTopLeft = 'L',
            charTopRight = 'R',
            charBottomLeft = 'L',
            charBottomRight = 'R'
        )

        text(
            textString = " test 121e31r3fqc ",
            offset = Offset(1,4),
            fgColor = Color(255,255,255),
            bgColor = Color(255, 0, 179)
        )

        text(
            textString = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean ut neque nunc. Duis sed turpis nec tellus pellentesque cursus.",
            offset = Offset(8, 4),
            bgColor = Color.BLUE
        )
    }
    TuiManager().write(homeScreen)
}
