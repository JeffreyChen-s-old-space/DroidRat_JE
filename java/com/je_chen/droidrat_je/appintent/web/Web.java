package com.je_chen.droidrat_je.appintent.web;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class Web {

    public void webSearch(Context context, String searchWhat){
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY,searchWhat);
        context.startActivity(intent);
    }

    public void openWeb(Context context, String uri){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        context.startActivity(intent);
    }

}
