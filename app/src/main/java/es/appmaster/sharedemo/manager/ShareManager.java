package es.appmaster.sharedemo.manager;

import android.content.Context;
import android.content.Intent;

/**
 * Share Manager implemented with Singleton pattern
 *
 * @author manolovn
 */
public class ShareManager {

    private static ShareManager INSTANCE = null;
    private Context context;

    private ShareManager(Context context) {
        this.context = context;
    }

    public static ShareManager getInstance(Context context) {
        if(INSTANCE == null) {
            INSTANCE = new ShareManager(context);
        }
        return INSTANCE;
    }


    public Intent generateShareIntent(String shareContent) {
        Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareContent);

        return shareIntent;
    }

}
