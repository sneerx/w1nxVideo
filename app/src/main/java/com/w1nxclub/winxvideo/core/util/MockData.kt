package com.w1nxclub.winxvideo.core.util

import com.w1nxclub.winxvideo.R
import com.w1nxclub.winxvideo.core.util.MockConstants.AARON_PAUL
import com.w1nxclub.winxvideo.core.util.MockConstants.ACTION
import com.w1nxclub.winxvideo.core.util.MockConstants.ADVENTURE
import com.w1nxclub.winxvideo.core.util.MockConstants.ALPACINO
import com.w1nxclub.winxvideo.core.util.MockConstants.ANNE_HATHAWAY
import com.w1nxclub.winxvideo.core.util.MockConstants.AVATAR
import com.w1nxclub.winxvideo.core.util.MockConstants.BABA
import com.w1nxclub.winxvideo.core.util.MockConstants.BELLA_RAMSEY
import com.w1nxclub.winxvideo.core.util.MockConstants.BREAKING_BAD
import com.w1nxclub.winxvideo.core.util.MockConstants.BRYAN_CRANSTON
import com.w1nxclub.winxvideo.core.util.MockConstants.CHRISTOPHER_NOLAN
import com.w1nxclub.winxvideo.core.util.MockConstants.COMEDY
import com.w1nxclub.winxvideo.core.util.MockConstants.CRIME
import com.w1nxclub.winxvideo.core.util.MockConstants.DRAMA
import com.w1nxclub.winxvideo.core.util.MockConstants.EMILIA_CLARKE
import com.w1nxclub.winxvideo.core.util.MockConstants.EMMA_DARCY
import com.w1nxclub.winxvideo.core.util.MockConstants.EVANGELINE_LILLY
import com.w1nxclub.winxvideo.core.util.MockConstants.FANTASY
import com.w1nxclub.winxvideo.core.util.MockConstants.GAME_OF_THRONES
import com.w1nxclub.winxvideo.core.util.MockConstants.HORROR
import com.w1nxclub.winxvideo.core.util.MockConstants.HOUSE_OF_DRAGON
import com.w1nxclub.winxvideo.core.util.MockConstants.IAN_MC_SHANE
import com.w1nxclub.winxvideo.core.util.MockConstants.INTERSTELLAR
import com.w1nxclub.winxvideo.core.util.MockConstants.JAMES_CAMERON
import com.w1nxclub.winxvideo.core.util.MockConstants.JOHN_WICK_4
import com.w1nxclub.winxvideo.core.util.MockConstants.JOSH_HOLLOWAY
import com.w1nxclub.winxvideo.core.util.MockConstants.KIANU_REEVES
import com.w1nxclub.winxvideo.core.util.MockConstants.KIT_HARINGTON
import com.w1nxclub.winxvideo.core.util.MockConstants.LAST_OF_US
import com.w1nxclub.winxvideo.core.util.MockConstants.LOST
import com.w1nxclub.winxvideo.core.util.MockConstants.MARLON_BRONDO
import com.w1nxclub.winxvideo.core.util.MockConstants.MATTHEW_FOX
import com.w1nxclub.winxvideo.core.util.MockConstants.MATTHEW_MCCONAUGHEY
import com.w1nxclub.winxvideo.core.util.MockConstants.MATT_SMITH
import com.w1nxclub.winxvideo.core.util.MockConstants.MYSTERY
import com.w1nxclub.winxvideo.core.util.MockConstants.PEDRO_PASCAL
import com.w1nxclub.winxvideo.core.util.MockConstants.SAM_WORTHINGTON
import com.w1nxclub.winxvideo.core.util.MockConstants.SCIENCE_FICTION
import com.w1nxclub.winxvideo.core.util.MockConstants.THRILLER
import com.w1nxclub.winxvideo.core.util.MockConstants.UCUZ_ROMAN
import com.w1nxclub.winxvideo.core.util.MockConstants.ZOE_SALDANA
import com.w1nxclub.winxvideo.data.model.credits.Cast
import com.w1nxclub.winxvideo.data.model.credits.Credits
import com.w1nxclub.winxvideo.data.model.credits.Director
import com.w1nxclub.winxvideo.data.model.genre.Genre
import com.w1nxclub.winxvideo.data.model.movie.Movie
import com.w1nxclub.winxvideo.data.model.movie.MovieResult
import com.w1nxclub.winxvideo.data.model.tvshow.TvShow
import com.w1nxclub.winxvideo.data.model.tvshow.TvShowResult

