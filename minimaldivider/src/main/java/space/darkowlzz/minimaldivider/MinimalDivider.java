package space.darkowlzz.minimaldivider;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MinimalDivider extends LinearLayout {

    private final int DEFAULT_TEXT_STYLE = 0;
    private final int DEFAULT_TEXT_SIZE = 0;
    private final int DEFAULT_TEXT_COLOR = 0;

    private TextView topTextView, bottomTextView;
    private View dividerView;
    private ImageView topImageView, bottomImageView;

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

    private boolean topImageEnabled = false;
    private int topImageSource;
    private int topImageWidth;
    private int topImageHeight;
    private boolean bottomImageEnabled = false;
    private int bottomImageSource;
    private int bottomImageWidth;
    private int bottomImageHeight;

    public boolean isBottomImageEnabled() {
        return bottomImageEnabled;
    }

    public int getBottomImageHeight() {
        return bottomImageHeight;
    }

    public int getBottomImageSource() {
        return bottomImageSource;
    }

    public int getBottomImageWidth() {
        return bottomImageWidth;
    }

    public int getBottomTextColor() {
        return bottomTextColor;
    }

    public boolean isBottomTextEnabled() {
        return bottomTextEnabled;
    }

    public float getBottomTextSize() {
        return bottomTextSize;
    }

    public int getBottomTextStyle() {
        return bottomTextStyle;
    }

    public String getBottomTextValue() {
        return bottomTextValue;
    }

    public int getDividerLineColor() {
        return dividerLineColor;
    }

    public int getDividerLineHeight() {
        return dividerLineHeight;
    }

    public int getDividerLineMarginBottom() {
        return dividerLineMarginBottom;
    }

    public int getDividerLineMarginTop() {
        return dividerLineMarginTop;
    }

    public int getDividerLineWidth() {
        return dividerLineWidth;
    }

    public boolean isTopImageEnabled() {
        return topImageEnabled;
    }

    public int getTopImageHeight() {
        return topImageHeight;
    }

    public int getTopImageSource() {
        return topImageSource;
    }

    public int getTopImageWidth() {
        return topImageWidth;
    }

    public int getTopTextColor() {
        return topTextColor;
    }

    public boolean isTopTextEnabled() {
        return topTextEnabled;
    }

    public float getTopTextSize() {
        return topTextSize;
    }

    public int getTopTextStyle() {
        return topTextStyle;
    }

    public String getTopTextValue() {
        return topTextValue;
    }


    /* Constructors */

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

            topImageEnabled = a.getBoolean(R.styleable.MinimalDivider_topImage_enabled, false);
            topImageSource = a.getResourceId(R.styleable.MinimalDivider_topImage_source, 0);
            topImageWidth = a.getDimensionPixelSize(R.styleable.MinimalDivider_topImage_width, 0);
            topImageHeight = a.getDimensionPixelSize(R.styleable.MinimalDivider_topImage_height, 0);

            bottomImageEnabled = a.getBoolean(R.styleable.MinimalDivider_bottomImage_enabled, false);
            bottomImageSource = a.getResourceId(R.styleable.MinimalDivider_bottomImage_source, 0);
            bottomImageWidth = a.getDimensionPixelSize(R.styleable.MinimalDivider_bottomImage_width, 0);
            bottomImageHeight = a.getDimensionPixelSize(R.styleable.MinimalDivider_bottomImage_height, 0);

        } finally {
            a.recycle();
        }

        LayoutInflater.from(context).inflate(R.layout.minimaldivider_layout, this);

        setOrientation(VERTICAL);

        topTextView = (TextView) findViewById(R.id.topText);
        dividerView = findViewById(R.id.divider);
        bottomTextView = (TextView) findViewById(R.id.bottomText);
        topImageView = (ImageView) findViewById(R.id.topImage);
        bottomImageView = (ImageView) findViewById(R.id.bottomImage);

        if (topImageEnabled) {
            topImageView.setVisibility(VISIBLE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                topImageView.setImageDrawable(getResources().getDrawable(topImageSource, context.getTheme()));
            } else {
                topImageView.setImageDrawable(getResources().getDrawable(topImageSource));
            }

            LayoutParams topImgParams = (LayoutParams) topImageView.getLayoutParams();
            if (topImageWidth != 0) {
                topImgParams.width = topImageWidth;
            }
            if (topImageHeight != 0) {
                topImgParams.height = topImageHeight;
            }
            topImageView.setLayoutParams(topImgParams);
        } else {
            topImageView.setVisibility(GONE);
        }

        if (bottomImageEnabled) {
            bottomImageView.setVisibility(VISIBLE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                bottomImageView.setImageDrawable(getResources().getDrawable(bottomImageSource, context.getTheme()));
            } else {
                bottomImageView.setImageDrawable(getResources().getDrawable(bottomImageSource));
            }

            LayoutParams btmImgParams = (LayoutParams) bottomImageView.getLayoutParams();
            if (bottomImageWidth != 0) {
                btmImgParams.width = bottomImageWidth;
            }
            if (bottomImageHeight != 0) {
                btmImgParams.height = bottomImageHeight;
            }
            bottomImageView.setLayoutParams(btmImgParams);
        } else {
            bottomImageView.setVisibility(GONE);
        }

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