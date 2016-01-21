package space.darkowlzz.minimaldivider;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by sunny on 20/01/16.
 */
public class MinimalDivider extends LinearLayout {

    private final int DEFAULT_DIVIDERLINE_WIDTH = 197;
    private final int DEFAULT_DIVIDERLINE_HEIGHT = 5;
    private final int DEFAULT_DIVIDERLINE_TOP_MARGIN = 26;
    private final int DEFAULT_DIVIDERLINE_BOTTOM_MARGIN = 26;

    private TextView topTextView, bottomTextView;
    private View dividerView;

    private boolean topTextEnabled = false;
    private String topTextValue = "";
    private boolean bottomTextEnabled = false;
    private String bottomTextValue = "";

    private int dividerLineColor;
    private int dividerLineWidth;
    private int dividerLineHeight;
    private int dividerLineMarginTop;
    private int dividerLineMarginBottom;

    public MinimalDivider(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.minimaldivider_layout, this);
    }

    public MinimalDivider(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews(context, attrs);
    }

    public MinimalDivider(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MinimalDivider(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initViews(context, attrs);
    }

    private void initViews(final Context context, AttributeSet attrs) {
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MinimalDivider, 0, 0);

        try {
            topTextEnabled = a.getBoolean(R.styleable.MinimalDivider_topText_enabled, false);
            bottomTextEnabled = a.getBoolean(R.styleable.MinimalDivider_bottomText_enabled, false);

            topTextValue = a.getString(R.styleable.MinimalDivider_topText_value);
            bottomTextValue = a.getString(R.styleable.MinimalDivider_bottomText_value);

            dividerLineWidth = a.getDimensionPixelSize(R.styleable.MinimalDivider_dividerLine_width, DEFAULT_DIVIDERLINE_WIDTH);
            dividerLineHeight = a.getDimensionPixelSize(R.styleable.MinimalDivider_dividerLine_height, DEFAULT_DIVIDERLINE_HEIGHT);
            dividerLineMarginTop = a.getDimensionPixelSize(R.styleable.MinimalDivider_dividerLine_marginTop, DEFAULT_DIVIDERLINE_TOP_MARGIN);
            dividerLineMarginBottom = a.getDimensionPixelSize(R.styleable.MinimalDivider_dividerLine_marginBottom, DEFAULT_DIVIDERLINE_BOTTOM_MARGIN);

            if(!isInEditMode()) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    dividerLineColor = a.getColor(R.styleable.MinimalDivider_dividerLine_color, getResources()
                            .getColor(R.color.defaultDividerLineColor, getContext().getTheme()));
                } else {
                    dividerLineColor = a.getColor(R.styleable.MinimalDivider_dividerLine_color, getResources()
                            .getColor(R.color.defaultDividerLineColor));
                }
            }

        } finally {
            a.recycle();
        }

        LayoutInflater.from(context).inflate(R.layout.minimaldivider_layout, this);

        topTextView = (TextView) findViewById(R.id.topText);
        dividerView = findViewById(R.id.divider);
        bottomTextView = (TextView) findViewById(R.id.bottomText);

        topTextView.setText(topTextValue);
        topTextView.setVisibility(topTextEnabled ? VISIBLE : GONE);

        bottomTextView.setText(bottomTextValue);
        bottomTextView.setVisibility(bottomTextEnabled ? VISIBLE : GONE);

        dividerView.setBackgroundColor(dividerLineColor);

        LayoutParams params = (LayoutParams) dividerView.getLayoutParams();
        params.width = dividerLineWidth;
        params.height = dividerLineHeight;
        params.topMargin = dividerLineMarginTop;
        params.bottomMargin = dividerLineMarginBottom;

        dividerView.setLayoutParams(params);
    }
}
