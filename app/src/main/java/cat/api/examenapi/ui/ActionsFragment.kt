package cat.api.examenapi.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cat.api.examenapi.R
import cat.api.examenapi.databinding.FragmentAcionsBinding

class ActionsFragment : Fragment() {

    lateinit var binding: FragmentAcionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_acions, container, false)
    }
}