object MockMovie {
    val mockMovieResult = MovieResult(
        MockData.movies
    )

    val mockTvResult = TvShowResult(
        MockData.tvshow
    )
}
object MockData {

    val movies = arrayListOf<Movie>(
        Movie(
            id = BABA,
            title = "The Godfather",
            overview = "Mario Puzo'nun çok satan kitabından Puzo ve yönetmen Francis Ford Coppola tarafından sinemaya uyarlanan eser, 40'lar ve 50'lerin Amerika'sında, bir İtalyan mafya ailesinin destansı öyküsünü konu alıyor. Corleone ailesi, Don Vito Corleone'nin başında olduğu, suça dayalı bir örgüt kurmuş olan İtalyan asıllı meşhur bir ailedir. Aile, New York'taki diğer dört aileyle birlikte New York'un yeraltı işlerini yönetmektedir. Ancak Corleone ailesini diğerlerinden ayıran özelliği, Don Corleone'nin cebinde bozuk para gibi taşıdığı politikacılar ve yargıçlardır. Politikacılar ve yargıçlarla olan bu yakın ilişkileri diğer ailelerin açamadığı kapıları açabilmesini sağlamaktadır.",
            posterPath = R.drawable.baba,
            backdropPath = R.drawable.baba_back,
            releaseDate = "10-19-1973",
            imdbRating = 9.0f,
            duration = 175,
            genres = arrayListOf(
                Genre(
                    id = DRAMA,
                    name = "Dram"
                ),
                Genre(
                    id = CRIME,
                    name = "Suç"
                )
            ),
            voteAverage = 4.5f,
            voteCount = 10,
            credits = Credits(
                cast = arrayListOf(
                    Cast(
                        id = ALPACINO,
                        name = "Al Pacino",
                        profilePath = R.drawable.alpacino
                    ),
                    Cast(
                        id = MARLON_BRONDO,
                        name = "Marlon Brondo",
                        profilePath = R.drawable.marlon_brondo
                    )
                ),
                director = null

            )
        ),
        Movie(
            id = AVATAR,
            title = "Avatar",
            overview = "Avatar, James Cameron tarafından yazılan ve yönetilen 2009 yapımı bir bilim kurgu filmidir. Film, Pandora adlı uzak bir gezegendeki mineral kaynaklarını keşfetmek için insanların bir Avatar programı aracılığıyla Na'vi adlı yerli halka katıldığı bir hikayeyi anlatıyor. Jake Sully adında felçli bir eski deniz piyadesi, Na'vi kültürünü öğrenmeye başladıkça içinde bulunduğu çatışmaları ve doğayla olan bağını keşfeder.",
            posterPath = R.drawable.avatar,
            backdropPath = R.drawable.avatar_back,
            releaseDate = "18-12-2009",
            imdbRating = 7.8f,
            duration = 162,
            genres = arrayListOf(
                Genre(
                    id = SCIENCE_FICTION,
                    name = "Bilim Kurgu"
                ),
                Genre(
                    id = ACTION,
                    name = "Aksiyon"
                ),
                Genre(
                    id = ADVENTURE,
                    name = "Macera"
                )
            ),
            voteAverage = 4.3f,
            voteCount = 15,
            credits = Credits(
                cast = arrayListOf(
                    Cast(
                        id = SAM_WORTHINGTON,
                        name = "Sam Worthington",
                        profilePath = R.drawable.sam_worthington
                    ),
                    Cast(
                        id = ZOE_SALDANA,
                        name = "Zoe Saldana",
                        profilePath = R.drawable.zoe_saldana
                    )
                ),
                director = Director(
                    id = JAMES_CAMERON,
                    name = "James Cameron",
                    profilePath = R.drawable.james_cameron
                )
            )
        ),
        Movie(
            id = INTERSTELLAR,
            title = "Interstellar",
            overview = "Interstellar, Christopher Nolan tarafından yazılan ve yönetilen 2014 yapımı bir bilim kurgu filmidir. Film, dünyada yaşanan iklim felaketleri sonucu insanlığın hayatta kalma mücadelesini konu alır. Bir grup astronot, insanlığın geleceği için yeni bir gezegen bulmak üzere uzayda bir yolculuğa çıkar. Bu yolculuk sırasında, uzay ve zamanın sınırlarını aşan olaylarla karşılaşırlar.",
            posterPath = R.drawable.interstellar,
            backdropPath = R.drawable.interstellar_back,
            releaseDate = "07-11-2014",
            imdbRating = 8.6f,
            duration = 169,
            genres = arrayListOf(
                Genre(
                    id = SCIENCE_FICTION,
                    name = "Bilim Kurgu"
                ),
                Genre(
                    id = ADVENTURE,
                    name = "Macera"
                ),
                Genre(
                    id = DRAMA,
                    name = "Dram"
                )
            ),
            voteAverage = 4.5f,
            voteCount = 12,
            credits =
            Credits(
                cast = arrayListOf(
                    Cast(
                        id = MATTHEW_MCCONAUGHEY,
                        name = "Matthew McConaughey",
                        profilePath = R.drawable.matthew_mcconaughey
                    ),
                    Cast(
                        id = ANNE_HATHAWAY,
                        name = "Anne Hathaway",
                        profilePath = R.drawable.anne_hathaway
                    )
                ),
                director = Director(
                    id = CHRISTOPHER_NOLAN,
                    name = "Christopher Nolan",
                    profilePath = R.drawable.christopher_nolan
                )

            )
        ),
        Movie(
            id = JOHN_WICK_4,
            title = "John Wick 4",
            overview = "John Wick 4, yönetmenliğini Chad Stahelski'nin üstlendiği 2023 yapımı bir aksiyon filmidir. Serinin devamı niteliğinde olan filmde, emekli suikastçi John Wick'in maceraları devam eder. Wick, artık peşinde olan birçok düşmanıyla mücadele etmek zorunda kalırken, kendisini ve sevdiklerini korumak için intikam yolculuğuna çıkar.",
            posterPath = R.drawable.jw4,
            backdropPath = R.drawable.jw4_back,
            releaseDate = "2023-09-15",
            imdbRating = 8.9f,
            duration = 120,
            genres = arrayListOf(
                Genre(
                    id = ACTION,
                    name = "Aksiyon"
                ),
                Genre(
                    id = THRILLER,
                    name = "Gerilim"
                ),
                Genre(
                    id = CRIME,
                    name = "Suç"
                )
            ),
            voteAverage = 4.7f,
            voteCount = 8,
            credits = Credits(
                cast = arrayListOf(
                    Cast(
                        id = KIANU_REEVES,
                        name = "Keanu Reeves",
                        profilePath = R.drawable.keanu_reeves
                    ),
                    Cast(
                        id = IAN_MC_SHANE,
                        name = "Ian McShane",
                        profilePath = R.drawable.ian_mcshane
                    )
                ),
                director = null

            )
        ),
        Movie(
            id = UCUZ_ROMAN,
            title = "Ucuz Roman",
            overview = "Ucuz Roman, 1994 yapımı bir Quentin Tarantino filmidir. Film, Los Angeles'ta geçen dört ayrı öyküyü bir araya getiren kara mizah unsurlarıyla dolu bir suç filmidir. Uyuşturucu, şiddet ve gangsterlik temasını işleyen filmde, farklı karakterlerin yolları kesişir ve beklenmedik olaylar yaşanır.",
            posterPath = R.drawable.ucuz_roman,
            backdropPath = R.drawable.ucuz_roman_back,
            releaseDate = "10-14-1994",
            imdbRating = 8.9f,
            duration = 154,
            genres = arrayListOf(
                Genre(
                    id = CRIME,
                    name = "Suç"
                ),
                Genre(
                    id = COMEDY,
                    name = "Komedi"
                ),
                Genre(
                    id = THRILLER,
                    name = "Gerilim"
                )
            ),
            voteAverage = 4.7f,
            voteCount = 8,
            credits =
            Credits(
                cast = null,
                director = null
            )

        )
    )

