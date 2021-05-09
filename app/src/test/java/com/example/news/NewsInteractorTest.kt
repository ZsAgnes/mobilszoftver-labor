package com.example.news;

import com.example.news.domain.NewsInteractor
import com.example.news.ui.news.newscontent.model.toUiArticle
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import org.robolectric.RobolectricTestRunner
import javax.inject.Inject

@ExperimentalCoroutinesApi
@RunWith(RobolectricTestRunner::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING) //Needed to test deletion
class NewsInteractorTest {
    @Inject
    lateinit var
            newsInteractor: NewsInteractor

    @Before
    fun setup() {
        injectorOfTests.inject(this)
    }

    @Test
    fun `test getting articles from network are as expected`() = runBlockingTest {
        val news = newsInteractor.getNews()
        Assert.assertEquals(news?.articles?.size, 2)
    }

    @Test
    fun `test getting articles from datasource are as expected`() = runBlockingTest {
        val news = newsInteractor.getAllSavedNews()
        Assert.assertEquals(news.size, 2)
    }

    @Test
    fun `test saving article as expected`() = runBlockingTest {
        val news = newsInteractor.getAllSavedNews()
        Assert.assertEquals(news[0].id, newsInteractor.saveNews(news[0].toUiArticle()))
    }


    @Test
    fun `test deleting article as expected`() = runBlockingTest {
        val news = newsInteractor.getAllSavedNews()
        newsInteractor.deleteSavedArticle(news[0].id)
        Assert.assertEquals(true, newsInteractor.deleteNews(news[0].id))
    }
}