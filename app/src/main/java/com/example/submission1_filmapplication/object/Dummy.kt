package com.example.submission1_filmapplication.`object`

import com.example.submission1_filmapplication.data.ModelDataRepMov
import com.example.submission1_filmapplication.data.ModelDataRepTvshow
import com.example.submission1_filmapplication.model.*

object Dummy {
    fun dataMov(): List<ModelMov> {
        val movie = ArrayList<ModelMov>()

        movie.add(
            ModelMov(
                "mov1",
                "Shawshank Redemption",
                "The Shawshank Redemption adalah film drama Amerika Serikat tahun 1994 yang ditulis dan disutradarai Frank Darabont dan dibintangi Tim Robbins dan Morgan Freeman",
                "5",
                "https://upload.wikimedia.org/wikipedia/id/8/81/ShawshankRedemptionMoviePoster.jpg"
            )
        )
        movie.add(
            ModelMov(
                "mov2",
                "Lupin",
                "Terinspirasi oleh petualangan Arsène Lupin, pencuri pria Assane Diop bersiap untuk membalas dendam ayahnya atas ketidakadilan yang ditimbulkan oleh keluarga kaya.",
                "4",
                "https://static.wikia.nocookie.net/netflix/images/3/30/Lupin_S1_Poster.jpg/revision/latest?cb=20210108012313"
            )
        )
        movie.add(
            ModelMov(
                "mov3",
                "Kingsman",
                "Kingsman: The Golden Circle merupakan sebuah film aksi petualangan Britania Raya-Amerika Serikat yang dirilis pada tahun 2017. Film yang disutradarai oleh Matthew Vaughn ini diperankan oleh Colin Firth, Taron Egerton dan masih banyak lagi",
                "4",
                "https://lumiere-a.akamaihd.net/v1/images/image_6f0e4de5.jpeg?region=0%2C0%2C800%2C1200"
            )
        )
        movie.add(
            ModelMov(
                "mov4",
                "The Imitation Game",
                "Berdasarkan kisah kehidupan nyata seorang cryptanalyst legendaris Alan Turing, salah satu ahli Matematika terbaik di dunia dan Enigma: Alat pembuat kode terhebat dalam sejarah.",
                "4",
                "https://m.media-amazon.com/images/M/MV5BOTgwMzFiMWYtZDhlNS00ODNkLWJiODAtZDVhNzgyNzJhYjQ4L2ltYWdlXkEyXkFqcGdeQXVyNzEzOTYxNTQ@._V1_.jpg"
            )
        )
        movie.add(
            ModelMov(
                "mov5",
                "Jumper",
                "Jumper merupakan sebuah film Amerika Serikat yang dirilis pada tahun 2008. Film yang disutradarai oleh Doug Liman ini pemainnya antara lain ialah Hayden Christensen, Jamie Bell, Rachel Bilson, Samuel L. Jackson, dan masih banyak lagi.",
                "4",
                "https://bewinchester.files.wordpress.com/2011/04/jumper20085726_f.jpg?w=640"
            )
        )
        movie.add(
            ModelMov(
                "mov6",
                "Harry Potter",
                "Harry Potter adalah serial film yang didasarkan pada novel eponim oleh J. K. Rowling. Serial ini didistribusikan oleh Warner Bros. dan terdiri dari delapan film fantasi, dimulai dengan Harry Potter and the Philosopher's Stone dan berpuncak dengan Harry Potter and the Deathly Hallows",
                "4",
                "https://ae01.alicdn.com/kf/HTB1quEjKpXXXXavXXXXq6xXFXXX4/Qunexc-24X36-INCH-ART-SILK-POSTER-HARRY-POTTER-POSTER-Tawanan-azkaban-RARE-BARU.jpg_Q90.jpg_.webp"
            )
        )
        movie.add(
            ModelMov(
                "mov7",
                "The Raid",
                "The Raid adalah film aksi seni bela diri dari Indonesia yang disutradarai oleh Gareth Evans dan dibintangi oleh Iko Uwais.",
                "4",
                "https://resizing.flixster.com/t6xg1LTbeE9hoq4UhInzdim_O5U=/ems.ZW1zLXByZC1hc3NldHMvbW92aWVzLzY2YTc3ZjJlLWFjNTktNGM4ZS05NjkxLTM4YzEyYWNlYTIxOS53ZWJw"
            )
        )
        movie.add(
            ModelMov(
                "mov8",
                "The Call",
                "The Call, juga dikenal sebagai Call, adalah film thriller Korea Selatan tahun 2020 yang disutradarai oleh Lee Chung-hyun, dibintangi oleh Park Shin-hye dan Jeon Jong-seo.",
                "4",
                "https://upload.wikimedia.org/wikipedia/en/thumb/b/b7/Call_poster.jpg/220px-Call_poster.jpg"
            )
        )
        movie.add(
            ModelMov(
                "mov9",
                "The Avenger",
                "Ketika musuh yang tak terduga muncul, mengancam keselamatan dan keamanan dunia, Nick Fury, direktur Badan Perdamaian Internasional, dikenal sebagai S.H.I.E.L.D. , membutuhkan tim untuk menyelamatkan dunia dari bencana. Usaha perekrutan pun dimulai Iron Man, Captain America, Hulk, Thor, Black Widow dan Hawkeye dikumpulkan untuk menaklukkan Dewa Kehancuran, Loki, dalam usahanya menghancurkan bumi. Dengan semua gabungan kekuatan, tugas nampak lebih mudah. Namun kenyatannya tidak demikian! Para pahlawan super justru saling melawan satu sama lain Hulk melawan Captain America, siapa yang akan menang? Apakah Iron Man dapat mengalahkan kekuatan super milik Thor? Bagaimana para pahlawan super ini secara bersama-sama menghadapi bencana, melindungi masyarakat dan yang terpenting, bertahan hidup?",
                "4",
                "https://m.media-amazon.com/images/M/MV5BNDYxNjQyMjAtNTdiOS00NGYwLWFmNTAtNThmYjU5ZGI2YTI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg"
            )
        )
        movie.add(
            ModelMov(
                "mov10",
                "Iron man",
                "Iron Man adalah sebuah film yang berdasarkan tokoh Marvel Comics, Iron Man. Film yang diproduksi Marvel Studios dan didistribusikan oleh Paramount Pictures ini adalah film pertama di Marvel Cinematic Universe.",
                "4",
                "https://cf.shopee.co.id/file/a6914f351153b5642dc0c8a0ccf57b45"
            )
        )
        return movie
    }

