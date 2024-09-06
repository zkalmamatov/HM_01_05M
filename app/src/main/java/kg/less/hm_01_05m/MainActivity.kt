package kg.less.hm_01_05m

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kg.less.hm_01_05m.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterContract {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val presenter = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        presenter.attachContract(this)

        binding.apply {
            btnIncrement.setOnClickListener {
                presenter.onIncrement()
            }

            btnDecrement.setOnClickListener{
                presenter.onDecrement()
            }
        }
    }

    override fun showResult(count: Int) = with(binding) {
        tvCount.text = count.toString()
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun changeColor(colorResId: Int) = with(binding){
        tvCount.setTextColor(ContextCompat.getColor(this@MainActivity, colorResId))

    }

    override fun onDestroy() {
        presenter.detachContract()
        super.onDestroy()
    }
}