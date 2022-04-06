package cat.api.examenapi.shared

import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private var idSeleccionada = -1
    private var nom = ""

    fun setId(id: Int) {
        idSeleccionada = id
    }

    fun getId(): Int {
        return idSeleccionada
    }

}