    fun dataTvshow(): List<ModelTvshow> {
        val tvshow = ArrayList<ModelTvshow>()

        tvshow.add(
            ModelTvshow(
                "show1",
                "Alice in Borderland",
                "Alice in Borderland adalah serial televisi drama thriller-thriller fiksi ilmiah Jepang berdasarkan manga dengan nama yang sama oleh Haro Aso.",
                "5",
                "https://i.pinimg.com/originals/d5/57/35/d557351db3f60b2c7fc7ff2641260a61.jpg"
            )
        )
        tvshow.add(
            ModelTvshow(
                "show2",
                "The Amazing World of Gumball",
                "The Amazing World of Gumball adalah serial televisi animasi komedi yang dibuat oleh Ben Bocquelet untuk Cartoon Network. Diproduksi terutama oleh Cartoon Network Studios Europe",
                "4",
                "https://i.pinimg.com/originals/5f/f4/4e/5ff44eb0e16776cbe319543c7a5e4a7e.jpg"
            )
        )
        tvshow.add(
            ModelTvshow(
                "show3",
                "The Walking Dead",
                "The Walking Dead terjadi setelah permulaan sebuah kiamat zombi di seluruh dunia. Zombi-zombi yang biasa disebut walker tersebut, berjalan menuju manusia dan makhluk hidup lainnya untuk memakannya (mereka tertarik pada kebisingan, misalnya suara tembakan, dan aroma yang berbeda, misalnya aroma manusia).",
                "4",
                "https://images-na.ssl-images-amazon.com/images/I/71I1rRWXQeL.jpg"
            )
        )
        tvshow.add(
            ModelTvshow(
                "show4",
                "SpongeBob Squarepants",
                "SpongeBob SquarePants adalah seekor spons laut berwarna kuning dan berlubang-lubang, yang tinggal dalam sebuah rumah nanas dalam laut di kota Bikini Bottom, di lautan Pasifik. Tetangganya, Squidward Tentacles, adalah seekor gurita yang tinggal dalam rumah moai. Tetangga SpongeBob lain dan teman akrabnya, Patrick Star, adalah seekor bintang laut merah muda, tinggal di bawah sebuah batu. Rumah Squidward terletak di antara rumah Spongebob dan rumah Patrick, dan inilah yang meresahkan Squidward.",
                "4",
                "https://m.media-amazon.com/images/M/MV5BNTk2NzEyNTQtZTQ5MS00MjAyLTgzMDMtNDNkYTBkM2M2OTU3XkEyXkFqcGdeQXVyODUwNjEzMzg@._V1_UY1200_CR92,0,630,1200_AL_.jpg"
            )
        )
        tvshow.add(
            ModelTvshow(
                "show5",
                "Sweet Home",
                "Setelah kematian keluarganya dalam sebuah kecelakaan, Cha Hyun-soo (Song Kang) yang penyendiri pindah ke apartemen baru. Tidak lama, kehidupannya yang tenang terganggu karena insiden-insiden aneh yang mulai terjadi di gedung barunya. Ketika orang-orang berubah menjadi monster, Hyun-soo dan penghuni lainnya mencoba bertahan.",
                "4",
                "https://i.pinimg.com/736x/0a/fa/84/0afa84b6393d82d8c7ee6f9f1a08173f.jpg"
            )
        )
        tvshow.add(
            ModelTvshow(
                "show6",
                "Start-Up",
                "Start-Up berlatar belakang di kawasan fiksi Korea Selatan Silicon Valley yang disebut Sandbox dan menceritakan kisah orang-orang di dunia perusahaan startup.",
                "4",
                "https://koreanindo.net/wp-content/uploads/2020/09/Suzy-Nam-Joo-Hyuk2.jpg"
            )
        )
        tvshow.add(
            ModelTvshow(
                "show7",
                "Kakegurui",
                "Serial anime Jepang yang diadaptasi dari manga dengan judul yang sama yang ditulis oleh Homura Kawamoto dan diilustrasikan oleh Tōru Naomura. Serial televisi anime dianimasikan oleh MAPPA. Ini ditayangkan dari Juli hingga September 2017 di Tokyo MX , MBS dan saluran lainnya.",
                "4",
                "https://m.media-amazon.com/images/M/MV5BMmRhZDI4ODItYTAzMC00NWQ1LTk1MTctZWYyMDY3ZTU3NWFiXkEyXkFqcGdeQXVyMzgxODM4NjM@._V1_.jpg"
            )
        )
        tvshow.add(
            ModelTvshow(
                "show8",
                "The Witcher",
                "Pertunjukan ini awalnya mengikuti Geralt of Rivia, Putri Mahkota Ciri, dan penyihir Yennefer dari Vengerberg di berbagai titik waktu, menjelajahi peristiwa formatif yang membentuk karakter mereka, sebelum akhirnya bergabung menjadi satu garis waktu yang merinci penjajah dari Nilfgaard.",
                "4",
                "https://cdn.shopify.com/s/files/1/0319/2540/3783/products/x_gye-fp4983_1.jpg?v=1608107964"
            )
        )
        tvshow.add(
            ModelTvshow(
                "show9",
                "Peaky Blinder",
                "Serial televisi drama kriminal Britania Raya yang dibuat oleh Steven Knight. Berlatar di Birmingham, Inggris, serial ini mengikuti eksploitasi keluarga kejahatan Shelby setelah langsung Perang Dunia Pertama. Keluarga fiksi secara longgar didasarkan pada geng pemuda perkotaan nyata dengan nama yang sama, yang aktif di kota dari tahun 1890-an hingga awal abad ke-20.",
                "4",
                "https://i.pinimg.com/originals/d4/65/2d/d4652d0351fd059977785a8f7a14e400.jpg"
            )
        )
        tvshow.add(
            ModelTvshow(
                "show10",
                "Flash",
                "Serial televisi yang akan datang Amerika yang dikembangkan oleh penulis/produser Greg Berlanti, Andrew Kreisberg dan Geoff Johns, udara di The CW. Serial ini akan didasarkan pada karakter DC Comics Flash (Barry Allen), seorang superhero kejahatan-pejuang berkostum yang diciptakan oleh Robert Kanigher, John Broome dan Carmine Infantino",
                "4",
                "https://upload.wikimedia.org/wikipedia/en/4/4a/The_Flash_season_7.jpg"
            )
        )
        return tvshow
    }

