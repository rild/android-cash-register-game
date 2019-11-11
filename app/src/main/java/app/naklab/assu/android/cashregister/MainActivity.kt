package app.naklab.assu.android.cashregister

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    val MAX_PRICE = 100000
    var successCount: Int = 0
    var displayedNumber: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        reset()
        next()
        initButtons()
    }

    fun reset() {
        successCount = 0
        textViewSuccessCount.text = successCount.toString()
        displayedNumber = 0
        textViewPrice.text = displayedNumber.toString()
    }

    fun next() {
        displayedNumber = Random.nextInt(MAX_PRICE)
        textViewPrice.text = displayedNumber.toString()
    }

    fun initButtonWithTag(b: View) {
        b.setOnClickListener {
            displayedNumber = displayedNumber - Integer.parseInt(b.getTag().toString())


            if (displayedNumber < 0) { // input wrongly
                reset()
            } else if (displayedNumber == 0) { // input successfully
                successCount = successCount + 1
                textViewSuccessCount.text = successCount.toString()
                next()
            }
            textViewPrice.text = displayedNumber.toString()
        }
    }

    fun initButtons() {
        // coins
        initButtonWithTag(imageView1)
        initButtonWithTag(imageView5)
        initButtonWithTag(imageView10)
        initButtonWithTag(imageView50)
        initButtonWithTag(imageView100)
        initButtonWithTag(imageView500)

        // bill
        initButtonWithTag(imageView1000)
        initButtonWithTag(imageView5000)
        initButtonWithTag(imageView10000)

        buttonReset.setOnClickListener {
            reset()
        }
    }
}
