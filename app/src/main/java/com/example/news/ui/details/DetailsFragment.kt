package com.example.news.ui.details

import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.extensions.applyArgs
import co.zsmb.rainbowcake.navigation.extensions.requireString
import com.bumptech.glide.Glide
import com.example.news.R
import com.example.news.ui.news.newscontent.model.UiArticle
import kotlinx.android.synthetic.main.fragment_details.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class DetailsFragment : RainbowCakeFragment<DetailsViewState, DetailsViewModel> {

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_details

    // A public no-arg constructor to be only used by the framework
    // Clients will be redirected to use the `newInstance` method instead via the deprecation notice
    @Suppress("ConvertSecondaryConstructorToPrimary")
    @Deprecated(
        message = "Use newInstance instead",
        replaceWith = ReplaceWith("DetailsFragment.newInstance()")
    )
    constructor()

    companion object {
        private const val UI_ARTICLE = "UI_ARTICLE"

        @Suppress("DEPRECATION")
        fun newInstance(uiArticle: String): DetailsFragment {
            return DetailsFragment().applyArgs {
                putString(UI_ARTICLE, uiArticle)
            }
        }
    }

    private lateinit var uiArticle: UiArticle
    private var liked = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initArguments()
        setupViews()
    }

    private fun setupViews() {
        Glide
            .with(requireContext())
            .load(uiArticle.urlToImage)
            .placeholder(R.drawable.news_placeholder)
            .into(newsDetailsImage)

        newsDetailsTitle.text = uiArticle.title
        newsDetailsAuthor.text = uiArticle.author
        newsDetailsDate.text = uiArticle.publishedAt
        newsDetailsDetails.text = uiArticle.description
        newsDetailsLink.text = uiArticle.url

        if (uiArticle.saved) {
            liked = true
            newsDetailsSaveButton.setImageResource(R.drawable.ic_heart_fill)
        } else {
            liked = false
            newsDetailsSaveButton.setImageResource(R.drawable.ic_heart_empty)
        }

        newsDetailsSaveButton.setOnClickListener {
            if (liked) {
                newsDetailsSaveButton.setImageResource(R.drawable.ic_heart_empty)
                viewModel.deleteSavedArticle(uiArticle.id)
            } else {
                newsDetailsSaveButton.setImageResource(R.drawable.ic_heart_fill)
                viewModel.saveArticle(uiArticle)
            }
            liked = !liked
        }

        newsDetailsDeleteButton.setOnClickListener {
            viewModel.deleteArticle(uiArticle.id)
        }
    }

    private fun initArguments() {
        val serializable = requireArguments().requireString(UI_ARTICLE)

        uiArticle = Json.decodeFromString<UiArticle>(serializable)
    }

    override fun render(viewState: DetailsViewState) {
        // TODO Render state
    }

}
