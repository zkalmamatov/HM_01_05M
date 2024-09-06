package kg.less.hm_01_05m

class MainPresenter {

    private val model = CounterModel()
    private var contract: CounterContract? = null

    fun attachContract(contract: CounterContract){
        this.contract = contract
    }

    fun onIncrement() {
        model.increment()
        checkAndUpdate()
    }

    fun onDecrement() {
        model.decrement()
        checkAndUpdate()
    }

    private fun checkAndUpdate() {
        contract?.showResult(model.count)
        if (model.count == 10) {
            contract?.showToast("Поздравляем!")
        } else if (model.count == 15) {
            contract?.changeColor(android.R.color.holo_green_light)
        }
    }

    fun detachContract(){
        contract = null
    }
}