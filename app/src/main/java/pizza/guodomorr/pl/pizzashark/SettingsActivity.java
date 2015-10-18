package pizza.guodomorr.pl.pizzashark;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import pizza.guodomorr.pl.pizzashark.widgets.RangeSeekBar;

public class SettingsActivity extends Activity {
    public static final String TAG = SettingsActivity.class.getSimpleName();
    /**
     * range seekBars values & checkboxes
     */
    private Double minRating = 0.0, maxRating = 5.0;
    private Integer minRatingCount = 0, maxRatingCount = 2350;
    private Double minCart = 0.0, maxCart = 120.;
    private Double minDeliveryCost = 1.0, maxDeliveryCost = 20.0;
    private boolean newCustomerDiscount, normalDiscount, allStamps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setupApplyButton();
        setupSeekBars();
        setupCheckBoxes();
    }

    private void setupSeekBars() {
        Log.d(TAG, "setupSeekBars ");
        /**inject customizers*/
        RelativeLayout ratingLay = (RelativeLayout) findViewById(R.id.rating);
        RelativeLayout ratingCountLay = (RelativeLayout) findViewById(R.id.ratingCount);
        RelativeLayout cartValueLay = (RelativeLayout) findViewById(R.id.cartValue);
        RelativeLayout deliveryCostLay = (RelativeLayout) findViewById(R.id.deliveryCost);
        /**inject titles*/
        TextView ratingTitle = (TextView) ratingLay.findViewById(R.id.title);
        TextView ratingCountTitle = (TextView) ratingCountLay.findViewById(R.id.title);
        TextView cartValueTitle = (TextView) cartValueLay.findViewById(R.id.title);
        TextView deliveryCostTitle = (TextView) deliveryCostLay.findViewById(R.id.title);

        ratingTitle.setText("");
        /**set titles for each seekbar*/
        ratingTitle.setText("Rating");
        ratingCountTitle.setText("Rating Count");
        cartValueTitle.setText("Cart value");
        deliveryCostTitle.setText("Delivery cost");
        /**inject seekBars parents of each RangeSeekBar*/
        FrameLayout ratingParent = (FrameLayout) ratingLay.findViewById(R.id.seekBarParent);
        FrameLayout ratingCountParent = (FrameLayout) ratingCountLay.findViewById(R.id.seekBarParent);
        FrameLayout cartValueParent = (FrameLayout) cartValueLay.findViewById(R.id.seekBarParent);
        FrameLayout deliveryCostParent = (FrameLayout) deliveryCostLay.findViewById(R.id.seekBarParent);

        /**setup rating RangeSeekBar*/
        RangeSeekBar<Double> ratingBar = new RangeSeekBar<>(0.0, 5.0, this);
        ratingParent.addView(ratingBar);
        ratingBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Double>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Double minValue, Double maxValue) {
                minRating = minValue;
                maxRating = maxValue;
            }
        });
        RangeSeekBar<Integer> ratingCountBar = new RangeSeekBar<>(0, 2350, this);
        ratingCountParent.addView(ratingCountBar);
        ratingCountBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
                minRatingCount = minValue;
                maxRatingCount = maxValue;
            }
        });
        RangeSeekBar<Double> cartValueBar = new RangeSeekBar<>(0.0, 120.0, this);
        cartValueParent.addView(cartValueBar);
        cartValueBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Double>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Double minValue, Double maxValue) {
                minCart = minValue;
                maxCart = maxValue;
            }
        });

        RangeSeekBar<Double> deliveryCountBar = new RangeSeekBar<>(0.0, 120.0, this);
        deliveryCostParent.addView(deliveryCountBar);
        deliveryCountBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Double>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Double minValue, Double maxValue) {
                minDeliveryCost = minValue;
                minDeliveryCost = maxValue;
            }
        });

    }

    private void setupCheckBoxes() {
        Log.d(TAG, "setupCheckBoxes ");
        final CheckBox newCustomer = (CheckBox) findViewById(R.id.newCustomer);
        newCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newCustomerDiscount = newCustomer.isChecked();
            }
        });
        final CheckBox normal = (CheckBox) findViewById(R.id.normal);
        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                normalDiscount = normal.isChecked();
            }
        });
        final CheckBox allStamps2 = (CheckBox) findViewById(R.id.allStamps);
        allStamps2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allStamps = allStamps2.isChecked();
            }
        });
    }

    private void setupApplyButton() {
        /**inject apply button*/
        Log.d(TAG, "setupApplyButton ");
        Button applyButton = (Button) findViewById(R.id.applyButton);
        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "minRating = " + minRating + ", maxRating = " + maxRating);
                Log.d(TAG, "minRatingCount = " + minRatingCount + ", maxRatingCount = " + maxRatingCount);
                Log.d(TAG, "minCart = " + minCart + ", maxCart = " + maxCart);
                Log.d(TAG, "minDeliveryCost = " + minDeliveryCost + ", maxDeliveryCost = " + maxDeliveryCost);
                Bundle bundle = new Bundle();

                bundle.putDouble(Constants.MIN_RATING, getFormedDouble(minRating));
                bundle.putDouble(Constants.MAX_RATING, getFormedDouble(maxRating));

                bundle.putInt(Constants.MIN_RATING_COUNT, minRatingCount);
                bundle.putInt(Constants.MAX_RATING_COUNT, maxRatingCount);

                bundle.putDouble(Constants.MIN_CART, getFormedDouble(minCart));
                bundle.putDouble(Constants.MAX_CART, getFormedDouble(maxCart));

                bundle.putDouble(Constants.MIN_DELIVERY, getFormedDouble(minDeliveryCost));
                bundle.putDouble(Constants.MAX_DELIVERY, getFormedDouble(maxDeliveryCost));

                bundle.putBoolean(Constants.NEW_CUSTOMER, newCustomerDiscount);
                bundle.putBoolean(Constants.NORMAL, normalDiscount);
                bundle.putBoolean(Constants.ALL_STAMPS, allStamps);

                Intent intent = getIntent();
                intent.putExtras(bundle);
                SettingsActivity.this.setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @NonNull
    private Double getFormedDouble(Double ble) {
        try {
            return Double.valueOf(String.format("%.2f", ble));
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0.00;
        }
    }
}
