package space.darkowlzz.minimaldivider;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MinimalDivider extends LinearLayout {

    private final int DEFAULT_TEXT_STYLE = 0;
    private final int DEFAULT_TEXT_SIZE = 0;
    private final int DEFAULT_TEXT_COLOR = 0;

    private TextView topTextView, bottomTextView;
    private View dividerView;

    private boolean topTextEnabled = false;
    private String topTextValue = "";
    private int topTextStyle;
    private float topTextSize;
    private int topTextColor;
    private boolean bottomTextEnabled = false;
    private String bottomTextValue = "";
    private int bottomTextStyle;
    private float bottomTextSize;
    private int bottomTextColor;

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

    private int getDimensionResource(int res) {
        return getResources().getDimensionPixelSize(res);
    }

    private void initViews(final Context context, AttributeSet attrs) {
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MinimalDivider, 0, 0);

        try {
            topTextEnabled = a.getBoolean(R.styleable.MinimalDivider_topText_enabled, false);
            bottomTextEnabled = a.getBoolean(R.styleable.MinimalDivider_bottomText_enabled, false);

            topTextValue = a.getString(R.styleable.MinimalDivider_topText_value);
            bottomTextValue = a.getString(R.styleable.MinimalDivider_bottomText_value);

            topTextStyle = a.getResourceId(R.styleable.MinimalDivider_topText_style, DEFAULT_TEXT_STYLE);
            bottomTextStyle = a.getResourceId(R.styleable.MinimalDivider_bottomText_style, DEFAULT_TEXT_STYLE);

            topTextSize = a.getDimensionPixelSize(R.styleable.MinimalDivider_topText_size, DEFAULT_TEXT_SIZE);
            bottomTextSize = a.getDimensionPixelSize(R.styleable.MinimalDivider_bottomText_size, DEFAULT_TEXT_SIZE);

            topTextColor = a.getColor(R.styleable.MinimalDivider_topText_color, DEFAULT_TEXT_COLOR);
            bottomTextColor = a.getColor(R.styleable.MinimalDivider_bottomText_color, DEFAULT_TEXT_COLOR);

            dividerLineWidth = a.getDimensionPixelSize(R.styleable.MinimalDivider_dividerLine_width,
                                                getDimensionResource(R.dimen.default_divider_width));
            dividerLineHeight = a.getDimensionPixelSize(R.styleable.MinimalDivider_dividerLine_height,
                                                getDimensionResource(R.dimen.default_divider_height));
            dividerLineMarginTop = a.getDimensionPixelSize(R.styleable.MinimalDivider_dividerLine_marginTop,
                                                getDimensionResource(R.dimen.default_divider_marginTop));
            dividerLineMarginBottom = a.getDimensionPixelSize(R.styleable.MinimalDivider_dividerLine_marginBottom,
                                                getDimensionResource(R.dimen.default_divider_marginBottom));

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

        setOrientation(VERTICAL);

        topTextView = (TextView) findViewById(R.id.topText);
        dividerView = findViewById(R.id.divider);
        bottomTextView = (TextView) findViewById(R.id.bottomText);

        // Set text content
        topTextView.setText(topTextValue);
        bottomTextView.setText(bottomTextValue);

        // Set text visibility
        topTextView.setVisibility(topTextEnabled ? VISIBLE : GONE);
        bottomTextView.setVisibility(bottomTextEnabled ? VISIBLE : GONE);

        // Set text appearance style
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            topTextView.setTextAppearance(topTextStyle);
            bottomTextView.setTextAppearance(bottomTextStyle);
        } else {
            topTextView.setTextAppearance(context, topTextStyle);
            bottomTextView.setTextAppearance(context, bottomTextStyle);
        }

        // Set text size
        if (topTextSize != DEFAULT_TEXT_SIZE) {
            topTextView.setTextSize(topTextSize);
        }
        if (bottomTextSize != DEFAULT_TEXT_SIZE) {
            bottomTextView.setTextSize(bottomTextSize);
        }

        // Set text color
        if (topTextColor != DEFAULT_TEXT_COLOR) {
            topTextView.setTextColor(topTextColor);
        }
        if (bottomTextColor != DEFAULT_TEXT_COLOR) {
            bottomTextView.setTextColor(bottomTextColor);
        }

        // Set divider line color
        dividerView.setBackgroundColor(dividerLineColor);

        // Set divider dimensions and margins
        LayoutParams params = (LayoutParams) dividerView.getLayoutParams();
        params.width = dividerLineWidth;
        params.height = dividerLineHeight;
        params.topMargin = dividerLineMarginTop;
        params.bottomMargin = dividerLineMarginBottom;
        dividerView.setLayoutParams(params);
    }
}