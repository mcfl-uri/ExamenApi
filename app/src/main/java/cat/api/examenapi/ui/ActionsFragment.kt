package cat.api.examenapi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import cat.api.examenapi.R
import cat.api.examenapi.api.ApiInterface
import cat.api.examenapi.api.models.Alumne
import cat.api.examenapi.api.models.Cicle
import cat.api.examenapi.databinding.FragmentActionsBinding
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ActionsFragment : Fragment() {

    lateinit var binding: FragmentActionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentActionsBinding>(
            inflater,
            R.layout.fragment_actions, container, false
        )

        binding.editaButton.setOnClickListener {
            if (binding.editaInputId.text.toString().isNotBlank() && binding.editaInput.text.toString().isNotBlank()) {
                updateAlumne(binding.editaInputId.text.toString().toInt(), binding.editaInput.text.toString())
            }
        }

        binding.getCicleButton.setOnClickListener {
            if (binding.getCicleInput.text.toString().isNotBlank())
                getCicleById(binding.getCicleInput.text.toString().toInt())
        }

        binding.deleteAlumneButton.setOnClickListener {
            if (binding.deleteInput.text.toString().isNotBlank())
                deleteAlumneById(binding.deleteInput.text.toString().toInt())
        }

        return binding.root
    }

    fun getCicleById(id: Int) {
        val call = ApiInterface.create().getCicleById(id)

        call.enqueue(object : Callback<Cicle> {

            override fun onResponse(call: Call<Cicle>, response: Response<Cicle>) {
                if (response?.body() != null) {
                    var tmp: Cicle = response.body()!!
                    view?.findViewById<TextView>(R.id.getNomCicle)?.setText("Nom del cicle: ${tmp.nomCicle}")
                }
            }

            override fun onFailure(call: Call<Cicle>, t: Throwable) {
                showAlert(false)
            }
        })
    }

    fun deleteAlumneById(id: Int) {
        val call = ApiInterface.create().deleteAlumne(id)

        call.enqueue(object: Callback<Alumne?> {

            override fun onResponse(call: Call<Alumne?>, response: Response<Alumne?>) {
                if (response?.body() != null) {
                    showAlert(true)
                }
            }

            override fun onFailure(call: Call<Alumne?>, t: Throwable) {
                showAlert(false)
            }

        })
    }

    fun updateAlumne(id: Int, name: String) {
        val call = ApiInterface.create().updateAlumne(id, name)

        call?.enqueue(object : Callback<ResponseBody?> {
            override fun onResponse(call: Call<ResponseBody?>, response: Response<ResponseBody?>) {
                showAlert(true)
            }

            override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
                showAlert(false)
            }

        })
    }

    private fun showAlert(status: Boolean) {

        val builder = AlertDialog.Builder(requireActivity())

        if (status) {
            builder.setTitle("Correcte")
            builder.setMessage("Operació realitzada")
        } else {
            builder.setTitle("Error")
            builder.setMessage("Error al recuperar les dades")
        }
        builder.setPositiveButton("Tanca", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

}