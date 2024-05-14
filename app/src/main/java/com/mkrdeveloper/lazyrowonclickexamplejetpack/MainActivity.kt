package com.mkrdeveloper.lazyrowonclickexamplejetpack

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mkrdeveloper.lazyrowonclickexamplejetpack.screens.DetailScreen
import com.mkrdeveloper.lazyrowonclickexamplejetpack.screens.MainScreen
import com.mkrdeveloper.lazyrowonclickexamplejetpack.ui.theme.LazyRowOnClickExampleJetpackTheme

data class BottomNavigation(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyRowOnClickExampleJetpackTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val imageId = arrayOf(
                        R.drawable.img,
                        R.drawable.img_1,
                        R.drawable.img_2,
                        R.drawable.img_3,
                        R.drawable.img_4,
                        R.drawable.img_5,
                        R.drawable.img_6,
                        R.drawable.img_7,
                        R.drawable.img_8,
                        R.drawable.img_9
                    )

                    val names = arrayOf(
                        "Corgi",
                        "Siberian Husky",
                        "Golden Retriever",
                        "Samoyed",
                        "Border Collie",
                        "Chow Chow",
                        "Pitbull",
                        "Akita",
                        "German Shepherd",
                        "Shiba Inu"
                    )

                    val ingredients = arrayOf(
                        "Anjing yang aktif, ramah, dan ceria",
                        "Warna matanya yang berbeda-beda",
                        "Golden dikenal ramah, pintar dan setia",
                        "Memiliki ekspresi wajah yang selalu tersenyum.",
                        "Memiliki sifat yang aktif, cerdas, mudah beradaptasi",
                        "Bulunya yang tebal dan badan gembulnya",
                        "Pitbull terkenal sebagai anjing yang galak",
                        "Akita adalah anjing yang ramah dan setia",
                        "Anjing suka menjadi anjing penjaga rumah",
                        "Tidak mudah percaya dengan orang lain"

                    )
                    val detail = arrayOf(
                        "Pembroke Corgi adalah anjing kecil yang aktif dan patuh. Mereka berani, ramah, dan marah (anjing besar dalam tubuh kecil). Mereka patuh dan setia kepada keluarga dan sangat cocok untuk rumah yang aktif dan sibuk. Mereka menjadi anjing penjaga yang baik, waspada di rumah, dan senang mengumumkan setiap pengunjung.",
                        "Ras ini dikenal karena temperamennya yang baik dan kecintaannya pada orang-orang berarti mereka tidak membuat anjing penjaga alami. Mereka mencintai dan membutuhkan teman dan tidak boleh ditinggalkan sendirian untuk waktu yang lama atau mereka bisa menjadi sangat merusak. Mereka akan senang dengan anjing lain yang dapat menyesuaikan diri dengan baik tetapi merupakan pemburu yang tajam dan efisien sehingga kontak dengan hewan rumah tangga lainnya membutuhkan penanganan dan pelatihan yang hati-hati. Meskipun mereka tidak sering menggonggong, mereka akan melolong, seringkali hanya untuk kesenangan!",
                        "Golden Retriever adalah anjing yang lembut dengan watak yang datar, dan biasanya beradaptasi dengan baik dengan kehidupan keluarga. Mereka senang terlibat dalam segala hal, baik di dalam maupun di luar ruangan. Mereka terutama adalah seekor retriever dan akan berusaha untuk menyeret, menarik, atau membawa apa pun yang dapat mereka masukkan ke dalam mulut mereka. Mereka juga menyukai air dan perawatan harus dilakukan untuk memastikan keselamatan mereka ketika segala bentuk air berada di dekatnya. Namun, Golden Retriever mudah cemas, dan harus sangat berhati-hati selama pelatihan, memastikan sensitivitas dipertahankan setiap saat.",
                        "Samoyed umumnya adalah anjing yang ramah,dan setia. Samoyed melindungi rumah mereka; tidak ada penyusup yang tidak akan pernah terdengar. Dia suka diikutsertakan dalam semua kegiatan keluarga dan bisa menjadi destruktif dan vokal jika dibiarkan terlalu lama atau bosan. Mereka senang menggali dan merupakan seniman pelarian yang hebat, jadi keamanan taman sangat penting. Mereka harus disosialisasikan sejak usia dini, terutama dengan kucing dan hewan peliharaan rumah tangga lainnya. Mereka bisa sangat vokal.",
                        "Border Collie selalu siap bekerja, penuh perhatian, lincah, dan waspada. Mereka dapat memiliki ikatan emosi yang sangat dekat dengan pemilik dan keluarganya. Namun, jika tidak diberi banyak waktu dan olahraga, mereka bukanlah hewan peliharaan yang ideal untuk keluarga dengan anak-anak yang masih sangat kecil, karena sudah menjadi sifat alami mereka untuk menggiring apa pun yang bergerak - termasuk anak-anak Anda. Jika tidak dirangsang secara fisik dan mental, mereka akan mudah merasa bosan dan dapat mengembangkan masalah perilaku atau menjadi nakal, karena otak mereka selalu aktif.",
                        "Chow adalah anjing yang suka menyendiri, mandiri, dan keras kepala. Mereka dapat menjadi terikat pada satu orang dan menjauh bila mereka merasa – atau pemiliknya – terancam. Jenis Chow mudah marah karena dianggap kurang pelatihan dan sosialisasi yang tepat saat ia masih muda. Selama mereka diperkenalkan kepada anak-anak, kucing dan hewan peliharaan rumah tangga lainnya ketika masih muda, masalah dapat dicegah.",
                        "Dengan orang-orang, Pitbull yang dibesarkan dengan baik dan disosialisasikan dengan baik harus memiliki temperamen yang sempurna dan sangat baik hati (jika tidak agak riuh!) dengan orang-orang. Namun, dengan anjing atau hewan lain, Pitbull bisa jadi kurang ramah, meskipun banyak bergantung pada sosialisasi dan pelatihan awal. Beberapa Pitbull hidup bahagia bersama anjing dan kucing lain; yang lain tidak boleh berjalan tanpa timah di area di mana mereka mungkin bertemu dengan anjing lain. Sosialisasi dini dan berkelanjutan sangat penting.",
                        "Mereka adalah anjing yang kuat – dalam tubuh dan karakter – dan tidak direkomendasikan untuk pemilik pemula. Mereka membutuhkan penanganan yang berpengalaman serta sosialisasi dan pelatihan secara dini dan berkelanjutan. Namun, mereka sangat setia pada keluarga mereka sendiri. Berani, mereka menjadi anjing penjaga yang baik tanpa menggonggong terlalu banyak. Naluri berburu mereka kuat dan ini harus diingat setiap saat.",
                        "German Shepherd akan mengembangkan ikatan yang sangat dekat dengan pawangnya dan ingin bersamanya sebanyak mungkin. Meskipun ras ini memang membutuhkan banyak perhatian, mereka akan membalas seratus kali lipat dengan kesetiaan dan keterampilan menjaga yang tidak pernah rusak. Di sisi lain, jika Anda tidak meluangkan waktu untuk bersosialisasi dan melatih GSD, akan ada masalah dengan kepercayaan diri dan ketidakstabilan. Anjing ini sangat ingin belajar dan sangat responsif terhadap pelatihan sehingga mereka harus membuktikan menjadi murid yang luar biasa di kelas pelatihan.",
                        "Anjing yang waspada, aktif dan ramah, jenis anjing Shiba Inu Jepang bisa sangat mandiri dan sering memiliki naluri berburu yang kuat. Sosialisasi awal dan menyeluruh sangat penting, terutama untuk membantu mereka bersosialisasi dengan anjing lain. Fitur yang tidak biasa dari ras ini adalah 'jeritan Shiba' – vokalisasi bernada tinggi yang dipancarkan saat bersemangat atau gelisah."

                    )




                    val items = listOf(
                        BottomNavigation(
                            title = "Home",
                            selectedIcon = Icons.Filled.Home,
                            unselectedIcon = Icons.Outlined.Home,
                            hasNews = false
                        ),
                        BottomNavigation(
                            title = "Grid",
                            selectedIcon = Icons.Filled.List,
                            unselectedIcon = Icons.Outlined.List,
                            hasNews = false,
                        ),
                        BottomNavigation(
                            title = "About",
                            selectedIcon = Icons.Filled.Person,
                            unselectedIcon = Icons.Outlined.Person,
                            hasNews = false
                        ),
                    )
                    var selectedItemIndex by rememberSaveable {
                        mutableStateOf(0)
                    }

                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        Scaffold(
                            bottomBar = {
                                NavigationBar {
                                    items.forEachIndexed { index, item ->

                                        NavigationBarItem(
                                            selected = selectedItemIndex == index,
                                            onClick = {
                                                selectedItemIndex = index
                                            },
                                            label = {
                                                Text(text = item.title)
                                            },
                                            alwaysShowLabel = false,
                                            icon = {
                                                BadgedBox(
                                                    badge = {
                                                        if (item.badgeCount != null) {
                                                            Badge {
                                                                Text(text = item.badgeCount.toString())
                                                            }
                                                        } else if (item.hasNews) {
                                                            Badge()
                                                        }

                                                    }
                                                ) {
                                                    Icon(
                                                        imageVector = if (index == selectedItemIndex) {
                                                            item.selectedIcon
                                                        } else item.unselectedIcon,
                                                        contentDescription = item.title
                                                    )
                                                }
                                            })



                                    }
                                }
                            }
                        )
                        {
                            val navController = rememberNavController()
                            NavHost(navController = navController, startDestination = "MainScreen") {
                                composable(route = "MainScreen") {
                                    MainScreen(imageId, names, ingredients, navController)
                                }
                                composable(route = "DetailScreen/{index}",
                                    arguments = listOf(
                                        navArgument(name = "index") {
                                            type = NavType.IntType
                                        }
                                    )
                                ) { index->
                                    DetailScreen(
                                        photos = imageId,
                                        names = names,
                                        detail = detail,
                                        itemIndex = index.arguments?.getInt("index")
                                    )
                                }
                            }
                        }


                    }




                }
            }
        }
    }
}

