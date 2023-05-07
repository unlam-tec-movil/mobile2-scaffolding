package ar.edu.unlam.mobile2.news

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class NewViewModel : ViewModel() {
    var news by mutableStateOf(listOf<New>())
        private set

    init {
        news = listOf(
            New(
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                "03/05/23", "Sport"
            ),
            New(
                "Lorem ipsum dolor sit amet. Sed culpa sunt quo minus expedita qui voluptatum ratione sed aspernatur debitis ut vero rerum.",
                "15/02/23", "Politic"
            ),
            New(
                "Qui minima voluptas est reprehenderit autem 33 similique aperiam.",
                "01/01/23", "Sport"
            ),
            New(
                "Ut praesentium impedit non autem illo At tenetur dolores quo blanditiis quod.",
                "05/02/23", "Music"
            ),
            New(
                "Qui sint consequatur ex maxime expedita sit consequatur officia et beatae consequuntur.",
                "03/03/23", "Economic"
            ),
            New(
                "Non recusandae culpa et nemo amet sit doloribus minus qui laboriosam quae aut fugit atque est quaerat fuga.",
                "03/05/23", "Sport"
            ),
            New(
                "Ut Quis rerum et velit ipsa in praesentium nostrum quo saepe quod.",
                "03/01/23", "Politic"
            ),
            New(
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                "03/05/23", "Economic"
            )

        )
    }
}