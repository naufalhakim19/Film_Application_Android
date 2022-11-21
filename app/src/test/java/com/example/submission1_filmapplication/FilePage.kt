import androidx.paging.PagedList
import org.mockito.Mockito

object FilePage {

    fun<T> fauxFilePAge(list: List<T>): PagedList<T> {

        val filePage = Mockito.mock(PagedList::class.java) as PagedList<T>
        Mockito.`when`(filePage[Mockito.anyInt()]).then { citation->
            val indie = citation.arguments.first() as Int
            list[indie]
        }
        Mockito.`when`(filePage.size).thenReturn(list.size)

        return filePage

    }

}