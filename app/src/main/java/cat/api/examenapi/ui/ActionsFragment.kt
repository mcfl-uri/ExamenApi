package cat.api.examenapi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import cat.api.examenapi.R
import cat.api.examenapi.api.ApiInterface
import cat.api.examenapi.api.models.Cicle
import cat.api.examenapi.databinding.FragmentActionsBinding
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

        binding.getCicleButton.setOnClickListener {
            if (binding.getCicleInput.text.toString().isNotBlank())
                getCicleById(binding.getCicleInput.text.toString().toInt())
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
                showAlert()
            }
        })
    }

    private fun showAlert() {
        val builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("Error")
        builder.setMessage("Error al recuperar les dades")
        builder.setPositiveButton("Tanca", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

}