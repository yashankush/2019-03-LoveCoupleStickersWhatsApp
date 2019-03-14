package fb.adstest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.valentine.stickers.R;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;

public class InterstitialAdsFb extends AppCompatActivity {

    private InterstitialAd interstitialAd;
    private Button bShowAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstitial_ads_fb);
        bShowAd = findViewById(R.id.b_fb_interstitial);
        interstitialAd = new InterstitialAd(this, getResources().getString(R.string.fb_interstitial_ads_app_id));

        interstitialAd.setAdListener(new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
                // Interstitial ad displayed callback
                Toast.makeText(InterstitialAdsFb.this, "Interstitial ad displayed.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                // Interstitial dismissed callback
                Toast.makeText(InterstitialAdsFb.this, "Interstitial ad dismissed.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Toast.makeText(InterstitialAdsFb.this, "Interstitial ad failed to load: "
                        + adError.getErrorMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdLoaded(Ad ad) {
                // Interstitial ad is loaded and ready to be displayed
                Toast.makeText(InterstitialAdsFb.this, "Interstitial ad is loaded and ready to be displayed!", Toast.LENGTH_SHORT).show();
                // Show the ad
                //interstitialAd.show();
            }

            @Override
            public void onAdClicked(Ad ad) {
                // Ad clicked callback
                Toast.makeText(InterstitialAdsFb.this, "Interstitial ad clicked!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Ad impression logged callback
                Toast.makeText(InterstitialAdsFb.this, "Interstitial ad impression logged!", Toast.LENGTH_SHORT).show();
            }
        });

        // For auto play video ads, it's recommended to load the ad
        // at least 30 seconds before it is shown
        interstitialAd.loadAd();

        bShowAd.setOnClickListener(view -> {
            if (interstitialAd.isAdLoaded()) {
                interstitialAd.show();
            } else {
                interstitialAd.loadAd();
            }
        });
    }
}
