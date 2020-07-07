package com.android.example.hooper

import android.content.res.Resources
import android.os.Build
import android.text.Html
import android.text.Spanned
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.android.example.hooper.database.Game

/**
 * Returns a textual description of a list of games
 */
fun formatGames(games: List<Game>, resources: Resources): Spanned {
    val sb = StringBuilder()
    sb.apply {
        games.forEach {
            append("<br>")
            append(it.teamOneName)
            append(it.teamTwoName)
            append("<br>")
        }
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    } else {
        return HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}

/**
 * ViewHolder that holds a single [TextView].
 *
 * A ViewHolder holds a view for the [RecyclerView] as well as providing additional information
 * to the RecyclerView such as where on the screen it was last drawn during scrolling.
 */
class TextItemViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView)