    fun remoteDataMov(): List<ModelDataRepMov> {
        val movie = ArrayList<ModelDataRepMov>()

        movie.add(
            ModelDataRepMov(
                "mov1",
                "Shawshank Redemption",
                "The Shawshank Redemption adalah film drama Amerika Serikat tahun 1994 yang ditulis dan disutradarai Frank Darabont dan dibintangi Tim Robbins dan Morgan Freeman",
                "5",
                "https://upload.wikimedia.org/wikipedia/id/8/81/ShawshankRedemptionMoviePoster.jpg"
            )
        )
        movie.add(
            ModelDataRepMov(
                "mov2",
                "Lupin",
                "Terinspirasi oleh petualangan Arsène Lupin, pencuri pria Assane Diop bersiap untuk membalas dendam ayahnya atas ketidakadilan yang ditimbulkan oleh keluarga kaya.",
                "4",
                "https://static.wikia.nocookie.net/netflix/images/3/30/Lupin_S1_Poster.jpg/revision/latest?cb=20210108012313"
            )
        )
        movie.add(
            ModelDataRepMov(
                "mov3",
                "Kingsman",
                "Kingsman: The Golden Circle merupakan sebuah film aksi petualangan Britania Raya-Amerika Serikat yang dirilis pada tahun 2017. Film yang disutradarai oleh Matthew Vaughn ini diperankan oleh Colin Firth, Taron Egerton dan masih banyak lagi",
                "4",
                "https://lumiere-a.akamaihd.net/v1/images/image_6f0e4de5.jpeg?region=0%2C0%2C800%2C1200"
            )
        )
        movie.add(
            ModelDataRepMov(
                "mov4",
                "The Imitation Game",
                "Berdasarkan kisah kehidupan nyata seorang cryptanalyst legendaris Alan Turing, salah satu ahli Matematika terbaik di dunia dan Enigma: Alat pembuat kode terhebat dalam sejarah.",
                "4",
                "https://m.media-amazon.com/images/M/MV5BOTgwMzFiMWYtZDhlNS00ODNkLWJiODAtZDVhNzgyNzJhYjQ4L2ltYWdlXkEyXkFqcGdeQXVyNzEzOTYxNTQ@._V1_.jpg"
            )
        )
        movie.add(
            ModelDataRepMov(
                "mov5",
                "Jumper",
                "Jumper merupakan sebuah film Amerika Serikat yang dirilis pada tahun 2008. Film yang disutradarai oleh Doug Liman ini pemainnya antara lain ialah Hayden Christensen, Jamie Bell, Rachel Bilson, Samuel L. Jackson, dan masih banyak lagi.",
                "4",
                "https://bewinchester.files.wordpress.com/2011/04/jumper20085726_f.jpg?w=640"
            )
        )
        movie.add(
            ModelDataRepMov(
                "mov6",
                "Harry Potter",
                "Harry Potter adalah serial film yang didasarkan pada novel eponim oleh J. K. Rowling. Serial ini didistribusikan oleh Warner Bros. dan terdiri dari delapan film fantasi, dimulai dengan Harry Potter and the Philosopher's Stone dan berpuncak dengan Harry Potter and the Deathly Hallows",
                "4",
                "https://ae01.alicdn.com/kf/HTB1quEjKpXXXXavXXXXq6xXFXXX4/Qunexc-24X36-INCH-ART-SILK-POSTER-HARRY-POTTER-POSTER-Tawanan-azkaban-RARE-BARU.jpg_Q90.jpg_.webp"
            )
        )
        movie.add(
            ModelDataRepMov(
                "mov7",
                "The Raid",
                "The Raid adalah film aksi seni bela diri dari Indonesia yang disutradarai oleh Gareth Evans dan dibintangi oleh Iko Uwais.",
                "4",
                "https://resizing.flixster.com/t6xg1LTbeE9hoq4UhInzdim_O5U=/ems.ZW1zLXByZC1hc3NldHMvbW92aWVzLzY2YTc3ZjJlLWFjNTktNGM4ZS05NjkxLTM4YzEyYWNlYTIxOS53ZWJw"
            )
        )
        movie.add(
            ModelDataRepMov(
                "mov8",
                "The Call",
                "The Call, juga dikenal sebagai Call, adalah film thriller Korea Selatan tahun 2020 yang disutradarai oleh Lee Chung-hyun, dibintangi oleh Park Shin-hye dan Jeon Jong-seo.",
                "4",
                "https://upload.wikimedia.org/wikipedia/en/thumb/b/b7/Call_poster.jpg/220px-Call_poster.jpg"
            )
        )
        movie.add(
            ModelDataRepMov(
                "mov9",
                "The Avenger",
                "Ketika musuh yang tak terduga muncul, mengancam keselamatan dan keamanan dunia, Nick Fury, direktur Badan Perdamaian Internasional, dikenal sebagai S.H.I.E.L.D. , membutuhkan tim untuk menyelamatkan dunia dari bencana. Usaha perekrutan pun dimulai Iron Man, Captain America, Hulk, Thor, Black Widow dan Hawkeye dikumpulkan untuk menaklukkan Dewa Kehancuran, Loki, dalam usahanya menghancurkan bumi. Dengan semua gabungan kekuatan, tugas nampak lebih mudah. Namun kenyatannya tidak demikian! Para pahlawan super justru saling melawan satu sama lain Hulk melawan Captain America, siapa yang akan menang? Apakah Iron Man dapat mengalahkan kekuatan super milik Thor? Bagaimana para pahlawan super ini secara bersama-sama menghadapi bencana, melindungi masyarakat dan yang terpenting, bertahan hidup?",
                "4",
                "https://m.media-amazon.com/images/M/MV5BNDYxNjQyMjAtNTdiOS00NGYwLWFmNTAtNThmYjU5ZGI2YTI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg"
            )
        )
        movie.add(
            ModelDataRepMov(
                "mov10",
                "Iron man",
                "Iron Man adalah sebuah film yang berdasarkan tokoh Marvel Comics, Iron Man. Film yang diproduksi Marvel Studios dan didistribusikan oleh Paramount Pictures ini adalah film pertama di Marvel Cinematic Universe.",
                "4",
                "https://cf.shopee.co.id/file/a6914f351153b5642dc0c8a0ccf57b45"
            )
        )
        return movie
    }

