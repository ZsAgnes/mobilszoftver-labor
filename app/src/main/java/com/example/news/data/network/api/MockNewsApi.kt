package com.example.news.data.network.api

import com.example.news.data.network.model.Article
import com.example.news.data.network.model.NewsList
import com.example.news.data.network.model.Source
import kotlinx.coroutines.delay

class MockNewsApi : NewsApi {
    override suspend fun getTopHeadlines(country: String, apiKey: String): NewsList {
        delay(1000)
        return NewsList(
            totalResults = 2,
            status = "ok",
            articles = listOf(
                Article(
                    source = Source(
                        id = null,
                        name = "Nemzetisport.hu"
                    ),
                    author = "BORBOLA BENCE",
                    title = "FTC: Végre én is bizonyíthatok! – Bogdán Ádám - NSO - Nemzeti Sport",
                    description = "Bajnoki cím ide vagy oda, a zöld-fehérek rutinos kapusa jó teljesítményt és eredményt remél csapatától",
                    url = "https://www.nemzetisport.hu/labdarugo_nb_i/ftc-vegre-en-is-bizonyithatok-bogdan-adam-2822749",
                    urlToImage = "http://www.nemzetisport.hu/data/cikk/2/82/27/49/cikk_2822749/2021-04-23225_fb.jpg",
                    publishedAt = "2021-04-25T07:52:17Z",
                    content = "Bajnoki cím ide vagy oda, a zöld-fehérek rutinos kapusa, Bogdán Ádám jó teljesítményt és eredményt remél csapatától az idénybl hátralév meccseken, így a vasárnapi rangadón is. Kisvárdán harminchárom … [+3985 chars]"
                ),
                Article(
                    source = Source(
                        id = null,
                        name = "Index.hu"
                    ),
                    author = "Csernus János",
                    title = "Tovább csökken a fertőzöttek száma, kevesebben vannak kórházban - Index.hu",
                    description = "Tovább csökken a fertőzöttek száma, kevesebben vannak kórházban - Ma 2328 új fertőzöttet regisztráltak, elhunyt 205 beteg.",
                    url = "https://index.hu/belfold/2021/04/25/koronavirus-covid-19-jarvanyadatok-operativ-torzs-vakcina-oltas-fertozott-lelegeztetogep-terasznyitas/",
                    urlToImage = "https://kep.cdn.index.hu/1/0/3773/37737/377376/37737647_2879899_2e012ee033088b296d8a3cf4cf99cde2_wm.jpg",
                    publishedAt = "2021-04-25T07:35:00Z",
                    content = "Vasárnapra virradóra 2328 új fertzöttet regisztráltak, ezzel a járvány kezdete óta összesen 769 518 fre ntt a beazonosított fertzöttek száma  közölte a központi tájékoztató oldal. Elhunyt 205, többsé… [+3172 chars]"
                )
            )
        )
    }

    override suspend fun saveArticle(userId: String, apiKey: String) {
        delay(1000)
    }

    override suspend fun deleteArticle(newsId: String, apiKey: String) {
        delay(1000)
    }
}