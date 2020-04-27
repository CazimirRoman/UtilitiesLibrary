package com.cazimir.utilitieslibrary

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri

fun showMyOtherApplicationsInGooglePlay(activity: Activity) {
    val appPackageName: String = activity.packageName

    try {
        activity.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=Cazimir+Roman&hl=en")))
    } catch (e: ActivityNotFoundException) {
        activity.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")))
    }
}

fun showMyListingInStoreForRating(context: Context) {
    val uri = Uri.parse("market://details?id=" + context.packageName)
    val goToMarket = Intent(Intent.ACTION_VIEW, uri)
    // To count with Play market backstack, After pressing back button,
    // to taken back to our application, we need to add following flags to intent.
    goToMarket.addFlags(
        Intent.FLAG_ACTIVITY_NO_HISTORY or
                Intent.FLAG_ACTIVITY_NEW_DOCUMENT or
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK
    )
    try {
        context.startActivity(goToMarket)
    } catch (e: ActivityNotFoundException) {
        context.startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("http://play.google.com/store/apps/details?id=" + context.packageName)
            )
        )
    }
}

fun shareMyApp(context: Context, shareText: String) {
    val sendIntent = Intent()
    sendIntent.action = Intent.ACTION_SEND
    sendIntent.putExtra(Intent.EXTRA_TEXT, shareText)
    sendIntent.type = "text/plain"
    context.startActivity(sendIntent)
}