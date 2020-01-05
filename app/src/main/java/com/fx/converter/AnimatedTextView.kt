package com.fx.converter

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView

class AnimatedTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : TextView(context, attrs, defStyleAttr) {
    lateinit var animationType: String
    var animationSpeed: Int? = 0

    init {
        attrs?.let {
            var typedArray =
                context.obtainStyledAttributes(it, R.styleable.animated_textView, defStyleAttr, 0)
            animationType = typedArray.getString(R.styleable.animated_textView_animationType)
            animationSpeed = typedArray.getInt(R.styleable.animated_textView_animationSpeed, 1000)
            typedArray.recycle()
        }
        applyAttrs()
    }

    fun applyAttrs() {
        animationType?.apply { setText(animationType) }
        setBackgroundColor(R.color.colorAccent)
    }

    fun startAnimate(){

    }
}