    fun remoteDataTvshow(): List<ModelDataRepTvshow> {
        val tvshow = ArrayList<ModelDataRepTvshow>()

        tvshow.add(
            ModelDataRepTvshow(
                "show1",
                "Alice in Borderland",
                "Alice in Borderland adalah serial televisi drama thriller-thriller fiksi ilmiah Jepang berdasarkan manga dengan nama yang sama oleh Haro Aso.",
                "5",
                "https://i.pinimg.com/originals/d5/57/35/d557351db3f60b2c7fc7ff2641260a61.jpg"
            )
        )
        tvshow.add(
            ModelDataRepTvshow(
                "show2",
                "The Amazing World of Gumball",
                "The Amazing World of Gumball adalah serial televisi animasi komedi yang dibuat oleh Ben Bocquelet untuk Cartoon Network. Diproduksi terutama oleh Cartoon Network Studios Europe",
                "4",
                "https://i.pinimg.com/originals/5f/f4/4e/5ff44eb0e16776cbe319543c7a5e4a7e.jpg"
            )
        )
        tvshow.add(
            ModelDataRepTvshow(
                "show3",
                "The Walking Dead",
                "The Walking Dead terjadi setelah permulaan sebuah kiamat zombi di seluruh dunia. Zombi-zombi yang biasa disebut walker tersebut, berjalan menuju manusia dan makhluk hidup lainnya untuk memakannya (mereka tertarik pada kebisingan, misalnya suara tembakan, dan aroma yang berbeda, misalnya aroma manusia).",
                "4",
                "https://images-na.ssl-images-amazon.com/images/I/71I1rRWXQeL.jpg"
            )
        )
        tvshow.add(
            ModelDataRepTvshow(
                "show4",
                "SpongeBob Squarepants",
                "SpongeBob SquarePants adalah seekor spons laut berwarna kuning dan berlubang-lubang, yang tinggal dalam sebuah rumah nanas dalam laut di kota Bikini Bottom, di lautan Pasifik. Tetangganya, Squidward Tentacles, adalah seekor gurita yang tinggal dalam rumah moai. Tetangga SpongeBob lain dan teman akrabnya, Patrick Star, adalah seekor bintang laut merah muda, tinggal di bawah sebuah batu. Rumah Squidward terletak di antara rumah Spongebob dan rumah Patrick, dan inilah yang meresahkan Squidward.",
                "4",
                "https://m.media-amazon.com/images/M/MV5BNTk2NzEyNTQtZTQ5MS00MjAyLTgzMDMtNDNkYTBkM2M2OTU3XkEyXkFqcGdeQXVyODUwNjEzMzg@._V1_UY1200_CR92,0,630,1200_AL_.jpg"
            )
        )
        tvshow.add(
            ModelDataRepTvshow(
                "show5",
                "Sweet Home",
                "Setelah kematian keluarganya dalam sebuah kecelakaan, Cha Hyun-soo (Song Kang) yang penyendiri pindah ke apartemen baru. Tidak lama, kehidupannya yang tenang terganggu karena insiden-insiden aneh yang mulai terjadi di gedung barunya. Ketika orang-orang berubah menjadi monster, Hyun-soo dan penghuni lainnya mencoba bertahan.",
                "4",
                "https://i.pinimg.com/736x/0a/fa/84/0afa84b6393d82d8c7ee6f9f1a08173f.jpg"
            )
        )
        tvshow.add(
            ModelDataRepTvshow(
                "show6",
                "Start-Up",
                "Start-Up berlatar belakang di kawasan fiksi Korea Selatan Silicon Valley yang disebut Sandbox dan menceritakan kisah orang-orang di dunia perusahaan startup.",
                "4",
                "https://koreanindo.net/wp-content/uploads/2020/09/Suzy-Nam-Joo-Hyuk2.jpg"
            )
        )
        tvshow.add(
            ModelDataRepTvshow(
                "show7",
                "Kakegurui",
                "Serial anime Jepang yang diadaptasi dari manga dengan judul yang sama yang ditulis oleh Homura Kawamoto dan diilustrasikan oleh Tōru Naomura. Serial televisi anime dianimasikan oleh MAPPA. Ini ditayangkan dari Juli hingga September 2017 di Tokyo MX , MBS dan saluran lainnya.",
                "4",
                "https://m.media-amazon.com/images/M/MV5BMmRhZDI4ODItYTAzMC00NWQ1LTk1MTctZWYyMDY3ZTU3NWFiXkEyXkFqcGdeQXVyMzgxODM4NjM@._V1_.jpg"
            )
        )
        tvshow.add(
            ModelDataRepTvshow(
                "show8",
                "The Witcher",
                "Pertunjukan ini awalnya mengikuti Geralt of Rivia, Putri Mahkota Ciri, dan penyihir Yennefer dari Vengerberg di berbagai titik waktu, menjelajahi peristiwa formatif yang membentuk karakter mereka, sebelum akhirnya bergabung menjadi satu garis waktu yang merinci penjajah dari Nilfgaard.",
                "4",
                "https://cdn.shopify.com/s/files/1/0319/2540/3783/products/x_gye-fp4983_1.jpg?v=1608107964"
            )
        )
        tvshow.add(
            ModelDataRepTvshow(
                "show9",
                "Peaky Blinder",
                "Serial televisi drama kriminal Britania Raya yang dibuat oleh Steven Knight. Berlatar di Birmingham, Inggris, serial ini mengikuti eksploitasi keluarga kejahatan Shelby setelah langsung Perang Dunia Pertama. Keluarga fiksi secara longgar didasarkan pada geng pemuda perkotaan nyata dengan nama yang sama, yang aktif di kota dari tahun 1890-an hingga awal abad ke-20.",
                "4",
                "https://i.pinimg.com/originals/d4/65/2d/d4652d0351fd059977785a8f7a14e400.jpg"
            )
        )
        tvshow.add(
            ModelDataRepTvshow(
                "show10",
                "Flash",
                "Serial televisi yang akan datang Amerika yang dikembangkan oleh penulis/produser Greg Berlanti, Andrew Kreisberg dan Geoff Johns, udara di The CW. Serial ini akan didasarkan pada karakter DC Comics Flash (Barry Allen), seorang superhero kejahatan-pejuang berkostum yang diciptakan oleh Robert Kanigher, John Broome dan Carmine Infantino",
                "4",
                "https://upload.wikimedia.org/wikipedia/en/4/4a/The_Flash_season_7.jpg"
            )
        )
        return tvshow
    }

}