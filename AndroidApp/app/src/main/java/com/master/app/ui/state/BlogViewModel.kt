package com.master.app.ui.state

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.master.app.ui.model.Blog
import com.master.app.ui.model.BlogInfo

class BlogViewModel(savedStateHandle: SavedStateHandle): ViewModel() {
    val blogId: Int? = savedStateHandle.get<Int>("id")

    val blog: Blog =  Blog(
        BlogInfo(
            1,
            "A Breakdown of the Full English Breakfast",
            "Welcome to Weekend Brunch! Skip the lines and make brunch at home. The coffee’s truly bottomless and the best part is PJs all the way! This week: a guide to the gloriousness that is known as A Full English Breakfast.",
            "picture",
            "01.04.2024",
            "Andrej Jokic"
            ),
            "On January 20, 1925, he was promoted from a Communist cell organiser in the 1st Rifle Reserve Battalion to the Chief Assistant of the Organisational Department of Political Administration of the Ukrainian Military District. On July 7, 1926, he moved to the Ural Military District, while retaining the same role. On December 10, 1926, he was appointed Deputy Head of the Political Department of the 4th Rifle Division of the Belorussian Military District. On the September 14, 1928, he was appointed Assistant to the Commander and Head of the Political Department of the 5th Vitebsk rifle division of the Belorussian Military District. He graduated from the political branch of KUVNAS at the M. Frunze Military Academy in 1930. On June 26, 1930, he was sent to Moscow as the delegate of the 16th Congress of the All-Union Communist Party (Bolsheviks) with a decisive vote from the Polotsk Party Organisation of the Belorussian Military District.\n" +
            "\n" +
            "In November 1930, he became the Military Commissar of the Experimental Mechanised Brigade of the Moscow Military District in Naro-Fominsk. A few months later on the April 8, 1931, he was appointed Head of the Political Department of the (Kalinovski) 1st Separate Mechanised Brigade in Naro-Fominsk. On April 28, 1934, Feldman was appointed Head of the Political Department of the 7th Mechanised Corpus in Leningrad. On September 22, 1935, by order of the USSR People's Commissar of Defence, K. Voroshilov, “On the introduction of personal military ranks for the commanding personnel of the Red Army” No. 2488 (dated November 28, 1935), Feldman was given the rank of Divisional Commissar. On May 11, 1937, Feldman was appointed head of the political department of the Black Sea Fleet and lived in Sevastopol.\n" +
            "\n" +
            "This occurred during the time of the Great Purge in the Soviet Union, led by Josef Stalin and Nikolai Yezhov, during which many military and naval leaders were arrested and killed. On January 28, 1938, Feldman was dismissed from his post and enlisted at the disposal of the Directorate for command and commanding personnel of the RKKA. On February 17, 1938, Feldman was called to Moscow and arrested on charges of participating in a counter-revolutionary organisation. As a result, the Supreme Court convicted him under Article 58-1 \"b\", 58-7 and 58-11 of the Criminal Code of the RSFSR, and he was sentenced to death on August 22, 1938. That same day Feldman was shot by NKVD forces and buried at the Kommunarka, Moscow Region. Feldman's wife Olga was arrested and spent 6 months in the Sevastopol jail before she was released. Olga's mother took children Octyabrina (15) and Artyom (12) to Odessa were she had been living while Olga was imprisoned.",
            listOf(
            "https://cdn.freecodecamp.org/curriculum/cat-photo-app/relaxing-cat.jpg",
            "https://cdn.freecodecamp.org/curriculum/cat-photo-app/relaxing-cat.jpg",
            "https://cdn.freecodecamp.org/curriculum/cat-photo-app/relaxing-cat.jpg",
            "https://cdn.freecodecamp.org/curriculum/cat-photo-app/relaxing-cat.jpg"
        )
    )
}