    val tvshow = arrayListOf<TvShow>(
        TvShow(
            id = GAME_OF_THRONES,
            title = "Game of Thrones",
            overview = "Krallık dediğin savaşsız olur mu? En güçlü krallığı kurup, huzuru sağlamış olsan bile bu gücü elinde nasıl koruyacaksın? Burada yanlış yapana yer yok, affetmek yok. Kuzey Krallığının hükümdarı Lord Ned Stark, uzun ve zorlu savaşlardan sonra anayurduna dönüp krallığını bütünlük içerisinde tutmayı başarmıştır. Kral Robert Baratheon ile yıllarca omuz omuza çarpışan ve Baratheon'un kral olmasını sağlayan Ned Stark'ın tek istediği kuzey sınırlarını koruyan krallığında ailesiyle ve halkıyla yaşamaktır.\n" +
                    "\n" +
                    "Fakat suyun öte yanında kendi topraklarından ve krallığından kovulduğunu iddia eden Viserys Targaryen , kız kardeşi Daenerys'i barbar kavimlerin başı Han Drogo'ya vererek, güç birliği planları yapmaktadır. Tahtını büyük bir iştahla geri isteyen ama kraliyet oyunlarından habersiz olan Viserys'in planları Kral Baratheon'a ulaşır. Savaş alanında büyük cengaver olan ama ülke ve aile yönetiminde aynı başarıyı tutturamayan Baratheon'un tamamen güvenebileceği ve her yanlış hamlesini arkasından toplayacak yeni bir sağ kola ihtiyacı vardır. Kuzeyin Lordu Ned Stark bu görev için seçilen tek aday isimdir. Kış yaklaşıyor...\n" +
                    "\n" +
                    "Hanedan entrikaları, kapılı kapılar ardında dönen oyunlar, birilerinin kuyusunu kazmak için düşmanın koynuna girmekten çekinmeyen kadınlar, kardeşler arası çekişmeler, dışlanmalar... Hepsi tek bir hedef için: Taht kavgası..",
            posterPath = R.drawable.game_of_thrones,
            backdropPath = R.drawable.game_of_thrones_back,
            releaseDate = "2011",
            imdbRating = 9.5f,
            genres = arrayListOf(
                Genre(
                    id = SCIENCE_FICTION,
                    name = "Bilim Kurgu"
                ),
                Genre(
                    id = FANTASY,
                    name = "Fantazi"
                ),
                Genre(
                    id = DRAMA,
                    name = "Dram"
                )
            ),
            voteAverage = 5.0f,
            voteCount = 25,
            credits = Credits(
                cast = arrayListOf(
                    Cast(
                        id = EMILIA_CLARKE,
                        name = "Emilia Clarke",
                        profilePath = R.drawable.emilia_clarke
                    ),
                    Cast(
                        id = KIT_HARINGTON,
                        name = "Kit Harington",
                        profilePath = R.drawable.kit_harington
                    )
                ),
                director = null
            ),
            numberOfSeasons = 7,
            numberOfEpisodes = 75
        ),
        TvShow(
            id = BREAKING_BAD,
            title = "Breaking Bad",
            overview = "Breaking Bad, Vince Gilligan tarafından yaratılan bir Amerikan televizyon dizisidir. Dizi, kimya öğretmeni Walter White'ın kanser olduğunu öğrendikten sonra, ailesini maddi güvence altına almak için methamphetamine (meth) üretmeye başlamasıyla başlar. Walter, eski öğrencisi Jesse Pinkman ile ortaklık kurar ve uyuşturucu dünyasına adım atar. Ancak bu yasadışı yolda yükselmek, onları tehlikeli suç çeteleriyle karşı karşıya getirecektir.",
            posterPath = R.drawable.breaking_bad_poster,
            backdropPath = R.drawable.breaking_bad_backdrop,
            releaseDate = "2008",
            imdbRating = 9.5f,
            genres = arrayListOf(
                Genre(
                    id = DRAMA,
                    name = "Dram"
                ),
                Genre(
                    id = CRIME,
                    name = "Suç"
                ),
                Genre(
                    id = THRILLER,
                    name = "Gerilim"
                )
            ),
            voteAverage = 5.0f,
            voteCount = 25,
            credits = Credits(
                cast = arrayListOf(
                    Cast(
                        id = BRYAN_CRANSTON,
                        name = "Bryan Cranston",
                        profilePath = R.drawable.bryan_cranston
                    ),
                    Cast(
                        id = AARON_PAUL,
                        name = "Aaron Paul",
                        profilePath = R.drawable.aaron_paul
                    )
                ),
                director = null
            ),
            numberOfSeasons = 5,
            numberOfEpisodes = 62
        ),
        TvShow(
            id = LAST_OF_US,
            title = "The Last of Us",
            overview = "The Last of Us, Neil Druckmann tarafından yaratılan ve Naughty Dog tarafından geliştirilen popüler bir video oyunu serisinden uyarlanan bir televizyon dizisidir. Dizi, post-apokaliptik bir dünyada hayatta kalmaya çalışan Joel ve Ellie adlı karakterleri merkezine alır. Bir mantar benzeri bir enfeksiyon sonucu dönüşen zombi benzeri yaratıklarla dolu bir dünyada, Joel ve Ellie, hayatta kalmak için birlikte mücadele eder ve aynı zamanda birbirlerini anlamaya ve bir bağ kurmaya çalışırlar.",
            posterPath = R.drawable.last_of_us,
            backdropPath = R.drawable.last_of_us_back,
            releaseDate = "2022",
            imdbRating = 9.0f,
            genres = arrayListOf(
                Genre(
                    id = DRAMA,
                    name = "Dram"
                ),
                Genre(
                    id = HORROR,
                    name = "Korku"
                ),
                Genre(
                    id = ADVENTURE,
                    name = "Macera"
                )
            ),
            voteAverage = 4.5f,
            voteCount = 10,
            credits = Credits(
                cast = arrayListOf(
                    Cast(
                        id = PEDRO_PASCAL,
                        name = "Pedro Pascal",
                        profilePath = R.drawable.pedro_pascal
                    ),
                    Cast(
                        id = BELLA_RAMSEY,
                        name = "Bella Ramsey",
                        profilePath = R.drawable.bella_ramsey
                    )
                ),
                director = null
            ),
            numberOfSeasons = 1,
            numberOfEpisodes = 10
        ),
        TvShow(
            id = HOUSE_OF_DRAGON,
            title = "House of the Dragon",
            overview = "House of the Dragon, George R.R. Martin'in A Song of Ice and Fire serisinden uyarlanan ve Game of Thrones evreninde geçen bir televizyon dizisidir. Dizi, Targaryen Hanedanı'nın hikayesini anlatır. Westeros'un geçmişine odaklanan dizi, Targaryen ailesinin yükselişini ve iç çekişmelerini konu alır. İktidar hırsı, entrikalar ve ejderhalarla dolu bir dünyada, Targaryen ailesi Westeros krallığının kontrolünü ele geçirmek için mücadele eder.",
            posterPath = R.drawable.hod,
            backdropPath = R.drawable.hod_back,
            releaseDate = "2022",
            imdbRating = 9.5f,
            genres = arrayListOf(
                Genre(
                    id = FANTASY,
                    name = "Fantazi"
                ),
                Genre(
                    id = DRAMA,
                    name = "Dram"
                ),
                Genre(
                    id = ACTION,
                    name = "Aksiyon"
                )
            ),
            voteAverage = 5.0f,
            voteCount = 25,
            credits = Credits(
                cast = arrayListOf(
                    Cast(
                        id = MATT_SMITH,
                        name = "Matt Smith",
                        profilePath = R.drawable.matt_smith
                    ),
                    Cast(
                        id = EMMA_DARCY,
                        name = "Emma Darcy",
                        profilePath = R.drawable.emma_darcy
                    )
                ),
                director = null
            ),
            numberOfSeasons = 1,
            numberOfEpisodes = 10
        ),
        TvShow(
            id = LOST,
            title = "Lost",
            overview = "Lost, J.J. Abrams, Damon Lindelof ve Jeffrey Lieber tarafından yaratılan bir Amerikan televizyon dizisidir. Dizi, Pasifik Okyanusu'nda yaşanan bir uçak kazası sonucu terkedilmiş bir adada mahsur kalan bir grup yolcunun hayatta kalma mücadelesini konu alır. Adada gizemli olaylar yaşanır, doğaüstü varlıklar ortaya çıkar ve karakterlerin geçmişleriyle ilgili sırlar açığa çıkar. Bir arada hayatta kalmaya çalışan bu grup, adanın sırlarını keşfetmeye ve kurtuluş yollarını bulmaya çalışır.",
            posterPath = R.drawable.lost_poster,
            backdropPath = R.drawable.lost_backdrop,
            releaseDate = "2004",
            imdbRating = 8.3f,
            genres = arrayListOf(
                Genre(
                    id = DRAMA,
                    name = "Dram"
                ),
                Genre(
                    id = FANTASY,
                    name = "Fantazi"
                ),
                Genre(
                    id = MYSTERY,
                    name = "Gizem"
                )
            ),
            voteAverage = 4.2f,
            voteCount = 20,
            credits = Credits(
                cast = arrayListOf(
                    Cast(
                        id = MATTHEW_FOX,
                        name = "Matthew Fox",
                        profilePath = R.drawable.matthew_fox
                    ),
                    Cast(
                        id = EVANGELINE_LILLY,
                        name = "Evangeline Lilly",
                        profilePath = R.drawable.evangeline_lilly
                    ),
                    Cast(
                        id = JOSH_HOLLOWAY,
                        name = "Josh Holloway",
                        profilePath = R.drawable.josh_holloway
                    )
                ),
                director = null
            ),
            numberOfSeasons = 6,
            numberOfEpisodes = 121
        )
    )
}