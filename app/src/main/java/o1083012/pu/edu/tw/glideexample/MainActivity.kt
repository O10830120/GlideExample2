package o1083012.pu.edu.tw.glideexample

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import jp.wasabeef.glide.transformations.BlurTransformation
import jp.wasabeef.glide.transformations.ColorFilterTransformation
import jp.wasabeef.glide.transformations.RoundedCornersTransformation
import jp.wasabeef.glide.transformations.gpu.SketchFilterTransformation
import o1083012.pu.edu.tw.glideexample.GlideOptions.bitmapTransform

@GlideModule
public final class MyAppGlideModule : AppGlideModule()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val multi = MultiTransformation<Bitmap>(
                SketchFilterTransformation(),
                ColorFilterTransformation(Color.argb(60, 0, 0, 255))
        )

        val img:ImageView = findViewById(R.id.imgA)
                GlideApp.with(this)
                .load(R.drawable.sea)
                .into(img)

        val img2:ImageView = findViewById(R.id.imgB)
            GlideApp.with(this)
                .load(R.drawable.sea)
                .apply(bitmapTransform(multi))
                .into(img2)
    }
}